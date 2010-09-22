/**
 *
 * Adopted by Ritesh
 * Date - May 27, 2010
 */
package uk.ac.ebi.jmzidml.xml.io;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.filters.MzIdentMLNamespaceFilter;
import uk.ac.ebi.jmzidml.xml.xxindex.FileUtils;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexerFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MzIdentMLUnmarshaller {
    private static final Logger logger = Logger.getLogger(MzIdentMLUnmarshaller.class);
//    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    private final MzIdentMLIndexer index;
    private final boolean useSpectrumCache;

    private final AdapterObjectCache cache = new AdapterObjectCache();
    //private IndexList indexList = null;

//    private boolean fileCorrupted = false;

    private final Pattern ID_PATTERN = Pattern.compile("id *= *\"([^\"]*)?\"", Pattern.CASE_INSENSITIVE);
    private final Pattern AC_PATTERN = Pattern.compile("accession *= *\"([^\"]*)?\"", Pattern.CASE_INSENSITIVE);
    private final Pattern VERSION_PATTERN = Pattern.compile("version *= *\"([^\"]*)?\"", Pattern.CASE_INSENSITIVE);

    public MzIdentMLUnmarshaller(URL mzIdentMLFileURL) {
        this(mzIdentMLFileURL, true);
    }

    public MzIdentMLUnmarshaller(File mzIdentMLFile) {
        this(mzIdentMLFile, true);

    }

    public MzIdentMLUnmarshaller(URL mzIdentMLFileURL, boolean aUseSpectrumCache) {
        this(FileUtils.getFileFromURL(mzIdentMLFileURL), aUseSpectrumCache);
    }

    public MzIdentMLUnmarshaller(File mzIdentMLFile, boolean aUseSpectrumCache) {
        index = MzIdentMLIndexerFactory.getInstance().buildIndex(mzIdentMLFile);
        useSpectrumCache = aUseSpectrumCache;
    }

    //
    // -------------- Methods ----------------------------
    //
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

    public int getObjectCountForXpath(String xpath) {
        return index.getCount(xpath);
    }

    public <T extends MzIdentMLObject> T unmarshalFromXpath(String xpath, Class cls) throws ParserConfigurationException, SAXException {
        // ToDo: only unmarshalls first element in xxindex!! Document this!
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
                Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
                //unmarshall the desired object
                JAXBElement<T> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(xmlSt))), cls);
                retval = holder.getValue();

                if (logger.isDebugEnabled()) {
                    logger.debug("unmarshalled object = " + retval);
                }

            }

        } catch (JAXBException e) {
            logger.error("MzMLUnmarshaller.unmarshalFromXpath", e);
            throw new IllegalStateException("Could not unmarshal object at xpath:" + xpath);
        }

        return retval;
    }

    public <T extends MzIdentMLObject> MzIdentMLObjectIterator<T> unmarshalCollectionFromXpath(String xpath, Class cls) {
        return new MzIdentMLObjectIterator<T>(xpath, cls, index, cache, useSpectrumCache);
    }


}
