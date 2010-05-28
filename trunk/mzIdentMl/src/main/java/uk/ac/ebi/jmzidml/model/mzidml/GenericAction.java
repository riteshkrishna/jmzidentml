package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A GenericAction represents a step within a GenericProtocol. It allows a reference to a sub-GenericProtocol, user entered text to describe the GenericAction or a term from a controlled vocabulary to be given.
 * <p/>
 * <p>Java class for FuGE.Common.Protocol.GenericActionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="FuGE.Common.Protocol.GenericActionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.Protocol.ActionType">
 *       &lt;sequence>
 *         &lt;element name="actionTerm" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}cvParam"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}GenericParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}ParameterPair" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="actionText" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Protocol_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.Protocol.GenericActionType", propOrder = {
        "actionTerm",
        "genericParameter",
        "parameterPair"
})
public class GenericAction
        extends Action
        implements Serializable {

    private final static long serialVersionUID = 100L;
    protected GenericAction.ActionTerm actionTerm;
    @XmlElement(name = "GenericParameter")
    protected List<GenericParameter> genericParameter;
    @XmlElement(name = "ParameterPair")
    protected List<ParameterPair> parameterPair;
    @XmlAttribute
    protected String actionText;
    @XmlAttribute(name = "Protocol_ref")
    protected String protocolRef;

    /**
     * Gets the value of the actionTerm property.
     *
     * @return possible object is
     *         {@link GenericAction.ActionTerm }
     */
    public GenericAction.ActionTerm getActionTerm() {
        return actionTerm;
    }

    /**
     * Sets the value of the actionTerm property.
     *
     * @param value allowed object is
     *              {@link GenericAction.ActionTerm }
     */
    public void setActionTerm(GenericAction.ActionTerm value) {
        this.actionTerm = value;
    }

    /**
     * The parameters belonging to the GenericAction. Gets the value of the genericParameter property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericParameter property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericParameter().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericParameter }
     */
    public List<GenericParameter> getGenericParameter() {
        if (genericParameter == null) {
            genericParameter = new ArrayList<GenericParameter>();
        }
        return this.genericParameter;
    }

    /**
     * ParameterPairs owned by the GenericAction. The TargetParameter should reference a Parameter owned by a child Protocol which is also referenced by the GenericAction. Gets the value of the parameterPair property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterPair property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterPair().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ParameterPair }
     */
    public List<ParameterPair> getParameterPair() {
        if (parameterPair == null) {
            parameterPair = new ArrayList<ParameterPair>();
        }
        return this.parameterPair;
    }

    /**
     * Gets the value of the actionText property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getActionText() {
        return actionText;
    }

    /**
     * Sets the value of the actionText property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setActionText(String value) {
        this.actionText = value;
    }

    /**
     * Gets the value of the protocolRef property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getProtocolRef() {
        return protocolRef;
    }

    /**
     * Sets the value of the protocolRef property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProtocolRef(String value) {
        this.protocolRef = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}cvParam"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "cvParam"
    })
    public static class ActionTerm
            implements Serializable, MzIdentMLObject {

        private final static long serialVersionUID = 100L;
        @XmlElement(required = true)
        protected CvParam cvParam;

        /**
         * Gets the value of the cvParam property.
         *
         * @return possible object is
         *         {@link CvParam }
         */
        public CvParam getCvParam() {
            return cvParam;
        }

        /**
         * Sets the value of the cvParam property.
         *
         * @param value allowed object is
         *              {@link CvParam }
         */
        public void setCvParam(CvParam value) {
            this.cvParam = value;
        }

    }

}
