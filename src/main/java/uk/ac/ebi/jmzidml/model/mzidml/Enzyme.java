
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.ParamListCapable;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The details of an individual cleavage enzyme should be provided by giving a regular expression or a CV term if a "standard" enzyme cleavage has been performed. 
 * 
 * <p>Java class for EnzymeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnzymeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.1}IdentifiableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SiteRegexp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EnzymeName" type="{http://psidev.info/psi/pi/mzIdentML/1.1}ParamListType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nTermGain"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[A-Za-z0-9 ]+"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="cTermGain"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="[A-Za-z0-9 ]+"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="semiSpecific" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="missedCleavages" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="minDistance"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *             &lt;minInclusive value="1"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnzymeType", propOrder = {
    "siteRegexp",
    "enzymeName"
})
public class Enzyme
    extends Identifiable
    implements Serializable, ParamListCapable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "SiteRegexp")
    protected String siteRegexp;
    @XmlElement(name = "EnzymeName")
    protected ParamList enzymeName;
    @XmlAttribute
    protected String nTermGain;
    @XmlAttribute
    protected String cTermGain;
    @XmlAttribute
    protected Boolean semiSpecific;
    @XmlAttribute
    protected Integer missedCleavages;
    @XmlAttribute
    protected Integer minDistance;

    /**
     * Gets the value of the siteRegexp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteRegexp() {
        return siteRegexp;
    }

    /**
     * Sets the value of the siteRegexp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteRegexp(String value) {
        this.siteRegexp = value;
    }

    /**
     * Gets the value of the enzymeName property.
     * 
     * @return
     *     possible object is
     *     {@link ParamList }
     *     
     */
    public ParamList getEnzymeName() {
        return enzymeName;
    }

    /**
     * Sets the value of the enzymeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamList }
     *     
     */
    public void setEnzymeName(ParamList value) {
        this.enzymeName = value;
    }

    /**
     * Gets the value of the nTermGain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNTermGain() {
        return nTermGain;
    }

    /**
     * Sets the value of the nTermGain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNTermGain(String value) {
        this.nTermGain = value;
    }

    /**
     * Gets the value of the cTermGain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTermGain() {
        return cTermGain;
    }

    /**
     * Sets the value of the cTermGain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTermGain(String value) {
        this.cTermGain = value;
    }

    /**
     * Gets the value of the semiSpecific property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSemiSpecific() {
        return semiSpecific;
    }

    /**
     * Sets the value of the semiSpecific property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSemiSpecific(Boolean value) {
        this.semiSpecific = value;
    }

    /**
     * Gets the value of the missedCleavages property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMissedCleavages() {
        return missedCleavages;
    }

    /**
     * Sets the value of the missedCleavages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMissedCleavages(Integer value) {
        this.missedCleavages = value;
    }

    /**
     * Gets the value of the minDistance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinDistance() {
        return minDistance;
    }

    /**
     * Sets the value of the minDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinDistance(Integer value) {
        this.minDistance = value;
    }

}
