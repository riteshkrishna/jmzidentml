/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.ebi.jmzidml.test.converters;

import java.io.File;
import de.proteinms.xtandemparser.xtandem.*;
import java.io.*;
import java.util.*;
import java.util.List;
import de.proteinms.xtandemparser.interfaces.*;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLMarshaller;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import java.math.BigInteger;


/**
 *
 * @author jonesar
 */
public class Tandem2mzid {


    //These are the main structures to be output by the main writing method
    SequenceCollection sequenceCollection;
    SpectrumIdentificationList siList;
    CvList cvList;
    AnalysisSoftwareList analysisSoftwareList;
    Provider provider;
    AuditCollection auditCollection;
    AnalysisSampleCollection analysisSampleCollection;
    AnalysisCollection analysisCollection;
    AnalysisProtocolCollection analysisProtocolCollection;


    //Some IDs to be used throughout;
    static String siiListID = "SII_LIST_1";
    static String spectraDataID = "SID_1";
    static String psiCvID = "PSI-MS";
    static String siProtocolID = "SearchProtocol_1";
    static String searchDBID = "SearchDB_1";
    static String analysisSoftID = "ID_software";
    static String specIdentID = "SpecIdent_1";
    static String unimodID = "UNIMOD";
    static String unitCvID = "UO";
    static String measureMzID = "Measure_MZ";
    static String measureIntID = "Measure_Int";
    static String measureErrorID = "Measure_Error";

    
    HashMap<String, Integer> foundProts = new HashMap<String, Integer>();
    
