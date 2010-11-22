
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * An Analysis which tries to identify peptides in input spectra, referencing the database
 *                 searched, the input spectra, the output results and the protocol that is run.
 *             
 * 
 * <p>Java class for PSI-PI.analysis.search.SpectrumIdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PSI-PI.analysis.search.SpectrumIdentificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ProtocolApplicationType">
 *       &lt;sequence>
 *         &lt;element name="InputSpectra" type="{http://psidev.info/psi/pi/mzIdentML/1.0}InputSpectraType" maxOccurs="unbounded"/>
 *         &lt;element name="SearchDatabase" type="{http://psidev.info/psi/pi/mzIdentML/1.0}SearchDatabaseType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SpectrumIdentificationProtocol_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SpectrumIdentificationList_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PSI-PI.analysis.search.SpectrumIdentificationType", propOrder = {
    "inputSpectra",
    "searchDatabase"
})
public class SpectrumIdentification
    extends ProtocolApplication
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "InputSpectra", required = true)
    protected List<InputSpectra> inputSpectra;
    @XmlElement(name = "SearchDatabase", required = true)
    protected List<SearchDatabase> searchDatabase;
    @XmlAttribute(name = "SpectrumIdentificationProtocol_ref", required = true)
    protected String spectrumIdentificationProtocolRef;
    @XmlAttribute(name = "SpectrumIdentificationList_ref", required = true)
    protected String spectrumIdentificationListRef;

    @XmlTransient
    private SpectrumIdentificationList spectrumIdentificationList;
    @XmlTransient
    private SpectrumIdentificationProtocol spectrumIdentificationProtocol;

    public SpectrumIdentificationList getSpectrumIdentificationList() {
        return spectrumIdentificationList;
    }

    public void setSpectrumIdentificationList(SpectrumIdentificationList spectrumIdentificationList) {
        this.spectrumIdentificationList = spectrumIdentificationList;
        if (spectrumIdentificationList != null) {
            this.setSpectrumIdentificationListRef(spectrumIdentificationList.getId());
        }
    }

    public SpectrumIdentificationProtocol getSpectrumIdentificationProtocol() {
        return spectrumIdentificationProtocol;
    }

    public void setSpectrumIdentificationProtocol(SpectrumIdentificationProtocol spectrumIdentificationProtocol) {
        this.spectrumIdentificationProtocol = spectrumIdentificationProtocol;
        if (spectrumIdentificationProtocol != null) {
            this.setSpectrumIdentificationProtocolRef(spectrumIdentificationProtocol.getId());
        }
    }

    /**
     * Gets the value of the inputSpectra property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputSpectra property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputSpectra().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputSpectra }
     * 
     * 
     */
    public List<InputSpectra> getInputSpectra() {
        if (inputSpectra == null) {
            inputSpectra = new ArrayList<InputSpectra>();
        }
        return this.inputSpectra;
    }

    /**
     * Gets the value of the searchDatabase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchDatabase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchDatabase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchDatabase }
     * 
     * 
     */
    public List<SearchDatabase> getSearchDatabase() {
        if (searchDatabase == null) {
            searchDatabase = new ArrayList<SearchDatabase>();
        }
        return this.searchDatabase;
    }

    /**
     * Gets the value of the spectrumIdentificationProtocolRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpectrumIdentificationProtocolRef() {
        return spectrumIdentificationProtocolRef;
    }

    /**
     * Sets the value of the spectrumIdentificationProtocolRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectrumIdentificationProtocolRef(String value) {
        this.spectrumIdentificationProtocolRef = value;
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
    }

}
