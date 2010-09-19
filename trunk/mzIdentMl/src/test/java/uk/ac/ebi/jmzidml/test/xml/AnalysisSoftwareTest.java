package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftware;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftwareList;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;
import java.util.Iterator;

/**
 * 
 * User: riteshk
 * Date: Sep 18, 2010
 */
public class AnalysisSoftwareTest extends TestCase {

    Logger logger = Logger.getLogger(AnalysisSoftwareTest.class);

    public void testAnalysisSoftwareInformation() throws Exception {

            URL xmlFileURL = AnalysisSoftwareTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            assertNotNull(xmlFileURL);

            boolean aUseSpectrumCache = true;

            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
            assertNotNull(unmarshaller);

            // Number of Analysis Software
            int totalAnalysisSoftware = unmarshaller.getObjectCountForXpath("/mzIdentML/AnalysisSoftwareList");
            assertEquals(1,totalAnalysisSoftware);

            Iterator<AnalysisSoftware> asl = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/AnalysisSoftwareList/AnalysisSoftware",AnalysisSoftware.class);

            while(asl.hasNext()){
                AnalysisSoftware as = asl.next();
                assertNotNull(as);
                System.out.println("\n Analysis Software -> Name : " + as.getName() + " \t Software : "
                                    + as.getCustomizations() + "\t URI" + as.getURI());
                System.out.println("\n Analysis Software -> Contact -> Name  :" + as.getContactRole().getContact().getName());
                System.out.println("\n Analysis Software -> Software -> Name :" + as.getSoftwareName().getParamGroup().getName()
                                    + "\t cvRef :" + as.getSoftwareName().getParamGroup().getUnitCvRef());
                
                //Todo : Only the name is accessible in the following, other fields come as null  
                // as.getSoftwareName().getParamGroup().getUnitAccession()
                //<SoftwareName>
                //<cvParam accession="MS:1001207" name="Mascot" cvRef="PSI-MS"/>
                //</SoftwareName>
            }

            AnalysisSoftwareList aslist = unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisSoftwareList", AnalysisSoftwareList.class);
            Iterator<AnalysisSoftware> asi = aslist.getAnalysisSoftware().iterator();
            while(asi.hasNext()){
                AnalysisSoftware as = asi.next();
                System.out.println("\n Analysis Software -> Name : " + as.getName() + " \t Software : "
                                                    + as.getCustomizations() + "\t URI" + as.getURI());
                System.out.println("\n Analysis Software -> Contact -> Name  :" + as.getContactRole().getContact().getName());
                System.out.println("\n Analysis Software -> Software -> Name :" + as.getSoftwareName().getParamGroup().getName()
                                                    + "\t cvRef :" + as.getSoftwareName().getParamGroup().getUnitCvRef());
            }

    }

}