    //List<SpectrumIdentificationResult> specIdentResults;

    
    int sirCounter = 1; //Counter used to create unique ID for SpectrumIdentificationResult
    
    
    public Tandem2mzid(String fileName){
    
        try{
            //File tandemFile = new File (fileName);
            //XTandemParser parser = new XTandemParser(tandemFile);
            XTandemFile xfile = new XTandemFile (fileName);
            parseFile(xfile);
            writeMzidFile();


        }
        catch(Exception e){

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Tandem2mzid("target/test-classes/12merge_tandem.xml");

    }


    public void parseFile(XTandemFile iXTandemFile){

        

        // Iterate over all the spectra
        Iterator<Spectrum> iter = iXTandemFile.getSpectraIterator();
        //ArrayList<Spectrum> specList = iXTandemFile.getSpectraList();

        // Prepare everything for the peptides.
        PeptideMap pepMap = iXTandemFile.getPeptideMap();

        // Prepare everything for the proteins.
        ProteinMap protMap = iXTandemFile.getProteinMap();

        // Setup the mzid objects
       handleCVs();

       PerformParams tandemParams = iXTandemFile.getPerformParameters();
       String version = tandemParams.getProcVersion();
       handleAnalysisSoftware(version);

       handleProvider();
       handleAuditCollection("firstname","secondName","email@place.com","address","myworkplace");
       handleAnalysisCollection(tandemParams.getProcStartTime());

       handleAnalysisProtocolCollection(true,true,new SearchModification[100],"trypsin",0.5,0.5,0.5,0.5);


        sequenceCollection = new SequenceCollection();
        siList = new SpectrumIdentificationList();
        siList.setId(siiListID);
        List<SpectrumIdentificationResult> specIdentResults = siList.getSpectrumIdentificationResult();
        List<DBSequence> dbSeqList = sequenceCollection.getDBSequence();
        List<uk.ac.ebi.jmzidml.model.mzidml.Peptide> peptideList = sequenceCollection.getPeptide();
        SpectraData spectraData = new SpectraData();
        spectraData.setId(spectraDataID);


         while (iter.hasNext()) {

            // Get the next spectrum.
            Spectrum spectrum = iter.next();
            int spectrumNumber = spectrum.getSpectrumNumber();
            SpectrumIdentificationResult specIdentRes = new SpectrumIdentificationResult();
            List<SpectrumIdentificationItem> siiList = specIdentRes.getSpectrumIdentificationItem();
            SpectrumIdentificationItem sii = new SpectrumIdentificationItem();
            uk.ac.ebi.jmzidml.model.mzidml.Peptide mzidPep = new uk.ac.ebi.jmzidml.model.mzidml.Peptide();
            Fragmentation frag = new Fragmentation();
            List<IonType> ionTypeList = frag.getIonType();

            // Get the peptide hits.
            ArrayList<de.proteinms.xtandemparser.xtandem.Peptide> pepList = pepMap.getAllPeptides(spectrumNumber);



            /*
              This part needs some thought - since this is where multiple peptide evidences should come in...
             * Think there is a flaw here if X!Tandem reports two idents with the same score e.g. containing I or L (same mass)
             * Should create another SII - TO DO

            */
            List<PeptideEvidence> pepEvidList = sii.getPeptideEvidence();
            int pepEvidCounter = 1;
            int siiCounter = 1; //Counter used to create unique ID for SpectrumIdentificationItem

            Double evalue = null;
            Double hyperscore = null;

            for (de.proteinms.xtandemparser.xtandem.Peptide peptide : pepList) {

                Protein protein = protMap.getProteinWithPeptideID(peptide.getDomainID());
                PeptideEvidence pepEvid = new PeptideEvidence();

                String protAccession="";
                String protSeq="";
                int protLength;

                if (protein != null){
                    protAccession = protein.getLabel();
                    //System.out.println("prot: " + protAccession);
                    protSeq = peptide.getSequence();        //getSequence returns the protein sequence
                    protSeq= protSeq.replaceAll("\\s+","");

                }

                //Use Hash map to test if Protein sequence has been added to DBSeq before
                DBSequence dbSeq = null;
                if(!foundProts.containsKey(protAccession)){
                    foundProts.put(protAccession, 1);
                    dbSeq = new DBSequence();
                    dbSeq.setAccession(protAccession);
                    dbSeq.setSeq(protSeq);
                    dbSeq.setLength(protSeq.length());
                    dbSeq.setId("dbseq_" + protAccession);
                    dbSeq.setSearchDatabaseRef(searchDBID);
                    dbSeqList.add(dbSeq);
                }
               
                // Do the modifications
                ArrayList<de.proteinms.xtandemparser.interfaces.Modification> fixModList = iXTandemFile.getModificationMap().getFixedModifications(peptide.getDomainID());
                ArrayList<de.proteinms.xtandemparser.interfaces.Modification> varModList = iXTandemFile.getModificationMap().getVariableModifications(peptide.getDomainID());

                String fixMods = "";

                List<uk.ac.ebi.jmzidml.model.mzidml.Modification> allMods = mzidPep.getModification();

                for (de.proteinms.xtandemparser.interfaces.Modification fixMod : fixModList) {

                    Double mass = fixMod.getMass();
                    String name = fixMod.getName();
                    int loc = Integer.parseInt(fixMod.getLocation());
                    fixMods +=  name + "$" + loc + ";";

                    uk.ac.ebi.jmzidml.model.mzidml.Modification mod = new uk.ac.ebi.jmzidml.model.mzidml.Modification();
                    List<CvParam> paramList = mod.getCvParam();
                    paramList.add(getModCV(mass));
                    mod.setMonoisotopicMassDelta(mass);
                    int pepLoc = loc - peptide.getDomainStart(); //location in Tandem is given as location within the whole protein
                    mod.setLocation(pepLoc + 1);        //mzid starts counting from 1, except for NTerm mods which are 0 TODO - Almost impossible to work out what are Nterm mods in Tandem, these have the same location as mods on the first aa in the peptide
                    List<String> residueList = mod.getResidues();
                    residueList.add(""+ peptide.getDomainSequence().charAt(pepLoc));
                    allMods.add(mod);

                }

                String varMods = "";

                for (de.proteinms.xtandemparser.interfaces.Modification varMod : varModList) {

                    Double mass = varMod.getMass();
                    String name = varMod.getName();
                    int loc = Integer.parseInt(varMod.getLocation());
                    varMods +=  name + "$" + loc + ";";

                    uk.ac.ebi.jmzidml.model.mzidml.Modification mod = new uk.ac.ebi.jmzidml.model.mzidml.Modification();
                    List<CvParam> paramList = mod.getCvParam();

                    CvParam modParam = new CvParam();

                    /*
                        <Modification location="11" residues="M" monoisotopicMassDelta="15.994919">
                            <cvParam accession="UNIMOD:35" name="Oxidation" cvRef="UNIMOD"/>
                        </Modification>
                        <Modification location="13" residues="C" monoisotopicMassDelta="57.021464">
                                <cvParam accession="UNIMOD:4" name="Carbamidomethyl" cvRef="UNIMOD"/>
                        </Modification>
                    */

                    if(mass <16 && mass >15.9 ){
                        modParam.setAccession("UNIMOD:35");
                        modParam.setCvRef("UNIMOD");
                        modParam.setName("Oxidation");
                    }
                    else if(mass <57.1 && mass > 57.0){
                        modParam.setAccession("UNIMOD:4");
                        modParam.setCvRef("UNIMOD");
                        modParam.setName("Carbamidomethyl");
                    }
                    else{
                        System.out.println("Error: modification with mass not recognized");
                        modParam.setName("ERROR");
                    }

                    //paramList.add(getModCV(mass));
                    paramList.add(modParam);                  

                    mod.setMonoisotopicMassDelta(mass);
                    int pepLoc = loc - peptide.getDomainStart(); //location in Tandem is given as location within the whole protein
                    mod.setLocation(pepLoc + 1);        //mzid starts counting from 1, except for NTerm mods which are 0 TODO - Almost impossible to work out what are Nterm mods in Tandem, these have the same location as mods on the first aa in the peptide
                    List<String> residueList = mod.getResidues();
                    residueList.add(""+ peptide.getDomainSequence().charAt(pepLoc));
                    allMods.add(mod);

                }

                //System.out.println("\t" + peptide.getDomainSequence() + "," + peptide.getStart() + "," + peptide.getEnd() + "," + peptide.getDomainExpect() + "," + fixMods + "," + varMods);
                evalue = peptide.getDomainExpect();
                hyperscore = peptide.getDomainHyperScore();                              
                
                //Add peptide sequence to mzid Peptide object
                mzidPep.setPeptideSequence(peptide.getDomainSequence());
                mzidPep.setId("Peptide" + sirCounter + "_" + siiCounter);
                pepEvid.setEnd(peptide.getEnd());
                pepEvid.setStart(peptide.getStart());
                pepEvid.setMissedCleavages(peptide.getMissedCleavages());
                pepEvid.setDBSequenceRef("dbseq_" + protAccession); //This would be better linked to DB seq object, but taking a short cut here

                char post = peptide.getDownFlankSequence().charAt(0);
                if(post == ']'){
                    post = '-';

                }
                pepEvid.setPost(""+post); //Reports 4 chars, we need the first only

                char pre = peptide.getUpFlankSequence().charAt(3);
                if(pre == '['){
                    pre = '-';
                }
                pepEvid.setPre(""+pre);    //Reports 4 chars, we need last only
                pepEvid.setId("PE" + sirCounter + "_" + siiCounter + "_" + pepEvidCounter);
                pepEvidCounter++;
                pepEvid.setIsDecoy(Boolean.FALSE);      //TODO - insert some code for testing a REGEX on protein accession
                pepEvidList.add(pepEvid);


                // Get the fragment ions
                Vector IonVector = iXTandemFile.getFragmentIonsForPeptide(peptide);

                /*
               <IonType index="2 4 4 9 7 10 8 11 8 13" charge="1">
                <cvParam cvRef="PSI-MS" accession="MS:1001366" name="frag: internal ya ion"/>
                <FragmentArray values="286 644.2 329.9 329.9 514.2 " Measure_ref="m_mz"/>
                <FragmentArray values="32 194 2053 2053 125" Measure_ref="m_intensity"/>
                <FragmentArray values="-0.2125 -0.1151 -0.2772 -0.2772 -0.0620" Measure_ref="m_error"/>
              </IonType>

                 */
                
                // Get all the ion types from the vector
                for (int i = 0; i < IonVector.size(); i++) {
                    FragmentIon[] ions = (FragmentIon[]) IonVector.get(i);
                    //ionsMap.put(peptide.getDomainID() + "_" + i, ions);

                    IonType ion = new IonType();
                    List<java.math.BigInteger> ionIndexList = ion.getIndex();
                    if(ions.length > 0){
                        List<FragmentArray> fragmentList = ion.getFragmentArray();
                        FragmentArray mzArray = new FragmentArray();
                        FragmentArray intArray = new FragmentArray();
                        FragmentArray errorArray = new FragmentArray();
                        mzArray.setMeasureRef(measureMzID);
                        intArray.setMeasureRef(measureIntID);
                        errorArray.setMeasureRef(measureErrorID);

                        List<Float> mzValues = mzArray.getValues();
                        List<Float> intValues = intArray.getValues();
                        List<Float> errorValues = errorArray.getValues();

                        for(int j=0; j < ions.length; j++){
                            FragmentIon fragIon = ions[j];

                            if(j==0){
                                int charge = (int)fragIon.getCharge();
                                ion.setCharge(charge);
                                CvParam cvParam = getFragmentCVParam(fragIon.getType());
                                ion.setCvParam(cvParam);
                            }

                            mzValues.add((float)fragIon.getMZ());
                            intValues.add((float)fragIon.getIntensity());
                            errorValues.add((float)fragIon.getTheoreticalExperimentalMassError());   //TODO test if this is the correct error value, more than one error value

                            //String ionLetter = fragIon.getLetter();

                            //int ionType = fragIon.getType();
                            //Double intensity = fragIon.getIntensity();
                            //Double error = fragIon.getErrorMargin();
                            //Double mz = fragIon.getMZ();

                            ionIndexList.add(BigInteger.valueOf(fragIon.getNumber()));  //index position

                            //System.out.println(ionLetter  + charge + intensity + error + mz );



                        }
                        //System.out.println(peptide.getDomainID() + "_" + i + ions.toString());
                        fragmentList.add(mzArray);
                        fragmentList.add(intArray);
                        fragmentList.add(errorArray);
                        ionTypeList.add(ion);
                    }
                    
                }
            }
            sii.setFragmentation(frag);


            // Get the support data for each spectrum.
            SupportData supportData = iXTandemFile.getSupportData(spectrumNumber);

            // Fill the peptide map: for each spectrum get the corressponding peptide list.
            //peptideMap.put(spectrumNumber, pepList);


            //int spectrumID = spectrum.getSpectrumId();
            String label = supportData.getFragIonSpectrumDescription();
            
            
            //specIdentRes.setSpectraData(spectraData); //not implemented yet - don't see why this is needed
            specIdentRes.setSpectrumID(label);
            specIdentRes.setSpectraDataRef(spectraDataID);
            specIdentRes.setId("SIR_"+ sirCounter);
            specIdentResults.add(specIdentRes);

            int precursorCharge = spectrum.getPrecursorCharge();
            double precursorMh = spectrum.getPrecursorMh();
            String accession = spectrum.getLabel();
            boolean identified = false;
            if(pepList.isEmpty()) {
                identified = false;
            } else {
                identified = true;
            }


            sii.setExperimentalMassToCharge(precursorMh);
            sii.setChargeState(precursorCharge);
            sii.setRank(1);
            sii.setPeptide(mzidPep);
            sii.setId("SII_"+ sirCounter + "_" + siiCounter);

            sirCounter++;
            siiCounter++;

            List<CvParam> cvParamList = sii.getCvParam();
            CvParam cvParam = new CvParam();
            cvParam.setCv(null);    //TODO
            cvParam.setAccession("MS:1001330"); //TODO replace with better scheme rather than hard coding
            cvParam.setName("xtandem:expect");
            cvParam.setValue("" + evalue);
            cvParam.setCvRef(psiCvID);
            //<cvParam accession="MS:1001330" name="xtandem:expect" cvRef="PSI-MS"  value="1.1e-003" />


            cvParamList.add(cvParam);

            //<cvParam accession="MS:1001331" name="xtandem:hyperscore" cvRef="PSI-MS"  value="60.4" />
            CvParam cvParam2 = new CvParam();
            cvParam2.setCv(null);    //TODO
            cvParam2.setAccession("MS:1001331"); //TODO replace with better scheme rather than hard coding
            cvParam2.setName("xtandem:hyperscore");
            cvParam2.setValue("" + hyperscore);
            cvParam2.setCvRef(psiCvID);
            cvParamList.add(cvParam2);


            siiList.add(sii);
            peptideList.add(mzidPep);               //The logic within X!Tandem is slightly complicated - need to test if the sequence is the same (new PepEvid) or different (new SII) - only for I or L within pep sequences
                                                    //TO - currently only implements the case where the same peptide matches to different proteins


            // Initialize the array lists
            //ArrayList<Double> mzValues;
            //ArrayList<Double> intensityValues;

            // Get the spectrum fragment mz and intensity values
            //mzValues = supportData.getXValuesFragIonMass2Charge();

            //intensityValues = supportData.getYValuesFragIonMass2Charge();

            // Fill the maps
            //allMzValues.put(new Integer(spectrumNumber), mzValues);
           // allIntensityValues.put(new Integer(spectrumNumber), intensityValues);


         }

    }

    public void handleCVs(){


        //<cv id="PSI-MS" fullName="PSI-MS" URI="http://psidev.cvs.sourceforge.net/viewvc/*checkout*/psidev/psi/psi-ms/mzML/controlledVocabulary/psi-ms.obo" version="2.25.0"/>
        //<cv id="UNIMOD" fullName="UNIMOD" URI="http://www.unimod.org/obo/unimod.obo" />
        //<cv id="UO" fullName="UNIT-ONTOLOGY" URI="http://obo.cvs.sourceforge.net/*checkout*/obo/obo/ontology/phenotype/unit.obo"></cv>

        cvList = new CvList();
        List<Cv> localCvList = cvList.getCv();
        Cv cv1 = new Cv();
        cv1.setURI("http://psidev.cvs.sourceforge.net/viewvc/*checkout*/psidev/psi/psi-ms/mzML/controlledVocabulary/psi-ms.obo");
        cv1.setId(psiCvID);
        cv1.setVersion("2.25.0");
        cv1.setFullName("PSI-MS");

        Cv cv2 = new Cv();
        cv2.setURI("http://www.unimod.org/obo/unimod.obo");
        cv2.setId(unimodID);
        cv2.setFullName("UNIMOD");

        Cv cv3 = new Cv();
        cv3.setURI("http://obo.cvs.sourceforge.net/*checkout*/obo/obo/ontology/phenotype/unit.obo");
        cv3.setId(unitCvID);
        cv3.setFullName("UNIT-ONTOLOGY");
        
        localCvList.add(cv1);
        localCvList.add(cv2);
        localCvList.add(cv3);        
    }

     /**
      *
      * Aim is to write out set up the analysisSoftwareList following this structure:
      *  <AnalysisSoftware id="ID_software" name="xtandem" version="2008.12.1.1" >
      *      <SoftwareName>
      *              <cvParam accession="MS:1001476" name="xtandem" cvRef="PSI-MS" />
      *      </SoftwareName>
      *
     */
    public void handleAnalysisSoftware(String version){
        analysisSoftwareList = new AnalysisSoftwareList();
        List<AnalysisSoftware> analysisSoftwares = analysisSoftwareList.getAnalysisSoftware();
        AnalysisSoftware analysisSoftware = new AnalysisSoftware();
        analysisSoftware.setName("xtandem");
        analysisSoftware.setId(analysisSoftID);
        analysisSoftware.setVersion(version);

        CvParam cvParam = new CvParam();
        cvParam.setName("xtandem");
        cvParam.setCvRef(psiCvID);
        cvParam.setAccession("MS:1001476");
        ParamAlternative paramAlt = new ParamAlternative();
        paramAlt.setCvParam(cvParam);
        analysisSoftware.setSoftwareName(paramAlt);

        analysisSoftwares.add(analysisSoftware);
        
    }


    /**
     *  Setup Provider element as follows
     *	<Provider id="PROVIDER">
     *      <ContactRole Contact_ref="PERSON_DOC_OWNER">
     *		<role>
     *			<cvParam accession="MS:1001271" name="researcher" cvRef="PSI-MS"/>
     *          </role>
     *		</ContactRole>
     *	</Provider>
     *
     */
    public void handleProvider(){
        provider = new Provider();
        provider.setId("PROVIDER");
        ContactRole contactRole = new ContactRole();
        contactRole.setContactRef("PERSON_DOC_OWNER");
        Role role = new Role();
        CvParam cvParam = new CvParam();
        cvParam.setAccession("MS:1001271");
        cvParam.setName("researcher");
        cvParam.setCvRef(psiCvID);
        role.setCvParam(cvParam);
        contactRole.setRole(role);
        
    }

    /**  TO DO Capture name and email of the user
     *	<AuditCollection>
     *		<Person id="PERSON_DOC_OWNER" firstName="Andy" lastName="Jones" email="someone@someuniversity.com">
     *			<affiliations Organization_ref="ORG_DOC_OWNER"/>
     *		</Person>
     *		<Organization id="ORG_DOC_OWNER" address="Some address" name="Some place" />
     *	</AuditCollection>
     *
     *
     */
    public void handleAuditCollection(String firstName, String lastName, String email, String address, String affiliationName){
        auditCollection = new AuditCollection();
        List<Contact> contactList = auditCollection.getContactGroup();
        Person person = new Person();
        person.setId("PERSON_DOC_OWNER");
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);

        Organization org = new Organization();
        org.setId("ORG_DOC_OWNER");
        org.setName(affiliationName);
        org.setAddress(address);


        List<Affiliations> affList = person.getAffiliations();
        Affiliations aff = new Affiliations();
        aff.setOrganization(org);
        affList.add(aff);
        contactList.add(person);
        contactList.add(org);

    }


