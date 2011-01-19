package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.DBSequence;
import uk.ac.ebi.jmzidml.model.mzidml.PeptideEvidence;
import uk.ac.ebi.jmzidml.model.mzidml.TranslationTable;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since $version
 */
public class PeptideEvidenceRefResolver extends AbstractReferenceResolver<PeptideEvidence> {

    public PeptideEvidenceRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(PeptideEvidence object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.PeptideEvidence.isAutoRefResolving()) {
            // add objects for the refID
            String ref1 = object.getDBSequenceRef();
            if (ref1 != null) {
                DBSequence refObject1 = this.unmarshal(ref1, DBSequence.class);
                object.setDBSequence(refObject1);
            }

            String ref2 = object.getTranslationTableRef();
            if (ref2 != null) {
                TranslationTable refObject2 = this.unmarshal(ref2, TranslationTable.class);
                object.setTranslationTable(refObject2);
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
    public void checkRefID(PeptideEvidence object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getDBSequence() != null && !object.getDBSequenceRef().equals(object.getDBSequence().getId()) ) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
        if ( object.getTranslationTable() != null && !object.getTranslationTableRef().equals(object.getTranslationTable().getId()) ) {
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
        if (PeptideEvidence.class.isInstance(target)) {
            updateObject((PeptideEvidence)target);
        } // else, not business of this resolver
    }
}
