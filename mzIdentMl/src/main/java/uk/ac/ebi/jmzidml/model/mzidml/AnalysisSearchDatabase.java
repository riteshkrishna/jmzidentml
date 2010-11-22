
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.CvParamListCapable;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A database for searching mass spectra. Examples include a set of amino acid sequence
 *                 entries, or annotated spectra libraries.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.search.SearchDatabaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.SearchDatabaseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Data.ExternalDataType">
 *       &lt;sequence>
 *         &lt;element name="DatabaseName" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamType"/>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}cvParam" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numDatabaseSequences" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="numResidues" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.SearchDatabaseType", propOrder = {
    "databaseName",
    "cvParam"
})
public class AnalysisSearchDatabase
    extends ExternalData
    implements Serializable, CvParamListCapable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "DatabaseName", required = true)
    protected ParamAlternative databaseName;
    protected List<CvParam> cvParam;
    @XmlAttribute
    protected String version;
    @XmlAttribute
    protected String releaseDate;
    @XmlAttribute
    protected Long numDatabaseSequences;
    @XmlAttribute
    protected Long numResidues;

    /**
     * Gets the value of the databaseName property.
     * 
     * @return
     *     possible object is
     *     {@link ParamAlternative }
     *     
     */
    public ParamAlternative getDatabaseName() {
        return databaseName;
    }

    /**
     * Sets the value of the databaseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternative }
     *     
     */
    public void setDatabaseName(ParamAlternative value) {
        this.databaseName = value;
    }

    /**
     * Gets the value of the cvParam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cvParam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCvParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CvParam }
     * 
     * 
     */
    public List<CvParam> getCvParam() {
        if (cvParam == null) {
            cvParam = new ArrayList<CvParam>();
        }
        return this.cvParam;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the releaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the value of the releaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleaseDate(String value) {
        this.releaseDate = value;
    }

    /**
     * Gets the value of the numDatabaseSequences property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumDatabaseSequences() {
        return numDatabaseSequences;
    }

    /**
     * Sets the value of the numDatabaseSequences property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumDatabaseSequences(Long value) {
        this.numDatabaseSequences = value;
    }

    /**
     * Gets the value of the numResidues property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumResidues() {
        return numResidues;
    }

    /**
     * Sets the value of the numResidues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumResidues(Long value) {
        this.numResidues = value;
    }

}
