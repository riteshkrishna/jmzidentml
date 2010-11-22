
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


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
 *         &lt;element name="role" type="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Audit.RoleType"/>
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
    protected Role role;
    @XmlAttribute(name = "Contact_ref", required = true)
    protected String contactRef;

    @XmlTransient
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    /**
     * Note: setting a Contact object will update the contactRef element with
     * the id from the new Contact object.
     *
     * @see #contactRef
     * @param contact the Contact to reference from this ContactRole.
     */
    public void setContact(Contact contact) {
        this.contact = contact;
        if (contact != null) {
            this.setContactRef( contact.getId() );
        }
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link Role }
     *     
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link Role }
     *     
     */
    public void setRole(Role value) {
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

}
