package uk.ac.ebi.jmzidml.test.xml;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisProtocolCollection;
import uk.ac.ebi.jmzidml.model.mzidml.BibliographicReference;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import java.net.URL;

/**
 * Package  : uk.ac.ebi.jmzidml.test.xml
 * Author   : riteshk
 * Date     : Sep 19, 2010
 */
public class BibliographicTest extends TestCase {

    Logger logger = Logger.getLogger(BibliographicTest.class);


    public void testBibliographicInformation() throws Exception {

        URL xmlFileURL = BibliographicTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        BibliographicReference bib =  unmarshaller.unmarshalFromXpath("/mzIdentML/BibliographicReference", BibliographicReference.class);
        assertNotNull(bib);

        System.out.println("Authors : " + bib.getAuthors()
                            + "\t Editor : " + bib.getEditor()
                            + "\t Publisher : " + bib.getPublisher()
                            + "\t Title : "+ bib.getTitle());

    }

}
