
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.xml.jaxb.adapters.SpectraDataAdapter;


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

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "SpectraData_ref")
    @XmlJavaTypeAdapter(SpectraDataAdapter.class)
    protected SpectraData spectraData;

    /**
     * Gets the value of the spectraData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public SpectraData getSpectraData() {
        return spectraData;
    }

    /**
     * Sets the value of the spectraData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectraData(SpectraData value) {
        this.spectraData = value;
    }

}
