
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


/**
 * The collection of objects that allow external references.
 * 
 * <p>Java class for FuGE.Collection.ReferenceableCollectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Collection.ReferenceableCollectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}BibliographicReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://psidev.info/psi/pi/mzIdentML/1.0}Database" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Collection.ReferenceableCollectionType", propOrder = {
    "bibliographicReference",
    "database"
})
public class ReferenceableCollection
    implements Serializable, MzIdentMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "BibliographicReference")
    protected List<BibliographicReference> bibliographicReference;
    @XmlElement(name = "Database")
    protected List<Database> database;

    /**
     * Reference to the complete set of BibliographicReference objects in the FuGE
     *                         document.
     *                     Gets the value of the bibliographicReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bibliographicReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBibliographicReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BibliographicReference }
     * 
     * 
     */
    public List<BibliographicReference> getBibliographicReference() {
        if (bibliographicReference == null) {
            bibliographicReference = new ArrayList<BibliographicReference>();
        }
        return this.bibliographicReference;
    }

    /**
     * Reference to the complete set of Database objects in the FuGE document.
     *                     Gets the value of the database property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the database property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatabase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Database }
     * 
     * 
     */
    public List<Database> getDatabase() {
        if (database == null) {
            database = new ArrayList<Database>();
        }
        return this.database;
    }

}
