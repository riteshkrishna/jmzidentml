/**
 *
 * Adopted by Ritesh
 * Date - May 27, 2010
 */
package uk.ac.ebi.jmzidml.xml.io;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.filters.MzIdentMLNamespaceFilter;
import uk.ac.ebi.jmzidml.xml.xxindex.FileUtils;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexerFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import javax.xml.xpath.XPathException;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MzIdentMLUnmarshaller {
    private static final Logger logger = Logger.getLogger(MzIdentMLUnmarshaller.class);

    private final MzIdentMLIndexer index;
    private final MzIdentMLObjectCache cache;

    private final Pattern ID_PATTERN = Pattern.compile("id *= *\"([^\"]*)?\"", Pattern.CASE_INSENSITIVE);
    private final Pattern AC_PATTERN = Pattern.compile("accession *= *\"([^\"]*)?\"", Pattern.CASE_INSENSITIVE);
    private final Pattern VERSION_PATTERN = Pattern.compile("version *= *\"([^\"]*)?\"", Pattern.CASE_INSENSITIVE);

    ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// /////
    // Constructor

    public MzIdentMLUnmarshaller(URL mzIdentMLFileURL) {
        this(mzIdentMLFileURL, null);
    }

    public MzIdentMLUnmarshaller(File mzIdentMLFile) {
        this(mzIdentMLFile, null);

    }

    @Deprecated
    public MzIdentMLUnmarshaller(URL mzIdentMLFileURL, MzIdentMLObjectCache cache) {
        this(FileUtils.getFileFromURL(mzIdentMLFileURL), cache);
    }

    @Deprecated
    public MzIdentMLUnmarshaller(File mzIdentMLFile, MzIdentMLObjectCache cache) {
        this.index = MzIdentMLIndexerFactory.getInstance().buildIndex(mzIdentMLFile);
        this.cache = cache;
    }

    ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// ///// /////
    // Methods

    public String getMzIdentMLVersion() {
        Matcher match = VERSION_PATTERN.matcher(index.getMzIdentMLAttributeXMLString());
        if (match.find()) {
            return match.group(1);
        } else {
            return null;
        }
    }

    public String getMzIdentMLAccession() {
        Matcher match = AC_PATTERN.matcher(index.getMzIdentMLAttributeXMLString());
        if (match.find()) {
            return match.group(1);
        } else {
            return null;
        }
    }

    public String getMzIdentMLId() {
        Matcher match = ID_PATTERN.matcher(index.getMzIdentMLAttributeXMLString());
        if (match.find()) {
            return match.group(1);
        } else {
            return null;
        }
    }

    // ToDo: methods with xpath or with class or MzIdentMLElement or all?

    public int getObjectCountForXpath(String xpath) {
        // ToDo: add check that the specified xpath is known
        return index.getCount(xpath);
    }

    /**
     * Retrieves the number of XML elements defined by the specified class.
     *
     * @param clazz the Class defining the XML element.
     * @return the number of elements associated with this class.
     * @throws XPathException if the specified Class can not be mapped to a unique xpath in the XML.
     */
    public int getObjectCountForClass(Class clazz) throws XPathException {
        String xpath = MzIdentMLElement.getType(clazz).getXpath();
        return getObjectCountForXpath(xpath);
    }

    public int getObjectCount(MzIdentMLElement element) {
        String xpath = element.getXpath();
        return getObjectCountForXpath(xpath);
    }

    /**
     * Unmarshal one object for the specified class.
     * Note: The class has to refer to MzIdentMLObject elements.
     *
     * @see #unmarshal(uk.ac.ebi.jmzidml.MzIdentMLElement)
     * @param clazz the type of Object to sub-class. It has to be a sub-class of MzIdentMLObject.
     * @return a object of the specified class
     */
    public <T extends MzIdentMLObject> T unmarshal(Class<T> clazz) {
        String xpath = MzIdentMLElement.getType(clazz).getXpath();
        return unmarshal(clazz, xpath);
    }

    public <T extends MzIdentMLObject> T unmarshal(String xpath) {
        Class<T> clazz = MzIdentMLElement.getType(xpath).getClazz();
        return unmarshal(clazz, xpath);
    }

    /**
     * Unmarshals one element of the type defined by the MzIdentMLElement.
     * Note: In case there are more than one element for the specified MzIdentMLElement,
     *       only one found will be returned. This is usually the first such element, but
     *       no order is guaranteed! Use appropriate methods to check that there is only
     *       one such element or to deal with a collection of elements.
     *
     * @see #getObjectCount(uk.ac.ebi.jmzidml.MzIdentMLElement)
     * @see #unmarshalCollectionFromXpath(uk.ac.ebi.jmzidml.MzIdentMLElement)
     * @param element The MzIdentMLElement defining the type of element to unmarshal.
     * @return A MzIdentMLObject according to the type defined by the MzIdentMLElement.
     */
    public <T extends MzIdentMLObject> T unmarshal(MzIdentMLElement element) {
        // Class and xpath of the element to unmarshal
        Class<T> clazz = element.getClazz();
        String xpath = element.getXpath();

        // first check if we have an element(s) for this Class in the cache
        return unmarshal(clazz, xpath);
    }

    private <T extends MzIdentMLObject> T unmarshal(Class<T> clazz, String xpath) {
        T retval = null;
//        if (cache != null && cache.hasEntry(clazz)) {
//            retval = cache.getEntries(clazz).get(0);
//        } else {
            if (xpath != null) {
                retval = retrieveFromXML(clazz, xpath);
            } else {
                logger.info("No xpath or index entry for class " + clazz + "! Can not unmarshal!");
            }

//            // we retrieved the element from the XML (since it was not in the cache or no cache exists)
//            // now we hand it to the cache (that knows what to do with it)
//            // for now we only consider to cache elements that are IdentifiableMzIdentMLObjects (e.g. have an ID)
//            if (cache != null && retval != null && retval instanceof IdentifiableMzIdentMLObject) {
//                cache.putInCache( (IdentifiableMzIdentMLObject) retval );
//            }
//        }
        return retval;
    }

    private <T extends MzIdentMLObject> T retrieveFromXML(Class<T> cls, String xpath) {
        T retval = null;
        try {
            Iterator<String> xpathIter = index.getXmlStringIterator(xpath);

            if (xpathIter.hasNext()) {

                String xmlSt = xpathIter.next();

                if (logger.isDebugEnabled()) {
                    logger.trace("XML to unmarshal: " + xmlSt);
                }

                // Create a filter to intercept events -- and patch the missing namespace
                MzIdentMLNamespaceFilter xmlFilter = new MzIdentMLNamespaceFilter();

                //required for the addition of namespaces to top-level objects
                //MzMLNamespaceFilter xmlFilter = new MzMLNamespaceFilter();
                //initializeUnmarshaller will assign the proper reader to the xmlFilter
                Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, cache, xmlFilter);
                //unmarshall the desired object
                JAXBElement<T> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(xmlSt))), cls);
                retval = holder.getValue();

                if (logger.isDebugEnabled()) {
                    logger.debug("unmarshalled object = " + retval);
                }

            }

        } catch (JAXBException e) {
            logger.error("MzMLUnmarshaller unmarshal error: ", e);
            throw new IllegalStateException("Could not unmarshal object at xpath:" + xpath);
        }
        return retval;
    }

    public <T extends MzIdentMLObject> Iterator<T> unmarshalCollectionFromXpath(MzIdentMLElement element) {
        // toDo: Check with Richard!!
//        int indexCnt = getObjectCount(element);
//
//        if (cache != null) {
//            List<MzIdentMLObject> list = cache.getEntries(element.getClazz());
//            if (list != null) {
//                int cacheCnt = list.size();
//                if (indexCnt == cacheCnt) {
//                    // all elements are already cached
//                    return cache.getEntries(element.<T>getClazz()).iterator();
//                }
//            }
//        }

        // we have to iterate over the XML elements
        return new MzIdentMLObjectIterator<T>(element, index, cache);
    }


    

}
