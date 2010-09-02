
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.xml.jaxb.adapters.PeptideEvidenceAdapter;


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
    @XmlJavaTypeAdapter(PeptideEvidenceAdapter.class)
    protected PeptideEvidence peptideEvidence;

    /**
     * Gets the value of the peptideEvidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public PeptideEvidence getPeptideEvidence() {
        return peptideEvidence;
    }

    /**
     * Sets the value of the peptideEvidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeptideEvidence(PeptideEvidence value) {
        this.peptideEvidence = value;
    }

}
