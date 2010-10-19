
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * The masses of residues used in the search.
 * 
 * <p>Java class for PSI-PI.analysis.search.MassTableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.MassTableType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Residue" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ResidueType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AmbiguousResidue" type="{http://psidev.info/psi/pi/mzIdentML/1.0}AmbiguousResidueType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="msLevel" use="required" type="{http://psidev.info/psi/pi/mzIdentML/1.0}listOfIntegers" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.MassTableType", propOrder = {
    "paramGroup",
    "residue",
    "ambiguousResidue"
})
public class MassTable
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<Param> paramGroup;

    @XmlTransient
    private List<CvParam> cvParams;
    @XmlTransient
    private List<UserParam> userParams;

    @XmlElement(name = "Residue")
    protected List<Residue> residue;
    @XmlElement(name = "AmbiguousResidue")
    protected List<AmbiguousResidue> ambiguousResidue;
    @XmlAttribute(required = true)
    protected List<BigInteger> msLevel;

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

    public List<CvParam> getCvParam() {
        return cvParams;
    }

    public List<UserParam> getUserParam() {
        return userParams;
    }

    /**
     * Gets the value of the residue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the residue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResidue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Residue }
     * 
     * 
     */
    public List<Residue> getResidue() {
        if (residue == null) {
            residue = new ArrayList<Residue>();
        }
        return this.residue;
    }

    /**
     * Gets the value of the ambiguousResidue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ambiguousResidue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmbiguousResidue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmbiguousResidue }
     * 
     * 
     */
    public List<AmbiguousResidue> getAmbiguousResidue() {
        if (ambiguousResidue == null) {
            ambiguousResidue = new ArrayList<AmbiguousResidue>();
        }
        return this.ambiguousResidue;
    }

    /**
     * Gets the value of the msLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMsLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getMsLevel() {
        if (msLevel == null) {
            msLevel = new ArrayList<BigInteger>();
        }
        return this.msLevel;
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
