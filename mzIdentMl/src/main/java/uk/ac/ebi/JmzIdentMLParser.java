/**
 *
 * @author Ritesh
 */

package uk.ac.ebi;

import org.xml.sax.SAXException;
import uk.ac.ebi.jmzidml.model.mzidml.CvList;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationResult;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectIterator;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import javax.xml.parsers.ParserConfigurationException;
import java.net.URL;

public class JmzIdentMLParser {

    public static void main(String[] args) {

        try {

            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            if (xmlFileURL != null) {


                boolean aUseSpectrumCache = true;

                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);

                CvList list = unmarshaller.unmarshalFromXpath("/mzIdentML/cvList", CvList.class);
                System.out.println("list = " + list);

                MzIdentMLObjectIterator iter = unmarshaller.unmarshalCollectionFromXpath("/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult", SpectrumIdentificationResult.class);
                while (iter.hasNext()) {
                    SpectrumIdentificationResult res = (SpectrumIdentificationResult) iter.next();
                    System.out.println("res = " + res.getSpectrumIdentificationItem().get(0).getPeptide());
                }

                System.out.println("Accn : " + unmarshaller.getMzIdentMLAccession());
                System.out.println("Version : " + unmarshaller.getMzIdentMLVersion());
                System.out.println("XPath Obj Count : " + unmarshaller.getObjectCountForXpath("/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem"));

            } else {
                System.err.println("FILE NOT FOUND");
            }

//        File mzIdentMLFile = new File(xmlFileName);
//        String xmlFileName = "C:\\Ritesh_Work\\Work_Done_At_EBI\\Project_Codes\\jmzidentml\\src\\main\\resources\\Mascot_MSMS_example.mzid";

        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