    /**
     * TODO This part is optional in the file - not yet completed
     *
     *
     *
     */
   public void handleAnalysisSampleCollection(){
        analysisSampleCollection = new AnalysisSampleCollection();

   }

   /**
    *  	<AnalysisCollection>
    *		<SpectrumIdentification id="SI_1" SpectrumIdentificationProtocol_ref="SearchProtocol" SpectrumIdentificationList_ref="siiListID" activityDate="2008-02-27T08:22:12">
    *			<InputSpectra SpectraData_ref="SD_1"/>
    *			<SearchDatabase SearchDatabase_ref="search_database"/>
    *		</SpectrumIdentification>
    *	</AnalysisCollection>
    *
    */
   public void handleAnalysisCollection(String activityDate){
        analysisCollection = new AnalysisCollection();
        List<SpectrumIdentification> specIdentList = analysisCollection.getSpectrumIdentification();
        SpectrumIdentification specIdent = new SpectrumIdentification();
        specIdent.setId(specIdentID);
        specIdent.setSpectrumIdentificationListRef(siiListID);
        specIdent.setSpectrumIdentificationProtocolRef(siProtocolID);
        specIdentList.add(specIdent);

        List<InputSpectra> inputSpecList = specIdent.getInputSpectra();
        InputSpectra inputSpec = new InputSpectra();
        inputSpec.setSpectraDataRef(spectraDataID);
        inputSpecList.add(inputSpec);

        List<SearchDatabase> searchDBList = specIdent.getSearchDatabase();
        SearchDatabase searchDB = new SearchDatabase();
        searchDB.setSearchDatabaseRef(searchDBID);
        searchDBList.add(searchDB);

        
       
   }


