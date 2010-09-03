
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.xml.jaxb.adapters.ProteinDetectionListAdapter;
import uk.ac.ebi.jmzidml.xml.jaxb.adapters.ProteinDetectionProtocolAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * An Analysis which assembles a set of peptides (e.g. from a spectra search analysis) to
 *                 proteins.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.process.ProteinDetectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.process.ProteinDetectionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ProtocolApplicationType">
 *       &lt;sequence>
 *         &lt;element name="InputSpectrumIdentifications" type="{http://psidev.info/psi/pi/mzIdentML/1.0}InputSpectrumIdentificationsType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProteinDetectionList_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProteinDetectionProtocol_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.process.ProteinDetectionType", propOrder = {
    "inputSpectrumIdentifications"
})
public class ProteinDetection
    extends ProtocolApplication
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "InputSpectrumIdentifications", required = true)
    protected List<InputSpectrumIdentifications> inputSpectrumIdentifications;
    @XmlAttribute(name = "ProteinDetectionList_ref", required = true)
    @XmlJavaTypeAdapter(ProteinDetectionListAdapter.class)
    protected ProteinDetectionList proteinDetectionList;
    @XmlAttribute(name = "ProteinDetectionProtocol_ref", required = true)
    @XmlJavaTypeAdapter(ProteinDetectionProtocolAdapter.class)
    protected ProteinDetectionProtocol proteinDetectionProtocol;

    /**
     * Gets the value of the inputSpectrumIdentifications property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputSpectrumIdentifications property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputSpectrumIdentifications().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputSpectrumIdentifications }
     * 
     * 
     */
    public List<InputSpectrumIdentifications> getInputSpectrumIdentifications() {
        if (inputSpectrumIdentifications == null) {
            inputSpectrumIdentifications = new ArrayList<InputSpectrumIdentifications>();
        }
        return this.inputSpectrumIdentifications;
    }

    /**
     * Gets the value of the proteinDetectionListRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ProteinDetectionList getProteinDetectionList() {
        return proteinDetectionList;
    }

    /**
     * Sets the value of the proteinDetectionListRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProteinDetectionList(ProteinDetectionList value) {
        this.proteinDetectionList = value;
    }

    /**
     * Gets the value of the proteinDetectionProtocolRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ProteinDetectionProtocol getProteinDetectionProtocol() {
        return proteinDetectionProtocol;
    }

    /**
     * Sets the value of the proteinDetectionProtocolRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProteinDetectionProtocol(ProteinDetectionProtocol value) {
        this.proteinDetectionProtocol = value;
    }

}
