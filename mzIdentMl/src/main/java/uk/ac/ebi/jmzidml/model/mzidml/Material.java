
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.AbstractIdentifiableParamGroup;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Material represents any kind of substance used in an experimental workflow, such as whole
 *                 organisms, cells, DNA, solutions, compounds and experimental substances (gels, arrays etc.). The
 *                 Material class can be extended by adding subclasses to model domain specific properties, or the
 *                 relationships to OntologyIndividual can be used to describe the characteristics and type of Material.
 *                 Materials can be related to other materials through a directed acyclic graph (represented by
 *                 ProtocolApplication(s)). Sub-component materials can be represented by the self-association on Material
 *                 (e.g. Wells within a array). These associations are abstract and should be extended to represent these
 *                 semantics for extensions of ProtocolApplication and Material.
 *             
 * 
 * <p>Java class for FuGE.Bio.Material.MaterialType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Bio.Material.MaterialType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;sequence>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ContactRole" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Bio.Material.MaterialType", propOrder = {
    "contactRole",
    "paramGroup"
})
@XmlSeeAlso({
    Sample.class
})
public abstract class Material
    extends AbstractIdentifiableParamGroup
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ContactRole")
    protected List<ContactRole> contactRole;
    @XmlElements({
        @XmlElement(name = "userParam", type = UserParam.class),
        @XmlElement(name = "cvParam", type = CvParam.class)
    })
    protected List<Param> paramGroup;

    /**
     * Contact details for the Material. The association to ContactRole could
     *                                 specify, for example, the creator or provider of the Material.
     *                             Gets the value of the contactRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactRole }
     * 
     * 
     */
    public List<ContactRole> getContactRole() {
        if (contactRole == null) {
            contactRole = new ArrayList<ContactRole>();
        }
        return this.contactRole;
    }

    /**
     * The characteristics of a Material.Gets the value of the paramGroup property.
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
     * {@link UserParam }
     * {@link CvParam }
     * 
     * 
     */
    public List<Param> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<Param>();
        }
        return this.paramGroup;
    }

}
