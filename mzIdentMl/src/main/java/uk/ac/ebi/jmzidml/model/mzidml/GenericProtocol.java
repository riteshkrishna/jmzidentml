
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
 * GenericProtocol should be used with GenericAction, GenericParameter or protocolText to
 *                 describe protocols in a data format for cases where no explicit extension of Protocol has been
 *                 developed.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.GenericProtocolType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.GenericProtocolType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ProtocolType">
 *       &lt;sequence>
 *         &lt;element name="protocolText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="software" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="GenericSoftware_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}GenericAction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.GenericProtocolType", propOrder = {
    "protocolText",
    "software",
    "equipment",
    "genericParameter",
    "genericAction"
})
public class GenericProtocol
    extends Protocol
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected String protocolText;
    protected List<GenericProtocol.Software> software;
    protected List<GenericProtocol.Equipment> equipment;
    @XmlElement(name = "GenericParameter")
    protected List<GenericParameter> genericParameter;
    @XmlElement(name = "GenericAction")
    protected List<GenericAction> genericAction;

    /**
     * Gets the value of the protocolText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolText() {
        return protocolText;
    }

    /**
     * Sets the value of the protocolText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolText(String value) {
        this.protocolText = value;
    }

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
     * {@link GenericProtocol.Software }
     * 
     * 
     */
    public List<GenericProtocol.Software> getSoftware() {
        if (software == null) {
            software = new ArrayList<GenericProtocol.Software>();
        }
        return this.software;
    }

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
     * {@link GenericProtocol.Equipment }
     * 
     * 
     */
    public List<GenericProtocol.Equipment> getEquipment() {
        if (equipment == null) {
            equipment = new ArrayList<GenericProtocol.Equipment>();
        }
        return this.equipment;
    }

    /**
     * The parameters defined for the GenericProtocol.Gets the value of the genericParameter property.
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
     * The actions performed within a GenericProtocol.Gets the value of the genericAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericAction }
     * 
     * 
     */
    public List<GenericAction> getGenericAction() {
        if (genericAction == null) {
            genericAction = new ArrayList<GenericAction>();
        }
        return this.genericAction;
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
