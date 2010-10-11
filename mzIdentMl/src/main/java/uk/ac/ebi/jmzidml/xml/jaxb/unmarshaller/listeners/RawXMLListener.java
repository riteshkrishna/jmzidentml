package uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.listeners;

import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;

import javax.xml.bind.Unmarshaller;

/**
 * Listener to handle class specific pre/post processing steps during unmarshalling.
 *
 * @author Florian Reisinger
 *         Date: 21-Sep-2010
 * @since 0.1
 */
public class RawXMLListener extends Unmarshaller.Listener {

    private static final Logger log = Logger.getLogger(RawXMLListener.class);

    private AdapterObjectCache cache;

    public RawXMLListener(AdapterObjectCache cache) {
        this.cache = cache;
    }

    @Override
    public void afterUnmarshal(Object target, Object parent) {
        log.debug("  unmarshalled: " + target.getClass());

        if (target instanceof ParamAlternative) {
            log.debug("Calling ParamAlternative specific 'afterUnmarshalOperation'.");
            ((ParamAlternative) target).afterUnmarshalOperation();
        }
        if (target instanceof ParamAlternativeList) {
            log.debug("Calling ParamAlternativeList specific 'afterUnmarshalOperation'.");
            ((ParamAlternativeList) target).afterUnmarshalOperation();
        }
        if (target instanceof Sample) {
            log.debug("Calling Sample specific 'afterUnmarshalOperation'.");
            ((Sample) target).afterUnmarshalOperation();
        }
        if (target instanceof DBSequence) {
            log.debug("Calling DBSequence specific 'afterUnmarshalOperation'.");
            ((DBSequence) target).afterUnmarshalOperation();
        }
        if (target instanceof ProteinDetectionHypothesis) {
            log.debug("Calling ProteinDetectionHypothesis specific 'afterUnmarshalOperation'.");
            ((ProteinDetectionHypothesis) target).afterUnmarshalOperation();
        }
        if (target instanceof AmbiguousResidue) {
            log.debug("Calling AmbiguousResidue specific 'afterUnmarshalOperation'.");
            ((AmbiguousResidue) target).afterUnmarshalOperation();
        }
        if (target instanceof MassTable) {
            log.debug("Calling MassTable specific 'afterUnmarshalOperation'.");
            ((MassTable) target).afterUnmarshalOperation();
        }
        if (target instanceof Modification) {
            log.debug("Calling Modification specific 'afterUnmarshalOperation'.");
            ((Modification) target).afterUnmarshalOperation();
        }
        if (target instanceof Peptide) {
            log.debug("Calling Peptide specific 'afterUnmarshalOperation'.");
            ((Peptide) target).afterUnmarshalOperation();
        }
        if (target instanceof PeptideEvidence) {
            log.debug("Calling PeptideEvidence specific 'afterUnmarshalOperation'.");
            ((PeptideEvidence) target).afterUnmarshalOperation();
        }
        if (target instanceof ProteinAmbiguityGroup) {
            log.debug("Calling ProteinAmbiguityGroup specific 'afterUnmarshalOperation'.");
            ((ProteinAmbiguityGroup) target).afterUnmarshalOperation();
        }
        if (target instanceof ProteinDetectionList) {
            log.debug("Calling ProteinDetectionList specific 'afterUnmarshalOperation'.");
            ((ProteinDetectionList) target).afterUnmarshalOperation();
        }
        if (target instanceof SourceFile) {
            log.debug("Calling SourceFile specific 'afterUnmarshalOperation'.");
            ((SourceFile) target).afterUnmarshalOperation();
        }
        if (target instanceof SpectrumIdentificationItem) {
            log.debug("Calling SpectrumIdentificationItem specific 'afterUnmarshalOperation'.");
            ((SpectrumIdentificationItem) target).afterUnmarshalOperation();
        }
        if (target instanceof SpectrumIdentificationList) {
            log.debug("Calling SpectrumIdentificationList specific 'afterUnmarshalOperation'.");
            ((SpectrumIdentificationList) target).afterUnmarshalOperation();
        }
        if (target instanceof SpectrumIdentificationResult) {
            log.debug("Calling SpectrumIdentificationResult specific 'afterUnmarshalOperation'.");
            ((SpectrumIdentificationResult) target).afterUnmarshalOperation();
        }

        // fix duplication problem for idrefed classes
        if (target instanceof Identifiable) {
                updateCacheForIDREFedObject(target, ((Identifiable) target).getId());
        }
    }

    /**
     *
     * Puts a newly created object (identified by an IDREF) into the global object cache and
     * - returns a reference to this object if the IDREF has not been cached before OR
     * - returns a reference to a previously cached version for this IDREF
     *
     * @param newInstance   the object instance being cached (required)
     * @param refId         an IDREF from an MzML XML document (required)
     */
    private Object updateCacheForIDREFedObject (Object newInstance, String refId) {

        Object retval = newInstance;

        // cache hit -> use the instance that is already cached, ignore newly created instance.
        if (cache.getCachedObject(refId, newInstance.getClass()) != null) {
            retval = cache.getCachedObject(refId, newInstance.getClass());

        // cache miss -> put newly created instance in the cache
        } else {
            cache.putInCache(refId, (MzIdentMLObject) newInstance);
        }

        return retval;
    }

}