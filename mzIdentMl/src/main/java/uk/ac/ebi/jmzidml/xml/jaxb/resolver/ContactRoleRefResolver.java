package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.Contact;
import uk.ac.ebi.jmzidml.model.mzidml.ContactRole;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 15-Nov-2010
 * @since 1.0
 */
public class ContactRoleRefResolver extends AbstractReferenceResolver<ContactRole> {

    public ContactRoleRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(ContactRole object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.ContactRole.isAutoRefResolving()) {
            // add objects for the refID
            String ref = object.getContactRef();
            if (ref != null) {
                Contact refObject = this.unmarshal(ref, Contact.class);
                object.setContact(refObject);
            }
        }
    }

    /**
     * A method to be called before the marshall process.
     * Whenever a referenced object is set, its refID should be updated
     * automatically, so that the refID and the ID of the object are
     * always in sync. Here we check that this is the case.
     *
     * @param object The Object to check for reference ID integrity.
     */
    @Override
    public void checkRefID(ContactRole object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getContact()!= null && !object.getContactRef().equals(object.getContact().getId()) ) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
    }

    /**
     * Method to perform the afterUnmarshal operation if the resolver
     * applies to the specified object.
     *
     * @param target the object to modify after unmarshalling.
     * @param parent object referencing the target. Null if target is root element.
     */
    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (ContactRole.class.isInstance(target)) {
            updateObject((ContactRole)target);
        } // else, not business of this resolver
    }

}
