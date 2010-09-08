
package uk.ac.ebi.jmzidml.model.mzidml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uk.ac.ebi.jmzidml.model.mzidml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Cv_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "cv");
    private final static QName _CvParam_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "cvParam");
    private final static QName _ReferenceableCollection_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "ReferenceableCollection");
    private final static QName _GenericParameter_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericParameter");
    private final static QName _Description_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "Description");
    private final static QName _ContactRole_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "ContactRole");
    private final static QName _EquipmentApplication_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "EquipmentApplication");
    private final static QName _GenericProtocol_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericProtocol");
    private final static QName _GenericEquipment_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericEquipment");
    private final static QName _AuditCollection_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "AuditCollection");
    private final static QName _BibliographicReference_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "BibliographicReference");
    private final static QName _Provider_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "Provider");
    private final static QName _Person_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "Person");
    private final static QName _GenericProtocolApplication_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericProtocolApplication");
    private final static QName _ParameterValue_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "ParameterValue");
    private final static QName _ExternalData_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "ExternalData");
    private final static QName _Organization_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "Organization");
    private final static QName _ActionApplication_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "ActionApplication");
    private final static QName _MzIdentML_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "mzIdentML");
    private final static QName _SoftwareApplication_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "SoftwareApplication");
    private final static QName _Database_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "Database");
    private final static QName _UserParam_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "userParam");
    private final static QName _PropertyValue_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "PropertyValue");
    private final static QName _DatabaseReference_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "DatabaseReference");
    private final static QName _GenericMaterialMeasurement_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericMaterialMeasurement");
    private final static QName _GenericAction_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericAction");
    private final static QName _ParameterPair_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "ParameterPair");
    private final static QName _GenericSoftware_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericSoftware");
    private final static QName _GenericMaterial_QNAME = new QName("http://psidev.info/psi/pi/mzIdentML/1.0", "GenericMaterial");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uk.ac.ebi.jmzidml.model.mzidml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ParameterPair.TargetParameter }
     * 
     */
    public ParameterPair.TargetParameter createParameterPairTargetParameter() {
        return new ParameterPair.TargetParameter();
    }

    /**
     * Create an instance of {@link GenericProtocol.Software }
     * 
     */
    public GenericProtocol.Software createGenericProtocolSoftware() {
        return new GenericProtocol.Software();
    }

    /**
     * Create an instance of {@link GenericEquipment.Software }
     * 
     */
    public GenericEquipment.Software createGenericEquipmentSoftware() {
        return new GenericEquipment.Software();
    }

    /**
     * Create an instance of {@link PeptideEvidence }
     * 
     */
    public PeptideEvidence createPeptideEvidence() {
        return new PeptideEvidence();
    }

    /**
     * Create an instance of {@link SpectrumIdentificationList }
     * 
     */
    public SpectrumIdentificationList createSpectrumIdentificationList() {
        return new SpectrumIdentificationList();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link ActionApplication.ActionDeviation }
     * 
     */
    public ActionApplication.ActionDeviation createActionApplicationActionDeviation() {
        return new ActionApplication.ActionDeviation();
    }

    /**
     * Create an instance of {@link ParameterPair }
     * 
     */
    public ParameterPair createParameterPair() {
        return new ParameterPair();
    }

    /**
     * Create an instance of {@link ParamAlternativeList }
     * 
     */
    public ParamAlternativeList createParamAlternativeList() {
        return new ParamAlternativeList();
    }

    /**
     * Create an instance of {@link CvList }
     * 
     */
    public CvList createCvList() {
        return new CvList();
    }

    /**
     * Create an instance of {@link GenericProtocol }
     * 
     */
    public GenericProtocol createGenericProtocol() {
        return new GenericProtocol();
    }

    /**
     * Create an instance of {@link ReferenceableCollection }
     * 
     */
    public ReferenceableCollection createReferenceableCollection() {
        return new ReferenceableCollection();
    }

    /**
     * Create an instance of {@link PeptideHypothesis }
     * 
     */
    public PeptideHypothesis createPeptideHypothesis() {
        return new PeptideHypothesis();
    }

    /**
     * Create an instance of {@link Range.RangeDescriptors }
     * 
     */
    public Range.RangeDescriptors createRangeRangeDescriptors() {
        return new Range.RangeDescriptors();
    }

    /**
     * Create an instance of {@link SubSample }
     * 
     */
    public SubSample createSubSample() {
        return new SubSample();
    }

    /**
     * Create an instance of {@link AtomicValue }
     * 
     */
    public AtomicValue createAtomicValue() {
        return new AtomicValue();
    }

    /**
     * Create an instance of {@link GenericParameter.ParameterType }
     * 
     */
    public GenericParameter.ParameterType createGenericParameterParameterType() {
        return new GenericParameter.ParameterType();
    }

    /**
     * Create an instance of {@link Fragmentation }
     * 
     */
    public Fragmentation createFragmentation() {
        return new Fragmentation();
    }

    /**
     * Create an instance of {@link InputSpectra }
     * 
     */
    public InputSpectra createInputSpectra() {
        return new InputSpectra();
    }

    /**
     * Create an instance of {@link AnalysisSearchDatabase }
     * 
     */
    public AnalysisSearchDatabase createAnalysisSearchDatabase() {
        return new AnalysisSearchDatabase();
    }

    /**
     * Create an instance of {@link SpectrumIdentificationResult }
     * 
     */
    public SpectrumIdentificationResult createSpectrumIdentificationResult() {
        return new SpectrumIdentificationResult();
    }

    /**
     * Create an instance of {@link ProteinDetectionProtocol }
     * 
     */
    public ProteinDetectionProtocol createProteinDetectionProtocol() {
        return new ProteinDetectionProtocol();
    }

    /**
     * Create an instance of {@link Enzyme }
     * 
     */
    public Enzyme createEnzyme() {
        return new Enzyme();
    }

    /**
     * Create an instance of {@link Residue }
     * 
     */
    public Residue createResidue() {
        return new Residue();
    }

    /**
     * Create an instance of {@link DatabaseFilters }
     * 
     */
    public DatabaseFilters createDatabaseFilters() {
        return new DatabaseFilters();
    }

    /**
     * Create an instance of {@link Measure }
     * 
     */
    public Measure createMeasure() {
        return new Measure();
    }

    /**
     * Create an instance of {@link ProteinDetection }
     * 
     */
    public ProteinDetection createProteinDetection() {
        return new ProteinDetection();
    }

    /**
     * Create an instance of {@link GenericProtocol.Equipment }
     * 
     */
    public GenericProtocol.Equipment createGenericProtocolEquipment() {
        return new GenericProtocol.Equipment();
    }

    /**
     * Create an instance of {@link SpectrumIdentificationProtocol }
     * 
     */
    public SpectrumIdentificationProtocol createSpectrumIdentificationProtocol() {
        return new SpectrumIdentificationProtocol();
    }

    /**
     * Create an instance of {@link GenericProtocolApplication.InputData }
     * 
     */
    public GenericProtocolApplication.InputData createGenericProtocolApplicationInputData() {
        return new GenericProtocolApplication.InputData();
    }

    /**
     * Create an instance of {@link ProteinDetectionList }
     * 
     */
    public ProteinDetectionList createProteinDetectionList() {
        return new ProteinDetectionList();
    }

    /**
     * Create an instance of {@link Provider }
     * 
     */
    public Provider createProvider() {
        return new Provider();
    }

    /**
     * Create an instance of {@link SpectrumIDFormat }
     * 
     */
    public SpectrumIDFormat createSpectrumIDFormat() {
        return new SpectrumIDFormat();
    }

    /**
     * Create an instance of {@link DatabaseReference }
     * 
     */
    public DatabaseReference createDatabaseReference() {
        return new DatabaseReference();
    }

    /**
     * Create an instance of {@link CvParam }
     * 
     */
    public CvParam createCvParam() {
        return new CvParam();
    }

    /**
     * Create an instance of {@link SearchModification }
     * 
     */
    public SearchModification createSearchModification() {
        return new SearchModification();
    }

    /**
     * Create an instance of {@link ParameterPair.SourceParameter }
     * 
     */
    public ParameterPair.SourceParameter createParameterPairSourceParameter() {
        return new ParameterPair.SourceParameter();
    }

    /**
     * Create an instance of {@link Tolerance }
     * 
     */
    public Tolerance createTolerance() {
        return new Tolerance();
    }

    /**
     * Create an instance of {@link AnalysisCollection }
     * 
     */
    public AnalysisCollection createAnalysisCollection() {
        return new AnalysisCollection();
    }

    /**
     * Create an instance of {@link Enzymes }
     * 
     */
    public Enzymes createEnzymes() {
        return new Enzymes();
    }

    /**
     * Create an instance of {@link UserParam }
     * 
     */
    public UserParam createUserParam() {
        return new UserParam();
    }

    /**
     * Create an instance of {@link AuditCollection }
     * 
     */
    public AuditCollection createAuditCollection() {
        return new AuditCollection();
    }

    /**
     * Create an instance of {@link MassTable }
     * 
     */
    public MassTable createMassTable() {
        return new MassTable();
    }

    /**
     * Create an instance of {@link BooleanValue }
     * 
     */
    public BooleanValue createBooleanValue() {
        return new BooleanValue();
    }

    /**
     * Create an instance of {@link ExternalData.FileFormat }
     * 
     */
    public ExternalData.FileFormat createExternalDataFileFormat() {
        return new ExternalData.FileFormat();
    }

    /**
     * Create an instance of {@link ProteinDetectionHypothesis }
     * 
     */
    public ProteinDetectionHypothesis createProteinDetectionHypothesis() {
        return new ProteinDetectionHypothesis();
    }

    /**
     * Create an instance of {@link SearchDatabase }
     * 
     */
    public SearchDatabase createSearchDatabase() {
        return new SearchDatabase();
    }

    /**
     * Create an instance of {@link Range.UpperLimit }
     * 
     */
    public Range.UpperLimit createRangeUpperLimit() {
        return new Range.UpperLimit();
    }

    /**
     * Create an instance of {@link GenericProtocolApplication.OutputMaterials }
     * 
     */
    public GenericProtocolApplication.OutputMaterials createGenericProtocolApplicationOutputMaterials() {
        return new GenericProtocolApplication.OutputMaterials();
    }

    /**
     * Create an instance of {@link ContactRole }
     * 
     */
    public ContactRole createContactRole() {
        return new ContactRole();
    }

    /**
     * Create an instance of {@link MzIdentML }
     * 
     */
    public MzIdentML createMzIdentML() {
        return new MzIdentML();
    }

    /**
     * Create an instance of {@link AnalysisProtocolCollection }
     * 
     */
    public AnalysisProtocolCollection createAnalysisProtocolCollection() {
        return new AnalysisProtocolCollection();
    }

    /**
     * Create an instance of {@link AnalysisSoftware }
     * 
     */
    public AnalysisSoftware createAnalysisSoftware() {
        return new AnalysisSoftware();
    }

    /**
     * Create an instance of {@link GenericEquipment }
     * 
     */
    public GenericEquipment createGenericEquipment() {
        return new GenericEquipment();
    }

    /**
     * Create an instance of {@link FragmentationTable }
     * 
     */
    public FragmentationTable createFragmentationTable() {
        return new FragmentationTable();
    }

    /**
     * Create an instance of {@link GenericMaterialMeasurement }
     * 
     */
    public GenericMaterialMeasurement createGenericMaterialMeasurement() {
        return new GenericMaterialMeasurement();
    }

    /**
     * Create an instance of {@link ExternalData }
     * 
     */
    public ExternalData createExternalData() {
        return new ExternalData();
    }

    /**
     * Create an instance of {@link SpectrumIdentification }
     * 
     */
    public SpectrumIdentification createSpectrumIdentification() {
        return new SpectrumIdentification();
    }

    /**
     * Create an instance of {@link BibliographicReference }
     * 
     */
    public BibliographicReference createBibliographicReference() {
        return new BibliographicReference();
    }

    /**
     * Create an instance of {@link DatabaseTranslation }
     * 
     */
    public DatabaseTranslation createDatabaseTranslation() {
        return new DatabaseTranslation();
    }

    /**
     * Create an instance of {@link GenericAction }
     * 
     */
    public GenericAction createGenericAction() {
        return new GenericAction();
    }

    /**
     * Create an instance of {@link GenericProtocolApplication.OutputData }
     * 
     */
    public GenericProtocolApplication.OutputData createGenericProtocolApplicationOutputData() {
        return new GenericProtocolApplication.OutputData();
    }

    /**
     * Create an instance of {@link FragmentArray }
     * 
     */
    public FragmentArray createFragmentArray() {
        return new FragmentArray();
    }

    /**
     * Create an instance of {@link ParameterValue }
     * 
     */
    public ParameterValue createParameterValue() {
        return new ParameterValue();
    }

    /**
     * Create an instance of {@link Cv }
     * 
     */
    public Cv createCv() {
        return new Cv();
    }

    /**
     * Create an instance of {@link ModParam }
     * 
     */
    public ModParam createModParam() {
        return new ModParam();
    }

    /**
     * Create an instance of {@link GenericProtocolApplication }
     * 
     */
    public GenericProtocolApplication createGenericProtocolApplication() {
        return new GenericProtocolApplication();
    }

    /**
     * Create an instance of {@link PropertyValue }
     * 
     */
    public PropertyValue createPropertyValue() {
        return new PropertyValue();
    }

    /**
     * Create an instance of {@link GenericSoftware }
     * 
     */
    public GenericSoftware createGenericSoftware() {
        return new GenericSoftware();
    }

    /**
     * Create an instance of {@link GenericSoftware.Equipment }
     * 
     */
    public GenericSoftware.Equipment createGenericSoftwareEquipment() {
        return new GenericSoftware.Equipment();
    }

    /**
     * Create an instance of {@link SpectraData }
     * 
     */
    public SpectraData createSpectraData() {
        return new SpectraData();
    }

    /**
     * Create an instance of {@link GenericEquipment.EquipmentParts }
     * 
     */
    public GenericEquipment.EquipmentParts createGenericEquipmentEquipmentParts() {
        return new GenericEquipment.EquipmentParts();
    }

    /**
     * Create an instance of {@link DataCollection }
     * 
     */
    public DataCollection createDataCollection() {
        return new DataCollection();
    }

    /**
     * Create an instance of {@link SequenceCollection }
     * 
     */
    public SequenceCollection createSequenceCollection() {
        return new SequenceCollection();
    }

    /**
     * Create an instance of {@link GenericAction.ActionTerm }
     * 
     */
    public GenericAction.ActionTerm createGenericActionActionTerm() {
        return new GenericAction.ActionTerm();
    }

    /**
     * Create an instance of {@link Person.Affiliations }
     * 
     */
    public Person.Affiliations createPersonAffiliations() {
        return new Person.Affiliations();
    }

    /**
     * Create an instance of {@link GenericParameter }
     * 
     */
    public GenericParameter createGenericParameter() {
        return new GenericParameter();
    }

    /**
     * Create an instance of {@link InputSpectrumIdentifications }
     * 
     */
    public InputSpectrumIdentifications createInputSpectrumIdentifications() {
        return new InputSpectrumIdentifications();
    }

    /**
     * Create an instance of {@link Modification }
     * 
     */
    public Modification createModification() {
        return new Modification();
    }

    /**
     * Create an instance of {@link TranslationTable }
     * 
     */
    public TranslationTable createTranslationTable() {
        return new TranslationTable();
    }

    /**
     * Create an instance of {@link DBSequence }
     * 
     */
    public DBSequence createDBSequence() {
        return new DBSequence();
    }

    /**
     * Create an instance of {@link EquipmentApplication }
     * 
     */
    public EquipmentApplication createEquipmentApplication() {
        return new EquipmentApplication();
    }

    /**
     * Create an instance of {@link ModificationParams }
     * 
     */
    public ModificationParams createModificationParams() {
        return new ModificationParams();
    }

    /**
     * Create an instance of {@link ProteinAmbiguityGroup }
     * 
     */
    public ProteinAmbiguityGroup createProteinAmbiguityGroup() {
        return new ProteinAmbiguityGroup();
    }

    /**
     * Create an instance of {@link Filter }
     * 
     */
    public Filter createFilter() {
        return new Filter();
    }

    /**
     * Create an instance of {@link Sample }
     * 
     */
    public Sample createSample() {
        return new Sample();
    }

    /**
     * Create an instance of {@link SoftwareApplication }
     * 
     */
    public SoftwareApplication createSoftwareApplication() {
        return new SoftwareApplication();
    }

    /**
     * Create an instance of {@link AnalysisSoftwareList }
     * 
     */
    public AnalysisSoftwareList createAnalysisSoftwareList() {
        return new AnalysisSoftwareList();
    }

    /**
     * Create an instance of {@link SpecificityRules }
     * 
     */
    public SpecificityRules createSpecificityRules() {
        return new SpecificityRules();
    }

    /**
     * Create an instance of {@link ContactRole.Role }
     * 
     */
    public ContactRole.Role createContactRoleRole() {
        return new ContactRole.Role();
    }

    /**
     * Create an instance of {@link GenericMaterial }
     * 
     */
    public GenericMaterial createGenericMaterial() {
        return new GenericMaterial();
    }

    /**
     * Create an instance of {@link Organization.Parent }
     * 
     */
    public Organization.Parent createOrganizationParent() {
        return new Organization.Parent();
    }

    /**
     * Create an instance of {@link ActionApplication }
     * 
     */
    public ActionApplication createActionApplication() {
        return new ActionApplication();
    }

    /**
     * Create an instance of {@link Database }
     * 
     */
    public Database createDatabase() {
        return new Database();
    }

    /**
     * Create an instance of {@link SourceFile }
     * 
     */
    public SourceFile createSourceFile() {
        return new SourceFile();
    }

    /**
     * Create an instance of {@link Inputs }
     * 
     */
    public Inputs createInputs() {
        return new Inputs();
    }

    /**
     * Create an instance of {@link Peptide }
     * 
     */
    public Peptide createPeptide() {
        return new Peptide();
    }

    /**
     * Create an instance of {@link ComplexValue }
     * 
     */
    public ComplexValue createComplexValue() {
        return new ComplexValue();
    }

    /**
     * Create an instance of {@link GenericProtocolApplication.InputCompleteMaterials }
     * 
     */
    public GenericProtocolApplication.InputCompleteMaterials createGenericProtocolApplicationInputCompleteMaterials() {
        return new GenericProtocolApplication.InputCompleteMaterials();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link GenericMaterial.Components }
     * 
     */
    public GenericMaterial.Components createGenericMaterialComponents() {
        return new GenericMaterial.Components();
    }

    /**
     * Create an instance of {@link IonType }
     * 
     */
    public IonType createIonType() {
        return new IonType();
    }

    /**
     * Create an instance of {@link Organization }
     * 
     */
    public Organization createOrganization() {
        return new Organization();
    }

    /**
     * Create an instance of {@link ParamAlternative }
     * 
     */
    public ParamAlternative createParamAlternative() {
        return new ParamAlternative();
    }

    /**
     * Create an instance of {@link AmbiguousResidue }
     * 
     */
    public AmbiguousResidue createAmbiguousResidue() {
        return new AmbiguousResidue();
    }

    /**
     * Create an instance of {@link SubstitutionModification }
     * 
     */
    public SubstitutionModification createSubstitutionModification() {
        return new SubstitutionModification();
    }

    /**
     * Create an instance of {@link Range.LowerLimit }
     * 
     */
    public Range.LowerLimit createRangeLowerLimit() {
        return new Range.LowerLimit();
    }

    /**
     * Create an instance of {@link AnalysisData }
     * 
     */
    public AnalysisData createAnalysisData() {
        return new AnalysisData();
    }

    /**
     * Create an instance of {@link SpectrumIdentificationItem }
     * 
     */
    public SpectrumIdentificationItem createSpectrumIdentificationItem() {
        return new SpectrumIdentificationItem();
    }

    /**
     * Create an instance of {@link Range }
     * 
     */
    public Range createRange() {
        return new Range();
    }

    /**
     * Create an instance of {@link AnalysisSampleCollection }
     * 
     */
    public AnalysisSampleCollection createAnalysisSampleCollection() {
        return new AnalysisSampleCollection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "cv")
    public JAXBElement<Cv> createCv(Cv value) {
        return new JAXBElement<Cv>(_Cv_QNAME, Cv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CvParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "cvParam")
    public JAXBElement<CvParam> createCvParam(CvParam value) {
        return new JAXBElement<CvParam>(_CvParam_QNAME, CvParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceableCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "ReferenceableCollection")
    public JAXBElement<ReferenceableCollection> createReferenceableCollection(ReferenceableCollection value) {
        return new JAXBElement<ReferenceableCollection>(_ReferenceableCollection_QNAME, ReferenceableCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericParameter")
    public JAXBElement<GenericParameter> createGenericParameter(GenericParameter value) {
        return new JAXBElement<GenericParameter>(_GenericParameter_QNAME, GenericParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Description }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "Description")
    public JAXBElement<Description> createDescription(Description value) {
        return new JAXBElement<Description>(_Description_QNAME, Description.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "ContactRole")
    public JAXBElement<ContactRole> createContactRole(ContactRole value) {
        return new JAXBElement<ContactRole>(_ContactRole_QNAME, ContactRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EquipmentApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "EquipmentApplication")
    public JAXBElement<EquipmentApplication> createEquipmentApplication(EquipmentApplication value) {
        return new JAXBElement<EquipmentApplication>(_EquipmentApplication_QNAME, EquipmentApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericProtocol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericProtocol")
    public JAXBElement<GenericProtocol> createGenericProtocol(GenericProtocol value) {
        return new JAXBElement<GenericProtocol>(_GenericProtocol_QNAME, GenericProtocol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericEquipment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericEquipment")
    public JAXBElement<GenericEquipment> createGenericEquipment(GenericEquipment value) {
        return new JAXBElement<GenericEquipment>(_GenericEquipment_QNAME, GenericEquipment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuditCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "AuditCollection")
    public JAXBElement<AuditCollection> createAuditCollection(AuditCollection value) {
        return new JAXBElement<AuditCollection>(_AuditCollection_QNAME, AuditCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BibliographicReference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "BibliographicReference")
    public JAXBElement<BibliographicReference> createBibliographicReference(BibliographicReference value) {
        return new JAXBElement<BibliographicReference>(_BibliographicReference_QNAME, BibliographicReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Provider }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "Provider")
    public JAXBElement<Provider> createProvider(Provider value) {
        return new JAXBElement<Provider>(_Provider_QNAME, Provider.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "Person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericProtocolApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericProtocolApplication")
    public JAXBElement<GenericProtocolApplication> createGenericProtocolApplication(GenericProtocolApplication value) {
        return new JAXBElement<GenericProtocolApplication>(_GenericProtocolApplication_QNAME, GenericProtocolApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "ParameterValue")
    public JAXBElement<ParameterValue> createParameterValue(ParameterValue value) {
        return new JAXBElement<ParameterValue>(_ParameterValue_QNAME, ParameterValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "ExternalData")
    public JAXBElement<ExternalData> createExternalData(ExternalData value) {
        return new JAXBElement<ExternalData>(_ExternalData_QNAME, ExternalData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "Organization")
    public JAXBElement<Organization> createOrganization(Organization value) {
        return new JAXBElement<Organization>(_Organization_QNAME, Organization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActionApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "ActionApplication")
    public JAXBElement<ActionApplication> createActionApplication(ActionApplication value) {
        return new JAXBElement<ActionApplication>(_ActionApplication_QNAME, ActionApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MzIdentML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "mzIdentML")
    public JAXBElement<MzIdentML> createMzIdentML(MzIdentML value) {
        return new JAXBElement<MzIdentML>(_MzIdentML_QNAME, MzIdentML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoftwareApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "SoftwareApplication")
    public JAXBElement<SoftwareApplication> createSoftwareApplication(SoftwareApplication value) {
        return new JAXBElement<SoftwareApplication>(_SoftwareApplication_QNAME, SoftwareApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Database }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "Database")
    public JAXBElement<Database> createDatabase(Database value) {
        return new JAXBElement<Database>(_Database_QNAME, Database.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "userParam")
    public JAXBElement<UserParam> createUserParam(UserParam value) {
        return new JAXBElement<UserParam>(_UserParam_QNAME, UserParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "PropertyValue")
    public JAXBElement<PropertyValue> createPropertyValue(PropertyValue value) {
        return new JAXBElement<PropertyValue>(_PropertyValue_QNAME, PropertyValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatabaseReference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "DatabaseReference")
    public JAXBElement<DatabaseReference> createDatabaseReference(DatabaseReference value) {
        return new JAXBElement<DatabaseReference>(_DatabaseReference_QNAME, DatabaseReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericMaterialMeasurement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericMaterialMeasurement")
    public JAXBElement<GenericMaterialMeasurement> createGenericMaterialMeasurement(GenericMaterialMeasurement value) {
        return new JAXBElement<GenericMaterialMeasurement>(_GenericMaterialMeasurement_QNAME, GenericMaterialMeasurement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericAction")
    public JAXBElement<GenericAction> createGenericAction(GenericAction value) {
        return new JAXBElement<GenericAction>(_GenericAction_QNAME, GenericAction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterPair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "ParameterPair")
    public JAXBElement<ParameterPair> createParameterPair(ParameterPair value) {
        return new JAXBElement<ParameterPair>(_ParameterPair_QNAME, ParameterPair.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericSoftware }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericSoftware")
    public JAXBElement<GenericSoftware> createGenericSoftware(GenericSoftware value) {
        return new JAXBElement<GenericSoftware>(_GenericSoftware_QNAME, GenericSoftware.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericMaterial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://psidev.info/psi/pi/mzIdentML/1.0", name = "GenericMaterial")
    public JAXBElement<GenericMaterial> createGenericMaterial(GenericMaterial value) {
        return new JAXBElement<GenericMaterial>(_GenericMaterial_QNAME, GenericMaterial.class, null, value);
    }

}
