package uk.ac.ebi.jmzidml.xml.xxindex;

import org.apache.log4j.Logger;
import psidev.psi.tools.xxindex.SimpleXmlElementExtractor;
import psidev.psi.tools.xxindex.StandardXpathAccess;
import psidev.psi.tools.xxindex.XmlElementExtractor;
import psidev.psi.tools.xxindex.XpathAccess;
import psidev.psi.tools.xxindex.index.IndexElement;
import psidev.psi.tools.xxindex.index.XpathIndex;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.IdentifiableMzIdentMLObject;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
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
        private String mzIdentMLAttributeXMLString = null;
        // a unified cache of all the id maps
        private HashMap<Class, HashMap<String, IndexElement>> idMapCache = new HashMap<Class, HashMap<String, IndexElement>>();

        ///// ///// ///// ///// ///// ///// ///// ///// ///// /////
        // Constructor

        private MzIdentMLIndexerImpl(File xmlFile) {

            if (xmlFile == null) {
                throw new IllegalStateException("XML File to index must not be null");
            }
            if (!xmlFile.exists()) {
                throw new IllegalStateException("XML File to index does not exist: " + xmlFile.getAbsolutePath());
            }

            //store file reference
            this.xmlFile = xmlFile;

            try {
                // generate XXINDEX
                logger.info("Creating index: ");
                xpathAccess = new StandardXpathAccess(xmlFile, Constants.XML_INDEXED_XPATHS);
                logger.debug("done!");

                // create xml element extractor
                xmlExtractor = new SimpleXmlElementExtractor();
                xmlExtractor.setEncoding(xmlExtractor.detectFileEncoding(xmlFile.toURI().toURL()));

                // create index
                index = xpathAccess.getIndex();

                // check if the xxindex contains this root
                if (!index.containsXpath(MzIdentMLElement.MzIdentML.getXpath())) {
                    logger.info("Index does not contain mzIdentML root! We are not dealing with an mzIndentML file!");
                    throw new IllegalStateException("Index does not contain mzIdentML root!");
                }

                // initialize the ID maps
                initIdMaps();

                // extract the MzIdentML attributes from the MzIdentML start tag
                mzIdentMLAttributeXMLString = extractMzIdentMLStartTag(xmlFile);

            } catch (IOException e) {
                logger.error("MzMLIndexerFactory$MzMlIndexerImpl.MzMlIndexerImpl", e);
                throw new IllegalStateException("Could not generate MzIdentML index for file: " + xmlFile);
            }

        }

        ///// ///// ///// ///// ///// ///// ///// ///// ///// /////
        // public methods

        public String getMzIdentMLAttributeXMLString() {
            return mzIdentMLAttributeXMLString;
        }

        public Iterator<String> getXmlStringIterator(String xpathExpression) {
            if ( index.containsXpath(xpathExpression) ) {
                return xpathAccess.getXmlSnippetIterator(xpathExpression);
            } else {
                return null;
            }
        }

        public int getCount(String xpathExpression) {
            int retval = 0;
            if (index.containsXpath(xpathExpression)) {
                List<IndexElement> tmpList = index.getElements(xpathExpression);
                if (tmpList != null) {
                    retval = tmpList.size();
                }
            }
            return retval;
        }

        public List<IndexElement> getIndexElements(String xpath) {
            return index.getElements(xpath);
        }

        public Set<String> getXpath() {
            return index.getKeys();
        }

        public String getXmlString(String ID, Class clazz) {
            logger.debug("Getting cached ID: " + ID + " from cache: " + clazz);

            HashMap<String, IndexElement> idMap = idMapCache.get(clazz);
            IndexElement element = idMap.get(ID);

            String xmlSnippet = null;
            if (element != null) {
                xmlSnippet = readXML(element);
                if (logger.isTraceEnabled()) {
                    logger.trace("Retrieved xml for class " + clazz + " with ID " + ID + ": " + xmlSnippet);
                }
            }
            return xmlSnippet;

        }

        public <T extends MzIdentMLObject> Set<String> getElementIDs(Class<T> clazz) {
            if (idMapCache == null) { return null; }
            HashMap<String, IndexElement> classCache = idMapCache.get(clazz);
            if (classCache == null) { return null; }
            return classCache.keySet();
        }

        ///// ///// ///// ///// ///// ///// ///// ///// ///// /////
        // private methods

        private String readXML(IndexElement byteRange) {
            return readXML(byteRange, 0);
        }

        private String readXML(IndexElement byteRange, int maxChars) {
            try {
                if (byteRange != null) {
                    long stop; // where we will stop reading
                    long limitedStop = byteRange.getStart() + maxChars; // the potential end-point of reading
                    // if a limit was specified and the XML element length is longer
                    // than the limit, we only read up to the provided limit
                    if (maxChars > 0 && byteRange.getStop() > limitedStop) {
                        stop = limitedStop;
                    } else { // otherwise we will read up to the end of the XML element
                        stop = byteRange.getStop();
                    }
                    return xmlExtractor.readString(byteRange.getStart(), stop, xmlFile);
                } else {
                    throw new IllegalStateException("Attempting to read NULL ByteRange");
                }
            } catch (IOException e) {
                logger.error("MzMLIndexerFactory$MzMlIndexerImpl.readXML", e);
                throw new IllegalStateException("Could not extract XML from file: " + xmlFile);
            }
        }

        private String extractMzIdentMLStartTag(File xmlFile) throws IOException {
            // get start position of the mzIdentML element
            List<IndexElement> ie = index.getElements(MzIdentMLElement.MzIdentML.getXpath());
            // there is only one root
            long startPos = ie.get(0).getStart();

            // get end position of the mzIdentML start tag
            // this is the start position of the next tag (cvList)
            ie = index.getElements(MzIdentMLElement.CvList.getXpath());
            // there will always be one and only one cvList
            long stopPos = ie.get(0).getStart() - 1;

            // get mzML start tag content
            String startTag = xmlExtractor.readString(startPos, stopPos, xmlFile);
            if (startTag != null) {
                //strip newlines that might interfere with later on regex matching
                startTag = startTag.replace("\n", "");
            }
            return startTag;
        }

        /**
         * Method to generate and populate ID maps for the XML elements that should be
         * mapped to a unique ID. This will require that these elements are indexes and
         * that they extend the Identifiable class to make sure they have a unique ID.
         *
         * @see uk.ac.ebi.jmzidml.MzIdentMLElement
         * @throws IOException in case of a read error from the underlying XML file.
         */
        private void initIdMaps() throws IOException {
            for (MzIdentMLElement element : MzIdentMLElement.values()) {
                // only for elements were a ID map is needed and a xpath is given
                if (element.isIdMapped() && element.isIndexed()) {
                    logger.debug("Initialising ID map for " + element.getClazz().getName());
                    // check if the according class is a sub-class of Identifiable
                    if (!IdentifiableMzIdentMLObject.class.isAssignableFrom(element.getClazz())) {
                        throw new IllegalStateException("Attempt to create ID map for not Identifiable element: " + element.getClazz());
                    }
                    // so far so good, now generate the ID map (if not already present) and populate it
                    HashMap<String, IndexElement> map = idMapCache.get(element.getClazz());
                    if (map == null) {
                        map = new HashMap<String, IndexElement>();
                        idMapCache.put(element.getClazz(), map);
                    }
                    initIdMapCache(map, element.getXpath());
                }
            }
        }

        // ToDo: optimise this! it could break as it is now!
        private void initIdMapCache(HashMap<String, IndexElement> idMap, String xpath) throws IOException {
            List<IndexElement> ranges = index.getElements(xpath);
            for (IndexElement byteRange : ranges) {
                // in some cases the XML element can be extremely big (for example: /mzIdentML/DataCollection)
                // and cause memory problems. Since we only need the id attribute (which usually follows just
                // behind the element opening tag, we don't need to read the whole XML element. We read the
                // first 500 characters of the XML element, which should be enough to extract the id.
                // ToDo: find better way to determine how long to read! Some elements have multiple long attributes. Ideally only read the full start tag!
                // ToDo: position stream at beginning of element and read until the next stop signal ('>').
                String xml = readXML(byteRange, 500);
                String id = getIdFromRawXML(xml);
                if (id != null) {
                    idMap.put(id, byteRange);
                } else {
                    throw new IllegalStateException("Error initializing ID cache: No id attribute found for element " + xml);
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




    }

}
