package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.model.mzidml.Contact;
import uk.ac.ebi.jmzidml.model.mzidml.Organization;
import uk.ac.ebi.jmzidml.model.mzidml.Person;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.filters.MzIdentMLNamespaceFilter;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;

/**
 * @author Florian Reisinger
 *         Date: 12-Nov-2010
 * @since 1.0
 */
public abstract class AbstractReferenceResolver<T extends MzIdentMLObject> extends Unmarshaller.Listener {

    private static final Logger log = Logger.getLogger(AbstractReferenceResolver.class);

    // ToDo: check if we need the cache here or if we can handle this from another level (e.g. the MzIdentMLUnmarshaller)
    private MzIdentMLIndexer index = null;
    private MzIdentMLObjectCache cache = null;


    protected AbstractReferenceResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        this.index = index;
        this.cache = cache;
    }



    public <R extends MzIdentMLObject> R unmarshal(String refId, Class<R> cls) {
        R retVal = null;

        // check if we have a cache to look up, if so see if it contains the referenced object already
//        if (cache != null) {
//            retVal = cache.getCachedObject(refId, cls);
//        }

        // if the referenced object/element is not yet in the cache (or no cache
        // is available) create it from the XML using the index and ID maps
        if (retVal == null) {

            log.debug("AbstractReferenceResolver.unmarshal for id: " + refId);
            // first retrieve the XML snippet representing the referenced object/element
            String xml;
            // special case for Contact.class as we can either have a Person.class or a Organisation.class
            if (cls ==  Contact.class) {
                System.out.println("SPECIAL CASE: Contact");
                // see if the ID fits a Person
                String personXML = index.getXmlString(refId, Person.class);
                // see if the ID fits an Organisation
                String organisationXML = index.getXmlString(refId, Organization.class);
                if (personXML != null && organisationXML == null) {
                    xml = personXML;
                    cls = MzIdentMLElement.Person.getClazz();
                } else if (personXML == null && organisationXML != null) {
                    xml = organisationXML;
                    cls = MzIdentMLElement.Person.getClazz();
                } else {
                    throw new IllegalStateException("Could not uniquely resolve Contact reference " + refId);
                }
            } else {
                xml = index.getXmlString(refId, cls);
            }

            try {
                // required for the addition of namespaces to top-level objects
                MzIdentMLNamespaceFilter xmlFilter = new MzIdentMLNamespaceFilter();

                // initializeUnmarshaller will assign the proper reader to the xmlFilter
                Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, cache, xmlFilter);

                // need to do it this way because snippet does not have a XmlRootElement annotation
                JAXBElement<R> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(xml))), cls);
                retVal = holder.getValue();

                // add it to the cache, if we there is one (as it was not in there)
                // the cache may accept this object or not depending on the settings in MzIdentMLElement
//                if (cache != null) {
//                    cache.putInCache(refId, retVal);
//                }

            } catch (JAXBException e) {
                log.error("AbstractReferenceResolver.unmarshal", e);
                throw new IllegalStateException("Could not unmarshall refId: " + refId + " for element type: " + cls);
            }

        }

        // finally return the referenced object
        return retVal;
    }

    public abstract void updateObject(T object);

    public abstract void checkRefID(T object);

}
