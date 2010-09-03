
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.xml.jaxb.adapters.SpectraDataAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * All identifications made from searching one spectrum. For PMF data, all peptide
 *                 identifications will be listed underneath as SpectrumIdentificationItems. For MS/MS data, there will be
 *                 ranked SpectrumIdentificationItems corresponding to possible different peptide IDs.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.search.SpectrumIdentificationResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.SpectrumIdentificationResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element name="SpectrumIdentificationItem" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.analysis.search.SpectrumIdentificationItemType" maxOccurs="unbounded"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="spectrumID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SpectraData_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.SpectrumIdentificationResultType", propOrder = {
    "spectrumIdentificationItem",
    "paramGroup"
})
public class SpectrumIdentificationResult
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "SpectrumIdentificationItem", required = true)
    protected List<SpectrumIdentificationItem> spectrumIdentificationItem;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<Param> paramGroup;
    @XmlAttribute(required = true)
    protected String spectrumID;
    @XmlAttribute(name = "SpectraData_ref", required = true)
    @XmlJavaTypeAdapter(SpectraDataAdapter.class)
    protected SpectraData spectraData;

    /**
     * Gets the value of the spectrumIdentificationItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spectrumIdentificationItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpectrumIdentificationItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpectrumIdentificationItem }
     * 
     * 
     */
    public List<SpectrumIdentificationItem> getSpectrumIdentificationItem() {
        if (spectrumIdentificationItem == null) {
            spectrumIdentificationItem = new ArrayList<SpectrumIdentificationItem>();
        }
        return this.spectrumIdentificationItem;
    }

    /**
     * Gets the value of the paramGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paramGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParamGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CvParam }
     * {@link UserParam }
     * 
     * 
     */
    public List<Param> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<Param>();
        }
        return this.paramGroup;
    }

    /**
     * Gets the value of the spectrumID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpectrumID() {
        return spectrumID;
    }

    /**
     * Sets the value of the spectrumID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectrumID(String value) {
        this.spectrumID = value;
    }

    /**
     * Gets the value of the spectraDataRef property.
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
     * Sets the value of the spectraDataRef property.
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
