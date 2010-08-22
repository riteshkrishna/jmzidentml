
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A Parameter is a replaceable value in a Parameterizable class, and uses the Measurement
 *                 class for giving a specific type of value. Examples of Parameters include: scanning wavelength, laser
 *                 power, centrifuge speed, multiplicative errors, the number of input nodes to a SOM, and PCR
 *                 temperatures. Parameter is abstract and should be extended by subclassing. The GenericParameter class
 *                 offers the functionality of a parameter defined by a controlled vocabulary term.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.ParameterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.ParameterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}MeasurementGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.ParameterType", propOrder = {
    "measurementGroup"
})
@XmlSeeAlso({
    GenericParameter.class
})
public abstract class Parameter
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "AtomicValue", type = AtomicValue.class),
        @XmlElement(name = "BooleanValue", type = BooleanValue.class),
        @XmlElement(name = "Range", type = Range.class),
        @XmlElement(name = "ComplexValue", type = ComplexValue.class)
    })
    protected Measurement measurementGroup;

    /**
     * The default value for this parameter.
     * 
     * @return
     *     possible object is
     *     {@link AtomicValue }
     *     {@link BooleanValue }
     *     {@link Range }
     *     {@link ComplexValue }
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
     *     {@link AtomicValue }
     *     {@link BooleanValue }
     *     {@link Range }
     *     {@link ComplexValue }
     *     
     */
    public void setMeasurementGroup(Measurement value) {
        this.measurementGroup = value;
    }

}
