package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * TODO marshalling/ persistor add validation to check for case where someone gets spectrumIdentificationItem and changes its id without updating ref id in
 *      SpectrumIdentificationItemRef and other such clases.
 *
 * NOTE: There is no setter method for the spectrumIdentificationItemRef. This simplifies keeping the spectrumIdentificationItem object reference and
 * spectrumIdentificationItemRef synchronized.
 *
 * <p>Java class for SpectrumIdentificationItemRefType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SpectrumIdentificationItemRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="SpectrumIdentificationItem_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectrumIdentificationItemRefType")
public class SpectrumIdentificationItemRef
        extends MzIdentMLObject
        implements Serializable {

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "spectrumIdentificationItem_ref", required = true)
    protected String spectrumIdentificationItemRef;
    @XmlTransient
    protected SpectrumIdentificationItem spectrumIdentificationItem;

    public SpectrumIdentificationItem getSpectrumIdentificationItem() {
        return spectrumIdentificationItem;
    }

    public void setSpectrumIdentificationItem(SpectrumIdentificationItem spectrumIdentificationItem) {
        if (spectrumIdentificationItem == null) {
            this.spectrumIdentificationItemRef = null;
        } else {
            String refId = spectrumIdentificationItem.getId();
            if (refId == null) throw new IllegalArgumentException("Referenced object does not have an identifier.");
            this.spectrumIdentificationItemRef = refId;
        }
        this.spectrumIdentificationItem = spectrumIdentificationItem;
    }

    /**
     * Gets the value of the spectrumIdentificationItemRef property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSpectrumIdentificationItemRef() {
        return spectrumIdentificationItemRef;
    }
}
