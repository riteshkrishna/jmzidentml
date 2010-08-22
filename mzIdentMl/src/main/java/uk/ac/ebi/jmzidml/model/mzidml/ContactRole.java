
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * The role that a Contact plays in an organization or with respect to the associating
 *                 class. A Contact may have several Roles within scope, and as such, associations to ContactRole allow the
 *                 use of a Contact in a certain manner. Examples might include a provider, or a data analyst.
 *             
 * 
 * <p>Java class for FuGE.Common.Audit.ContactRoleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Audit.ContactRoleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="role">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}cvParam"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Contact_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Audit.ContactRoleType", propOrder = {
    "role"
})
public class ContactRole
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected ContactRole.Role role;
    @XmlAttribute(name = "Contact_ref", required = true)
    protected String contactRef;

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link ContactRole.Role }
     *     
     */
    public ContactRole.Role getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactRole.Role }
     *     
     */
    public void setRole(ContactRole.Role value) {
        this.role = value;
    }

    /**
     * Gets the value of the contactRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactRef() {
        return contactRef;
    }

    /**
     * Sets the value of the contactRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactRef(String value) {
        this.contactRef = value;
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
     *       &lt;sequence>
     *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}cvParam"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cvParam"
    })
    public static class Role
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(required = true)
        protected CvParam cvParam;

        /**
         * Gets the value of the cvParam property.
         * 
         * @return
         *     possible object is
         *     {@link CvParam }
         *     
         */
        public CvParam getCvParam() {
            return cvParam;
        }

        /**
         * Sets the value of the cvParam property.
         * 
         * @param value
         *     allowed object is
         *     {@link CvParam }
         *     
         */
        public void setCvParam(CvParam value) {
            this.cvParam = value;
        }

    }

}
