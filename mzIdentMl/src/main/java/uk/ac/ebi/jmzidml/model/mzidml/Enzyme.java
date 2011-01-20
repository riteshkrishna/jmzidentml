
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * The details of an individual cleavage enzyme should be provided by giving a regular
 *                 expression or a CV term if a "standard" enzyme cleavage has been performed.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.search.EnzymeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.EnzymeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteRegexp" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.analysis.search.SiteRegexpType" minOccurs="0"/>
 *         &lt;element name="EnzymeName" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamListType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NTermGain">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[A-Za-z0-9 ]+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CTermGain">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[A-Za-z0-9 ]+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="semiSpecific" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="missedCleavages" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="minDistance">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.EnzymeType", propOrder = {
    "siteRegexp",
    "enzymeName"
})
public class Enzyme
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "SiteRegexp")
    protected String siteRegexp;
    @XmlElement(name = "EnzymeName")
    protected ParamAlternativeList enzymeName;
    @XmlAttribute(required = true)
    protected String id;
    @XmlAttribute(name = "NTermGain")
    protected String nTermGain;
    @XmlAttribute(name = "CTermGain")
    protected String cTermGain;
    @XmlAttribute
    protected Boolean semiSpecific;
    @XmlAttribute
    protected Integer missedCleavages;
    @XmlAttribute
    protected Integer minDistance;

    @XmlTransient
    protected Long hid;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

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
     *     {@link ParamAlternativeList }
     *     
     */
    public ParamAlternativeList getEnzymeName() {
        return enzymeName;
    }

    /**
     * Sets the value of the enzymeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternativeList }
     *     
     */
    public void setEnzymeName(ParamAlternativeList value) {
        this.enzymeName = value;
    }

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
     * Gets the value of the semiSpecific property. Hibernate hbm files dont seem to recognise isSemiSpecific
     * so this method was added.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getSemiSpecific() {
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
