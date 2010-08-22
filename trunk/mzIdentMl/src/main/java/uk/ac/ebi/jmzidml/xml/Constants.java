/*
 * Adoped by Ritesh
 * Date - 26/5/2010
 *
 * The ReferenceType represent the main elements in the XML document.
 *
 * The XPath references have been created according to the main block in the mzIdentML file.
 * 
 */

package uk.ac.ebi.jmzidml.xml;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    public static final String JAXB_ENCODING_PROPERTY = "jaxb.encoding";
    public static final String JAXB_FORMATTING_PROPERTY = "jaxb.formatted.output";
    public static final String JAXB_SCHEMALOCATION_PROPERTY = "jaxb.schemaLocation";
    public static final String JAXB_FRAGMENT_PROPERTY = "jaxb.fragment";


    //This should contain all the schema objects that use key/keyref
    public static enum ReferencedType {

        CV,
        AnalysisSoftware,
        Provider,
        AuditCollection,
        AnalysisSampleCollection,
        SequenceCollection,
        AnalysisCollection,
        AnalysisProtocolCollection,
        DataCollection,
        BibliographicReference,
        Peptide,
        DBSequence,              //Ritesh
        PeptideEvidence        // Ritesh
    }

    private static Set<String> xpathsToIndex = new HashSet<String>();

    static {

        xpathsToIndex.add("/mzIdentML");

        xpathsToIndex.add("/mzIdentML/cvList");
        xpathsToIndex.add("/mzIdentML/cvList/cv");

        xpathsToIndex.add("/mzIdentML/AnalysisSoftwareList");

        xpathsToIndex.add("/mzIdentML/Provider");

        xpathsToIndex.add("/mzIdentML/AuditCollection");

        xpathsToIndex.add("/mzIdentML/AnalysisSampleCollection");
        xpathsToIndex.add("/mzIdentML/AnalysisSampleCollection/Sample");

        xpathsToIndex.add("/mzIdentML/SequenceCollection");
        xpathsToIndex.add("/mzIdentML/SequenceCollection/DBSequence");
        xpathsToIndex.add("/mzIdentML/SequenceCollection/Peptide");

        xpathsToIndex.add("/mzIdentML/AnalysisCollection");

        xpathsToIndex.add("/mzIdentML/AnalysisProtocolCollection");
        xpathsToIndex.add("/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol");
        xpathsToIndex.add("/mzIdentML/AnalysisProtocolCollection/ProteinDetectionProtocol");

        xpathsToIndex.add("/mzIdentML/DataCollection");
        xpathsToIndex.add("/mzIdentML/DataCollection/Inputs");
        xpathsToIndex.add("/mzIdentML/DataCollection/AnalysisData");
        xpathsToIndex.add("/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList");
        xpathsToIndex.add("/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult");
        xpathsToIndex.add("/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem");
        xpathsToIndex.add("/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList");
        xpathsToIndex.add("/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup");
        xpathsToIndex.add("/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis");

        xpathsToIndex.add("/mzIdentML/BibliographicReference");

        // finally make the set unmodifiable
        xpathsToIndex = Collections.unmodifiableSet(xpathsToIndex);
    }

    public static final Set<String> XML_INDEXED_XPATHS = xpathsToIndex;

}
