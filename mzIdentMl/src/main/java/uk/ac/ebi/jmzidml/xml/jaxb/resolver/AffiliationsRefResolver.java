package uk.ac.ebi.jmzidml.xml.jaxb.resolver;

import uk.ac.ebi.jmzidml.MzIdentMLElement;
import uk.ac.ebi.jmzidml.model.mzidml.Affiliations;
import uk.ac.ebi.jmzidml.model.mzidml.Organization;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class AffiliationsRefResolver extends AbstractReferenceResolver<Affiliations> {

    public AffiliationsRefResolver(MzIdentMLIndexer index, MzIdentMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(Affiliations object) {
        // add objects for the refID
        String ref = object.getOrganizationRef();
        if (ref != null) {
            Organization refObject = this.unmarshal(ref, Organization.class);
            object.setOrganization(refObject);
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
        if (Affiliations.class.isInstance(target) && MzIdentMLElement.Affiliations.isAutoRefResolving()) {
            updateObject((Affiliations) target);
        } // else, not business of this resolver
    }
}
