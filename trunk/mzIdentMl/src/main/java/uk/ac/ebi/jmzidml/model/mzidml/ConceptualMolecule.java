package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * An abstract class for describing database entries of biological molecules such as DNA and protein sequences, metabolites or lipids etc.
 * <p/>
 * <p>Java class for FuGE.Bio.ConceptualMolecule.ConceptualMoleculeType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="FuGE.Bio.ConceptualMolecule.ConceptualMoleculeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.0}FuGE.Common.IdentifiableType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuGE.Bio.ConceptualMolecule.ConceptualMoleculeType")
@XmlSeeAlso({
        DBSequence.class,
        Peptide.class
})
public abstract class ConceptualMolecule
        extends Identifiable
        implements Serializable {

    private final static long serialVersionUID = 100L;

}
