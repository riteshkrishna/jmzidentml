
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * Abstract superclass representing different methods of supplying a value or measurement.
 *             
 * 
 * <p>Java class for FuGE.Common.Measurement.MeasurementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Measurement.MeasurementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Ontology.cvParamType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Measurement.MeasurementType", propOrder = {
    "dataType"
})
@XmlSeeAlso({
    BooleanValue.class,
    Range.class,
    AtomicValue.class,
    ComplexValue.class
})
public abstract class Measurement implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    protected CvParam dataType;

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link CvParam }
     *     
     */
    public CvParam getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CvParam }
     *     
     */
    public void setDataType(CvParam value) {
        this.dataType = value;
    }

}
