package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 18, 2010
 */
public class SequenceCollectionTest extends TestCase {

    Logger logger = Logger.getLogger(SequenceCollectionTest.class);

    public void testSequenceCollectionInformation() throws Exception {

            URL xmlFileURL = SequenceCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            assertNotNull(xmlFileURL);

            boolean aUseSpectrumCache = true;

            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
            assertNotNull(unmarshaller);

            // Number of Sequence collection
            int totalSequenceCollection = unmarshaller.getObjectCountForXpath("/mzIdentML/SequenceCollection");
            assertEquals(1,totalSequenceCollection);

            SequenceCollection sc = unmarshaller.unmarshalFromXpath("/mzIdentML/SequenceCollection", SequenceCollection.class);
            assertNotNull(sc);

            List<DBSequence> dbsequence  = sc.getDBSequence();
            List<Peptide> peptides       = sc.getPeptide();

            System.out.println("Total number of DBSequences = "+ dbsequence.size());
            System.out.println("Total number of Peptides    = " + peptides.size());

            DBSequence dbsequenceInstance = dbsequence.get(0);
            System.out.println("DBSequence Accen : " + dbsequenceInstance.getAccession()
                                + "\t Id : " + dbsequenceInstance.getId()
                                + "\t Name : " + dbsequenceInstance.getName()
                                + "\t Database name : " + dbsequenceInstance.getAnalysisSearchDatabase().getName()
                                + "\t length :" + dbsequenceInstance.getLength());
            System.out.println("Sequence : " + dbsequenceInstance.getSeq());
            Iterator<Param> p = dbsequenceInstance.getParamGroup().iterator();
            while(p.hasNext()){
                Param param = p.next();
                System.out.println("Param : " + param.getName()
                                    + "\t" + param.getUnitAccession()
                                    + "\t" + param.getValue()
                                    + "\t" + param.getUnitCvRef());
            }

            Peptide peptideInstance = peptides.get(0);
            System.out.println("Peptide Id :" + peptideInstance.getId()
                              +" Sequence : " + peptideInstance.getPeptideSequence());
            Iterator <Modification> mods = peptideInstance.getModification().iterator();
            while(mods.hasNext()){
                Modification m = mods.next();
                System.out.println("Mod location :" + m.getLocation()
                                    + "\t Avg DeltaMass :" + m.getAvgMassDelta()
                                    + "\t Mono Mass : " + m.getMonoisotopicMassDelta());
                Iterator<String> res = m.getResidues().iterator();
                while(res.hasNext())
                    System.out.println("Residue :" + res.next());
            }
    }
}
