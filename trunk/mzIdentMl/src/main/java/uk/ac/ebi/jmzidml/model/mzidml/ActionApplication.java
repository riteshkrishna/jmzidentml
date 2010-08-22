
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * ActionApplication mirrors the structure of Actions within Protocols and allows
 *                 ActionDeviations to be reported. RULE: If an Action references a childProtocol, an ActionApplication
 *                 must be created and reference a childProtocolApplication of the corresponding type (or
 *                 GenericProtocolApplication) to mirror the Protocol structure. ActionApplications can be (but need not
 *                 be) created for simple Actions.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.ActionApplicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.ActionApplicationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ParameterizableApplicationType">
 *       &lt;sequence>
 *         &lt;element name="actionDeviation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}Description"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Action_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProtocolApplication_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.ActionApplicationType", propOrder = {
    "actionDeviation"
})
public class ActionApplication
    extends ParameterizableApplication
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected ActionApplication.ActionDeviation actionDeviation;
    @XmlAttribute(name = "Action_ref", required = true)
    protected String actionRef;
    @XmlAttribute(name = "ProtocolApplication_ref")
    protected String protocolApplicationRef;

    /**
     * Gets the value of the actionDeviation property.
     * 
     * @return
     *     possible object is
     *     {@link ActionApplication.ActionDeviation }
     *     
     */
    public ActionApplication.ActionDeviation getActionDeviation() {
        return actionDeviation;
    }

    /**
     * Sets the value of the actionDeviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionApplication.ActionDeviation }
     *     
     */
    public void setActionDeviation(ActionApplication.ActionDeviation value) {
        this.actionDeviation = value;
    }

    /**
     * Gets the value of the actionRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionRef() {
        return actionRef;
    }

    /**
     * Sets the value of the actionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionRef(String value) {
        this.actionRef = value;
    }

    /**
     * Gets the value of the protocolApplicationRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolApplicationRef() {
        return protocolApplicationRef;
    }

    /**
     * Sets the value of the protocolApplicationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolApplicationRef(String value) {
        this.protocolApplicationRef = value;
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
     *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}Description"/>
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
        "description"
    })
    public static class ActionDeviation
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "Description", required = true)
        protected Description description;

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link Description }
         *     
         */
        public Description getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link Description }
         *     
         */
        public void setDescription(Description value) {
            this.description = value;
        }

    }

}
