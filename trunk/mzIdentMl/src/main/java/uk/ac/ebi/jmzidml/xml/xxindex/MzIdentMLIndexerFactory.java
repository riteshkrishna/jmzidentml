/*
* Date: 26/5/2010
* Adopted by - Ritesh
*
*/


package uk.ac.ebi.jmzidml.xml.xxindex;

import org.apache.log4j.Logger;
import psidev.psi.tools.xxindex.StandardXmlElementExtractor;
import psidev.psi.tools.xxindex.StandardXpathAccess;
import psidev.psi.tools.xxindex.XmlElementExtractor;
import psidev.psi.tools.xxindex.XpathAccess;
import psidev.psi.tools.xxindex.index.IndexElement;
import psidev.psi.tools.xxindex.index.XpathIndex;
import uk.ac.ebi.jmzidml.xml.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MzIdentMLIndexerFactory {

    private static final Logger logger = Logger.getLogger(MzIdentMLIndexerFactory.class);

    private static final MzIdentMLIndexerFactory instance = new MzIdentMLIndexerFactory();
    private static final Pattern ID_PATTERN = Pattern.compile("\\sid\\s*=\\s*['\"]([^'\"]*)['\"]", Pattern.CASE_INSENSITIVE);

    private MzIdentMLIndexerFactory() {
    }

    public static MzIdentMLIndexerFactory getInstance() {
        return instance;
    }

    public MzIdentMLIndexer buildIndex(File xmlFile) {
        return new MzIdentMLIndexerImpl(xmlFile);
    }

    private class MzIdentMLIndexerImpl implements MzIdentMLIndexer {

        private File xmlFile = null;
        private XpathAccess xpathAccess = null;
        private XmlElementExtractor xmlExtractor = null;
        private XpathIndex index = null;
        private String root = null;
        private String mzIdentMLAttributeXMLString = null;

        // Ritesh - Suggestions :
        // Some maps like auditCollectionMap, bibliographicReferenceMap may not be required. Instead we can include
        // maps for spectrumIdentificationItems, peptide_ref etc which will be more looked at.
        private HashMap<String, IndexElement> cvIdMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> analysisSoftwareMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> providerMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> auditCollectionMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> analysisSampleCollectionMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> sequenceCollectionMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> analysisCollectionMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> analysisProtocolCollectionMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> dataCollectionMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> peptideMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> bibliographicReferenceMap = new HashMap<String, IndexElement>();

        private HashMap<String, IndexElement> dbSequenceMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> peptideEvidenceMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> personMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> organizationMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> analysisSearchDatabaseMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> spectraDataMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> spectrumIdentificationListMap = new HashMap<String, IndexElement>();
        private HashMap<String, IndexElement> spectrumIdentificationProtocolMap = new HashMap<String, IndexElement>();

        private MzIdentMLIndexerImpl(File xmlFile) {

            if (xmlFile == null) {
                throw new IllegalStateException("XML File to index must not be null");
            }
            if (!xmlFile.exists()) {
                throw new IllegalStateException("XML File to index does not exist: " + xmlFile.getAbsolutePath());
            }

            try {

                //store file reference
                this.xmlFile = xmlFile;

                //generate XXINDEX
                logger.info("Creating index: ");
                xpathAccess = new StandardXpathAccess(xmlFile, Constants.XML_INDEXED_XPATHS);
                logger.debug("done!");

                //create xml element extractor
                xmlExtractor = new StandardXmlElementExtractor();
                xmlExtractor.setEncoding(xmlExtractor.detectFileEncoding(xmlFile.toURI().toURL()));

                //create index
                index = xpathAccess.getIndex();

                root = "/mzIdentML";
                // check if the xxindex contains this root
                if (!index.containsXpath(root)) {
                    logger.info("We are dealing with an mzIndentML file!");
                    throw new IllegalStateException("Invalid XML - /mzIndentML not found!");
                }

                //cv cache
                logger.info("Init CV cache");
                initIdMapCache(cvIdMap, "/cvList/cv");

                //dataProcessing cache
                logger.info("Init AnalysisSoftware cache");
                initIdMapCache(analysisSoftwareMap, "/AnalysisSoftwareList/AnalysisSoftware");

                //provider cache
                logger.info("Init Provider cache");
                initIdMapCache(providerMap, "/Provider");

                //auditCollection cache
                logger.info("Init AuditCollection cache");
                initIdMapCache(auditCollectionMap, "/AuditCollection");

                //AnalysisSampleCollection cache
                logger.info("Init AnalysisSampleCollection cache");
                initIdMapCache(analysisSampleCollectionMap, "/AnalysisSampleCollection");

                //SequenceCollection cache
                logger.info("Init sequenceCollection cache");
                initIdMapCache(sequenceCollectionMap, "/SequenceCollection");

                //analysisCollection cache
                logger.info("Init AnalysisCollection cache");
                initIdMapCache(analysisCollectionMap, "/AnalysisCollection");

                //analysisProtocolCollection cache
                logger.info("Init AnalysisProtocolCollection cache");
                initIdMapCache(analysisProtocolCollectionMap, "/AnalysisProtocolCollection");

                //dataCollection cache
                logger.info("Init DataCollection cache");
                initIdMapCache(dataCollectionMap, "/DataCollection");

                //bibliographicReferenceMap cache
                logger.info("Init BibliographicReference cache");
                initIdMapCache(bibliographicReferenceMap, "/BibliographicReference");

                //peptide cache
                logger.info("Init Peptide cache");
                initIdMapCache(peptideMap, "/SequenceCollection/Peptide");

                //DBSequence cache
                logger.info("Init DBSequence cache");
                initIdMapCache(dbSequenceMap, "/SequenceCollection/DBSequence");
                
                //PeptideEvidenceMap cache
                logger.info("Init PeptideEvidence cache");
                initIdMapCache(peptideEvidenceMap, "/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/PeptideEvidence");
                
                //contact cache for Person elements
                logger.info("Init Person cache");
                initIdMapCache(personMap, "/AuditCollection/Person");
                //contact cache for Organisation elements
                logger.info("Init Organization cache");
                initIdMapCache(organizationMap, "/AuditCollection/Organization");

                //contact cache for SearchDatabase elements
                logger.info("Init SearchDatabase cache");
                initIdMapCache(analysisSearchDatabaseMap, "/DataCollection/Inputs/SearchDatabase");

                //contact cache for SpectraData elements
                logger.info("Init SpectraData cache");
                initIdMapCache(spectraDataMap, "/DataCollection/Inputs/SpectraData");

                //contact cache for SpectrumIdentificationList elements
                logger.info("Init SpectrumIdentificationList cache");
                initIdMapCache(spectrumIdentificationListMap, "/DataCollection/AnalysisData/SpectrumIdentificationList");

                //contact cache for SpectrumIdentificationProtocol elements
                logger.info("Init SpectrumIdentificationProtocol cache");
                initIdMapCache(spectrumIdentificationProtocolMap, "/AnalysisProtocolCollection/SpectrumIdentificationProtocol");

                
                //extract the MzIdentML attributes from the MzML start tag
                //get start position
                List<IndexElement> ie = index.getElements(root);
                //there is only one root
                IndexElement rootEl = ie.get(0);
                long startPos = rootEl.getStart();

                //get end position - this is the start position of the next tag
                ie = index.getElements(root + "/cvList");
                //there will always be one and only one cvList
                IndexElement cvListEl = ie.get(0);

                long stopPos = cvListEl.getStart() - 1;

                //get mzML start tag content
                mzIdentMLAttributeXMLString = xmlExtractor.readString(startPos, stopPos, xmlFile);
                if (mzIdentMLAttributeXMLString != null) {
                    //strip newlines that might interfere with later on regex matching
                    mzIdentMLAttributeXMLString = mzIdentMLAttributeXMLString.replace("\n", "");
                }
            } catch (IOException e) {
                logger.error("MzMLIndexerFactory$MzMlIndexerImpl.MzMlIndexerImpl", e);
                throw new IllegalStateException("Could not generate index file for: " + xmlFile);
            }

        }


        public String getMzIdentMLAttributeXMLString() {
            return mzIdentMLAttributeXMLString;
        }

        private void initIdMapCache(HashMap<String, IndexElement> idMap, String xpath) throws IOException {
            List<IndexElement> ranges = index.getElements(root + xpath);
            for (IndexElement byteRange : ranges) {
                String xml = readXML(byteRange);
                String id = getIdFromRawXML(xml);
                if (id != null) {
                    idMap.put(id, byteRange);
                }
            }
        }

        private String getIdFromRawXML(String xml) {
            Matcher match = ID_PATTERN.matcher(xml);
            if (match.find()) {
                return match.group(1).intern();
            } else {
                throw new IllegalStateException("Invalid ID in xml: " + xml);
            }
        }


        //
        // Ritesh - We may not need /indexedmzML altogether
        //
        public Iterator<String> getXmlStringIterator(String xpathExpression) {
            // check if we are required to provide the indexList of the indexedmzML
            if (xpathExpression.contains("indexList") || xpathExpression.contains("fileChecksum")) {
                // we can not use the root "mzML", since the mzML index list is outside the mzML!
                return xpathAccess.getXmlSnippetIterator("/indexedmzML" + checkRoot(xpathExpression));
            } else {
                // Note: ! root is always the mzML element (even if we are dealing with indexedmzML) !
                return xpathAccess.getXmlSnippetIterator(root + checkRoot(xpathExpression));
            }
        }

        private String checkRoot(String xpathExpression) {
            // since we're appending the root we've already checked, make
            // sure that the xpath doesn't erroneously contain that root

            // get rid of possible '/indexedmzML' root
            String unrootedXpath = xpathExpression;
//            if (unrootedXpath.startsWith("/indexedmzML")) {
//                unrootedXpath = unrootedXpath.substring("/indexedmzML".length());
//                logger.debug("removed /indexedmzML root expression");
//            }
            // get rid of possible '/mzML' root
            if (unrootedXpath.startsWith("/mzIdentML")) {
                unrootedXpath = unrootedXpath.substring("/mzIdentML".length());
                logger.debug("removed /mzIdentML root expression");
            }
            return unrootedXpath;
        }

        private String readXML(IndexElement byteRange) {
            try {
                if (byteRange != null) {
                    return xmlExtractor.readString(byteRange.getStart(), byteRange.getStop(), xmlFile);
                } else {
                    throw new IllegalStateException("Attempting to read NULL ByteRange");
                }
            } catch (IOException e) {
                logger.error("MzMLIndexerFactory$MzMlIndexerImpl.readXML", e);
                throw new IllegalStateException("Could not extract XML from file: " + xmlFile);
            }
        }

        public int getCount(String xpathExpression) {
            int retval = 0;
            List<IndexElement> tmpList = index.getElements(root + checkRoot(xpathExpression));
            if (tmpList != null) {
                retval = tmpList.size();
            }
            return retval;
        }

        public String getXmlString(String xpath, long offset) {
            String retVal = null;
            List<IndexElement> indexElements = index.getElements(xpath);
            for (IndexElement indexElement : indexElements) {
                if (indexElement.getStart() == offset) {
                    // found what we are looking for
                    try {
                        retVal = xmlExtractor.readString(indexElement.getStart(), indexElement.getStop(), xmlFile);
                    } catch (IOException ioe) {
                        logger.error("MzIdentMLIndexerFactory$MzMlIndexerImpl.getXmlString(xpath, offset)", ioe);
                        throw new IllegalStateException("Could not extract XML from file: " + xmlFile);
                    }
                    break; // there will only be max one element with a specific offset,
                    // but it does not harm to step out of the loop manually
                }
            }
            return retVal;
        }

        public List<IndexElement> getIndexElements(String xpathExpression) {
            return index.getElements(xpathExpression);
        }

        public Set<String> getXpath() {
            return index.getKeys();
        }

        public String getXmlString(String ID, Constants.ReferencedType type) {

            logger.debug("Getting cached ID: " + ID + " from cache: " + type);

            String xml = null;
            switch (type) {

                case CV:
                    xml = readXML(cvIdMap.get(ID));
                    break;
                case AnalysisSoftware:
                    xml = readXML(analysisSoftwareMap.get(ID));
                    break;
                case Provider:
                    xml = readXML(providerMap.get(ID));
                    break;
                case AuditCollection:
                    xml = readXML(auditCollectionMap.get(ID));
                    break;
                case AnalysisSampleCollection:
                    xml = readXML(analysisSampleCollectionMap.get(ID));
                    break;
                case SequenceCollection:
                    xml = readXML(sequenceCollectionMap.get(ID));
                    break;
                case AnalysisCollection:
                    xml = readXML(analysisCollectionMap.get(ID));
                    break;
                case AnalysisProtocolCollection:
                    xml = readXML(analysisProtocolCollectionMap.get(ID));
                    break;
                case DataCollection:
                    xml = readXML(dataCollectionMap.get(ID));
                    break;
                case BibliographicReference:
                    xml = readXML(bibliographicReferenceMap.get(ID));
                    break;
                case Peptide:
                    xml = readXML(peptideMap.get(ID));
                    break;
                case DBSequence:
                    xml = readXML(dbSequenceMap.get(ID));
                    break;
                case PeptideEvidence:
                    xml = readXML(peptideEvidenceMap.get(ID));
                    break;    
                case Person:
                    IndexElement personElement = personMap.get(ID);
                    if (personElement == null) break; // if there it no entry for the ID we break here and return null
                    xml = readXML(personElement);
                    break;
                case Organization:
                    IndexElement organizationElement = organizationMap.get(ID);
                    if (organizationElement == null) break; // if there it no entry for the ID we break here and return null
                    xml = readXML(organizationElement);
                    break;
                case AnalysisSearchDatabase:
                    xml = readXML(analysisSearchDatabaseMap.get(ID));
                    break;
                case SpectraData:
                    xml = readXML(spectraDataMap.get(ID));
                    break;
                case SpectrumIdentificationList:
                    xml = readXML(spectrumIdentificationListMap.get(ID));
                    break;
                case SpectrumIdentificationProtocol:
                    xml = readXML(spectrumIdentificationProtocolMap.get(ID));
                    break;

                default:
                    throw new IllegalStateException("Unkonwn cache type: " + type);

            }

            return xml;

        }


    }

}
