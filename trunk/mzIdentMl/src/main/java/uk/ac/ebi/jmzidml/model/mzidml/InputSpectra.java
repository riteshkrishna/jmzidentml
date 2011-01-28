
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * The attribute referencing an identifier within the SpectraData section.
 *             
 * 
 * <p>Java class for InputSpectraType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputSpectraType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="SpectraData_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputSpectraType")
public class InputSpectra
    implements Serializable, MzIdentMLObject
{
    @XmlTransient
    private Long hid;

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "SpectraData_ref")
    protected String spectraDataRef;

    @XmlTransient
    private SpectraData spectraData;

    public Long getHid() {
        return hid;
    }

    public SpectraData getSpectraData() {
        return spectraData;
    }

    public void setSpectraData(SpectraData spectraData) {
        this.spectraData = spectraData;
        if (spectraData != null) {
            this.spectraDataRef = spectraData.getId();
        }
    }

    /**
     * Gets the value of the spectraDataRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpectraDataRef() {
        return spectraDataRef;
    }

    /**
     * Sets the value of the spectraDataRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectraDataRef(String value) {
        this.spectraDataRef = value;
        if ( spectraData != null && !spectraData.getId().equals(value) ) {
            spectraData = null;
        }
    }

}
