
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * A pairing of an output parameter from a Protocol (SourceParameter) with an input
 *                 parameter to a separate Protocol (TargetParameter) to indicate that the ParameterValue will be the same.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.ParameterPairType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.ParameterPairType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetParameter">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Parameter_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sourceParameter">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Parameter_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.ParameterPairType", propOrder = {
    "targetParameter",
    "sourceParameter"
})
public class ParameterPair
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected ParameterPair.TargetParameter targetParameter;
    @XmlElement(required = true)
    protected ParameterPair.SourceParameter sourceParameter;

    /**
     * Gets the value of the targetParameter property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterPair.TargetParameter }
     *     
     */
    public ParameterPair.TargetParameter getTargetParameter() {
        return targetParameter;
    }

    /**
     * Sets the value of the targetParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterPair.TargetParameter }
     *     
     */
    public void setTargetParameter(ParameterPair.TargetParameter value) {
        this.targetParameter = value;
    }

    /**
     * Gets the value of the sourceParameter property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterPair.SourceParameter }
     *     
     */
    public ParameterPair.SourceParameter getSourceParameter() {
        return sourceParameter;
    }

    /**
     * Sets the value of the sourceParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterPair.SourceParameter }
     *     
     */
    public void setSourceParameter(ParameterPair.SourceParameter value) {
        this.sourceParameter = value;
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
     *       &lt;attribute name="Parameter_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SourceParameter
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "Parameter_ref", required = true)
        protected String parameterRef;

        /**
         * Gets the value of the parameterRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParameterRef() {
            return parameterRef;
        }

        /**
         * Sets the value of the parameterRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParameterRef(String value) {
            this.parameterRef = value;
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
     *       &lt;attribute name="Parameter_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TargetParameter
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlAttribute(name = "Parameter_ref", required = true)
        protected String parameterRef;

        /**
         * Gets the value of the parameterRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParameterRef() {
            return parameterRef;
        }

        /**
         * Sets the value of the parameterRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParameterRef(String value) {
            this.parameterRef = value;
        }

    }

}
