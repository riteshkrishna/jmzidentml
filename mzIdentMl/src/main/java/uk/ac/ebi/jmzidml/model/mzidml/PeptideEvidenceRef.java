package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for PeptideEvidenceRefType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PeptideEvidenceRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="PeptideEvidence_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeptideEvidenceRefType")
public class PeptideEvidenceRef
        extends MzIdentMLObject
        implements Serializable {

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "peptideEvidence_ref", required = true)
    protected String peptideEvidenceRef;
    @XmlTransient
    protected PeptideEvidence peptideEvidence;

    public PeptideEvidence getPeptideEvidence() {
        return peptideEvidence;
    }

    public void setPeptideEvidence(PeptideEvidence peptideEvidence) {
        if (peptideEvidence == null) {
            this.peptideEvidenceRef = null;
        } else {
            String refId = peptideEvidence.getId();
            if (refId == null) throw new IllegalArgumentException("Referenced object does not have an identifier.");
            this.peptideEvidenceRef= refId;
        }
        this.peptideEvidence = peptideEvidence;
    }

    /**
     * Gets the value of the peptideEvidenceRef property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPeptideEvidenceRef() {
        return peptideEvidenceRef;
    }
}
