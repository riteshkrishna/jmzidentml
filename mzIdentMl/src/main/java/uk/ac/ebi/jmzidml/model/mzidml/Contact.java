
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * <p>Java class for ContactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Person" type="{http://psidev.info/psi/pi/mzIdentML/1.1}PersonType"/>
 *         &lt;element name="Organization" type="{http://psidev.info/psi/pi/mzIdentML/1.1}OrganizationType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactType", propOrder = {
    "personOrOrganization"
})
public class Contact
    extends MzIdentMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "Person", type = Person.class),
        @XmlElement(name = "Organization", type = Organization.class)
    })
    protected AbstractContact personOrOrganization;

    /**
     * Gets the value of the personOrOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     {@link Organization }
     *     
     */
    public AbstractContact getPersonOrOrganization() {
        return personOrOrganization;
    }

    /**
     * Sets the value of the personOrOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     {@link Organization }
     *     
     */
    public void setPersonOrOrganization(AbstractContact value) {
        this.personOrOrganization = value;
    }

}
