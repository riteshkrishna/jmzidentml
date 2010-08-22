
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * The use of a piece of Equipment with the requisite Parameters and ParameterValues.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.EquipmentApplicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.EquipmentApplicationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ParameterizableApplicationType">
 *       &lt;attribute name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Equipment_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.EquipmentApplicationType")
public class EquipmentApplication
    extends ParameterizableApplication
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute
    protected String serialNumber;
    @XmlAttribute(name = "Equipment_ref", required = true)
    protected String equipmentRef;

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the equipmentRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipmentRef() {
        return equipmentRef;
    }

    /**
     * Sets the value of the equipmentRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipmentRef(String value) {
        this.equipmentRef = value;
    }

}
