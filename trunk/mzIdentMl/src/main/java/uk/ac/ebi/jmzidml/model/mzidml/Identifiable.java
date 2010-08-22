
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * Other classes in the model can be specified as sub-classes, inheriting from Identifiable.
 *                 Identifiable gives classes a unique identifier within the scope and a name that need not be unique.
 *                 Identifiable also provides a mechanism for annotating objects with BibliographicReference(s) and
 *                 DatabaseEntry(s).
 *             
 * 
 * <p>Java class for FuGE.Common.IdentifiableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.IdentifiableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.IdentifiableType")
@XmlSeeAlso({
    MzIdentML.class,
    Database.class,
    BibliographicReference.class,
    Provider.class,
    TranslationTable.class,
    Measure.class,
    SpectrumIdentificationItem.class,
    ProteinAmbiguityGroup.class,
    ParameterizableApplication.class,
    Parameter.class,
    ConceptualMolecule.class,
    ProteinDetectionHypothesis.class,
    Protocol.class,
    Material.class,
    Contact.class,
    MassTable.class,
    PeptideEvidence.class,
    Data.class,
    Action.class,
    Software.class,
    SpectrumIdentificationResult.class,
    ProtocolApplication.class,
    Equipment.class
})
public abstract class Identifiable implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(required = true)
    protected String id;
    @XmlAttribute
    protected String name;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
