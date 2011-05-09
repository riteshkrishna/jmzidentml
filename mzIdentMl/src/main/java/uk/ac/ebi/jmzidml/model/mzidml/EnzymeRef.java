package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for EnzymeRefType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EnzymeRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="enzyme_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnzymeRefType")
public class EnzymeRef
        extends MzIdentMLObject
        implements Serializable {

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "enzyme_ref")
    protected String enzymeRef;
    @XmlTransient
    protected Enzyme enzyme;

    public Enzyme getEnzyme() {
        return enzyme;
    }

    public void setEnzyme(Enzyme enzyme) {
        if (enzyme == null) {
            this.enzymeRef = null;
        } else {
            String refId = enzyme.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.enzymeRef = refId;
        }
        this.enzyme = enzyme;
    }


    /**
     * Gets the value of the enzymeRef property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEnzymeRef() {
        return enzymeRef;
    }

    /**
     * Sets the value of the enzymeRef property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEnzymeRef(String value) {
        this.enzymeRef = value;
    }

}
