
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.IdentifiableMzIdentMLObject;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


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
    BibliographicReference.class,
    Provider.class,
    TranslationTable.class,
    ConceptualMolecule.class,
    ProteinDetectionHypothesis.class,
    Protocol.class,
    Measure.class,
    SpectrumIdentificationItem.class,
    Material.class,
    Contact.class,
    MassTable.class,
    ProteinAmbiguityGroup.class,
    PeptideEvidence.class,
    Data.class,
    Software.class,
    SpectrumIdentificationResult.class,
    Equipment.class,
    ProtocolApplication.class
})
public abstract class Identifiable implements Serializable, MzIdentMLObject, IdentifiableMzIdentMLObject
{

    @XmlTransient
    private Long hid;

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

    /**
     * ID for each record
     * @return
     */
    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }


}
