package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 *
 * TODO marshalling/ persistor add validation to check for case where someone gets organization and changes its id without updating ref id in
 *      affliliations and other such clases.
 *
 * NOTE: There is no setter method for the organizationRef. This simplifies keeping the organization object reference and
 * organizationRef synchronized.
 *
 * <p>Java class for AffiliationsType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AffiliationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Organization_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AffiliationsType")
public class Affiliations
        extends MzIdentMLObject
        implements Serializable {

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "organization_ref", required = true)
    protected String organizationRef;
    @XmlTransient
    protected Organization organization;


    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        if (organization == null) {
            this.organizationRef = null;
        } else {
            String refId = organization.getId();
            if (refId == null) throw new IllegalArgumentException("Referenced object does not have an identifier.");
            this.organizationRef = refId;
        }
        this.organization = organization;
    }



    /**
     * Gets the value of the organizationRef property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOrganizationRef() {
        return organizationRef;
    }


}
