
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * Software used in the Protocol. Examples of Software include: feature extraction software,
 *                 clustering software, etc... Software is abstract and should either be extended by subclassing or the
 *                 GenericSoftware class, a functional version of Software, should be used without extension.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.SoftwareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.SoftwareType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ContactRole" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.SoftwareType", propOrder = {
    "contactRole"
})
@XmlSeeAlso({
    AnalysisSoftware.class
})
public abstract class Software
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ContactRole")
    protected ContactRole contactRole;
    @XmlAttribute
    protected String version;

    /**
     * Gets the value of the contactRole property.
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
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
