
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * Specification of a search modification as parameter for a spectra search. Contains the
 *                 name of the modification, the mass, the specificity and whether it is a static modification.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.search.SearchModificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.SearchModificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ModParam" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.polypeptide.ModParamType"/>
 *         &lt;element name="SpecificityRules" type="{http://psidev.info/psi/pi/mzIdentML/1.0}SpecificityRulesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fixedMod" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.SearchModificationType", propOrder = {
    "modParam",
    "specificityRules"
})
public class SearchModification
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ModParam", required = true)
    protected ModParam modParam;
    @XmlElement(name = "SpecificityRules")
    protected SpecificityRules specificityRules;
    @XmlAttribute(required = true)
    protected boolean fixedMod;

    /**
     * Gets the value of the modParam property.
     * 
     * @return
     *     possible object is
     *     {@link ModParam }
     *     
     */
    public ModParam getModParam() {
        return modParam;
    }

    /**
     * Sets the value of the modParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModParam }
     *     
     */
    public void setModParam(ModParam value) {
        this.modParam = value;
    }

    /**
     * Gets the value of the specificityRules property.
     * 
     * @return
     *     possible object is
     *     {@link SpecificityRules }
     *     
     */
    public SpecificityRules getSpecificityRules() {
        return specificityRules;
    }

    /**
     * Sets the value of the specificityRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificityRules }
     *     
     */
    public void setSpecificityRules(SpecificityRules value) {
        this.specificityRules = value;
    }

    /**
     * Gets the value of the fixedMod property.
     * 
     */
    public boolean isFixedMod() {
        return fixedMod;
    }

    /**
     * Sets the value of the fixedMod property.
     * 
     */
    public void setFixedMod(boolean value) {
        this.fixedMod = value;
    }

}
