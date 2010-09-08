
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * MaterialMeasurement represents the quantity of a source Material used in a
 *                 ProtocolApplication. MaterialMeasurement is abstract and should be extended if a subclass of
 *                 ProtocolApplication has to be associated with a measured source of a subclass of Material.
 *             
 * 
 * <p>Java class for FuGE.Bio.Material.MaterialMeasurementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Bio.Material.MaterialMeasurementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}MeasurementGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Bio.Material.MaterialMeasurementType", propOrder = {
    "measurementGroup"
})
@XmlSeeAlso({
    GenericMaterialMeasurement.class
})
public abstract class MaterialMeasurement
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "BooleanValue", type = BooleanValue.class),
        @XmlElement(name = "ComplexValue", type = ComplexValue.class),
        @XmlElement(name = "Range", type = Range.class),
        @XmlElement(name = "AtomicValue", type = AtomicValue.class)
    })
    protected Measurement measurementGroup;

    /**
     * The value of the measured source of material.
     * 
     * @return
     *     possible object is
     *     {@link BooleanValue }
     *     {@link ComplexValue }
     *     {@link Range }
     *     {@link AtomicValue }
     *     
     */
    public Measurement getMeasurementGroup() {
        return measurementGroup;
    }

    /**
     * Sets the value of the measurementGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanValue }
     *     {@link ComplexValue }
     *     {@link Range }
     *     {@link AtomicValue }
     *     
     */
    public void setMeasurementGroup(Measurement value) {
        this.measurementGroup = value;
    }

}
