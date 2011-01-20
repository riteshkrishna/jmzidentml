
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * <p>Java class for DataCollectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataCollectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Inputs" type="{http://psidev.info/psi/pi/mzIdentML/1.0}InputsType"/>
 *         &lt;element name="AnalysisData" type="{http://psidev.info/psi/pi/mzIdentML/1.0}AnalysisDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCollectionType", propOrder = {
    "inputs",
    "analysisData"
})
public class DataCollection
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Inputs", required = true)
    protected Inputs inputs;
    @XmlElement(name = "AnalysisData", required = true)
    protected AnalysisData analysisData;

    @XmlTransient
    protected Long hid;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }


    /**
     * Gets the value of the inputs property.
     * 
     * @return
     *     possible object is
     *     {@link Inputs }
     *     
     */
    public Inputs getInputs() {
        return inputs;
    }

    /**
     * Sets the value of the inputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inputs }
     *     
     */
    public void setInputs(Inputs value) {
        this.inputs = value;
    }

    /**
     * Gets the value of the analysisData property.
     * 
     * @return
     *     possible object is
     *     {@link AnalysisData }
     *     
     */
    public AnalysisData getAnalysisData() {
        return analysisData;
    }

    /**
     * Sets the value of the analysisData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalysisData }
     *     
     */
    public void setAnalysisData(AnalysisData value) {
        this.analysisData = value;
    }

}
