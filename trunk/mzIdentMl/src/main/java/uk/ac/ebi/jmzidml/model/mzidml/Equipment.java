
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The equipment (hardware) used in the Protocol. Examples include: computers, scanners,
 *                 wash stations etc... Equipment is abstract and should either be extended by subclassing or the
 *                 GenericEquipment class, a functional version of Equipment, should be used.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.EquipmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.EquipmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element name="make" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamType" minOccurs="0"/>
 *         &lt;element name="model" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.EquipmentType", propOrder = {
    "make",
    "model"
})
@XmlSeeAlso({
    GenericEquipment.class
})
public abstract class Equipment
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected ParamAlternative make;
    protected ParamAlternative model;

    /**
     * Gets the value of the make property.
     * 
     * @return
     *     possible object is
     *     {@link ParamAlternative }
     *     
     */
    public ParamAlternative getMake() {
        return make;
    }

    /**
     * Sets the value of the make property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternative }
     *     
     */
    public void setMake(ParamAlternative value) {
        this.make = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link ParamAlternative }
     *     
     */
    public ParamAlternative getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternative }
     *     
     */
    public void setModel(ParamAlternative value) {
        this.model = value;
    }

}
