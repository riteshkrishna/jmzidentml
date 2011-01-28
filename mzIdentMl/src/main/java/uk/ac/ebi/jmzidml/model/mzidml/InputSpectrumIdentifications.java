
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for InputSpectrumIdentificationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputSpectrumIdentificationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="SpectrumIdentificationList_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputSpectrumIdentificationsType")
public class InputSpectrumIdentifications
    implements Serializable, MzIdentMLObject
{
    @XmlTransient
    private Long hid;

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "SpectrumIdentificationList_ref", required = true)
    protected String spectrumIdentificationListRef;

    @XmlTransient
    private SpectrumIdentificationList spectrumIdentificationList;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public SpectrumIdentificationList getSpectrumIdentificationList() {
        return spectrumIdentificationList;
    }

    public void setSpectrumIdentificationList(SpectrumIdentificationList spectrumIdentificationList) {
        this.spectrumIdentificationList = spectrumIdentificationList;
        if (spectrumIdentificationList != null) {
            this.spectrumIdentificationListRef = spectrumIdentificationList.getId();
        }
    }

    /**
     * Gets the value of the spectrumIdentificationListRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpectrumIdentificationListRef() {
        return spectrumIdentificationListRef;
    }

    /**
     * Sets the value of the spectrumIdentificationListRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectrumIdentificationListRef(String value) {
        this.spectrumIdentificationListRef = value;
        if ( spectrumIdentificationList != null && !spectrumIdentificationList.getId().equals(value) ) {
            spectrumIdentificationList = null;
        }
    }

}
