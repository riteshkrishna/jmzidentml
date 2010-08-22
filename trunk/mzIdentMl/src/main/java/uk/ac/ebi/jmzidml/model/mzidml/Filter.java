
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * <p>Java class for FilterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FilterType" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamType"/>
 *         &lt;element name="Include" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamListType" minOccurs="0"/>
 *         &lt;element name="Exclude" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterType", propOrder = {
    "filterType",
    "include",
    "exclude"
})
public class Filter
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "FilterType", required = true)
    protected ParamAlternative filterType;
    @XmlElement(name = "Include")
    protected ParamAlternativeList include;
    @XmlElement(name = "Exclude")
    protected ParamAlternativeList exclude;

    /**
     * Gets the value of the filterType property.
     * 
     * @return
     *     possible object is
     *     {@link ParamAlternative }
     *     
     */
    public ParamAlternative getFilterType() {
        return filterType;
    }

    /**
     * Sets the value of the filterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternative }
     *     
     */
    public void setFilterType(ParamAlternative value) {
        this.filterType = value;
    }

    /**
     * Gets the value of the include property.
     * 
     * @return
     *     possible object is
     *     {@link ParamAlternativeList }
     *     
     */
    public ParamAlternativeList getInclude() {
        return include;
    }

    /**
     * Sets the value of the include property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternativeList }
     *     
     */
    public void setInclude(ParamAlternativeList value) {
        this.include = value;
    }

    /**
     * Gets the value of the exclude property.
     * 
     * @return
     *     possible object is
     *     {@link ParamAlternativeList }
     *     
     */
    public ParamAlternativeList getExclude() {
        return exclude;
    }

    /**
     * Sets the value of the exclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternativeList }
     *     
     */
    public void setExclude(ParamAlternativeList value) {
        this.exclude = value;
    }

}
