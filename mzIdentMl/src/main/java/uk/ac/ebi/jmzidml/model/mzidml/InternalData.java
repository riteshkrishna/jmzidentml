
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Data that is internal to an instance XML document. InternalData can be extended with an
 *                 element that defines a particular encoding or data type for the storage array or the subclass
 *                 GenericInternalData should be instantiated. The array will typically use pointer arithmetic to access
 *                 values based on the rank (e.g. number of) Dimensions and their respective sizes (e.g. the number of
 *                 contained DimensionElements).
 *             
 * 
 * <p>Java class for FuGE.Bio.Data.InternalDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Bio.Data.InternalDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Data.DataType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Bio.Data.InternalDataType")
@XmlSeeAlso({
    ProteinDetectionList.class,
    SpectrumIdentificationList.class
})
public abstract class InternalData
    extends Data
    implements Serializable
{

    private final static long serialVersionUID = 100L;

}
