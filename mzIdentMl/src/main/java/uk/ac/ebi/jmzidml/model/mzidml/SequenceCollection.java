package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * <p>Java class for SequenceCollectionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SequenceCollectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DBSequence" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.analysis.search.DBSequenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Peptide" type="{http://psidev.info/psi/pi/mzIdentML/1.0}PSI-PI.polypeptide.PeptideType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceCollectionType", propOrder = {
        "dBSequence",
        "peptide"
})
public class SequenceCollection
        implements Serializable, MzIdentMLObject {

    @XmlTransient
    private Long hid;

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "DBSequence")
    protected List<DBSequence> dBSequence;
    @XmlElement(name = "Peptide")
    protected List<Peptide> peptide;

    /**
     * Gets the value of the dBSequence property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dBSequence property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDBSequence().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link DBSequence }
     */
    public List<DBSequence> getDBSequence() {
        if (dBSequence == null) {
            dBSequence = new ArrayList<DBSequence>();
        }
        return this.dBSequence;
    }

    /**
     * Gets the value of the peptide property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peptide property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeptide().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Peptide }
     */
    public List<Peptide> getPeptide() {
        if (peptide == null) {
            peptide = new ArrayList<Peptide>();
        }
        return this.peptide;
    }

}
