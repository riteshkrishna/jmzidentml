package uk.ac.ebi.jmzidml.xml.jaxb.marshaller.listeners;

import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.*;

import javax.xml.bind.Marshaller;

/**
 * Listener to handle class specific pre/post processing steps during marshalling.
 * @author Florian Reisinger
 *         Date: 21-Sep-2010
 * @since 0.1
 */
public class ObjectClassListener extends Marshaller.Listener {

    private static final Logger log = Logger.getLogger(ObjectClassListener.class);

    public void beforeMarshal(Object source) {
        log.debug("marshalling: " + source.getClass());
        if(source instanceof ParamAlternative) {
            log.debug("Calling ParamAlternative specific 'beforeMarshalOperation'.");
            ((ParamAlternative)source).beforeMarshalOperation();
        }
        if(source instanceof ParamAlternativeList) {
            log.debug("Calling ParamAlternativeList specific 'beforeMarshalOperation'.");
            ((ParamAlternativeList)source).beforeMarshalOperation();
        }
        if(source instanceof Sample) {
            log.debug("Calling Sample specific 'beforeMarshalOperation'.");
            ((Sample)source).beforeMarshalOperation();
        }
        if (source instanceof DBSequence) {
            log.debug("Calling DBSequence specific 'beforeMarshalOperation'.");
            ((DBSequence) source).beforeMarshalOperation();
        }
        if (source instanceof ProteinDetectionHypothesis) {
            log.debug("Calling ProteinDetectionHypothesis specific 'beforeMarshalOperation'.");
            ((ProteinDetectionHypothesis) source).beforeMarshalOperation();
        }
        if (source instanceof AmbiguousResidue) {
            log.debug("Calling AmbiguousResidue specific 'beforeMarshalOperation'.");
            ((AmbiguousResidue) source).beforeMarshalOperation();
        }
        if (source instanceof MassTable) {
            log.debug("Calling MassTable specific 'beforeMarshalOperation'.");
            ((MassTable) source).beforeMarshalOperation();
        }
        if (source instanceof Modification) {
            log.debug("Calling Modification specific 'beforeMarshalOperation'.");
            ((Modification) source).beforeMarshalOperation();
        }
        if (source instanceof Peptide) {
            log.debug("Calling Peptide specific 'beforeMarshalOperation'.");
            ((Peptide) source).beforeMarshalOperation();
        }
        if (source instanceof PeptideEvidence) {
            log.debug("Calling PeptideEvidence specific 'beforeMarshalOperation'.");
            ((PeptideEvidence) source).beforeMarshalOperation();
        }
        if (source instanceof ProteinAmbiguityGroup) {
            log.debug("Calling ProteinAmbiguityGroup specific 'beforeMarshalOperation'.");
            ((ProteinAmbiguityGroup) source).beforeMarshalOperation();
        }
        if (source instanceof ProteinDetectionList) {
            log.debug("Calling v specific 'beforeMarshalOperation'.");
            ((ProteinDetectionList) source).beforeMarshalOperation();
        }
        if (source instanceof SourceFile) {
            log.debug("Calling SourceFile specific 'beforeMarshalOperation'.");
            ((SourceFile) source).beforeMarshalOperation();
        }
        if (source instanceof SpectrumIdentificationItem) {
            log.debug("Calling SpectrumIdentificationItem specific 'beforeMarshalOperation'.");
            ((SpectrumIdentificationItem) source).beforeMarshalOperation();
        }
        if (source instanceof SpectrumIdentificationList) {
            log.debug("Calling SpectrumIdentificationList specific 'beforeMarshalOperation'.");
            ((SpectrumIdentificationList) source).beforeMarshalOperation();
        }
        if (source instanceof SpectrumIdentificationResult) {
            log.debug("Calling SpectrumIdentificationResult specific 'beforeMarshalOperation'.");
            ((SpectrumIdentificationResult) source).beforeMarshalOperation();
        }
    }

}