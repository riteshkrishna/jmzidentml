
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The software used for performing the analyses.
 * 
 * <p>Java class for PSI-PI.analysis.search.AnalysisSoftwareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.AnalysisSoftwareType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.SoftwareType">
 *       &lt;sequence>
 *         &lt;element name="SoftwareName" type="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamType"/>
 *         &lt;element name="Customizations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.AnalysisSoftwareType", propOrder = {
    "softwareName",
    "customizations"
})
public class AnalysisSoftware
    extends Software
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "SoftwareName", required = true)
    protected ParamAlternative softwareName;
    @XmlElement(name = "Customizations")
    protected String customizations;
    @XmlAttribute(name = "URI")
    @XmlSchemaType(name = "anyURI")
    protected String uri;

    /**
     * Gets the value of the softwareName property.
     * 
     * @return
     *     possible object is
     *     {@link ParamAlternative }
     *     
     */
    public ParamAlternative getSoftwareName() {
        return softwareName;
    }

    /**
     * Sets the value of the softwareName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamAlternative }
     *     
     */
    public void setSoftwareName(ParamAlternative value) {
        this.softwareName = value;
    }

    /**
     * Gets the value of the customizations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomizations() {
        return customizations;
    }

    /**
     * Sets the value of the customizations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomizations(String value) {
        this.customizations = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURI(String value) {
        this.uri = value;
    }

}
