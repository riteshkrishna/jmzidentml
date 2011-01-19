
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.AbstractIdentifiableParamGroup;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * PeptideEvidence maps a spectrum identification to DBSequence in which such a peptide is
 *                 located.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.process.PeptideEvidenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.process.PeptideEvidenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DBSequence_Ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="pre">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[ABCDEFGHIJKLMNOPQRSTUVWXYZ?\-]{1}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="post">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[ABCDEFGHIJKLMNOPQRSTUVWXYZ?\-]{1}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="TranslationTable_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="frame" type="{http://psidev.info/psi/pi/mzIdentML/1.0}allowed_frames" />
 *       &lt;attribute name="isDecoy" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="missedCleavages" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.process.PeptideEvidenceType", propOrder = {
    "paramGroup"
})
public class PeptideEvidence
    extends AbstractIdentifiableParamGroup
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "userParam", type = UserParam.class),
        @XmlElement(name = "cvParam", type = CvParam.class)
    })
    protected List<Param> paramGroup;
    @XmlAttribute(name = "DBSequence_Ref", required = true)
    protected String dbSequenceRef;
    @XmlAttribute
    protected Integer start;
    @XmlAttribute
    protected Integer end;
    @XmlAttribute
    protected String pre;
    @XmlAttribute
    protected String post;
    @XmlAttribute(name = "TranslationTable_ref")
    protected String translationTableRef;
    @XmlAttribute
    protected Integer frame;
    @XmlAttribute
    protected Boolean isDecoy;
    @XmlAttribute
    protected Integer missedCleavages;

    @XmlTransient
    private DBSequence dbSequence;
    @XmlTransient
    private TranslationTable translationTable;

    public DBSequence getDBSequence() {
        return dbSequence;
    }

    public void setDBSequence(DBSequence dbSequence) {
        this.dbSequence = dbSequence;
        if (dbSequence != null) {
            this.dbSequenceRef = dbSequence.getId();
        }
    }

    public TranslationTable getTranslationTable() {
        return translationTable;
    }

    public void setTranslationTable(TranslationTable translationTable) {
        this.translationTable = translationTable;
        if (translationTable != null) {
            this.translationTableRef = translationTable.getId();
        }
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
     * {@link UserParam }
     * {@link CvParam }
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
     * Gets the value of the dbSequenceRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBSequenceRef() {
        return dbSequenceRef;
    }

    /**
     * Sets the value of the dbSequenceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBSequenceRef(String value) {
        this.dbSequenceRef = value;
        if ( dbSequence != null && !dbSequence.getId().equals(value) ) {
            dbSequence = null;
        }
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStart(Integer value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnd(Integer value) {
        this.end = value;
    }

    /**
     * Gets the value of the pre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPre() {
        return pre;
    }

    /**
     * Sets the value of the pre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPre(String value) {
        this.pre = value;
    }

    /**
     * Gets the value of the post property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPost() {
        return post;
    }

    /**
     * Sets the value of the post property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPost(String value) {
        this.post = value;
    }

    /**
     * Gets the value of the translationTableRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranslationTableRef() {
        return translationTableRef;
    }

    /**
     * Sets the value of the translationTableRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranslationTableRef(String value) {
        this.translationTableRef = value;
        if ( translationTable != null && !translationTable.getId().equals(value) ) {
            translationTable = null;
        }
    }

    /**
     * Gets the value of the frame property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrame() {
        return frame;
    }

    /**
     * Sets the value of the frame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrame(Integer value) {
        this.frame = value;
    }

    /**
     * Gets the value of the isDecoy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsDecoy() {
        if (isDecoy == null) {
            return false;
        } else {
            return isDecoy;
        }
    }

    /**
     * Sets the value of the isDecoy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDecoy(Boolean value) {
        this.isDecoy = value;
    }

    /**
     * Gets the value of the missedCleavages property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMissedCleavages() {
        return missedCleavages;
    }

    /**
     * Sets the value of the missedCleavages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMissedCleavages(Integer value) {
        this.missedCleavages = value;
    }

}
