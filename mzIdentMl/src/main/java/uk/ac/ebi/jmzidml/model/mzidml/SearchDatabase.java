
package uk.ac.ebi.jmzidml.model.mzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.xml.jaxb.adapters.AnalysisSearchDatabaseAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "SearchDatabase_ref")
    @XmlJavaTypeAdapter(AnalysisSearchDatabaseAdapter.class)
    protected AnalysisSearchDatabase analysisSearchDatabase;

    /**
     * Gets the value of the analysisSearchDatabase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public AnalysisSearchDatabase getAnalysisSearchDatabase() {
        return analysisSearchDatabase;
    }

    /**
     * Sets the value of the analysisSearchDatabase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalysisSearchDatabase(AnalysisSearchDatabase value) {
        this.analysisSearchDatabase = value;
    }

}
