
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * A range value.
 * 
 * <p>Java class for FuGE.Common.Measurement.RangeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Measurement.RangeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Measurement.MeasurementType">
 *       &lt;sequence>
 *         &lt;element name="lowerLimit">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}PropertyValue"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="upperLimit">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}PropertyValue"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="rangeDescriptors" maxOccurs="unbounded" minOccurs="0">
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
@XmlType(name = "FuGE.Common.Measurement.RangeType", propOrder = {
    "lowerLimit",
    "upperLimit",
    "rangeDescriptors"
})
public class Range
    extends Measurement
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected Range.LowerLimit lowerLimit;
    @XmlElement(required = true)
    protected Range.UpperLimit upperLimit;
    protected List<Range.RangeDescriptors> rangeDescriptors;

    /**
     * Gets the value of the lowerLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Range.LowerLimit }
     *     
     */
    public Range.LowerLimit getLowerLimit() {
        return lowerLimit;
    }

    /**
     * Sets the value of the lowerLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Range.LowerLimit }
     *     
     */
    public void setLowerLimit(Range.LowerLimit value) {
        this.lowerLimit = value;
    }

    /**
     * Gets the value of the upperLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Range.UpperLimit }
     *     
     */
    public Range.UpperLimit getUpperLimit() {
        return upperLimit;
    }

    /**
     * Sets the value of the upperLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Range.UpperLimit }
     *     
     */
    public void setUpperLimit(Range.UpperLimit value) {
        this.upperLimit = value;
    }

    /**
     * Gets the value of the rangeDescriptors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rangeDescriptors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRangeDescriptors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Range.RangeDescriptors }
     * 
     * 
     */
    public List<Range.RangeDescriptors> getRangeDescriptors() {
        if (rangeDescriptors == null) {
            rangeDescriptors = new ArrayList<Range.RangeDescriptors>();
        }
        return this.rangeDescriptors;
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
     *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}PropertyValue"/>
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
        "propertyValue"
    })
    public static class LowerLimit
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "PropertyValue", required = true)
        protected PropertyValue propertyValue;

        /**
         * Gets the value of the propertyValue property.
         * 
         * @return
         *     possible object is
         *     {@link PropertyValue }
         *     
         */
        public PropertyValue getPropertyValue() {
            return propertyValue;
        }

        /**
         * Sets the value of the propertyValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link PropertyValue }
         *     
         */
        public void setPropertyValue(PropertyValue value) {
            this.propertyValue = value;
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
    public static class RangeDescriptors
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
     *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}PropertyValue"/>
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
        "propertyValue"
    })
    public static class UpperLimit
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "PropertyValue", required = true)
        protected PropertyValue propertyValue;

        /**
         * Gets the value of the propertyValue property.
         * 
         * @return
         *     possible object is
         *     {@link PropertyValue }
         *     
         */
        public PropertyValue getPropertyValue() {
            return propertyValue;
        }

        /**
         * Sets the value of the propertyValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link PropertyValue }
         *     
         */
        public void setPropertyValue(PropertyValue value) {
            this.propertyValue = value;
        }

    }

}
