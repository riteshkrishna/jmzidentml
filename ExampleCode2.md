# Using the API - Example 2 #

```
package uk.ac.ebi;

/**
 * Using the element name and XPath to gather information
 */

import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;
import uk.ac.ebi.jmzidml.MzIdentMLElement;

import java.net.URL;
import java.util.Iterator;
import java.util.List;


public class CaseStudyForParser2 {
    public static void main(String[] args) {
          try {

              // Open the input mzIdentML file for parsing
               URL xmlFileURL = CaseStudyForParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");

                if (xmlFileURL != null) {

                   boolean aUseSpectrumCache = true;
                   MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);


                    // Get a list of all the PeptideEvidence. The class name is internally converted to its XPath and the
                    // information is retrieved from indexer. Auto-resolve need not be activated here if we are not resolving
                    // any reference on the fly.
                    Iterator<PeptideEvidence> pepEvdIter = unmarshaller.unmarshalCollectionFromXpath(MzIdentMLElement.PeptideEvidence);

                    // Retrieve information for each PeptideEvidence in the list
                    while (pepEvdIter.hasNext()) {
                        PeptideEvidence element = pepEvdIter.next();
                        System.out.println("PeptideEvidence id: " + element.getId());
                        System.out.println("DBSequence ref : " + element.getDBSequenceRef());
                        System.out.println("Start location = " + element.getStart() + ", End location = " + element.getEnd());
                        System.out.println("\n");
                    }

                }
               }catch(Exception e) {
                    e.printStackTrace(); }
        }

}

```