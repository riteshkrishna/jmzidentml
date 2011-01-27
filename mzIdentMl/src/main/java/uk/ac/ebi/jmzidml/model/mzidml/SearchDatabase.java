
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for SearchDatabaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchDatabaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="SearchDatabase_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchDatabaseType")
public class SearchDatabase
    implements Serializable, MzIdentMLObject
{

    @XmlTransient
    private Long hid;

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "SearchDatabase_ref")
    protected String searchDatabaseRef;

    @XmlTransient
    private AnalysisSearchDatabase analysisSearchDatabase;

    /**
     * Getter for hibernate don't use that method
     * @return
     */
    public AnalysisSearchDatabase getAnalysisSearchDatabase() {
        return analysisSearchDatabase;
    }

    public AnalysisSearchDatabase getSearchDatabase() {
        return analysisSearchDatabase;
    }

    public void setSearchDatabase(AnalysisSearchDatabase analysisSearchDatabase) {
        this.analysisSearchDatabase = analysisSearchDatabase;
        if (analysisSearchDatabase != null) {
            this.searchDatabaseRef = analysisSearchDatabase.getId();
        }
    }

    /**
     * Gets the value of the searchDatabaseRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchDatabaseRef() {
        return searchDatabaseRef;
    }

    /**
     * Sets the value of the searchDatabaseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchDatabaseRef(String value) {
        this.searchDatabaseRef = value;
        if ( analysisSearchDatabase != null && !analysisSearchDatabase.getId().equals(value) ) {
            analysisSearchDatabase = null;
        }
    }

    /**
     * Get the value of HID from DB
     *
     * @return
     */

    public Long getHid() {
        return hid;
    }
}
