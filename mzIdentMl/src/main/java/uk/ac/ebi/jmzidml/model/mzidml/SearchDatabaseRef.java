
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 *  TODO marshalling/ persistor add validation to check for case where someone gets searchDatabase and changes its id without updating ref id in
 *      SearchDatabase and other such clases.
 *
 * NOTE: There is no setter method for the searchDatabaseRef. This simplifies keeping the searchDatabase object reference and
 * searchDatabaseRef synchronized.
 *
 * <p>Java class for SearchDatabaseRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchDatabaseRefType">
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
@XmlType(name = "SearchDatabaseRefType")
public class SearchDatabaseRef
    extends MzIdentMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "searchDatabase_ref")
    protected String searchDatabaseRef;
    @XmlTransient
    protected AnalysisSearchDatabase searchDatabase;

    public AnalysisSearchDatabase getSearchDatabase() {
        return searchDatabase;
    }

    public void setSearchDatabase(AnalysisSearchDatabase searchDatabase) {
        if (searchDatabase == null) {
            this.searchDatabaseRef= null;
        } else {
            String refId = searchDatabase.getId();
            if (refId == null) throw new IllegalArgumentException("Referenced object does not have an identifier.");
            this.searchDatabaseRef = refId;
        }
        this.searchDatabase = searchDatabase;
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

}
