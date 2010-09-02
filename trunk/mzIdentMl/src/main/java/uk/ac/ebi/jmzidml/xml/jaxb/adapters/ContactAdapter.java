package uk.ac.ebi.jmzidml.xml.jaxb.adapters;

import uk.ac.ebi.jmzidml.model.mzidml.Contact;
import uk.ac.ebi.jmzidml.xml.Constants;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 02-Sep-2010
 * @since $version
 */
public class ContactAdapter extends AbstractResolvingAdapter<String, Contact> {

    public ContactAdapter(MzIdentMLIndexer index, AdapterObjectCache cache) {
        super(index, cache);
    }

    public Contact unmarshal(String refId) {

        System.out.println("attempting to resolve contact: " + refId);

        Contact retval;
        if (cache.getCachedObject(refId, Contact.class) != null) {
            // ToDo: unchecked cast, may produce runtime exception! check if we can get around this
            // ToDo: maybe check returned type (but then we would have to throw exception anyway)
            retval = (Contact) cache.getCachedObject(refId, Contact.class);
            logger.debug("used cached value for ID: " + refId);
        } else {
            retval = super.unmarshal(refId, Constants.ReferencedType.Contact);
            cache.putInCache(refId, retval);
            logger.debug("cached object at ID: " + refId);
        }
        return retval;
    }

    public String marshal(Contact contact) {
        if (contact != null) {
            return contact.getId();
        } else {
            return null;
        }
    }



}
