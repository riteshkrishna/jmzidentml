
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Data can be an input to or an output from a ProtocolApplication. Data may be produced
 *                 from a Material (data acquisition) or from another Data object (data transformation). Examples of Data
 *                 are gene expression measurements, or phenotypes associated with genetic manipulations.
 *             
 * 
 * <p>Java class for FuGE.Bio.Data.DataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Bio.Data.DataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Bio.Data.DataType")
@XmlSeeAlso({
    ExternalData.class,
    InternalData.class
})
public abstract class Data
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;

}
