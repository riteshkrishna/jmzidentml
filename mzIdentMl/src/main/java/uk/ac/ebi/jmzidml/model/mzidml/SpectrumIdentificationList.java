
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents the set of all search results from SpectrumIdentification.
 * 
 * <p>Java class for PSI-PI.analysis.search.SpectrumIdentificationListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.SpectrumIdentificationListType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Data.InternalDataType">
 *       &lt;sequence>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FragmentationTable" type="{http://psidev.info/psi/pi/mzIdentML/1.0}FragmentationTableType" minOccurs="0"/>
 *         &lt;element name="SpectrumIdentificationResult" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.analysis.search.SpectrumIdentificationResultType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numSequencesSearched" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.SpectrumIdentificationListType", propOrder = {
    "paramGroup",
    "fragmentationTable",
    "spectrumIdentificationResult"
})
public class SpectrumIdentificationList
    extends InternalData
    implements Serializable
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

    @XmlElement(name = "FragmentationTable")
    protected FragmentationTable fragmentationTable;
    @XmlElement(name = "SpectrumIdentificationResult", required = true)
    protected List<SpectrumIdentificationResult> spectrumIdentificationResult;
    @XmlAttribute
    protected Long numSequencesSearched;

    /**
     * Scores or output parameters associated with the
     *                                 SpectrumIdentificationList
     *                             Gets the value of the paramGroup property.
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

    public List<CvParam> getCvParams() {
        return cvParams;
    }

    public List<UserParam> getUserParams() {
        return userParams;
    }

    /**
     * Gets the value of the fragmentationTable property.
     * 
     * @return
     *     possible object is
     *     {@link FragmentationTable }
     *     
     */
    public FragmentationTable getFragmentationTable() {
        return fragmentationTable;
    }

    /**
     * Sets the value of the fragmentationTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link FragmentationTable }
     *     
     */
    public void setFragmentationTable(FragmentationTable value) {
        this.fragmentationTable = value;
    }

    /**
     * Gets the value of the spectrumIdentificationResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spectrumIdentificationResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpectrumIdentificationResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpectrumIdentificationResult }
     * 
     * 
     */
    public List<SpectrumIdentificationResult> getSpectrumIdentificationResult() {
        if (spectrumIdentificationResult == null) {
            spectrumIdentificationResult = new ArrayList<SpectrumIdentificationResult>();
        }
        return this.spectrumIdentificationResult;
    }

    /**
     * Gets the value of the numSequencesSearched property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumSequencesSearched() {
        return numSequencesSearched;
    }

    /**
     * Sets the value of the numSequencesSearched property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumSequencesSearched(Long value) {
        this.numSequencesSearched = value;
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
