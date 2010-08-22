
package uk.ac.ebi.jmzidml.model.mzidml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;


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
 *         &lt;element name="fileFormat" minOccurs="0">
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
    SpectraData.class,
    SourceFile.class,
    AnalysisSearchDatabase.class
})
public class ExternalData
    extends Data
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlSchemaType(name = "anyURI")
    protected String externalFormatDocumentation;
    protected ExternalData.FileFormat fileFormat;
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
     *     {@link ExternalData.FileFormat }
     *     
     */
    public ExternalData.FileFormat getFileFormat() {
        return fileFormat;
    }

    /**
     * Sets the value of the fileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalData.FileFormat }
     *     
     */
    public void setFileFormat(ExternalData.FileFormat value) {
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
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
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cvParam"
    })
    public static class FileFormat
        implements Serializable, MzIdentMLObject
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(required = true)
        protected CvParam cvParam;

        /**
         * Gets the value of the cvParam property.
         * 
         * @return
         *     possible object is
         *     {@link CvParam }
         *     
         */
        public CvParam getCvParam() {
            return cvParam;
        }

        /**
         * Sets the value of the cvParam property.
         * 
         * @param value
         *     allowed object is
         *     {@link CvParam }
         *     
         */
        public void setCvParam(CvParam value) {
            this.cvParam = value;
        }

    }

}
