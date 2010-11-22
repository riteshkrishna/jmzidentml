package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.Cv;
import uk.ac.ebi.jmzidml.model.mzidml.CvParam;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class CvParamRefResolver extends AbstractReferenceResolver<CvParam> {

    public CvParamRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(CvParam object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzIdentMLElement.CvParam.isAutoRefResolving()) {
            // add objects for the refID
            String ref = object.getCvRef();
            if (ref != null) {
                Cv refObject = this.unmarshal(ref, Cv.class);
                object.setCv(refObject);
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
    public void checkRefID(CvParam object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if ( object.getCv()!= null && !object.getCvRef().equals(object.getCv().getId()) ) {
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
        if (CvParam.class.isInstance(target)) {
            updateObject((CvParam)target);
        } // else, not business of this resolver
    }

}