   /**
    *	<AnalysisProtocolCollection>
            <SpectrumIdentificationProtocol id="SearchProtocol" AnalysisSoftware_ref="ID_software">
                    <SearchType>
                            <cvParam accession="MS:1001083" name="ms-ms search" cvRef="PSI-MS"/>
                    </SearchType>
                    <AdditionalSearchParams>
                            <cvParam accession="MS:1001211" name="parent mass type mono"    cvRef="PSI-MS"/>
                            <cvParam accession="MS:1001256" name="fragment mass type mono"    cvRef="PSI-MS"/>
                    </AdditionalSearchParams>
                    <ModificationParams>
                            <SearchModification fixedMod="true">
                                    <ModParam massDelta="57.021464" residues="C">
                                            <cvParam accession="UNIMOD:4" name="Carbamidomethyl" cvRef="UNIMOD" />
                                    </ModParam>
                            </SearchModification>
                            <SearchModification fixedMod="false">
                                    <ModParam massDelta="15.994919" residues="M">
                                            <cvParam accession="UNIMOD:35" name="Oxidation" cvRef="UNIMOD" />
                                    </ModParam>
                            </SearchModification>
                    </ModificationParams>
                    <Enzymes independent="0">
                            <Enzyme id="ENZ_1" CTermGain="OH" NTermGain="H" missedCleavages="1" semiSpecific="0">
                            <EnzymeName>
                            <cvParam accession="MS:1001251" name="Trypsin" cvRef="PSI-MS" />
                            </EnzymeName>
                            </Enzyme>
                    </Enzymes>
                    <MassTable id="0" msLevel="2">
                    </MassTable>
                    <FragmentTolerance>
                            <cvParam accession="MS:1001412" name="search tolerance plus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                            <cvParam accession="MS:1001413" name="search tolerance minus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                    </FragmentTolerance>
                    <ParentTolerance>
                            <cvParam accession="MS:1001412" name="search tolerance plus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                            <cvParam accession="MS:1001413" name="search tolerance minus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                    </ParentTolerance>
                    <Threshold>
                            <cvParam accession="MS:1001494" name="no threshold" cvRef="PSI-MS" />
                    </Threshold>
            </SpectrumIdentificationProtocol>
    </AnalysisProtocolCollection>
    *
    *
    */
   public void handleAnalysisProtocolCollection(Boolean parentIsMono, Boolean fragmentIsMono, SearchModification[] searchMods, String enzymeName, Double fragTolPlus, Double fragTolMinus, Double parTolPlus, Double parTolMinus){

        analysisProtocolCollection = new AnalysisProtocolCollection();
        List<SpectrumIdentificationProtocol> sipList = analysisProtocolCollection.getSpectrumIdentificationProtocol();

        SpectrumIdentificationProtocol siProtocol = new SpectrumIdentificationProtocol();
        siProtocol.setId(siProtocolID);
        siProtocol.setAnalysisSoftwareRef(analysisSoftID);

        //<cvParam accession="MS:1001083" name="ms-ms search" cvRef="PSI-MS"/>
        CvParam cvParam = new CvParam();
        cvParam.setName("ms-ms search");
        cvParam.setCvRef(psiCvID);
        cvParam.setAccession("MS:1001083");
        ParamAlternative paramAlt = new ParamAlternative();
        paramAlt.setCvParam(cvParam);
        
        siProtocol.setSearchType(paramAlt);


        ParamAlternativeList addSearchParamList = new ParamAlternativeList();
        List<Param> paramList = addSearchParamList.getParamGroup();

        CvParam cvParam1 = new CvParam();
        CvParam cvParam2 = new CvParam();

        if(parentIsMono){
            cvParam1.setName("parent mass type mono");
            cvParam1.setCvRef(psiCvID);
            cvParam1.setAccession("MS:1001211");
        }
        else{
            cvParam1.setName("parent mass type average");
            cvParam1.setCvRef(psiCvID);
            cvParam1.setAccession("MS:1001212");
        }

        if(fragmentIsMono){
            cvParam1.setName("fragment mass type mono");
            cvParam1.setCvRef(psiCvID);
            cvParam1.setAccession("MS:1001256");
        }
        else{
            cvParam1.setName("fragment mass type average");
            cvParam1.setCvRef(psiCvID);
            cvParam1.setAccession("MS:1001255");
        }

        paramList.add(cvParam1);
        paramList.add(cvParam2);
        siProtocol.setAdditionalSearchParams(addSearchParamList);
        //TODO Appears to be a problem with writing out ParamGroup - used in a few places...


        //TODO Modification Params - need to get these from input.xml and default_input.xml

        ModificationParams modParams = new ModificationParams();
        List<SearchModification> searchModList = modParams.getSearchModification();

        SearchModification searchMod = new SearchModification();

        //One example for variable Oxidation on M
        searchMod.setFixedMod(false);
        ModParam modParam = new ModParam();
        modParam.setMassDelta(new Float(15.994919));
        modParam.setCvParam(getModCV(15.994919));
        searchModList.add(searchMod);
     
                /*
            <ModificationParams>
                <SearchModification fixedMod="false">
                          <ModParam massDelta="15.994919" residues="M">
                            <cvParam accession="UNIMOD:35" name="Oxidation" cvRef="UNIMOD" />
                         </ModParam>
                </SearchModification>
                */

        /*
            <Enzymes independent="0">
                <Enzyme id="ENZ_1" CTermGain="OH" NTermGain="H" missedCleavages="1" semiSpecific="0">
                <EnzymeName>
                <cvParam accession="MS:1001251" name="Trypsin" cvRef="PSI-MS" />
                </EnzymeName>
                </Enzyme>
             </Enzymes>
*/

        Enzymes enzymes = new Enzymes();
        enzymes.setIndependent(false);

        Enzyme enzyme = new Enzyme();
        //TODO only trypsin implemented - this is difficult to convert from Regex used in X!Tandem
        if(enzymeName.equalsIgnoreCase("trypsin")){
            enzyme.setId("Enz1");
            enzyme.setCTermGain("OH");
            enzyme.setNTermGain("H");
            enzyme.setMissedCleavages(1);
            enzyme.setSemiSpecific(false);

            ParamAlternativeList enzNameList = new ParamAlternativeList();
            List<Param> paramList1 = addSearchParamList.getParamGroup();

            CvParam cvParam3 = new CvParam();
            cvParam3.setName("Trypsin");
            cvParam3.setAccession("MS:1001251");
            cvParam3.setCvRef(psiCvID);                
            
           
        }
        else{
            //TODO
        }

        siProtocol.setEnzymes(enzymes);


        Tolerance fragTol = new Tolerance();
        Tolerance parTol = new Tolerance();

        List<CvParam> fragCvList = fragTol.getCvParam();
        CvParam fragCvPlus = getCvParamWithMassUnits(true);
        CvParam fragCvMinus = getCvParamWithMassUnits(true);
        

        /*
         <FragmentTolerance>
                            <cvParam accession="MS:1001412" name="search tolerance plus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                            <cvParam accession="MS:1001413" name="search tolerance minus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                    </FragmentTolerance>
                    <ParentTolerance>
                            <cvParam accession="MS:1001412" name="search tolerance plus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                            <cvParam accession="MS:1001413" name="search tolerance minus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
                    </ParentTolerance>
          */

        fragCvPlus.setAccession("MS:1001412");
        fragCvPlus.setName("search tolerance plus value");
        fragCvMinus.setAccession("MS:1001413");
        fragCvMinus.setName("search tolerance minus value");
        fragCvPlus.setValue(""+fragTolPlus);
        fragCvMinus.setValue(""+fragTolMinus);
        fragCvList.add(fragCvPlus);
        fragCvList.add(fragCvMinus);

        List<CvParam> parCvList = parTol.getCvParam();
        CvParam parCvPlus = getCvParamWithMassUnits(true);
        CvParam parCvMinus = getCvParamWithMassUnits(true);
        
        parCvPlus.setAccession("MS:1001412");
        parCvPlus.setName("search tolerance plus value");
        parCvMinus.setAccession("MS:1001413");
        parCvMinus.setName("search tolerance minus value");
        parCvPlus.setValue(""+parTolPlus);
        parCvMinus.setValue(""+parTolMinus);
        parCvList.add(parCvPlus);
        parCvList.add(parCvMinus);

        siProtocol.setFragmentTolerance(fragTol);
        siProtocol.setParentTolerance(parTol);

        ParamAlternativeList thresholdList = new ParamAlternativeList();
        List<Param> thresholdParamList = thresholdList.getParamGroup();

        CvParam cvParam4 = new CvParam();
        cvParam4.setName("no threshold");
        cvParam4.setCvRef(psiCvID);
        cvParam4.setAccession("MS:1001494");
        thresholdParamList.add(cvParam4);

        //<cvParam accession="MS:1001494" name="no threshold" cvRef="PSI-MS" />
        siProtocol.setThreshold(thresholdList);
        


        sipList.add(siProtocol);

   }

