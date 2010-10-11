
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * One (poly)peptide (a sequence with modifications).
 * 
 * <p>Java class for PSI-PI.polypeptide.PeptideType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.polypeptide.PeptideType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.ConceptualMolecule.ConceptualMoleculeType">
 *       &lt;sequence>
 *         &lt;element name="peptideSequence" type="{http://psidev.info/psi/pi/mzIdentML/1.0}sequence"/>
 *         &lt;element name="Modification" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.polypeptide.ModificationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SubstitutionModification" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.polypeptide.SubstitutionModificationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.polypeptide.PeptideType", propOrder = {
    "peptideSequence",
    "modification",
    "substitutionModification",
    "paramGroup"
})
public class Peptide
    extends ConceptualMolecule
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected String peptideSequence;
    @XmlElement(name = "Modification")
    protected List<Modification> modification;
    @XmlElement(name = "SubstitutionModification")
    protected List<SubstitutionModification> substitutionModification;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<Param> paramGroup;

    @XmlTransient
    private List<CvParam> cvParams;
    @XmlTransient
    private List<UserParam> userParams;


    /**
     * Gets the value of the peptideSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeptideSequence() {
        return peptideSequence;
    }

    /**
     * Sets the value of the peptideSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeptideSequence(String value) {
        this.peptideSequence = value;
    }

    /**
     * Gets the value of the modification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Modification }
     * 
     * 
     */
    public List<Modification> getModification() {
        if (modification == null) {
            modification = new ArrayList<Modification>();
        }
        return this.modification;
    }

    /**
     * Gets the value of the substitutionModification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substitutionModification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstitutionModification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubstitutionModification }
     * 
     * 
     */
    public List<SubstitutionModification> getSubstitutionModification() {
        if (substitutionModification == null) {
            substitutionModification = new ArrayList<SubstitutionModification>();
        }
        return this.substitutionModification;
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

    public List<CvParam> getCvParams() {
        return cvParams;
    }

    public List<UserParam> getUserParams() {
        return userParams;
    }

    /**
     * After unmarshalling, split the List of generic Params into
     * a List of CvParams and a List of UserParams.
     */
    public void afterUnmarshalOperation() {
        cvParams = new ArrayList<CvParam>();
        userParams = new ArrayList<UserParam>();
        for (Param param : getParamGroup()) {
            if (param instanceof CvParam) {
                cvParams.add((CvParam) param);
            }
            if (param instanceof UserParam) {
                userParams.add((UserParam) param);
            }
        }
    }

    /**
     * Before we marshall the XML, combine the CvParams and UserParams
     * into the generic List of Params.
     */
    public void beforeMarshalOperation() {
        paramGroup = new ArrayList<Param>();
        for (CvParam cvParam : cvParams) {
            paramGroup.add(cvParam);
        }
        for (UserParam userParam : userParams) {
            paramGroup.add(userParam);
        }
    }


}
