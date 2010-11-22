package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.MassTable;
import uk.ac.ebi.jmzidml.model.mzidml.Peptide;
import uk.ac.ebi.jmzidml.model.mzidml.Sample;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationItem;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class SpectrumIdentificationItemRefResolver extends AbstractReferenceResolver<SpectrumIdentificationItem> {

    public SpectrumIdentificationItemRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(SpectrumIdentificationItem object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.SpectrumIdentificationItem.isAutoRefResolving()) {
            // add objects for the refID
            String ref1 = object.getPeptideRef();
            if (ref1 != null) {
                Peptide refObject1 = this.unmarshal(ref1, Peptide.class);
                object.setPeptide(refObject1);
            }

            String ref2 = object.getMassTableRef();
            if (ref2 != null) {
                MassTable refObject2 = this.unmarshal(ref2, MassTable.class);
                object.setMassTable(refObject2);
            }

            String ref3 = object.getSampleRef();
            if (ref3 != null) {
                Sample refObject3 = this.unmarshal(ref3, Sample.class);
                object.setSample(refObject3);
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
    public void checkRefID(SpectrumIdentificationItem object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getPeptide()!= null && !object.getPeptideRef().equals(object.getPeptide().getId()) ) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
        if ( object.getMassTable()!= null && !object.getMassTableRef().equals(object.getMassTable().getId()) ) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
        if ( object.getSample()!= null && !object.getSampleRef().equals(object.getSample().getId()) ) {
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
        if (SpectrumIdentificationItem.class.isInstance(target)) {
            updateObject((SpectrumIdentificationItem)target);
        } // else, not business of this resolver
    }

}
