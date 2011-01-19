
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for PeptideHypothesisType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeptideHypothesisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="PeptideEvidence_Ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeptideHypothesisType")
public class PeptideHypothesis
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "PeptideEvidence_Ref", required = true)
    protected String peptideEvidenceRef;

    @XmlTransient
    PeptideEvidence peptideEvidence;

    public PeptideEvidence getPeptideEvidence() {
        return peptideEvidence;
    }

    public void setPeptideEvidence(PeptideEvidence peptideEvidence) {
        this.peptideEvidence = peptideEvidence;
        if (peptideEvidence != null) {
            this.peptideEvidenceRef = peptideEvidence.getId();
        }
    }

    /**
     * Gets the value of the peptideEvidenceRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeptideEvidenceRef() {
        return peptideEvidenceRef;
    }

    /**
     * Sets the value of the peptideEvidenceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeptideEvidenceRef(String value) {
        this.peptideEvidenceRef = value;
        if ( peptideEvidence != null && !peptideEvidence.getId().equals(value) ) {
            peptideEvidence = null;
        }
    }

}
