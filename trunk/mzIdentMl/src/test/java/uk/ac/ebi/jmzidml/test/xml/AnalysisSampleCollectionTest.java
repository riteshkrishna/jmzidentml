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
 * Date     : Sep 18, 2010
 */
public class AnalysisSampleCollectionTest extends TestCase {

    Logger logger = Logger.getLogger(AnalysisSampleCollectionTest.class);


    public void testAnalysisSampleCollectionInformation() throws Exception {

        URL xmlFileURL = AnalysisSampleCollectionTest.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
        assertNotNull(xmlFileURL);

        boolean aUseSpectrumCache = true;

        MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL, aUseSpectrumCache);
        assertNotNull(unmarshaller);

        AnalysisSampleCollection asc =  unmarshaller.unmarshalFromXpath("/mzIdentML/AnalysisSampleCollection", AnalysisSampleCollection.class);
        assertNotNull(asc);

        Iterator<Sample> as = asc.getSample().iterator();
        while(as.hasNext()){
            Sample sample = as.next();
            System.out.println("Analysis Sample : Name = " + sample.getName());
            Iterator <ContactRole> cri = sample.getContactRole().iterator();
            while(cri.hasNext()){
                ContactRole contactrole = cri.next();
                System.out.println("Analysis Sample -> Contact Role : Name = " + contactrole.getContact().getName()
                                    + " \t Address : "+ contactrole.getContact().getAddress()
                                    + " \t Role Accession : " + contactrole.getRole().getCvParam().getAccession());
            }


            Iterator <Param> p = sample.getParamGroup().iterator();
            while(p.hasNext()){
                Param param = p.next();
                System.out.println("Param : " + param.getName()
                                    + "\t" + param.getUnitAccession()
                                    + "\t" + param.getValue()
                                    + "\t" + param.getUnitCvRef());
            }
        }
    }

}
