package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.SpectraData;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationResult;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class SpectrumIdentificationResultRefResolver extends AbstractReferenceResolver<SpectrumIdentificationResult> {

    public SpectrumIdentificationResultRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(SpectrumIdentificationResult object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.SpectrumIdentificationResult.isAutoRefResolving()) {
            // add objects for the refID
            String ref = object.getSpectraDataRef();
            if (ref != null) {
                SpectraData refObject = this.unmarshal(ref, SpectraData.class);
                object.setSpectraData(refObject);
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
    public void checkRefID(SpectrumIdentificationResult object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getSpectraData()!= null && !object.getSpectraDataRef().equals(object.getSpectraData().getId()) ) {
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
        if (SpectrumIdentificationResult.class.isInstance(target)) {
            updateObject((SpectrumIdentificationResult)target);
        } // else, not business of this resolver
    }

}
