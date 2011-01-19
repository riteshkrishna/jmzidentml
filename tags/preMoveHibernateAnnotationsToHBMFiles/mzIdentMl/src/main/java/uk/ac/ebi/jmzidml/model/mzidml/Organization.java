
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * Organizations are entities like companies, universities, government agencies for which
 *                 the attributes are self describing.
 *             
 * 
 * <p>Java class for FuGE.Common.Audit.OrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Audit.OrganizationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Audit.ContactType">
 *       &lt;sequence>
 *         &lt;element name="parent" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Organization_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Audit.OrganizationType", propOrder = {
    "parent"
})
public class Organization
    extends Contact
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected Organization.Parent parent;

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link Organization.Parent }
     *     
     */
    public Organization.Parent getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organization.Parent }
     *     
     */
    public void setParent(Organization.Parent value) {
        this.parent = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
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
    @XmlType(name = "")
    public static class Parent
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "Organization_ref", required = true)
        protected String organizationRef;

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
        }

    }

}
