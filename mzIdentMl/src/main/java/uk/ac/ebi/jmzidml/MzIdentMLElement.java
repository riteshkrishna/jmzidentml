package uk.ac.ebi.jmzidml;

import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.model.mzidml.params.*;
import uk.ac.ebi.jmzidml.xml.jaxb.resolver.*;

/**
 * For performance reasons (Memory Overflow), all the reference auto-resolving have been switched off.
 * Reference auto-resolving creates too many duplicated objects, one possible solution for this is to use
 * caching.
 */
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
    AbstractContact                 (null,                              false, null, /*abstract class*/                                                                                                                         false, false, AbstractContact.class,                null,                                       null,                                           false,  null),
    AbstractParam                   (null,                              false, null, /*abstract class*/                                                                                                                         false, false, AbstractParam.class,                  null,                                       null,                                           false,   AbstractParamUnitCvRefResolver.class), // this resolver might be turned off for performance
    Affiliations                    ("Affiliations",                    true,  "/MzIdentML/AuditCollection/Person/Affiliations",                                                                                                false, false, Affiliations.class,                   null,                                       null,                                           false,  AffiliationsRefResolver.class),
    AmbiguousResidue                ("AmbiguousResidue",                false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable/AmbiguousResidue",                                               false, false, AmbiguousResidue.class,               AmbiguousResidueCvParam.class,              AmbiguousResidueUserParam.class,                false,  null),
    AnalysisCollection              ("AnalysisCollection",              true,  "/MzIdentML/AnalysisCollection",                                                                                                                 false, false, AnalysisCollection.class,             null,                                       null,                                           false,  null),
    AnalysisData                    ("AnalysisData",                    true,  "/MzIdentML/DataCollection/AnalysisData",                                                                                                        false, false, AnalysisData.class,                   null,                                       null,                                           false,  null),
    AnalysisProtocolCollection      ("AnalysisProtocolCollection",      true,  "/MzIdentML/AnalysisProtocolCollection",                                                                                                         false, false, AnalysisProtocolCollection.class,     null,                                       null,                                           false,  null),
    AnalysisSampleCollection        ("AnalysisSampleCollection",        true,  "/MzIdentML/AnalysisSampleCollection",                                                                                                           false, false, AnalysisSampleCollection.class,       null,                                       null,                                           false,  null),
    AnalysisSearchDatabase          ("SearchDatabase",                  true,  "/MzIdentML/DataCollection/Inputs/SearchDatabase",                                                                                               false, true,  AnalysisSearchDatabase.class,         AnalysisSearchDatabaseCvParam.class,        null,                                           false,  null),
    AnalysisSoftware                ("AnalysisSoftware",                true,  "/MzIdentML/AnalysisSoftwareList/AnalysisSoftware",                                                                                              false, true,  AnalysisSoftware.class,               null,                                       null,                                           false,  null),
    AnalysisSoftwareList            ("AnalysisSoftwareList",            true,  "/MzIdentML/AnalysisSoftwareList",                                                                                                               false, false, AnalysisSoftwareList.class,           null,                                       null,                                           false,  null),
    AuditCollection                 ("AuditCollection",                 true,  "/MzIdentML/AuditCollection",                                                                                                                    false, false, AuditCollection.class,                null,                                       null,                                           false,  null),
    BibliographicReference          ("BibliographicReference",          true,  "/MzIdentML/BibliographicReference",                                                                                                             false, false, BibliographicReference.class,         null,                                       null,                                           false,  null),
//    Contact                         ("Contact",                         false, "/MzIdentML/AuditCollection/Contact",                                                                                                            false, false, Contact.class,                        null,                                       null,                                           false,  null),
    ContactRole                     ("ContactRole",                     true,  "/MzIdentML/AnalysisSoftwareList/AnalysisSoftware/ContactRole",                                                                                  false, false, ContactRole.class,                    null,                                       null,                                           false,   ContactRoleRefResolver.class),
    CV                              ("cv",                              true,  "/MzIdentML/cvList/cv",                                                                                                                          false, true,  Cv.class,                             null,                                       null,                                           false,  null),
    CvList                          ("cvList",                          true,  "/MzIdentML/cvList",                                                                                                                             false, false, CvList.class,                         null,                                       null,                                           false,  null),
    CvParam                         ("cvParam",                         false, null, /* multiple locations */                                                                                                                   false, false, CvParam.class,                        null,                                       null,                                           false,   CvParamRefResolver.class),
    DatabaseFilters                 ("DatabaseFilters",                 false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseFilters",                                                          false, false, DatabaseFilters.class,                null,                                       null,                                           false,  null),
    DatabaseTranslation             ("DatabaseTranslation",             true,  "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseTranslation",                                                      false, false, DatabaseTranslation.class,            null,                                       null,                                           false,  null),
    DataCollection                  ("DataCollection",                  true,  "/MzIdentML/DataCollection",                                                                                                                     false, false, DataCollection.class,                 null,                                       null,                                           false,  null),
    DBSequence                      ("DBSequence",                      true,  "/MzIdentML/SequenceCollection/DBSequence",                                                                                                      false, true,  DBSequence.class,                     DBSequenceCvParam.class,                    DBSequenceUserParam.class,                      false,   DBSequenceRefResolver.class),
    Enzyme                          ("Enzyme",                          false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/Enzymes/Enzyme",                                                           false, false, Enzyme.class,                         null,                                       null,                                           false,  null),
    Enzymes                         ("Enzymes",                         false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/Enzymes",                                                                  false, false, Enzymes.class,                        null,                                       null,                                           false,  null),
    ExternalData                    (null,                              false, null, /* base element, not directly used */                                                                                                      false, false, ExternalData.class,                   null,                                       null,                                           false,  null),
    FileFormat                      ("FileFormat",                      false, null, /* multiple locations */                                                                                                                   false, false, FileFormat.class,                     FileFormatCvParam.class,                    null,                                           false,  null),
    Filter                          ("Filter",                          false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseFilters/Filter",                                                   false, false, Filter.class,                         null,                                       null,                                           false,  null),
    FragmentArray                   ("FragmentArray",                   false, "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/Fragmentation/IonType/FragmentArray", false, false, FragmentArray.class,  null,                                       null,                                           false,  FragmentArrayRefResolver.class),
    Fragmentation                   ("Fragmentation",                   false, "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/Fragmentation",       false, false, Fragmentation.class,                  null,                                       null,                                           false,  null),
    FragmentationTable              ("FragmentationTable",              true,  "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/FragmentationTable",                                                          false, false, FragmentationTable.class,             null,                                       null,                                           false,  null),
    Identifiable                    (null,                              false, null, /* abstract class */                                                                                                                       false, false, Identifiable.class,                   null,                                       null,                                           false,  null),
    Inputs                          ("Inputs",                          true,  "/MzIdentML/DataCollection/Inputs",                                                                                                              false, false, Inputs.class,                         null,                                       null,                                           false,  null),
    InputSpectra                    ("InputSpectra",                    true,  "/MzIdentML/AnalysisCollection/SpectrumIdentification/InputSpectra",                                                                             false, false, InputSpectra.class,                   null,                                       null,                                           false,   InputSpectraRefResolver.class),
    InputSpectrumIdentifications    ("InputSpectrumIdentifications",    false, "/MzIdentML/AnalysisCollection/ProteinDetection/InputSpectrumIdentifications",                                                                   false, false, InputSpectrumIdentifications.class,   null,                                       null,                                           false,   InputSpectrumIdentificationsRefResolver.class),
    IonType                         ("IonType",                         false, "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/Fragmentation/IonType",false, false, IonType.class,                       IonTypeCvParam.class,                       null,                                           false,  null),
    MassTable                       ("MassTable",                       true,  "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable",                                                                false, true,  MassTable.class,                      MassTableCvParam.class,                     MassTableUserParam.class,                       false,  null),
    Measure                         ("Measure",                         true,  "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/FragmentationTable/Measure",                                                  false, true,  Measure.class,                        MeasureCvParam.class,                       null,                                           false,  null),
    Modification                    ("Modification",                    false, "/MzIdentML/SequenceCollection/Peptide/Modification",                                                                                            false, false, Modification.class,                   ModificationCvParam.class,                  ModificationUserParam.class,                    false,  null),
    ModificationParams              ("ModificationParams",              false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/ModificationParams",                                                       false, false, ModificationParams.class,             null,                                       null,                                           false,  null),
    MzIdentML                       ("MzIdentML",                       true,  "/MzIdentML",                                                                                                                                    false, true,  MzIdentML.class,                      null,                                       null,                                           false,  null),
    Organization                    ("Organization",                    true,  "/MzIdentML/AuditCollection/Organization",                                                                                                       false, true,  Organization.class,                   OrganizationCvParam.class,                  OrganizationUserParam.class,                    false,  null),
    Param                           (null,                              false, null, /* abstract class */                                                                                                                       false, false, Param.class,                          null,                                       null,                                           false,  null),
    ParamList                       (null,                              false, null, /* multiple places */                                                                                                                      false, false, ParamList.class,                      null,                                       null,                                           false,  null),
    ParentOrganization              ("Parent",                          false, "/MzIdentML/AuditCollection/Organization/Parent",                                                                                                false, false, ParentOrganization.class,             null,                                       null,                                           false,  ParentOrganizationRefResolver.class),
    Peptide                         ("Peptide",                         true,  "/MzIdentML/SequenceCollection/Peptide",                                                                                                         false, true,  Peptide.class,                        PeptideCvParam.class,                       PeptideUserParam.class,                         false,  null),
    PeptideEvidence                 ("PeptideEvidence",                 true,  "/MzIdentML/SequenceCollection/PeptideEvidenceList/PeptideEvidence",                                                                             false, true,  PeptideEvidence.class,                PeptideEvidenceCvParam.class,               PeptideEvidenceUserParam.class,                 false,   PeptideEvidenceResolver.class),
    PeptideEvidenceList             ("PeptideEvidenceList",             true,  "/MzIdentML/SequenceCollection/PeptideEvidenceList",                                                                                             false, true,  PeptideEvidenceList.class,            PeptideEvidenceListCvParam.class,           PeptideEvidenceListUserParam.class,                                           false,  null),
    PeptideEvidenceRef              ("PeptideEvidenceRef",              false, "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem/PeptideEvidenceRef",  false, false, PeptideEvidenceRef.class,             null,                                       null,                                           false,   PeptideEvidenceRefResolver.class),
    PeptideHypothesis               ("PeptideHypothesis",               false, "/MzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis/PeptideHypothesis",                false, false, PeptideHypothesis.class,              null,                                       null,                                           false,   PeptideHypothesisRefResolver.class),
    Person                          ("Person",                          true,  "/MzIdentML/AuditCollection/Person",                                                                                                             false, true,  Person.class,                         PersonCvParam.class,                        PersonUserParam.class,                          false,  null),
    ProteinAmbiguityGroup           ("ProteinAmbiguityGroup",           true,  "/MzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup",                                                             false, false, ProteinAmbiguityGroup.class,          ProteinAmbiguityGroupCvParam.class,         ProteinAmbiguityGroupUserParam.class,           false,  null),
    ProteinDetection                ("ProteinDetection",                true,  "/MzIdentML/AnalysisCollection/ProteinDetection",                                                                                                false, false, ProteinDetection.class,               null,                                       null,                                           false,   ProteinDetectionRefResolver.class),
    ProteinDetectionHypothesis      ("ProteinDetectionHypothesis",      true,  "/MzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis",                                  false, false, ProteinDetectionHypothesis.class,     ProteinDetectionHypothesisCvParam.class,    ProteinDetectionHypothesisUserParam.class,      false,   ProteinDetectionHypothesisRefResolver.class),
    ProteinDetectionList            ("ProteinDetectionList",            true,  "/MzIdentML/DataCollection/AnalysisData/ProteinDetectionList",                                                                                   false, true,  ProteinDetectionList.class,           ProteinDetectionListCvParam.class,          ProteinDetectionListUserParam.class,            false,  null),
    ProteinDetectionProtocol        ("ProteinDetectionProtocol",        true,  "/MzIdentML/AnalysisProtocolCollection/ProteinDetectionProtocol",                                                                                false, true,  ProteinDetectionProtocol.class,       null,                                       null,                                           false,   ProteinDetectionProtocolRefResolver.class),
    ProtocolApplication             (null,                              false, null, /* abstract class */                                                                                                                       false, false, ProtocolApplication.class,            null,                                       null,                                           false,  null),
    Provider                        ("Provider",                        true,  "/MzIdentML/Provider",                                                                                                                           false, true,  Provider.class,                       null,                                       null,                                           false,   ProviderRefResolver.class),
    Residue                         ("Residue",                         false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/MassTable/Residue",                                                        false, false, Residue.class,                        null,                                       null,                                           false,  null),
    Role                            ("Role",                            false, "/MzIdentML/AnalysisSoftwareList/AnalysisSoftware/ContactRole/Role",                                                                             false, false, Role.class,                           RoleCvParam.class,                          null,                                           false,  null),
    Sample                          ("Sample",                          true,  "/MzIdentML/AnalysisSampleCollection/Sample",                                                                                                    false, true,  Sample.class,                         SampleCvParam.class,                        SampleUserParam.class,                          false,  null),
    SearchDatabaseRef               ("SearchDatabaseRef",                  false, "/MzIdentML/AnalysisCollection/SpectrumIdentification/SearchDatabaseRef",                                                                        false, false, SearchDatabaseRef.class,              null,                                       null,                                           false,   SearchDatabaseRefResolver.class),
    SearchModification              ("SearchModification",              false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/ModificationParams/SearchModification",                                    false, false, SearchModification.class,             null,                                       null,                                           false,  null),
    SequenceCollection              ("SequenceCollection",              true,  "/MzIdentML/SequenceCollection",                                                                                                                 false, false, SequenceCollection.class,             null,                                       null,                                           false,  null),
    SourceFile                      ("SourceFile",                      false, "/MzIdentML/DataCollection/Inputs/SourceFile",                                                                                                   false, false, SourceFile.class,                     SourceFileCvParam.class,                    SourceFileUserParam.class,                      false,  null),
    SpecificityRules                ("SpecificityRules",                false, "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/ModificationParams/SearchModification/SpecificityRules",                   false, false, SpecificityRules.class,               SpecificityRulesCvParam.class,              null,                                           false,  null),
    SpectraData                     ("SpectraData",                     true,  "/MzIdentML/DataCollection/Inputs/SpectraData",                                                                                                  false, true,  SpectraData.class,                    null,                                       null,                                           false,  null),
    SpectrumIdentification          ("SpectrumIdentification",          true,  "/MzIdentML/AnalysisCollection/SpectrumIdentification",                                                                                          false, false, SpectrumIdentification.class,         null,                                       null,                                           false,   SpectrumIdentificationRefResolver.class),
    SpectrumIdentificationItem      ("SpectrumIdentificationItem",      true,  "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult/SpectrumIdentificationItem",                     false, false, SpectrumIdentificationItem.class,     SpectrumIdentificationItemCvParam.class,    SpectrumIdentificationItemUserParam.class,      false,   SpectrumIdentificationItemRefResolver.class),
    SpectrumIdentificationItemRef   ("SpectrumIdentificationItemRef",   false, "/MzIdentML/DataCollection/AnalysisData/ProteinDetectionList/ProteinAmbiguityGroup/ProteinDetectionHypothesis/PeptideHypothesis/SpectrumIdentificationItemRef", false, false,  SpectrumIdentificationItemRef.class,  null,                        null,                                           false,  SpectrumIdentificationItemRefRefResolver.class),
    SpectrumIdentificationList      ("SpectrumIdentificationList",      true,  "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList",                                                                             false, true,  SpectrumIdentificationList.class,     SpectrumIdentificationListCvParam.class,    SpectrumIdentificationListUserParam.class,      false,  null),
    SpectrumIdentificationProtocol  ("SpectrumIdentificationProtocol",  true,  "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol",                                                                          false, true,  SpectrumIdentificationProtocol.class, null,                                       null,                                           false ,  SpectrumIdentificationProtocolRefResolver.class),
    SpectrumIdentificationResult    ("SpectrumIdentificationResult",    true,  "/MzIdentML/DataCollection/AnalysisData/SpectrumIdentificationList/SpectrumIdentificationResult",                                                false, false, SpectrumIdentificationResult.class,   SpectrumIdentificationResultCvParam.class,  SpectrumIdentificationResultUserParam.class,    false,   SpectrumIdentificationResultRefResolver.class),
    SpectrumIDFormat                ("SpectrumIDFormat",                false, "/MzIdentML/DataCollection/Inputs/SpectraData/SpectrumIDFormat",                                                                                 false, false, SpectrumIDFormat.class,               SpectrumIDFormatCvParam.class,              null,                                           false,  null),
    SubSample                       ("SubSample",                       false, "/MzIdentML/AnalysisSampleCollection/Sample/SubSample",                                                                                          false, false, SubSample.class,                      null,                                       null,                                           false,  SubSampleRefResolver.class),
    SubstitutionModification        ("SubstitutionModification",        false, "/MzIdentML/SequenceCollection/Peptide/SubstitutionModification",                                                                                false, false, SubstitutionModification.class,       null,                                       null,                                           false,  null),
    Tolerance                       (null,                              false, null, /* multiple tag names */                                                                                                                   false, false, Tolerance.class,                      ToleranceCvParam.class,                     null,                                           false,  null),
    TranslationTable                ("TranslationTable",                true,  "/MzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/DatabaseTranslation/TranslationTable",                                     false, true,  TranslationTable.class,               TranslationTableCvParam.class,              null,                                           false,  null),
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
        // CV (TypeProperties.getIndexing(Cv.class), "/MzIdentML/cvList/cv", TypeProperties.getCaching(Cv.class), Cv.class),
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