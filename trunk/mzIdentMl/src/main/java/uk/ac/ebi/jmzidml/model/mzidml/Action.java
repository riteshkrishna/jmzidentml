package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * An Action is one step of a Protocol. Sets of ordered Actions define the Protocol. Action is abstract and can be extended to specify particular types of steps within a subclass of Protocol.
 * <p/>
 * <p>Java class for FuGE.Common.Protocol.ActionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.ActionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *       &lt;attribute name="actionOrdinal" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.ActionType")
@XmlSeeAlso({
        GenericAction.class
})
public abstract class Action
        extends Identifiable
        implements Serializable {

    private final static long serialVersionUID = 100L;
    @XmlAttribute
    protected Integer actionOrdinal;

    /**
     * Gets the value of the actionOrdinal property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getActionOrdinal() {
        return actionOrdinal;
    }

    /**
     * Sets the value of the actionOrdinal property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setActionOrdinal(Integer value) {
        this.actionOrdinal = value;
    }

}
