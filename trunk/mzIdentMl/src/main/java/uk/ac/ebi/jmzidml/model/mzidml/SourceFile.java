
package uk.ac.ebi.jmzidml.model.mzidml;

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
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "userParam", type = UserParam.class),
        @XmlElement(name = "cvParam", type = CvParam.class)
    })
    protected List<Param> paramGroup;

    @XmlTransient
    private List<CvParam> cvParams;
    @XmlTransient
    private List<UserParam> userParams;


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
     * {@link UserParam }
     * {@link CvParam }
     *
     * 
     */
    public List<Param> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<Param>();
        }
        return this.paramGroup;
    }

    public List<CvParam> getCvParams() {
        return cvParams;
    }

    public List<UserParam> getUserParams() {
        return userParams;
    }

    /**
     * After unmarshalling, split the List of generic Params into
     * a List of CvParams and a List of UserParams.
     */
    public void afterUnmarshalOperation() {
        cvParams = new ArrayList<CvParam>();
        userParams = new ArrayList<UserParam>();
        for (Param param : getParamGroup()) {
            if (param instanceof CvParam) {
                cvParams.add((CvParam) param);
            }
            if (param instanceof UserParam) {
                userParams.add((UserParam) param);
            }
        }
    }

    /**
     * Before we marshall the XML, combine the CvParams and UserParams
     * into the generic List of Params.
     */
    public void beforeMarshalOperation() {
        paramGroup = new ArrayList<Param>();
        for (CvParam cvParam : cvParams) {
            paramGroup.add(cvParam);
        }
        for (UserParam userParam : userParams) {
            paramGroup.add(userParam);
        }
    }

}
