
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * The provider of the document in terms of the Contact and the software the produced the
 *                 document instance.
 *             
 * 
 * <p>Java class for FuGE.Collection.ProviderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Collection.ProviderType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ContactRole" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Software_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Collection.ProviderType", propOrder = {
    "contactRole"
})
public class Provider
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ContactRole")
    protected ContactRole contactRole;
    @XmlAttribute(name = "Software_ref")
    protected String softwareRef;

    @XmlTransient
    private AnalysisSoftware software;

    public AnalysisSoftware getSoftware() {
        return software;
    }

    /**
     * Note: setting a Software object will update the softwareRef element with
     * the id from the new Software object.
     *
     * @see uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftware#getId()
     * @see #softwareRef
     * @param software the Software to reference from this Provider.
     */
    public void setSoftware(AnalysisSoftware software) {
        this.software = software;
        if (software != null) {
            this.softwareRef = software.getId();
        }
    }

    /**
     * The Contact that provided the document instance.
     * 
     * @return
     *     possible object is
     *     {@link ContactRole }
     *     
     */
    public ContactRole getContactRole() {
        return contactRole;
    }

    /**
     * Sets the value of the contactRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactRole }
     *     
     */
    public void setContactRole(ContactRole value) {
        this.contactRole = value;
    }

    /**
     * Gets the value of the softwareRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwareRef() {
        return softwareRef;
    }

    /**
     * Sets the value of the softwareRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwareRef(String value) {
        this.softwareRef = value;
        if ( software != null && !software.getId().equals(value) ) {
            software = null;
        }
    }

}
