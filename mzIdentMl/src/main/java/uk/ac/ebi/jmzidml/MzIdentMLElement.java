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

    //                               tag name                         indexed   xpath                                                                                                                                         cached idMapped class-name                           CvParam-subclass                            UserParam-subclass                        refResolving, reference-resolver
    //AdditionalSearchParams
    Affiliations                    ("affiliations",                    true,  "/mzIdentML/AuditCollection/Person/affiliations",                                                                                                false, false, Affiliations.class,                   null,                                       null,                                           true,   AffiliationsRefResolver.class),
    AmbiguousResidue                ("AmbiguousResidue",                false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable/AmbiguousResidue",                                               false, false, AmbiguousResidue.class,               AmbiguousResidueCvParam.class,              AmbiguousResidueUserParam.class,                false,  null),
    AnalysisCollection              ("AnalysisCollection",              true,  "/mzIdentML/AnalysisCollection",                                                                                                                 false, false, AnalysisCollection.class,             null,                                       null,                                           false,  null),
    AnalysisData                    ("AnalysisData",                    true,  "/mzIdentML/DataCollection/AnalysisData",                                                                                                        false, false, AnalysisData.class,                   null,                                       null,                                           false,  null),
    // AnalysisParams
    AnalysisProtocolCollection      ("AnalysisProtocolCollection",      true,  "/mzIdentML/AnalysisProtocolCollection",                                                                                                         false, false, AnalysisProtocolCollection.class,     null,                                       null,                                           false,  null),
    AnalysisSampleCollection        ("AnalysisSampleCollection",        true,  "/mzIdentML/AnalysisSampleCollection",                                                                                                           false, false, AnalysisSampleCollection.class,       null,                                       null,                                           false,  null),
    AnalysisSearchDatabase          ("SearchDatabase",                  true,  "/mzIdentML/DataCollection/Inputs/SearchDatabase",                                                                                               false, true,  AnalysisSearchDatabase.class,         AnalysisSearchDatabaseCvParam.class,        null,                                           false,  null),
    AnalysisSoftware                ("AnalysisSoftware",                true,  "/mzIdentML/AnalysisSoftwareList/AnalysisSoftware",                                                                                              false, true,  AnalysisSoftware.class,               null,                                       null,                                           false,  null),
    AnalysisSoftwareList            ("AnalysisSoftwareList",            true,  "/mzIdentML/AnalysisSoftwareList",                                                                                                               false, false, AnalysisSoftwareList.class,           null,                                       null,                                           false,  null),
    AuditCollection                 ("AuditCollection",                 true,  "/mzIdentML/AuditCollection",                                                                                                                    false, false, AuditCollection.class,                null,                                       null,                                           false,  null),
    BibliographicReference          ("BibliographicReference",          true,  "/mzIdentML/BibliographicReference",                                                                                                             false, false, BibliographicReference.class,         null,                                       null,                                           false,  null),
    ConceptualMolecule              (null,                              false, null, /* abstract class */                                                                                                                       false, false, ConceptualMolecule.class,             null,                                       null,                                           false,  null),
    Contact                         (null,                              false, null, /* abstract class */                                                                                                                       false, false, Contact.class,                        null,                                       null,                                           false,  null),
    ContactRole                     ("ContactRole",                     true,  "/mzIdentML/AnalysisSoftwareList/AnalysisSoftware/ContactRole",                                                                                  false, false, ContactRole.class,                    null,                                       null,                                           true,   ContactRoleRefResolver.class),
    CV                              ("cv",                              true,  "/mzIdentML/cvList/cv",                                                                                                                          false, true,  Cv.class,                             null,                                       null,                                           false,  null),
    CvList                          ("cvList",                          true,  "/mzIdentML/cvList",                                                                                                                             false, false, CvList.class,                         null,                                       null,                                           false,  null),
    CvParam                         ("cvParam",                         false, null, /* multiple locations */                                                                                                                   false, false, CvParam.class,                        null,                                       null,                                           true,   CvParamRefResolver.class),
    Data                            (null,                              false, null, /* abstract class */                                                                                                                       false, false, Data.class,                           null,                                       null,                                           false,  null),
    DataCollection                  ("DataCollection",                  true,  "/mzIdentML/DataCollection",                                                                                                                     false, false, DataCollection.class,                 null,                                       null,                                           false,  null),
    DatabaseFilters                 ("DatabaseFilters",                 false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseFilters",                                                          false, false, DatabaseFilters.class,                null,                                       null,                                           false,  null),
    // DatabaseName
    DatabaseTranslation             ("DatabaseTranslation",             true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseTranslation",                                                      false, false, DatabaseTranslation.class,            null,                                       null,                                           false,  null),
    DBSequence                      ("DBSequence",                      true,  "/mzIdentML/SequenceCollection/DBSequence",                                                                                                      false, true,  DBSequence.class,                     DBSequenceCvParam.class,                    DBSequenceUserParam.class,                      true,   DBSequenceRefResolver.class),
    Enzyme                          ("Enzyme",                          false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/Enzymes/Enzyme",                                                           false, false, Enzyme.class,                         null,                                       null,                                           false,  null),
    // EnzymeName
    Enzymes                         ("Enzymes",                         false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/Enzymes",                                                                  false, false, Enzymes.class,                        null,                                       null,                                           false,  null),
    Equipment                       (null,                              false, null, /* abstract class */                                                                                                                       false, false, Equipment.class,                      null,                                       null,                                           false,  null),
    ExternalData                    (null,                              false, null, /* base element, not directly used */                                                                                                      false, false, ExternalData.class,                   null,                                       null,                                           false,  null),
    FileFormat                      ("fileFormat",                      false, null, /* multiple locations */                                                                                                                   false, false, FileFormat.class,                     FileFormatCvParam.class,                    null,                                           false,  null),
    Filter                          ("Filter",                          false, null,                                                                                                                                            false, false, Filter.class,                         null,                                       null,                                           false,  null),
    // FilterType
    FragmentArray                   ("FragmentArray",                   false, null,                                                                                                                                            false, false, FragmentArray.class,                  null,                                       null,                                           false,  null),
    Fragmentation                   ("Fragmentation",                   false, "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/Fragmentation",       false, false, Fragmentation.class,                  null,                                       null,                                           false,  null),
    FragmentationTable              ("FragmentationTable",              true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/FragmentationTable",                                                          false, false, FragmentationTable.class,             null,                                       null,                                           false,  null),
    // FragmentTolerance
    Identifiable                    (null,                              false, null, /* abstract class */                                                                                                                       false, false, Identifiable.class,                   null,                                       null,                                           false,  null),
    // Include
    InputSpectra                    ("InputSpectra",                    true,  "/mzIdentML/AnalysisCollection/SpectrumIdentification/InputSpectra",                                                                             false, false, InputSpectra.class,                   null,                                       null,                                           true,   InputSpectraRefResolver.class),
    InputSpectrumIdentifications    ("InputSpectrumIdentifications",    false, null,                                                                                                                                            false, false, InputSpectrumIdentifications.class,   null,                                       null,                                           true,   InputSpectrumIdentificationsRefResolver.class),
    Inputs                          ("Inputs",                          true,  "/mzIdentML/DataCollection/Inputs",                                                                                                              false, false, Inputs.class,                         null,                                       null,                                           false,  null),
    InternalData                    (null,                              false, null, /* abstract class */                                                                                                                       false, false, InternalData.class,                   null,                                       null,                                           false,  null),
    IonType                         ("IonType",                         false, null,                                                                                                                                            false, false, IonType.class,                        IonTypeCvParam.class,                       null,                                           false,  null),
    MassTable                       ("MassTable",                       true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable",                                                                false, true,  MassTable.class,                      MassTableCvParam.class,                     MassTableUserParam.class,                       false,  null),
    Material                        (null,                              false, null, /* abstract class */                                                                                                                       false, false, Material.class,                       null,                                       null,                                           false,  null),
    Measure                         ("Measure",                         true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/FragmentationTable/Measure",                                                  false, true,  Measure.class,                        MeasureCvParam.class,                       null,                                           false,  null),
    ModParam                        ("ModParam",                        true, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/ModificationParams/SearchModification",                                                                                                                                            false, false, ModParam.class,                       ModParamCvParam.class,                      null,                                           false,  null),
    Modification                    ("Modification",                    false, "/mzIdentML/SequenceCollection/Peptide/Modification",                                                                                            false, false, Modification.class,                   ModificationCvParam.class,                  ModificationUserParam.class,                    false,  null),
    ModificationParams              ("ModificationParams",              false, null,                                                                                                                                            false, false, ModificationParams.class,             null,                                       null,                                           false,  null),
    MzIdentML                       ("mzIdentML",                       true,  "/mzIdentML",                                                                                                                                    false, true,  MzIdentML.class,                      null,                                       null,                                           false,  null),
    Organization                    ("Organization",                    true,  "/mzIdentML/AuditCollection/Organization",                                                                                                       false, true,  Organization.class,                   null,                                       null,                                           false,  null),
    Param                           (null,                              false, null, /* abstract class */                                                                                                                       false, false, Param.class,                          null,                                       null,                                           false,  null),
    ParamAlternative                (null,                              false, null, /* used with other tag name */                                                                                                             false, false, ParamAlternative.class,               null,                                       null,                                           false,  null),
    ParamAlternativeList            (null,                              false, null, /* used with other tag name */                                                                                                             false, false, ParamAlternativeList.class,           null,                                       null,                                           false,  null),
    // ParentTolerance
    Peptide                         ("Peptide",                         true,  "/mzIdentML/SequenceCollection/Peptide",                                                                                                         false, true,  Peptide.class,                        PeptideCvParam.class,                       PeptideUserParam.class,                         false,  null),
    //PeptideSequence
    PeptideEvidence                 ("PeptideEvidence",                 true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/PeptideEvidence",     false, true,  PeptideEvidence.class,                PeptideEvidenceCvParam.class,               PeptideEvidenceUserParam.class,                 true,   PeptideEvidenceRefResolver.class),
    PeptideHypothesis               ("PeptideHypothesis",               false, "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis/PeptideHypothesis",                false, false, PeptideHypothesis.class,              null,                                       null,                                           true,   PeptideHypothesisRefResolver.class),
    Person                          ("Person",                          true,  "/mzIdentML/AuditCollection/Person",                                                                                                             false, true,  Person.class,                         null,                                       null,                                           false,  null),
    PropertyValue                   (null,                              false, null, /* used at all? */                                                                                                                         false, false, PropertyValue.class,                  null,                                       null,                                           false,  null),
    ProteinAmbiguityGroup           ("ProteinAmbiguityGroup",           true,  "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup",                                                             false, false, ProteinAmbiguityGroup.class,          ProteinAmbiguityGroupCvParam.class,         ProteinAmbiguityGroupUserParam.class,           false,  null),
    ProteinDetection                ("ProteinDetection",                true,  "/mzIdentML/AnalysisCollection/ProteinDetection",                                                                                                false, false, ProteinDetection.class,               null,                                       null,                                           true,   ProteinDetectionRefResolver.class),
    ProteinDetectionHypothesis      ("ProteinDetectionHypothesis",      true,  "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis",                                  false, false, ProteinDetectionHypothesis.class,     ProteinDetectionHypothesisCvParam.class,    ProteinDetectionHypothesisUserParam.class,      true,   ProteinDetectionHypothesisRefResolver.class),
    ProteinDetectionList            ("ProteinDetectionList",            true,  "/mzIdentML/DataCollection/AnalysisData/ProteinDetectionList",                                                                                   false, true,  ProteinDetectionList.class,           ProteinDetectionListCvParam.class,          ProteinDetectionListUserParam.class,            false,  null),
    ProteinDetectionProtocol        ("ProteinDetectionProtocol",        true,  "/mzIdentML/AnalysisProtocolCollection/ProteinDetectionProtocol",                                                                                false, true,  ProteinDetectionProtocol.class,       null,                                       null,                                           true,   ProteinDetectionProtocolRefResolver.class),
    Protocol                        (null,                              false, null, /* abstract class */                                                                                                                       false, false, Protocol.class,                       null,                                       null,                                           false,  null),
    ProtocolApplication             (null,                              false, null, /* abstract class */                                                                                                                       false, false, ProtocolApplication.class,            null,                                       null,                                           false,  null),
    Provider                        ("Provider",                        true,  "/mzIdentML/Provider",                                                                                                                           false, true,  Provider.class,                       null,                                       null,                                           true,   ProviderRefResolver.class),
    Role                            ("role",                            false, null, /* multiple locations */                                                                                                                   false, false, Role.class,                           RoleCvParam.class,                          null,                                           false,  null),
    Residue                         ("Residue",                         false, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable/Residue",                                                        false, false, Residue.class,                        null,                                       null,                                           false,  null),
    Sample                          ("Sample",                          true,  "/mzIdentML/AnalysisSampleCollection/Sample",                                                                                                    false, true,  Sample.class,                         SampleCvParam.class,                        SampleUserParam.class,                          false,  null),
    SearchDatabase                  ("SearchDatabase",                  false, null, /* multiple locations */                                                                                                                   false, false, SearchDatabase.class,                 null,                                       null,                                           true,   SearchDatabaseRefResolver.class),
    SearchModification              ("SearchModification",              true, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/ModificationParams/SearchModification",                                    false, false, SearchModification.class,             null,                                       null,                                           false,  null),
    // SearchType
    // Seq
    SequenceCollection              ("SequenceCollection",              true,  "/mzIdentML/SequenceCollection",                                                                                                                 false, false, SequenceCollection.class,             null,                                       null,                                           false,  null),
    // SiteRegexp
    Software                        (null,                              false, null, /* abstract class */                                                                                                                       false, true,  Software.class,                       null,                                       null,                                           false,  null),
    SourceFile                      ("SourceFile",                      false, "/mzIdentML/DataCollection/Inputs/SourceFile",                                                                                                   false, false, SourceFile.class,                     SourceFileCvParam.class,                    SourceFileUserParam.class,                      false,  null),
    SpecificityRules                ("SpecificityRules",                false, null,                                                                                                                                            false, false, SpecificityRules.class,               SpecificityRulesCvParam.class,              null,                                           false,  null),
    SpectraData                     ("SpectraData",                     true,  "/mzIdentML/DataCollection/Inputs/SpectraData",                                                                                                  false, true,  SpectraData.class,                    null,                                       null,                                           false,  null),
    SpectrumIDFormat                ("spectrumIDFormat",                false, "/mzIdentML/DataCollection/Inputs/SpectraData/spectrumIDFormat",                                                                                 false, false, SpectrumIDFormat.class,               null,                                       null,                                           false,  null),
    SpectrumIdentification          ("SpectrumIdentification",          true,  "/mzIdentML/AnalysisCollection/SpectrumIdentification",                                                                                          false, false, SpectrumIdentification.class,         null,                                       null,                                           true,   SpectrumIdentificationRefResolver.class),
    SpectrumIdentificationItem      ("SpectrumIdentificationItem",      true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem",                     false, false, SpectrumIdentificationItem.class,     SpectrumIdentificationItemCvParam.class,    SpectrumIdentificationItemUserParam.class,      true,   SpectrumIdentificationItemRefResolver.class),
    SpectrumIdentificationList      ("SpectrumIdentificationList",      true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList",                                                                             false, true,  SpectrumIdentificationList.class,     SpectrumIdentificationListCvParam.class,    SpectrumIdentificationListUserParam.class,      false,  null),
    SpectrumIdentificationProtocol  ("SpectrumIdentificationProtocol",  true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol",                                                                          false, true,  SpectrumIdentificationProtocol.class, null,                                       null,                                           true ,  SpectrumIdentificationProtocolRefResolver.class),
    SpectrumIdentificationResult    ("SpectrumIdentificationResult",    true,  "/mzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult",                                                false, false, SpectrumIdentificationResult.class,   SpectrumIdentificationResultCvParam.class,  SpectrumIdentificationResultUserParam.class,    true,   SpectrumIdentificationResultRefResolver.class),
    SubSample                       (null,                              false, null,                                                                                                                                            false, false, SubSample.class,                      null,                                       null,                                           false,  null),
    SubstitutionModification        ("SubstitutionModification",        false, "/mzIdentML/SequenceCollection/Peptide/SubstitutionModification",                                                                                false, false, SubstitutionModification.class,       null,                                       null,                                           false,  null),
    // Threshold
    Tolerance                       (null,                              false, null, /* multiple tag names */                                                                                                                   false, false, Tolerance.class,                      ToleranceCvParam.class,                     null,                                           false,  null),
    TranslationTable                ("TranslationTable",                true,  "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseTranslation/TranslationTable",                                     false, true,  TranslationTable.class,               TranslationTableCvParam.class,              null,                                           false,  null),
    UserParam                       ("userParam",                       false, null, /* multiple locations */                                                                                                                   false, false, UserParam.class,                      null,                                       null,                                           false,  null);


    private final String tagName;
    private final boolean indexed;
    private final String xpath;
    private final boolean cached;
    private final boolean idMapped;
    private final Class clazz;
    private final Class cvParamClass;
    private final Class userParamClass;
    private final boolean autoRefResolving;
    private final Class refResolverClass;

    private <T extends MzIdentMLObject> MzIdentMLElement(String tagName,
                                                         boolean indexed,
                                                         String xpath,
                                                         boolean cached,
                                                         boolean idMapped,
                                                         Class<T> clazz,
                                                         Class cvParamClass,
                                                         Class userParamClass,
                                                         boolean autoRefResolving,
                                                         Class refResolverClass) {
        this.tagName = tagName;
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

    public String getTagName() {
        return tagName;
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
            if (type.getXpath() != null && type.getXpath().equals(xpath)) {
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