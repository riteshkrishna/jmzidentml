
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * Data external to the XML instance document. The location of the data file is given in the
 *                 location attribute.
 *             
 * 
 * <p>Java class for FuGE.Bio.Data.ExternalDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuGE.Bio.Data.ExternalDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Data.DataType">
 *       &lt;sequence>
 *         &lt;element name="externalFormatDocumentation" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="fileFormat" type="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Bio.Data.FileFormatType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="location" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Bio.Data.ExternalDataType", propOrder = {
    "externalFormatDocumentation",
    "fileFormat"
})
@XmlSeeAlso({
    SourceFile.class,
    AnalysisSearchDatabase.class,
    SpectraData.class
})
public class ExternalData
    extends Data
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlSchemaType(name = "anyURI")
    protected String externalFormatDocumentation;
    protected FileFormat fileFormat;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String location;

    /**
     * Gets the value of the externalFormatDocumentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalFormatDocumentation() {
        return externalFormatDocumentation;
    }

    /**
     * Sets the value of the externalFormatDocumentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalFormatDocumentation(String value) {
        this.externalFormatDocumentation = value;
    }

    /**
     * Gets the value of the fileFormat property.
     * 
     * @return
     *     possible object is
     *     {@link FileFormat }
     *     
     */
    public FileFormat getFileFormat() {
        return fileFormat;
    }

    /**
     * Sets the value of the fileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileFormat }
     *     
     */
    public void setFileFormat(FileFormat value) {
        this.fileFormat = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

}
