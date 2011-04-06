
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for ParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParamType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.1}ParamGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamType", propOrder = {
    "paramGroup"
})
public class Param
    extends MzIdentMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected AbstractParam paramGroup;

    /**
     * Sets the value of the paramGroup property.
     * This can either be a CvParam or UserParam instance object.
     * 
     * @param value
     *     allowed object is
     *     {@link CvParam }
     *     {@link UserParam }
     *     
     */
    public void setParam(AbstractParam value) {
        this.paramGroup = value;
    }

    public CvParam getCvParam() {
        if (paramGroup instanceof CvParam) {
            return (CvParam) paramGroup;
        } else {
            return null;
        }
    }

    public UserParam getUserParam() {
        if (paramGroup instanceof UserParam) {
            return (UserParam) paramGroup;
        } else {
            return null;
        }
    }

}
