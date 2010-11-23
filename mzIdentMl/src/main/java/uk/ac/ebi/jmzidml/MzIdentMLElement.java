package uk.ac.ebi.jmzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.model.mzidml.params.*;
import uk.ac.ebi.jmzidml.xml.jaxb.resolver.*;

@SuppressWarnings("unused")
public enum MzIdentMLElement {

    // ToDo: define and document dependencies between flags/attributes
    // ToDo (for example: a element can not be ID mapped if it is not indexed,
    // ToDo: or an element can not be cached if it is not ID mapped)? 
    // ToDo: implement according consistency checks

    // ToDo: complete xpath for all elements
    // ToDo: update indexed flag for elements that should be indexed
    // ToDo: check which elements should be cached
    // ToDo: check for which elements an id map should be generated

    //                             indexed   xpath                                                                                                                                         cached idMapped class-name                           CvParam-subclass                            UserParam-subclass                        refResolving, reference-resolver   
    Affiliations                    (true,  "/mzIdentML/AuditCollection/Person/affiliations",                                                                                               false, false, Affiliations.class,                   null,                                       null,                                           true,   AffiliationsRefResolver.class),
    AmbiguousResidue                (false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable/AmbiguousResidue",                                              false, false, AmbiguousResidue.class,               AmbiguousResidueCvParam.class,              AmbiguousResidueUserParam.class,                false,  null),
    AnalysisCollection              (true,  "/mzIdentML/AnalysisCollection",                                                                                                                false, false, AnalysisCollection.class,             null,                                       null,                                           false,  null),
    AnalysisData                    (true,  "/mzIdentML/DataCollection/AnalysisData",                                                                                                       false, false, AnalysisData.class,                   null,                                       null,                                           false,  null),
    AnalysisProtocolCollection      (true,  "/mzIdentML/AnalysisProtocolCollection",                                                                                                        false, false, AnalysisProtocolCollection.class,     null,                                       null,                                           false,  null),
    AnalysisSampleCollection        (true,  "/mzIdentML/AnalysisSampleCollection",                                                                                                          false, false, AnalysisSampleCollection.class,       null,                                       null,                                           false,  null),
    AnalysisSearchDatabase          (true,  "/mzIdentML/DataCollection/Inputs/SearchDatabase",                                                                                              false, true,  AnalysisSearchDatabase.class,         AnalysisSearchDatabaseCvParam.class,        null,                                           false,  null),
    AnalysisSoftware                (true,  "/mzIdentML/AnalysisSoftwareList/AnalysisSoftware",                                                                                             false, true,  AnalysisSoftware.class,               null,                                       null,                                           false,  null),
    AnalysisSoftwareList            (true,  "/mzIdentML/AnalysisSoftwareList",                                                                                                              false, false, AnalysisSoftwareList.class,           null,                                       null,                                           false,  null),
    AuditCollection                 (true,  "/mzIdentML/AuditCollection",                                                                                                                   false, false, AuditCollection.class,                null,                                       null,                                           false,  null),
    BibliographicReference          (true,  "/mzIdentML/BibliographicReference",                                                                                                            false, false, BibliographicReference.class,         null,                                       null,                                           false,  null),
    ConceptualMolecule              (false, null, /* abstract class */                                                                                                                      false, false, ConceptualMolecule.class,             null,                                       null,                                           false,  null),
    Contact                         (false, null, /* abstract class */                                                                                                                      false, false, Contact.class,                        null,                                       null,                                           false,  null),
    ContactRole                     (true,  "/mzIdentML/AnalysisSoftwareList/AnalysisSoftware/ContactRole",                                                                                 false, false, ContactRole.class,                    null,                                       null,                                           true,   ContactRoleRefResolver.class),
    CV                              (true,  "/mzIdentML/cvList/cv",                                                                                                                         false, true,  Cv.class,                             null,                                       null,                                           false,  null),
    CvList                          (true,  "/mzIdentML/cvList",                                                                                                                            false, false, CvList.class,                         null,                                       null,                                           false,  null),
    CvParam                         (false, null, /* multiple locations */                                                                                                                  false, false, CvParam.class,                        null,                                       null,                                           true,   CvParamRefResolver.class),
    Data                            (false, null, /* abstract class */                                                                                                                      false, false, Data.class,                           null,                                       null,                                           false,  null),
    DataCollection                  (true,  "/mzIdentML/DataCollection",                                                                                                                    false, false, DataCollection.class,                 null,                                       null,                                           false,  null),
    DatabaseFilters                 (false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseFilters",                                                         false, false, DatabaseFilters.class,                null,                                       null,                                           false,  null),
    DatabaseTranslation             (true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseTranslation",                                                     false, false, DatabaseTranslation.class,            null,                                       null,                                           false,  null),
    DBSequence                      (true,  "/mzIdentML/SequenceCollection/DBSequence",                                                                                                     false, true,  DBSequence.class,                     DBSequenceCvParam.class,                    DBSequenceUserParam.class,                      true,   DBSequenceRefResolver.class),
    Enzyme                          (false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/Enzymes/Enzyme",                                                          false, false, Enzyme.class,                         null,                                       null,                                           false,  null),
    Enzymes                         (false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/Enzymes",                                                                 false, false, Enzymes.class,                        null,                                       null,                                           false,  null),
    Equipment                       (false, null, /* abstract class */                                                                                                                      false, false, Equipment.class,                      null,                                       null,                                           false,  null),
    ExternalData                    (false, null,                                                                                                                                           false, false, ExternalData.class,                   null,                                       null,                                           false,  null),
    FileFormat                      (false, "/mzIdentML/DataCollection/Inputs/SourceFile/fileFormat",                                                                                       false, false, FileFormat.class,                     FileFormatCvParam.class,                    null,                                           false,  null),
    Filter                          (false, null,                                                                                                                                           false, false, Filter.class,                         null,                                       null,                                           false,  null),
    FragmentArray                   (false, null,                                                                                                                                           false, false, FragmentArray.class,                  null,                                       null,                                           false,  null),
    Fragmentation                   (false, null,                                                                                                                                           false, false, Fragmentation.class,                  null,                                       null,                                           false,  null),
    FragmentationTable              (false, null,                                                                                                                                           false, false, FragmentationTable.class,             null,                                       null,                                           false,  null),
    Identifiable                    (false, null, /* abstract class */                                                                                                                      false, false, Identifiable.class,                   null,                                       null,                                           false,  null),
    InputSpectra                    (true,  "/mzIdentML/AnalysisCollection/SpectrumIdentification/InputSpectra",                                                                            false, false, InputSpectra.class,                   null,                                       null,                                           true,   InputSpectraRefResolver.class),
    InputSpectrumIdentifications    (false, null,                                                                                                                                           false, false, InputSpectrumIdentifications.class,   null,                                       null,                                           true,   InputSpectrumIdentificationsRefResolver.class),
    Inputs                          (true,  "/mzIdentML/DataCollection/Inputs",                                                                                                             false, false, Inputs.class,                         null,                                       null,                                           false,  null),
    InternalData                    (false, null, /* abstract class */                                                                                                                      false, false, InternalData.class,                   null,                                       null,                                           false,  null),
    IonType                         (false, null,                                                                                                                                           false, false, IonType.class,                        IonTypeCvParam.class,                       null,                                           false,  null),
    MassTable                       (true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable",                                                               false, true,  MassTable.class,                      MassTableCvParam.class,                     MassTableUserParam.class,                       false,  null),
    Material                        (false, null, /* abstract class */                                                                                                                      false, false, Material.class,                       null,                                       null,                                           false,  null),
    Measure                         (true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/FragmentationTable/Measure",                                                 false, true,  Measure.class,                        MeasureCvParam.class,                       null,                                           false,  null),
    ModParam                        (false, null,                                                                                                                                           false, false, ModParam.class,                       ModParamCvParam.class,                      null,                                           false,  null),
    Modification                    (false, "/mzIdentML/SequenceCollection/Peptide/Modification",                                                                                           false, false, Modification.class,                   ModificationCvParam.class,                  ModificationUserParam.class,                    false,  null),
    ModificationParams              (false, null,                                                                                                                                           false, false, ModificationParams.class,             null,                                       null,                                           false,  null),
    MzIdentML                       (true,  "/mzIdentML",                                                                                                                                   false, false, MzIdentML.class,                      null,                                       null,                                           false,  null),
    Organization                    (true,  "/mzIdentML/AuditCollection/Organization",                                                                                                      false, true,  Organization.class,                   null,                                       null,                                           false,  null),
    Param                           (false, null, /* abstract class */                                                                                                                      false, false, Param.class,                          null,                                       null,                                           false,  null),
    ParamAlternative                (false, null,                                                                                                                                           false, false, ParamAlternative.class,               null,                                       null,                                           false,  null),
    ParamAlternativeList            (false, null,                                                                                                                                           false, false, ParamAlternativeList.class,           null,                                       null,                                           false,  null),
    Peptide                         (true,  "/mzIdentML/SequenceCollection/Peptide",                                                                                                        false, true,  Peptide.class,                        PeptideCvParam.class,                       PeptideUserParam.class,                         false,  null),
    PeptideEvidence                 (true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/PeptideEvidence",    false, true,  PeptideEvidence.class,                PeptideEvidenceCvParam.class,               PeptideEvidenceUserParam.class,                 true,   PeptideEvidenceRefResolver.class),
    PeptideHypothesis               (false, "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis/PeptideHypothesis",               false, false, PeptideHypothesis.class,              null,                                       null,                                           true,   PeptideHypothesisRefResolver.class),
    Person                          (true,  "/mzIdentML/AuditCollection/Person",                                                                                                            false, true,  Person.class,                         null,                                       null,                                           false,  null),
    PropertyValue                   (false, null,                                                                                                                                           false, false, PropertyValue.class,                  null,                                       null,                                           false,  null),
    ProteinAmbiguityGroup           (true,  "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup",                                                            false, false, ProteinAmbiguityGroup.class,          ProteinAmbiguityGroupCvParam.class,         ProteinAmbiguityGroupUserParam.class,           false,  null),
    ProteinDetection                (true,  "/mzIdentML/AnalysisCollection/ProteinDetection",                                                                                               false, false, ProteinDetection.class,               null,                                       null,                                           true,   ProteinDetectionRefResolver.class),
    ProteinDetectionHypothesis      (true,  "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis",                                 false, false, ProteinDetectionHypothesis.class,     ProteinDetectionHypothesisCvParam.class,    ProteinDetectionHypothesisUserParam.class,      true,   ProteinDetectionHypothesisRefResolver.class),
    ProteinDetectionList            (true,  "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList",                                                                                  false, true,  ProteinDetectionList.class,           ProteinDetectionListCvParam.class,          ProteinDetectionListUserParam.class,            false,  null),
    ProteinDetectionProtocol        (true,  "/mzIdentML/AnalysisProtocolCollection/ProteinDetectionProtocol",                                                                               false, true,  ProteinDetectionProtocol.class,       null,                                       null,                                           true,   ProteinDetectionProtocolRefResolver.class),
    Protocol                        (false, null, /* abstract class */                                                                                                                      false, false, Protocol.class,                       null,                                       null,                                           false,  null),
    ProtocolApplication             (false, null, /* abstract class */                                                                                                                      false, false, ProtocolApplication.class,            null,                                       null,                                           false,  null),
    Provider                        (true,  "/mzIdentML/Provider",                                                                                                                          false, true,  Provider.class,                       null,                                       null,                                           true,   ProviderRefResolver.class),
    Role                            (false, null, /* multiple locations */                                                                                                                  false, false, Role.class,                           RoleCvParam.class,                          null,                                           false,  null),
    Residue                         (false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable/Residue",                                                       false, false, Residue.class,                        null,                                       null,                                           false,  null),
    Sample                          (true,  "/mzIdentML/AnalysisSampleCollection/Sample",                                                                                                   false, true,  Sample.class,                         SampleCvParam.class,                        SampleUserParam.class,                          false,  null),
    SearchDatabase                  (true,  "/mzIdentML/AnalysisCollection/SpectrumIdentification/SearchDatabase",                                                                          false, false, SearchDatabase.class,                 null,                                       null,                                           true,   SearchDatabaseRefResolver.class),
    SearchModification              (false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/ModificationParams/SearchModification",                                   false, false, SearchModification.class,             null,                                       null,                                           false,  null),
    SequenceCollection              (true,  "/mzIdentML/SequenceCollection",                                                                                                                false, false, SequenceCollection.class,             null,                                       null,                                           false,  null),
    Software                        (false, null, /* abstract class */                                                                                                                      false, true,  Software.class,                       null,                                       null,                                           false,  null),
    SourceFile                      (false, "/mzIdentML/DataCollection/Inputs/SourceFile",                                                                                                  false, false, SourceFile.class,                     SourceFileCvParam.class,                    SourceFileUserParam.class,                      false,  null),
    SpecificityRules                (false, null,                                                                                                                                           false, false, SpecificityRules.class,               SpecificityRulesCvParam.class,              null,                                           false,  null),
    SpectraData                     (true,  "/mzIdentML/DataCollection/Inputs/SpectraData",                                                                                                 false, true,  SpectraData.class,                    null,                                       null,                                           false,  null),
    SpectrumIDFormat                (false, null,                                                                                                                                           false, false, SpectrumIDFormat.class,               null,                                       null,                                           false,  null),
    SpectrumIdentification          (true,  "/mzIdentML/AnalysisCollection/SpectrumIdentification",                                                                                         false, false, SpectrumIdentification.class,         null,                                       null,                                           true,   SpectrumIdentificationRefResolver.class),
    SpectrumIdentificationItem      (true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem",                    false, false, SpectrumIdentificationItem.class,     SpectrumIdentificationItemCvParam.class,    SpectrumIdentificationItemUserParam.class,      true,   SpectrumIdentificationItemRefResolver.class),
    SpectrumIdentificationList      (true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList",                                                                            false, true,  SpectrumIdentificationList.class,     SpectrumIdentificationListCvParam.class,    SpectrumIdentificationListUserParam.class,      false,  null),
    SpectrumIdentificationProtocol  (true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol",                                                                         false, true,  SpectrumIdentificationProtocol.class, null,                                       null,                                           true ,  SpectrumIdentificationProtocolRefResolver.class),
    SpectrumIdentificationResult    (true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult",                                               false, false, SpectrumIdentificationResult.class,   SpectrumIdentificationResultCvParam.class,  SpectrumIdentificationResultUserParam.class,    true,   SpectrumIdentificationResultRefResolver.class),
    SubSample                       (false, null,                                                                                                                                           false, false, SubSample.class,                      null,                                       null,                                           false,  null),
    SubstitutionModification        (false, "/mzIdentML/SequenceCollection/Peptide/SubstitutionModification",                                                                               false, false, SubstitutionModification.class,       null,                                       null,                                           false,  null),
    Tolerance                       (false, null,                                                                                                                                           false, false, Tolerance.class,                      ToleranceCvParam.class,                     null,                                           false,  null),
    TranslationTable                (true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseTranslation/TranslationTable",                                    false, true,  TranslationTable.class,               TranslationTableCvParam.class,              null,                                           false,  null),
    UserParam                       (false, null, /* multiple locations */                                                                                                                  false, false, UserParam.class,                      null,                                       null,                                           false,  null);


    private final boolean indexed;
    private final String xpath;
    private final boolean cached;
    private final boolean idMapped;
    private final Class clazz;
    private final Class cvParamClass;
    private final Class userParamClass;
    private final boolean autoRefResolving;
    private final Class refResolverClass;

    private <T extends MzIdentMLObject> MzIdentMLElement(boolean indexed,
                                                         String xpath,
                                                         boolean cached,
                                                         boolean idMapped,
                                                         Class<T> clazz,
                                                         Class cvParamClass,
                                                         Class userParamClass,
                                                         boolean autoRefResolving,
                                                         Class refResolverClass) {
        this.indexed = indexed;
        this.cached = cached; // currently not used!
        this.xpath = xpath;
        this.idMapped = idMapped;
        this.clazz = clazz;
        this.cvParamClass = cvParamClass;
        this.userParamClass = userParamClass;
        this.autoRefResolving = autoRefResolving;
        this.refResolverClass = refResolverClass;

        // ToDo: perhaps statically load properties file to load parameters like caching or indexing?
        // for example:
        // CV (TypeProperties.getIndexing(Cv.class), "/mzIdentML/cvList/cv", TypeProperties.getCaching(Cv.class), Cv.class),
    }

    public boolean isIndexed() {
        return indexed;
    }

    public boolean isCached() {
        return cached;
    }

    public boolean isIdMapped() {
        return idMapped;
    }

    public boolean isAutoRefResolving() {
        return autoRefResolving;
    }

    public String getXpath() {
        return xpath;
    }

    @SuppressWarnings("unchecked")
    public <T extends MzIdentMLObject> Class<T> getClazz() {
        return clazz;
    }

    @SuppressWarnings("unchecked")
    public <C extends CvParam> Class<C> getCvParamClass() {
        return cvParamClass;
    }

    @SuppressWarnings("unchecked")
    public <U extends UserParam> Class<U> getUserParamClass() {
        return userParamClass;
    }

    @SuppressWarnings("unchecked")
    public <R extends AbstractReferenceResolver> Class<R> getRefResolverClass() {
        return refResolverClass;
    }

    public static MzIdentMLElement getType(Class clazz) {
        for (MzIdentMLElement type : MzIdentMLElement.values()) {
            if (type.getClazz() == clazz) {
                return type;
            }
        }
        return null;
    }

    public static MzIdentMLElement getType(String xpath) {
        for (MzIdentMLElement type : MzIdentMLElement.values()) {
            if (type.getXpath().equals(xpath)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MzIdentMLElement{" +
                "indexed=" + indexed +
                ", xpath='" + xpath + '\'' +
                ", cached=" + cached +
                ", clazz=" + clazz +
                '}';
    }
}