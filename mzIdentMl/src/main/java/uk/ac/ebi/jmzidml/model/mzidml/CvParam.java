
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * A single entry from an ontology or a controlled vocabulary.
 * 
 * <p>Java class for FuGE.Common.Ontology.cvParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Ontology.cvParamType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Ontology.ParamType">
 *       &lt;attribute name="cvRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="accession" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Ontology.cvParamType")
public class CvParam
    extends Param
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(required = true)
    protected String cvRef;
    @XmlAttribute(required = true)
    protected String accession;

    @XmlTransient
    Cv cv;

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
        if (cv != null) {
            this.cvRef = cv.getId();
        }
    }

    /**
     * Gets the value of the cvRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvRef() {
        return cvRef;
    }

    /**
     * Sets the value of the cvRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvRef(String value) {
        this.cvRef = value;
        if ( cv != null && !cv.getId().equals(value) ) {
            cv = null;
        }
    }

    /**
     * Gets the value of the accession property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccession() {
        return accession;
    }

    /**
     * Sets the value of the accession property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccession(String value) {
        this.accession = value;
    }

}
