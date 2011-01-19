
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.ParamGroupCapable;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A file from which this mzIdentML instance was created.
 * 
 * <p>Java class for PSI-PI.analysis.search.SourceFileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.SourceFileType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Data.ExternalDataType">
 *       &lt;sequence>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.SourceFileType", propOrder = {
    "paramGroup"
})
public class SourceFile
    extends ExternalData
    implements Serializable, ParamGroupCapable
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<Param> paramGroup;

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


    /**
     * Gets the value of the paramGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paramGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParamGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CvParam }
     * {@link UserParam }
     * 
     * 
     */
    public List<Param> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<Param>();
        }
        return this.paramGroup;
    }

}
