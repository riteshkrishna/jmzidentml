
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.xml.jaxb.adapters.AnalysisSoftwareAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
    @XmlJavaTypeAdapter(AnalysisSoftwareAdapter.class)
    protected AnalysisSoftware analysisSoftware;

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
     * Gets the value of the analysisSoftware property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public AnalysisSoftware getAnalysisSoftware() {
        return analysisSoftware;
    }

    /**
     * Sets the value of the analysisSoftware property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalysisSoftware(AnalysisSoftware value) {
        this.analysisSoftware = value;
    }

}
