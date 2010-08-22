
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * A subclass of the abstract Parameter class to represent a parameter that is defined by a
 *                 controlled vocabulary term.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.GenericParameterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.GenericParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ParameterType">
 *       &lt;sequence>
 *         &lt;element name="parameterType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}cvParam"/>
 *                 &lt;/sequence>
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
@XmlType(name = "FuGE.Common.Protocol.GenericParameterType", propOrder = {
    "parameterType"
})
public class GenericParameter
    extends Parameter
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected GenericParameter.ParameterType parameterType;

    /**
     * Gets the value of the parameterType property.
     * 
     * @return
     *     possible object is
     *     {@link GenericParameter.ParameterType }
     *     
     */
    public GenericParameter.ParameterType getParameterType() {
        return parameterType;
    }

    /**
     * Sets the value of the parameterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericParameter.ParameterType }
     *     
     */
    public void setParameterType(GenericParameter.ParameterType value) {
        this.parameterType = value;
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
     *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}cvParam"/>
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
        "cvParam"
    })
    public static class ParameterType
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(required = true)
        protected CvParam cvParam;

        /**
         * Gets the value of the cvParam property.
         * 
         * @return
         *     possible object is
         *     {@link CvParam }
         *     
         */
        public CvParam getCvParam() {
            return cvParam;
        }

        /**
         * Sets the value of the cvParam property.
         * 
         * @param value
         *     allowed object is
         *     {@link CvParam }
         *     
         */
        public void setCvParam(CvParam value) {
            this.cvParam = value;
        }

    }

}
