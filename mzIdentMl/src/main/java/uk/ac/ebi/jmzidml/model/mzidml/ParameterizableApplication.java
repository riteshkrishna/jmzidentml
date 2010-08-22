
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The interface that is the use of a Parameterizable class.
 * 
 * <p>Java class for FuGE.Common.Protocol.ParameterizableApplicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.ParameterizableApplicationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParameterValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.ParameterizableApplicationType", propOrder = {
    "parameterValue"
})
@XmlSeeAlso({
    SoftwareApplication.class,
    ActionApplication.class,
    EquipmentApplication.class
})
public abstract class ParameterizableApplication
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ParameterValue")
    protected List<ParameterValue> parameterValue;

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

}
