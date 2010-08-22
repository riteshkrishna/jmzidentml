
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A description of the sample analysed by mass spectrometry using CVParams or UserParams.
 *                 If a composite sample has been analysed, a parent sample should be defined, which references subsamples.
 *             
 * 
 * <p>Java class for SampleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SampleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Material.MaterialType">
 *       &lt;sequence>
 *         &lt;element name="subSample" type="{http://psidev.info/psi/pi/mzIdentML/1.0}subSampleType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SampleType", propOrder = {
    "subSample"
})
public class Sample
    extends Material
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    protected List<SubSample> subSample;

    /**
     * Gets the value of the subSample property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subSample property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubSample().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubSample }
     * 
     * 
     */
    public List<SubSample> getSubSample() {
        if (subSample == null) {
            subSample = new ArrayList<SubSample>();
        }
        return this.subSample;
    }

}
