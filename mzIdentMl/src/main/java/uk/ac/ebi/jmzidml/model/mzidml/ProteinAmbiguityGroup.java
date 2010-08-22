
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * A set of logically related results from a protein detection, for example to represent
 *                 conflicting assignments of peptides to proteins.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.process.ProteinAmbiguityGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.process.ProteinAmbiguityGroupType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element name="ProteinDetectionHypothesis" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.analysis.process.ProteinDetectionHypothesisType" maxOccurs="unbounded"/>
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
@XmlType(name = "PSI-PI.analysis.process.ProteinAmbiguityGroupType", propOrder = {
    "proteinDetectionHypothesis",
    "paramGroup"
})
public class ProteinAmbiguityGroup
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ProteinDetectionHypothesis", required = true)
    protected List<ProteinDetectionHypothesis> proteinDetectionHypothesis;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<Param> paramGroup;

    /**
     * Gets the value of the proteinDetectionHypothesis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proteinDetectionHypothesis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProteinDetectionHypothesis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProteinDetectionHypothesis }
     * 
     * 
     */
    public List<ProteinDetectionHypothesis> getProteinDetectionHypothesis() {
        if (proteinDetectionHypothesis == null) {
            proteinDetectionHypothesis = new ArrayList<ProteinDetectionHypothesis>();
        }
        return this.proteinDetectionHypothesis;
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

}
