
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * A subclass of the abstract Software class for capturing the description of Software used.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.GenericSoftwareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.GenericSoftwareType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.SoftwareType">
 *       &lt;sequence>
 *         &lt;element name="equipment" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="GenericEquipment_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}GenericParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.GenericSoftwareType", propOrder = {
    "equipment",
    "genericParameter"
})
public class GenericSoftware
    extends Software
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected List<GenericSoftware.Equipment> equipment;
    @XmlElement(name = "GenericParameter")
    protected List<GenericParameter> genericParameter;

    /**
     * Gets the value of the equipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericSoftware.Equipment }
     * 
     * 
     */
    public List<GenericSoftware.Equipment> getEquipment() {
        if (equipment == null) {
            equipment = new ArrayList<GenericSoftware.Equipment>();
        }
        return this.equipment;
    }

    /**
     * The parameters for this piece of GenericSoftware.Gets the value of the genericParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericParameter }
     * 
     * 
     */
    public List<GenericParameter> getGenericParameter() {
        if (genericParameter == null) {
            genericParameter = new ArrayList<GenericParameter>();
        }
        return this.genericParameter;
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
     *       &lt;attribute name="GenericEquipment_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Equipment
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "GenericEquipment_ref", required = true)
        protected String genericEquipmentRef;

        /**
         * Gets the value of the genericEquipmentRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGenericEquipmentRef() {
            return genericEquipmentRef;
        }

        /**
         * Sets the value of the genericEquipmentRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGenericEquipmentRef(String value) {
            this.genericEquipmentRef = value;
        }

    }

}
