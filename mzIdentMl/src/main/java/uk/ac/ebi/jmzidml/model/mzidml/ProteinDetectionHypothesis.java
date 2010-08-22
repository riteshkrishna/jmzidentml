
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.ebi.jmzidml.xml.jaxb.adapters.DBSequenceAdapter;


/**
 * A single result of the ProteinDetection analysis (i.e. a protein).
 * 
 * <p>Java class for PSI-PI.analysis.process.ProteinDetectionHypothesisType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.process.ProteinDetectionHypothesisType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element name="PeptideHypothesis" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PeptideHypothesisType" maxOccurs="unbounded"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DBSequence_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="passThreshold" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.process.ProteinDetectionHypothesisType", propOrder = {
    "peptideHypothesis",
    "paramGroup"
})
public class ProteinDetectionHypothesis
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "PeptideHypothesis", required = true)
    protected List<PeptideHypothesis> peptideHypothesis;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<Param> paramGroup;
    @XmlAttribute(name = "DBSequence_ref")
    @XmlJavaTypeAdapter(DBSequenceAdapter.class)
    protected DBSequence dbSequenceProteinDetection;
    @XmlAttribute(required = true)
    protected boolean passThreshold;

    /**
     * Gets the value of the peptideHypothesis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peptideHypothesis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeptideHypothesis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeptideHypothesis }
     * 
     * 
     */
    public List<PeptideHypothesis> getPeptideHypothesis() {
        if (peptideHypothesis == null) {
            peptideHypothesis = new ArrayList<PeptideHypothesis>();
        }
        return this.peptideHypothesis;
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

    /**
     * Gets the value of the dbSequenceProteinDetection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DBSequence getDBSequenceProteinDetection() {
        return dbSequenceProteinDetection;
    }

    /**
     * Sets the value of the dbSequenceProteinDetection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBSequenceProteinDetection(DBSequence value) {
        this.dbSequenceProteinDetection = value;
    }

    /**
     * Gets the value of the passThreshold property.
     * 
     */
    public boolean isPassThreshold() {
        return passThreshold;
    }

    /**
     * Sets the value of the passThreshold property.
     * 
     */
    public void setPassThreshold(boolean value) {
        this.passThreshold = value;
    }

}
