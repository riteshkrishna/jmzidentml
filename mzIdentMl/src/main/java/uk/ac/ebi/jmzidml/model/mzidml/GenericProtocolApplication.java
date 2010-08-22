
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
 * A subclass of ProtocolApplication to be used as it is in data formats without being
 *                 extended.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.GenericProtocolApplicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.GenericProtocolApplicationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ProtocolApplicationType">
 *       &lt;sequence>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}GenericMaterialMeasurement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inputData" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Data_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="outputData" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Data_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="outputMaterials" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Material_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="inputCompleteMaterials" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Material_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParameterValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Protocol_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.GenericProtocolApplicationType", propOrder = {
    "genericMaterialMeasurement",
    "inputData",
    "outputData",
    "outputMaterials",
    "inputCompleteMaterials",
    "parameterValue"
})
public class GenericProtocolApplication
    extends ProtocolApplication
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "GenericMaterialMeasurement")
    protected List<GenericMaterialMeasurement> genericMaterialMeasurement;
    protected List<GenericProtocolApplication.InputData> inputData;
    protected List<GenericProtocolApplication.OutputData> outputData;
    protected List<GenericProtocolApplication.OutputMaterials> outputMaterials;
    protected List<GenericProtocolApplication.InputCompleteMaterials> inputCompleteMaterials;
    @XmlElement(name = "ParameterValue")
    protected List<ParameterValue> parameterValue;
    @XmlAttribute(name = "Protocol_ref", required = true)
    protected String protocolRef;

    /**
     * Measured sources of material that are inputs to this
     *                                 GenericProtocolApplication.
     *                             Gets the value of the genericMaterialMeasurement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericMaterialMeasurement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericMaterialMeasurement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericMaterialMeasurement }
     * 
     * 
     */
    public List<GenericMaterialMeasurement> getGenericMaterialMeasurement() {
        if (genericMaterialMeasurement == null) {
            genericMaterialMeasurement = new ArrayList<GenericMaterialMeasurement>();
        }
        return this.genericMaterialMeasurement;
    }

    /**
     * Gets the value of the inputData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericProtocolApplication.InputData }
     * 
     * 
     */
    public List<GenericProtocolApplication.InputData> getInputData() {
        if (inputData == null) {
            inputData = new ArrayList<GenericProtocolApplication.InputData>();
        }
        return this.inputData;
    }

    /**
     * Gets the value of the outputData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericProtocolApplication.OutputData }
     * 
     * 
     */
    public List<GenericProtocolApplication.OutputData> getOutputData() {
        if (outputData == null) {
            outputData = new ArrayList<GenericProtocolApplication.OutputData>();
        }
        return this.outputData;
    }

    /**
     * Gets the value of the outputMaterials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputMaterials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputMaterials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericProtocolApplication.OutputMaterials }
     * 
     * 
     */
    public List<GenericProtocolApplication.OutputMaterials> getOutputMaterials() {
        if (outputMaterials == null) {
            outputMaterials = new ArrayList<GenericProtocolApplication.OutputMaterials>();
        }
        return this.outputMaterials;
    }

    /**
     * Gets the value of the inputCompleteMaterials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputCompleteMaterials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputCompleteMaterials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericProtocolApplication.InputCompleteMaterials }
     * 
     * 
     */
    public List<GenericProtocolApplication.InputCompleteMaterials> getInputCompleteMaterials() {
        if (inputCompleteMaterials == null) {
            inputCompleteMaterials = new ArrayList<GenericProtocolApplication.InputCompleteMaterials>();
        }
        return this.inputCompleteMaterials;
    }

    /**
     * The parameter values for this Parameterizable Application.
     *                             Gets the value of the parameterValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParameterValue }
     * 
     * 
     */
    public List<ParameterValue> getParameterValue() {
        if (parameterValue == null) {
            parameterValue = new ArrayList<ParameterValue>();
        }
        return this.parameterValue;
    }

    /**
     * Gets the value of the protocolRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolRef() {
        return protocolRef;
    }

    /**
     * Sets the value of the protocolRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolRef(String value) {
        this.protocolRef = value;
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
     *       &lt;attribute name="Material_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class InputCompleteMaterials
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "Material_ref", required = true)
        protected String materialRef;

        /**
         * Gets the value of the materialRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaterialRef() {
            return materialRef;
        }

        /**
         * Sets the value of the materialRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaterialRef(String value) {
            this.materialRef = value;
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
     *       &lt;attribute name="Data_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class InputData
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "Data_ref", required = true)
        protected String dataRef;

        /**
         * Gets the value of the dataRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataRef() {
            return dataRef;
        }

        /**
         * Sets the value of the dataRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataRef(String value) {
            this.dataRef = value;
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
     *       &lt;attribute name="Data_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OutputData
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "Data_ref", required = true)
        protected String dataRef;

        /**
         * Gets the value of the dataRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataRef() {
            return dataRef;
        }

        /**
         * Sets the value of the dataRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataRef(String value) {
            this.dataRef = value;
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
     *       &lt;attribute name="Material_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OutputMaterials
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "Material_ref", required = true)
        protected String materialRef;

        /**
         * Gets the value of the materialRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaterialRef() {
            return materialRef;
        }

        /**
         * Sets the value of the materialRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaterialRef(String value) {
            this.materialRef = value;
        }

    }

}
