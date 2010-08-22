
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
 * A subclass of the abstract Equipment class for capturing the description of Equipment
 *                 used.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.GenericEquipmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.GenericEquipmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.EquipmentType">
 *       &lt;sequence>
 *         &lt;element name="software" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="GenericSoftware_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}GenericParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="equipmentParts" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="GenericEquipment_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.GenericEquipmentType", propOrder = {
    "software",
    "genericParameter",
    "equipmentParts"
})
public class GenericEquipment
    extends Equipment
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected List<GenericEquipment.Software> software;
    @XmlElement(name = "GenericParameter")
    protected List<GenericParameter> genericParameter;
    protected List<GenericEquipment.EquipmentParts> equipmentParts;

    /**
     * Gets the value of the software property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the software property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoftware().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericEquipment.Software }
     * 
     * 
     */
    public List<GenericEquipment.Software> getSoftware() {
        if (software == null) {
            software = new ArrayList<GenericEquipment.Software>();
        }
        return this.software;
    }

    /**
     * The parameters for this piece of GenericEquipment.Gets the value of the genericParameter property.
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
     * Gets the value of the equipmentParts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipmentParts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipmentParts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericEquipment.EquipmentParts }
     * 
     * 
     */
    public List<GenericEquipment.EquipmentParts> getEquipmentParts() {
        if (equipmentParts == null) {
            equipmentParts = new ArrayList<GenericEquipment.EquipmentParts>();
        }
        return this.equipmentParts;
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
    public static class EquipmentParts
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="GenericSoftware_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Software
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "GenericSoftware_ref", required = true)
        protected String genericSoftwareRef;

        /**
         * Gets the value of the genericSoftwareRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGenericSoftwareRef() {
            return genericSoftwareRef;
        }

        /**
         * Sets the value of the genericSoftwareRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGenericSoftwareRef(String value) {
            this.genericSoftwareRef = value;
        }

    }

}
