
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * A Protocol is a parameterizable description of a method. ProtocolApplication is used to
 *                 specify the ParameterValues of its Protocol's Parameters. Protocol should be extended in data formats.
 *                 For cases where no extension is developed, the subclass of Protocol, GenericProtocol, should be used to
 *                 capture experimental protocols.
 *             
 * 
 * <p>Java class for FuGE.Common.Protocol.ProtocolType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.ProtocolType">
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
@XmlType(name = "FuGE.Common.Protocol.ProtocolType")
@XmlSeeAlso({
    SpectrumIdentificationProtocol.class,
    ProteinDetectionProtocol.class
})
public abstract class Protocol
    extends Identifiable
    implements Serializable
{

    private final static long serialVersionUID = 100L;

}