   public void writeMzidFile(){

        try {
            FileWriter writer = new FileWriter("tandem_output.xml");
            MzIdentMLMarshaller m = new MzIdentMLMarshaller();

            // mzIdentML
            //     cvList
            //     AnalysisSoftwareList
            //     Provider
            //     AuditCollection
            //     AnalysisSampleCollection
            //     SequenceCollection
            //     AnalysisCollection
            //     AnalysisProtocolCollection
            //     DataCollection
            //         Inputs
            //         AnalysisData
            //             SpectrumIdentificationList
            //             ProteinDetectionList
            //         /AnalysisData
            //     /DataCollection
            //     BibliographicReference
            // /mzIdentML


            // Note: writing of '\n' characters is optional and only for readability of the produced XML document
            // Also note: since the XML is produced in individual parts, the overall formatting of the document
            //            is not as nice as it would be when marshalling the whole structure at once.

            // XML header
            writer.write(m.createXmlHeader() + "\n");


            // mzIdentML start tag
            
            writer.write(m.createMzIdentMLStartTag("12345") + "\n");



            m.marshall(cvList, writer);
            writer.write("\n");

            m.marshall(analysisSoftwareList, writer);
            writer.write("\n");


            m.marshall(provider, writer);
            writer.write("\n");


            m.marshall(auditCollection, writer);
            writer.write("\n");


            //m.marshall(analysisSampleCollection, writer);     //TODO - complete this part
            //writer.write("\n");


            m.marshall(sequenceCollection, writer);
            writer.write("\n");

           
            
            m.marshall(analysisCollection, writer);
            writer.write("\n");

           
            m.marshall(analysisProtocolCollection, writer);
            writer.write("\n");
      

            writer.write(m.createDataCollectionStartTag() + "\n");



            //Inputs inputs = unmarshaller.unmarshal(MzIdentMLElement.Inputs.getXpath());
            //m.marshall(inputs, writer);
            //writer.write("\n");

            writer.write(m.createAnalysisDataStartTag() + "\n");

           // writer.write(m.createSpectrumIdentificationListStartTag("SIL_1", null, 71412L) + "\n");

            //FragmentationTable table = unmarshaller.unmarshal(MzIdentMLElement.FragmentationTable.getXpath());
            //m.marshall(table, writer);
            //writer.write("\n");

           
            //Iterator<SpectrumIdentificationResult> specResIter = unmarshaller.unmarshalCollectionFromXpath(MzIdentMLElement.SpectrumIdentificationResult);

            /*
            Iterator<SpectrumIdentificationResult> specResIter = specIdentResults.iterator();
            while (specResIter.hasNext()) {
                SpectrumIdentificationResult specIdentRes = specResIter.next();
                m.marshall(specIdentRes, writer);
                writer.write("\n");
            }
            */

            m.marshall(siList, writer);
            writer.write("\n");


           // writer.write(m.createSpectrumIdentificationListClosingTag() + "\n");

           writer.write(m.createProteinDetectionListStartTag("PDL_1", null) + "\n");

            /*
            Iterator<ProteinAmbiguityGroup> protAmbGroupIter = unmarshaller.unmarshalCollectionFromXpath(MzIdentMLElement.ProteinAmbiguityGroup);
            while (protAmbGroupIter.hasNext()) {
                ProteinAmbiguityGroup protAmbGroup = protAmbGroupIter.next();
                m.marshall(protAmbGroup, writer);
                writer.write("\n");
            }

             */
            
            writer.write(m.createProteinDetectionListClosingTag() + "\n");

            writer.write(m.createAnalysisDataClosingTag() + "\n");

            writer.write(m.createDataCollectionClosingTag() + "\n");

            //BibliographicReference ref = unmarshaller.unmarshal(MzIdentMLElement.BibliographicReference.getXpath());
           // m.marshall(ref, writer);
           // writer.write("\n");
            


            writer.write(m.createMzIdentMLClosingTag());

            writer.close();

        } catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Method to guess the Unimod entry from a given mass
     * TODO - complete for all mods or import code to do this properly
     *
     */
    public CvParam getModCV(Double mass){

        CvParam modParam = new CvParam();

        /*
            <Modification location="11" residues="M" monoisotopicMassDelta="15.994919">
                <cvParam accession="UNIMOD:35" name="Oxidation" cvRef="UNIMOD"/>
            </Modification>
            <Modification location="13" residues="C" monoisotopicMassDelta="57.021464">
                    <cvParam accession="UNIMOD:4" name="Carbamidomethyl" cvRef="UNIMOD"/>
            </Modification>
        */

        if(mass <16 && mass >15.9 ){
            modParam.setAccession("UNIMOD:35");
            modParam.setCvRef(unimodID);
            modParam.setName("Oxidation");
        }
        else if(mass <57.1 && mass > 57.0){
            modParam.setAccession("UNIMOD:4");
            modParam.setCvRef(unimodID);
            modParam.setName("Carbamidomethyl");
        }
        else{

            System.out.println("Error: modification with mass not recognized");
            modParam.setName("ERROR");
        }

        return modParam;
    }

    /**
     * Helper method to setup a CvParam with CVRef, with either Daltons or ppm as units
     *
     */

    public CvParam getCvParamWithMassUnits(Boolean isDaltonUnit){
        CvParam cvParam = new CvParam();

         //<cvParam accession="MS:1001413" name="search tolerance minus value" value="0.5" cvRef="PSI-MS" unitAccession="UO:0000221" unitName="dalton" unitCvRef="UO" />
        cvParam.setCvRef(psiCvID);
        cvParam.setUnitCvRef(unitCvID);

        if(isDaltonUnit){
            cvParam.setUnitAccession("UO:0000221");           
            cvParam.setUnitName("dalton");
        }
        else{
            cvParam.setUnitAccession("UO:0000169");
            cvParam.setUnitName("parts per million");
        }
        return cvParam;
    }

    public CvParam getFragmentCVParam(int iontype){

        CvParam cvParam = new CvParam();
        cvParam.setCvRef(psiCvID);

        /*
id: MS:1001108 name: param: a ion
id: MS:1001118 name: param: b ion
id: MS:1001119 name: param: c ion
id: MS:1001146 name: param: a ion-NH3
id: MS:1001148 name: param: a ion-H2O
id: MS:1001149 name: param: b ion-NH3
id: MS:1001150 name: param: b ion-H2O
id: MS:1001151 name: param: y ion-NH3
id: MS:1001152 name: param: y ion-H2O
id: MS:1001257 name: param: v ion
id: MS:1001258 name: param: d ion
id: MS:1001259 name: param: immonium ion
id: MS:1001260 name: param: w ion
id: MS:1001261 name: param: x ion
id: MS:1001262 name: param: y ion
id: MS:1001263 name: param: z ion
id: MS:1001406 name: param: internal yb ion
id: MS:1001407 name: param: internal ya ion
id: MS:1001408 name: param: z+1 ion
id: MS:1001409 name: param: z+2 ion
         */
        switch (iontype) {
            case FragmentIon.A_ION:
                cvParam.setAccession("MS:1001108");
                cvParam.setName("param: a ion");
            case FragmentIon.AH2O_ION:
                cvParam.setAccession("MS:1001148");
                cvParam.setName("a ion-H2O");
            case FragmentIon.ANH3_ION:
                cvParam.setAccession("MS:1001146");
                cvParam.setName("param: a ion-NH3");
            case FragmentIon.B_ION:
                cvParam.setAccession("MS:1001118");
                cvParam.setName("param: b ion");
            case FragmentIon.BH2O_ION:
                cvParam.setAccession("MS:1001150");
                cvParam.setName("param: b ion-H2O");
            case FragmentIon.BNH3_ION:
                cvParam.setAccession("MS:1001149");
                cvParam.setName("param: b ion-NH3");
            case FragmentIon.C_ION:
                cvParam.setAccession("MS:1001108");
                cvParam.setName("param: a ion");
            case FragmentIon.X_ION:
                cvParam.setAccession("MS:1001261");
                cvParam.setName("param: x ion");
            case FragmentIon.Y_ION:
                cvParam.setAccession("MS:1001262");
                cvParam.setName("param: y ion");
            case FragmentIon.YH2O_ION: 
                cvParam.setAccession("MS:1001152");
                cvParam.setName("param: y ion-H2O");
            case FragmentIon.YNH3_ION:
                cvParam.setAccession("MS:1001151");
                cvParam.setName("param: y ion-NH3");
            case FragmentIon.Z_ION:
                cvParam.setAccession("MS:1001263");
                cvParam.setName("param: z ion");
            case FragmentIon.MH_ION:
                cvParam.setAccession("No Cv term?");
                cvParam.setName("param: MH ion");
            case FragmentIon.MHNH3_ION:
                cvParam.setAccession("No Cv term?");
                cvParam.setName("param: MH ion-NH3");
            case FragmentIon.MHH2O_ION:
                cvParam.setAccession("No Cv term?");
                cvParam.setName("param: MH ion-H20");
        }

        return cvParam;

    }
    
}


