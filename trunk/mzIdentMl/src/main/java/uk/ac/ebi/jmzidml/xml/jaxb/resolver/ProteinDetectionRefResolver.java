package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.ProteinDetection;
import uk.ac.ebi.jmzidml.model.mzidml.ProteinDetectionList;
import uk.ac.ebi.jmzidml.model.mzidml.ProteinDetectionProtocol;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class ProteinDetectionRefResolver extends AbstractReferenceResolver<ProteinDetection> {

    public ProteinDetectionRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(ProteinDetection object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.ProteinDetection.isAutoRefResolving()) {
            // add objects for the refID
            String ref1 = object.getProteinDetectionListRef();
            if (ref1 != null) {
                ProteinDetectionList refObject1 = this.unmarshal(ref1, ProteinDetectionList.class);
                object.setProteinDetectionList(refObject1);
            }

            String ref2 = object.getProteinDetectionProtocolRef();
            if (ref2 != null) {
                ProteinDetectionProtocol refObject2 = this.unmarshal(ref2, ProteinDetectionProtocol.class);
                object.setProteinDetectionProtocol(refObject2);
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
    public void checkRefID(ProteinDetection object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getProteinDetectionList()!= null && !object.getProteinDetectionListRef().equals(object.getProteinDetectionList().getId()) ) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
        if ( object.getProteinDetectionProtocol()!= null && !object.getProteinDetectionProtocolRef().equals(object.getProteinDetectionProtocol().getId()) ) {
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
        if (ProteinDetection.class.isInstance(target)) {
            updateObject((ProteinDetection)target);
        } // else, not business of this resolver
    }

}
