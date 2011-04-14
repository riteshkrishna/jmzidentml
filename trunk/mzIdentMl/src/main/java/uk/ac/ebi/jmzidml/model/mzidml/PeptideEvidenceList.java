
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.ParamListCapable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for PeptideEvidenceListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeptideEvidenceListType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.1}IdentifiableType">
 *       &lt;sequence>
 *         &lt;element name="PeptideEvidence" type="{http://psidev.info/psi/pi/mzIdentML/1.1}PeptideEvidenceType" maxOccurs="unbounded"/>
 *         &lt;element name="AdditionalParams" type="{http://psidev.info/psi/pi/mzIdentML/1.1}ParamListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeptideEvidenceListType", propOrder = {
    "peptideEvidence",
     "enzymeRef",
    "additionalParams"
})
public class PeptideEvidenceList
    extends Identifiable
    implements Serializable, ParamListCapable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "PeptideEvidence", required = true)
    protected List<PeptideEvidence> peptideEvidence;
    @XmlElement(name = "AdditionalParams")
    protected ParamList additionalParams;
    @XmlElement(name="EnzymeRef")
    protected EnzymeRef enzymeRef;

    /**
     * Gets the value of the peptideEvidence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peptideEvidence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeptideEvidence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeptideEvidence }
     * 
     * @return List<PeptideEvidence> the list of PeptideEvidence elements contained in this list wrapper.
     */
    public List<PeptideEvidence> getPeptideEvidence() {
        if (peptideEvidence == null) {
            peptideEvidence = new ArrayList<PeptideEvidence>();
        }
        return this.peptideEvidence;
    }

    /**
     * Gets the value of the additionalParams property.
     * 
     * @return
     *     possible object is
     *     {@link ParamList }
     *     
     */
    public ParamList getAdditionalParams() {
        /**
         * create new instance of ParamList? Only thin wrapper for list and a list would be created.
         *
         */
        if(additionalParams == null){
            additionalParams = new ParamList();
        }
        return additionalParams;
    }

    public List<CvParam> getCvParam() {
        return this.getAdditionalParams().getCvParam();
    }

    public List<UserParam> getUserParam() {
        return this.getAdditionalParams().getUserParam();
    }

    public EnzymeRef getEnzymeRef() {
        return this.enzymeRef;
    }
}
