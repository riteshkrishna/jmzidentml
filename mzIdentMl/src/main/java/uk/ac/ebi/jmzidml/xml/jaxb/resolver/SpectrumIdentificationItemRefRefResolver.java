package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.Affiliations;
import uk.ac.ebi.jmzidml.model.mzidml.Organization;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationItem;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationItemRef;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * Created by IntelliJ IDEA.
 * User: rwang
 * Date: 25/02/11
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public class SpectrumIdentificationItemRefRefResolver extends AbstractReferenceResolver<SpectrumIdentificationItemRef> {

    public SpectrumIdentificationItemRefRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(SpectrumIdentificationItemRef object) {
        // add objects for the refID
        String ref = object.getSpectrumIdentificationItemRef();
        if (ref != null) {
            SpectrumIdentificationItem refObject = this.unmarshal(ref, SpectrumIdentificationItem.class);
            object.setSpectrumIdentificationItem(refObject);
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
        if (Affiliations.class.isInstance(target) && MzIdentMLElement.SpectrumIdentificationItemRef.isAutoRefResolving()) {
            updateObject((SpectrumIdentificationItemRef) target);
        } // else, not business of this resolver
    }
}
