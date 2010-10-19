package uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.listeners;

import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.model.mzidml.params.*;
import uk.ac.ebi.jmzidml.model.utils.ParamUpdater;
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

        // splitting of Param into CvParam/UserParam AND sub-classing
        // (due to possible exceptions while sub-classing in try/catch)
        try {
            if (target instanceof AmbiguousResidue) {
                log.debug("processing AmbiguousResidue in 'afterUnmarshal'.");
                AmbiguousResidue tmp = (AmbiguousResidue) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), AmbiguousResidueCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), AmbiguousResidueUserParam.class);
            }
            if (target instanceof AnalysisSearchDatabase) {
                log.debug("processing AnalysisSearchDatabase in 'afterUnmarshal'.");
                AnalysisSearchDatabase tmp = (AnalysisSearchDatabase) target;
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), AnalysisSearchDatabaseCvParam.class);
            }
            if (target instanceof DBSequence) {
                log.debug("processing DBSequence in 'afterUnmarshal'.");
                DBSequence tmp = (DBSequence) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), DBSequenceCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), DBSequenceUserParam.class);
            }
            if (target instanceof FileFormat) {
                log.debug("processing FileFormat in 'afterUnmarshal'.");
                FileFormat tmp = (FileFormat) target;
                // replace CvParam with sub-classes CvParam
                tmp.setCvParam(ParamUpdater.updateCvParamSubclass(tmp.getCvParam(), FileFormatCvParam.class));
            }
            if (target instanceof IonType) {
                log.debug("processing IonType in 'afterUnmarshal'.");
                IonType tmp = (IonType) target;
                // replace CvParam with sub-classes CvParam
                tmp.setCvParam(ParamUpdater.updateCvParamSubclass(tmp.getCvParam(), IonTypeCvParam.class));
            }
            if (target instanceof MassTable) {
                log.debug("processing MassTable in 'afterUnmarshal'.");
                MassTable tmp = (MassTable) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), MassTableCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), MassTableUserParam.class);
            }
            if (target instanceof Measure) {
                log.debug("processing Measure in 'afterUnmarshal'.");
                Measure tmp = (Measure) target;
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), MeasureCvParam.class);
            }
            if (target instanceof Modification) {
                log.debug("processing Modification in 'afterUnmarshal'.");
                Modification tmp = (Modification) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), ModificationCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), ModificationUserParam.class);
            }
            if (target instanceof ModParam) {
                log.debug("processing ModParam in 'afterUnmarshal'.");
                ModParam tmp = (ModParam) target;
                // now update with the corresponding sub-classes
                tmp.setCvParam(ParamUpdater.updateCvParamSubclass(tmp.getCvParam(), ModParamCvParam.class));
            }
            if (target instanceof Peptide) {
                log.debug("processing Peptide in 'afterUnmarshal'.");
                Peptide tmp = (Peptide) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), PeptideCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), PeptideUserParam.class);
            }
            if (target instanceof PeptideEvidence) {
                log.debug("processing PeptideEvidence in 'afterUnmarshal'.");
                PeptideEvidence tmp = (PeptideEvidence) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), PeptideEvidenceCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), PeptideEvidenceUserParam.class);
            }
            if (target instanceof ProteinAmbiguityGroup) {
                log.debug("processing ProteinAmbiguityGroup in 'afterUnmarshal'.");
                ProteinAmbiguityGroup tmp = (ProteinAmbiguityGroup) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), ProteinAmbiguityGroupCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), ProteinAmbiguityGroupUserParam.class);
            }
            if (target instanceof ProteinDetectionHypothesis) {
                log.debug("processing ProteinDetectionHypothesis in 'afterUnmarshal'.");
                ProteinDetectionHypothesis tmp = (ProteinDetectionHypothesis) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), ProteinDetectionHypothesisCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), ProteinDetectionHypothesisUserParam.class);
            }
            if (target instanceof ProteinDetectionList) {
                log.debug("processing ProteinDetectionList in 'afterUnmarshal'.");
                ProteinDetectionList tmp = (ProteinDetectionList) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), ProteinDetectionListCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), ProteinDetectionListUserParam.class);
            }
            if (target instanceof Role) {
                log.debug("processing Role in 'afterUnmarshal'.");
                Role tmp = (Role) target;
                // now update with the corresponding sub-classes
                tmp.setCvParam(ParamUpdater.updateCvParamSubclass(tmp.getCvParam(), RoleCvParam.class));
            }
            if (target instanceof Sample) {
                log.debug("processing Sample in 'afterUnmarshal'.");
                Sample tmp = (Sample) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), SampleCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), SampleUserParam.class);
            }
            if (target instanceof SourceFile) {
                log.debug("processing SourceFile in 'afterUnmarshal'.");
                SourceFile tmp = (SourceFile) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), SourceFileCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), SourceFileUserParam.class);
            }
            if (target instanceof SpecificityRules) {
                log.debug("processing SpecificityRules in 'afterUnmarshal'.");
                SpecificityRules tmp = (SpecificityRules) target;
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), SpecificityRulesCvParam.class);
            }
            if (target instanceof SpectrumIdentificationItem) {
                log.debug("processing SpectrumIdentificationItem in 'afterUnmarshal'.");
                SpectrumIdentificationItem tmp = (SpectrumIdentificationItem) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), SpectrumIdentificationItemCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), SpectrumIdentificationItemUserParam.class);
            }
            if (target instanceof SpectrumIdentificationList) {
                log.debug("processing SpectrumIdentificationList in 'afterUnmarshal'.");
                SpectrumIdentificationList tmp = (SpectrumIdentificationList) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), SpectrumIdentificationListCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), SpectrumIdentificationListUserParam.class);
            }
            if (target instanceof SpectrumIdentificationResult) {
                log.debug("processing SpectrumIdentificationResult in 'afterUnmarshal'.");
                SpectrumIdentificationResult tmp = (SpectrumIdentificationResult) target;
                // split params into CvParams and UserParams
                tmp.afterUnmarshalOperation();
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), SpectrumIdentificationResultCvParam.class);
                ParamUpdater.updateUserParamSubclassesList(tmp.getUserParam(), SpectrumIdentificationResultUserParam.class);
            }
            if (target instanceof Tolerance) {
                log.debug("processing Tolerance in 'afterUnmarshal'.");
                Tolerance tmp = (Tolerance) target;
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), ToleranceCvParam.class);
            }
            if (target instanceof TranslationTable) {
                log.debug("processing TranslationTable in 'afterUnmarshal'.");
                TranslationTable tmp = (TranslationTable) target;
                // now update with the corresponding sub-classes
                ParamUpdater.updateCvParamSubclassesList(tmp.getCvParam(), TranslationTableCvParam.class);
            }
        } catch (Exception e) {
            log.error("Exception during post unmarshall processing! ", e);
            throw new IllegalStateException("Error during post unmarshall processing!", e);
        }

        // stuff that does not need to be sub-classed
        // ToDo: check use of those!
        // ToDo: these are not sub-classed!! (since we would have to go from the parent class down.
        if (target instanceof ParamAlternative) {
            log.debug("processing ParamAlternative in 'afterUnmarshal'.");
            ((ParamAlternative) target).afterUnmarshalOperation();
        }
        if (target instanceof ParamAlternativeList) {
            log.debug("processing ParamAlternativeList  'afterUnmarshal'.");
            ((ParamAlternativeList) target).afterUnmarshalOperation();
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
     * @return the Object contained in the cache for the specified refId.
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