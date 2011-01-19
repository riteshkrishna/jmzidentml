package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentification;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationList;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationProtocol;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class SpectrumIdentificationRefResolver extends AbstractReferenceResolver<SpectrumIdentification> {

    public SpectrumIdentificationRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(SpectrumIdentification object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.SpectrumIdentification.isAutoRefResolving()) {
            // add objects for the refID
            String ref1 = object.getSpectrumIdentificationListRef();
            if (ref1 != null) {
                SpectrumIdentificationList refObject1 = this.unmarshal(ref1, SpectrumIdentificationList.class);
                object.setSpectrumIdentificationList(refObject1);
            }

            String ref2 = object.getSpectrumIdentificationProtocolRef();
            if (ref2 != null) {
                SpectrumIdentificationProtocol refObject2 = this.unmarshal(ref2, SpectrumIdentificationProtocol.class);
                object.setSpectrumIdentificationProtocol(refObject2);
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
    public void checkRefID(SpectrumIdentification object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getSpectrumIdentificationList()!= null && !object.getSpectrumIdentificationListRef().equals(object.getSpectrumIdentificationList().getId()) ) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
        if ( object.getSpectrumIdentificationProtocol()!= null && !object.getSpectrumIdentificationProtocolRef().equals(object.getSpectrumIdentificationProtocol().getId()) ) {
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
        if (SpectrumIdentification.class.isInstance(target)) {
            updateObject((SpectrumIdentification)target);
        } // else, not business of this resolver
    }

}
