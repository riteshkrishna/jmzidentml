package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.PeptideEvidence;
import uk.ac.ebi.jmzidml.model.mzidml.PeptideHypothesis;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class PeptideHypothesisRefResolver extends AbstractReferenceResolver<PeptideHypothesis> {

    public PeptideHypothesisRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(PeptideHypothesis object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.PeptideHypothesis.isAutoRefResolving()) {
            // add objects for the refID
            String ref = object.getPeptideEvidenceRef();
            if (ref != null) {
                PeptideEvidence refObject = this.unmarshal(ref, PeptideEvidence.class);
                object.setPeptideEvidence(refObject);
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
    public void checkRefID(PeptideHypothesis object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getPeptideEvidence() != null && !object.getPeptideEvidenceRef().equals(object.getPeptideEvidence().getId()) ) {
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
        if (PeptideHypothesis.class.isInstance(target)) {
            updateObject((PeptideHypothesis)target);
        } // else, not business of this resolver
    }
}
