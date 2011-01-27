
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for FuGE.Common.Audit.AffiliationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Audit.AffiliationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Organization_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Audit.AffiliationsType")
public class Affiliations
    implements Serializable, MzIdentMLObject
{

    @XmlTransient
    protected Long hid;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "Organization_ref", required = true)
    protected String organizationRef;

    @XmlTransient
    private Organization organization;

    /**
     * Gets the value of the organisation property.
     * Note: this property may be populated automatically at unmarshal
     * time with the Object referenced with the contactRef property.
     *
     * @see uk.ac.ebi.jmzidml.MzIdentMLElement#isAutoRefResolving()
     * @return Valid values are Organisation objects.
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Sets a Organization reference. Setting a Organization object will update
     * the organizationRef element with the id from the new Organization object.
     * Note: if the contact object is null, the organizationRef ID is NOT
     * changed, only the object reference is set to null.
     *
     * @see #organizationRef
     * @param organization the Organization to reference from this Affiliation.
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
        if (organization != null) {
            this.organizationRef = organization.getId();
        }
    }

    /**
     * Gets the value of the organizationRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationRef() {
        return organizationRef;
    }

    /**
     * Sets the value of the organizationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationRef(String value) {
        this.organizationRef = value;
        if ( organization != null && !organization.getId().equals(value) ) {
            organization = null;
        }
    }

}
