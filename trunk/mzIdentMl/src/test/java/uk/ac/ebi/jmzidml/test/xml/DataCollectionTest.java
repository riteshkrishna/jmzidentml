package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 19, 2010
 */
public class DataCollectionTest extends TestCase {

    Logger logger = Logger.getLogger(DataCollectionTest.class);


    public void testDataCollectionInformation() throws Exception {

        URL xmlFileURL = DataCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        DataCollection dc =  unmarshaller.unmarshalFromXpath("/mzIdentML/DataCollection", DataCollection.class);
        assertNotNull(dc);

        Inputs dcInputs = dc.getInputs();
        assertNotNull(dcInputs);

        Iterator<AnalysisSearchDatabase> dcInput_dbs = dcInputs.getSearchDatabase().iterator();
        Iterator<SourceFile> dcInput_sf = dcInputs.getSourceFile().iterator();
        Iterator<SpectraData> dcInput_specdata = dcInputs.getSpectraData().iterator();

        while(dcInput_dbs.hasNext()){
            AnalysisSearchDatabase asd = dcInput_dbs.next();
            System.out.println("Inout -> SearchDatabase :"
                                + "\t Location :" + asd.getLocation()
                                + "\t Id :" + asd.getId()
                                + "\t Name :" + asd.getName()
                                + "\t Version : " + asd.getVersion());
            System.out.println("Inout -> SearchDatabase -> fileformat :"
                               + asd.getFileFormat().getCvParam().getAccession());
        }

        while(dcInput_sf.hasNext()){
            SourceFile sf = dcInput_sf.next();
            System.out.println("Input -> SourceFile : Location : "
                                + sf.getLocation());
        }

        while(dcInput_specdata.hasNext()){
            SpectraData sd = dcInput_specdata.next();
            System.out.println("Input -> SpectraData Id : "
                                + sd.getId() + "\t location : " + sd.getLocation());
        }


        System.out.println("********************************************************** ");
        System.out.println("**************** Analysis Data *************************** ");
        System.out.println("********************************************************** ");

        AnalysisData ad = dc.getAnalysisData();
        assertNotNull(ad);

        ProteinDetectionList pdl  = ad.getProteinDetectionList();
        Iterator<SpectrumIdentificationList> sil = ad.getSpectrumIdentificationList().iterator();

        System.out.println("ProteinDetectionList Name : " + pdl.getName() + "\t Id : " + pdl.getId());
        Iterator<ProteinAmbiguityGroup> pag = pdl.getProteinAmbiguityGroup().iterator();
        while(pag.hasNext()){
            ProteinAmbiguityGroup pagInstance = pag.next();
            System.out.println("ProteinDetectionList -> ProteinAmbiguityGroup : Id :"
                                    + pagInstance.getId()
                                    + "\t Name : "+ pagInstance.getName());

            Iterator<ProteinDetectionHypothesis> pdh = pagInstance.getProteinDetectionHypothesis().iterator();
            while(pdh.hasNext()){
                ProteinDetectionHypothesis pdhInstance  = pdh.next();
                System.out.println("ProteinDetectionList -> ProteinAmbiguityGroup -> ProteinDetectionHypothesis Name :"
                        + pdhInstance.getName() + "\t Id : " + pdhInstance.getId());

                System.out.println("ProteinDetectionList -> ProteinAmbiguityGroup -> ProteinDetectionHypothesis -> DBSequence :"
                        + pdhInstance.getDBSequenceProteinDetection().getAnalysisSearchDatabase().getName()
                        + "\t Id : "+ pdhInstance.getDBSequenceProteinDetection().getAnalysisSearchDatabase().getId()
                        + "\t Location : "+ pdhInstance.getDBSequenceProteinDetection().getAnalysisSearchDatabase().getLocation());

                Iterator<PeptideHypothesis> pepHyp  = pdhInstance.getPeptideHypothesis().iterator();
                while(pepHyp.hasNext()){
                    PeptideHypothesis pephypinstance = pepHyp.next();
                    System.out.println("ProteinDetectionList -> ProteinAmbiguityGroup -> ProteinDetectionHypothesis -> PeptideHypothesis "
                        + "Name : " + pephypinstance.getPeptideEvidence().getName()
                        + "Sequence : " + pephypinstance.getPeptideEvidence().getDBSequence().getSeq());

                }
            }
        }


        while(sil.hasNext()){
            SpectrumIdentificationList silInstance = sil.next();
            System.out.println("SpectrumIdentificationList Id :"
                                + silInstance.getId() + "\t Name : " + silInstance.getName());
            System.out.println("SpectrumIdentificationList -> FragmentTable Id :"
                    + silInstance.getFragmentationTable().getMeasure().iterator().next().getId());

            Iterator<SpectrumIdentificationResult> sir = silInstance.getSpectrumIdentificationResult().iterator();
            while(sir.hasNext()){
                SpectrumIdentificationResult sirinstance = sir.next();
                System.out.println("SpectrumIdentificationList ->  SpectrumIdentificationResult Spectrum-Id :"
                                    + sirinstance.getSpectrumID()
                                    + " \t Name : " + sirinstance.getName());
                Iterator<SpectrumIdentificationItem> siilist = sirinstance.getSpectrumIdentificationItem().iterator();
                while(siilist.hasNext()){
                    SpectrumIdentificationItem sii = siilist.next();
                    System.out.println("SpectrumIdentificationList ->  SpectrumIdentificationResult -> SpectrumIdentificationItem :"
                            + " Id : " + sii.getId()
                            + " Name : " + sii.getName());
                    System.out.println("SpectrumIdentificationList ->  SpectrumIdentificationResult -> SpectrumIdentificationItem -> Peptide :"
                                        + " Id : " + sii.getPeptide().getId()
                                        + " Seq : " + sii.getPeptide().getPeptideSequence());

                    Iterator<PeptideEvidence> sii_pepEvd = sii.getPeptideEvidence().iterator();
                    while(sii_pepEvd.hasNext()){
                        PeptideEvidence pepevd = sii_pepEvd.next();
                        System.out.println("SpectrumIdentificationList ->  SpectrumIdentificationResult -> SpectrumIdentificationItem -> PeptideEvidence :"
                                            + " Name : " + pepevd.getName()
                                            + " Seq  :"  + pepevd.getDBSequence().getSeq());
                    }


                }
            }

        }
    }
}
