
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.ParamGroupCapable;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Data that is internal to an instance XML document. InternalData can be extended with an
 *                 element that defines a particular encoding or data type for the storage array or the subclass
 *                 GenericInternalData should be instantiated. The array will typically use pointer arithmetic to access
 *                 values based on the rank (e.g. number of) Dimensions and their respective sizes (e.g. the number of
 *                 contained DimensionElements).
 *             
 * 
 * <p>Java class for FuGE.Bio.Data.InternalDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Bio.Data.InternalDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Data.DataType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Bio.Data.InternalDataType")
@XmlSeeAlso({
    ProteinDetectionList.class,
    SpectrumIdentificationList.class
})
public abstract class InternalData
    extends Data
    implements Serializable, ParamGroupCapable
{

    private final static long serialVersionUID = 100L;

    @XmlTransient
    private List<CvParam> cvParams;
    @XmlTransient
    private List<UserParam> userParams;



    public List<CvParam> getCvParam() {
        if (cvParams == null) {
            cvParams = new ArrayList<CvParam>();
        }
        return cvParams;
    }

    public List<UserParam> getUserParam() {
        if (userParams == null) {
            userParams = new ArrayList<UserParam>();
        }
        return userParams;
    }

    public void splitParamList() {
        if (getCvParam() == null || getCvParam().size() != 0) {
            throw new IllegalStateException("Error in initialisation. List of CvParam objects should be not null and empty in afterUnmarshal operation!");
        }
        if (getUserParam() == null || getUserParam().size() != 0) {
            throw new IllegalStateException("Error in initialisation. List of UserParam objects should be not null and empty in afterUnmarshal operation!");
        }
        for (Param param : getParamGroup()) {
            if (param instanceof CvParam) {
                getCvParam().add((CvParam) param);
            }
            if (param instanceof UserParam) {
                getUserParam().add((UserParam) param);
            }
        }
    }

    public void updateParamList() {
        // whatever we had in the List of Params, we only
        // consider what is in the CvParam/UserParam lists now.
        getParamGroup().clear();
        // combine the List<CvParam> and List<UserParam> in the one List<Param> that will be marshalled.
        for (CvParam cvParam : getCvParam()) {
            getParamGroup().add(cvParam);
        }
        for (UserParam userParam : getUserParam()) {
            getParamGroup().add(userParam);
        }
    }


}
