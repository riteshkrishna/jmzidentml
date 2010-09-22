
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
 *       &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup"/>
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
public class ParamAlternative
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    private Param paramGroup;

    @XmlTransient
    private CvParam cvParam;
    @XmlTransient
    private UserParam userParam;


    public CvParam getCvParam() {
        return cvParam;
    }

    public UserParam getUserParam() {
        return userParam;
    }

    public void setUserParam(UserParam userParam) {
        this.userParam = userParam;
    }

    public void setCvParam(CvParam cvParam) {
        this.cvParam = cvParam;
    }

    /**
     * Operation after unmarshalling to provide access to specific type
     * ParamAlternative implementations of CvParam or UserParam.
     */
    public void afterUnmarshalOperation() {
        if (paramGroup == null) return;
        
        if (paramGroup instanceof CvParam) {
            cvParam = (CvParam) paramGroup;
        }
        if (paramGroup instanceof UserParam) {
            userParam = (UserParam) paramGroup;
        }
    }

    /**
     * Method to assign the specific ParamAlternative implementation
     * to the generic ParamAlternative value of the XML mapped paramGroup field.
     */
    public void beforeMarshalOperation() {
        if (cvParam != null ) {
            if (userParam != null) { // we are not supposed to have both a CvParam AND a UserParam!
                throw new IllegalStateException("Found UserParam and CvParam where only either one was expected.");
            } // else we only have a CvParam, so we assign that
            paramGroup = cvParam;
        } else {
            // either userParam has a value or not. It does not make
            // a difference since cvParam is null anyway.
            paramGroup = userParam;
        }
    

    }

}
