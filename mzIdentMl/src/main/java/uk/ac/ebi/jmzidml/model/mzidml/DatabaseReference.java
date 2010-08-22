
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * A reference to a record in a database.
 * 
 * <p>Java class for FuGE.Common.References.DatabaseReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Common.References.DatabaseReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="accession" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="accessionVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Database_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Common.References.DatabaseReferenceType")
public class DatabaseReference
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(required = true)
    protected String accession;
    @XmlAttribute
    protected String accessionVersion;
    @XmlAttribute(name = "Database_ref", required = true)
    protected String databaseRef;

    /**
     * Gets the value of the accession property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccession() {
        return accession;
    }

    /**
     * Sets the value of the accession property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccession(String value) {
        this.accession = value;
    }

    /**
     * Gets the value of the accessionVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessionVersion() {
        return accessionVersion;
    }

    /**
     * Sets the value of the accessionVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessionVersion(String value) {
        this.accessionVersion = value;
    }

    /**
     * Gets the value of the databaseRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseRef() {
        return databaseRef;
    }

    /**
     * Sets the value of the databaseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseRef(String value) {
        this.databaseRef = value;
    }

}
