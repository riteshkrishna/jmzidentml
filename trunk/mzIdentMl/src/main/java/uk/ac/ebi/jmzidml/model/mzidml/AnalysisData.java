
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * <p>Java class for AnalysisDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnalysisDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpectrumIdentificationList" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.analysis.search.SpectrumIdentificationListType" maxOccurs="unbounded"/>
 *         &lt;element name="ProteinDetectionList" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.analysis.process.ProteinDetectionListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalysisDataType", propOrder = {
    "spectrumIdentificationList",
    "proteinDetectionList"
})
public class AnalysisData
    implements Serializable, MzIdentMLObject
{
    @XmlTransient
    protected Long hid;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "SpectrumIdentificationList", required = true)
    protected List<SpectrumIdentificationList> spectrumIdentificationList;
    @XmlElement(name = "ProteinDetectionList")
    protected ProteinDetectionList proteinDetectionList;

    /**
     * Gets the value of the spectrumIdentificationList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spectrumIdentificationList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpectrumIdentificationList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpectrumIdentificationList }
     * 
     * 
     */
    public List<SpectrumIdentificationList> getSpectrumIdentificationList() {
        if (spectrumIdentificationList == null) {
            spectrumIdentificationList = new ArrayList<SpectrumIdentificationList>();
        }
        return this.spectrumIdentificationList;
    }

    /**
     * Gets the value of the proteinDetectionList property.
     * 
     * @return
     *     possible object is
     *     {@link ProteinDetectionList }
     *     
     */
    public ProteinDetectionList getProteinDetectionList() {
        return proteinDetectionList;
    }

    /**
     * Sets the value of the proteinDetectionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProteinDetectionList }
     *     
     */
    public void setProteinDetectionList(ProteinDetectionList value) {
        this.proteinDetectionList = value;
    }

}
