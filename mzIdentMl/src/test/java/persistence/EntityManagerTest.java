package persistence;


/**
 * TODO: verify cvparam under AnalysisSoftwareList - does it need a new table?
 *
 */

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import uk.ac.ebi.JmzIdentMLParser;
import uk.ac.ebi.jmzidml.model.mzidml.*;
import uk.ac.ebi.jmzidml.model.mzidml.params.FileFormatCvParam;
import uk.ac.ebi.jmzidml.model.mzidml.params.RoleCvParam;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLMarshaller;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Console;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class EntityManagerTest {

    /*
        Unmarshall AnalysisSoftwareList from the xml file. Iterate through the AnalysisSoftware instances
        and modify the Customizations properties. Persist to db and verify changes committed.
     */
    @Test
    public void testUnmarshallAndPersistAnalysisSoftwareListWithModifications() throws Exception {
        System.err.println("Running testUnmarshallAndPersistAnalysisSoftwareListWithModifications");
        FileWriter writer = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            if (xmlFileURL != null) {
                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
                factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
                session = factory.openSession();
                session.beginTransaction();
                // check the same in another way
                AnalysisSoftwareList asList = unmarshaller.unmarshal(AnalysisSoftwareList.class);
                int count=0;
                for (AnalysisSoftware as : asList.getAnalysisSoftware()) {
                        as.setCustomizations("Modified customization"+count);
                        count++;
                        session.save(as);
                }
                session.getTransaction().commit();
                Query query = session.createQuery("from AnalysisSoftware");
                List<AnalysisSoftware> analysisSoftwareList = query.list();
                Iterator<AnalysisSoftware> it = analysisSoftwareList.iterator();
                count = 0;
                while (it.hasNext()) {
                    AnalysisSoftware analysisSoftware = it.next();
                    assertTrue(analysisSoftware.getCustomizations().equals("Modified customization"+count));
                    count++;
                }

                /**
                 * Ideally this would write out a correctly formed mzIdentML file which could be read back in to
                 * check but that is not possible yet.
                 */
                MzIdentMLMarshaller m = new MzIdentMLMarshaller();
                writer = new FileWriter("testUnmarshallAndPersistAnalysisSoftwareListWithModifications.xml");
                writer.write(m.createMzIdentMLStartTag("1") + "\n");
                m.marshall(asList, writer);
                writer.write("\n");
                writer.write(m.createMzIdentMLClosingTag());
            }
        } finally {
            try {
                session.flush();
                session.close();
                factory.close(); // close at application end
            } catch (Exception e) {

            }
        }
    }


    @Test
    public void testPersistNewObjects() throws Exception {
        SessionFactory factory = null;
        Session session = null;

        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.getTransaction().begin();
            Query query = null;

            // AmbiguousResidue
            AmbiguousResidue ambRes = new AmbiguousResidue();
            ambRes.setCode("testcode");
            session.save(ambRes);
            query = session.createQuery("from AmbiguousResidue");
            assertTrue(((AmbiguousResidue) query.list().get(0)).getCode().equals("testcode"));

            // FileFormat
            FileFormat fileFormat = new FileFormat();
            FileFormatCvParam fileCv = new FileFormatCvParam();
            fileCv.setAccession("fileFormatCvParamAccession");
            fileFormat.setCvParam(fileCv);
            session.save(fileFormat);
            query = session.createQuery("from FileFormat");
            List<FileFormat> fileFormatList = query.list();
            assertTrue(fileFormatList.size() > 0);
            fileFormat = (FileFormat) query.iterate().next();
            assertTrue(fileFormat.getCvParam().getAccession().equals("fileFormatCvParamAccession"));

            // ExternalData
            ExternalData externalData = new ExternalData();
            externalData.setFileFormat(fileFormat);
            session.save(externalData);
            query = session.createQuery("from ExternalData");
            List<ExternalData> externalDataList = query.list();
            externalData = externalDataList.get(0);
            assertTrue(externalData.getFileFormat().getCvParam().getAccession().equals("fileFormatCvParamAccession"));

            // DatabaseFilters
            Filter filter = new Filter();
            DatabaseFilters databaseFilters = new DatabaseFilters();
            databaseFilters.getFilter().add(filter);
            session.save(databaseFilters);
            query = session.createQuery("from DatabaseFilters");
            assertTrue(((DatabaseFilters) query.list().get(0)).getFilter().size() > 0);

            // AnalysisSearchDatabase
            AnalysisSearchDatabase analysisSearchDatabase = new AnalysisSearchDatabase();
            analysisSearchDatabase.setVersion("version1");
            session.save(analysisSearchDatabase);
            query = session.createQuery("from AnalysisSearchDatabase");
            assertTrue(((AnalysisSearchDatabase) query.list().get(0)).getVersion().equals("version1"));

            //Organization
            Organization org = new Organization();
            Organization.Parent parent = new Organization.Parent();
            parent.setOrganizationRef("organizationRef");
            org.setParent(parent);
            org.setName("orgname");
            session.save(org);
            query = session.createQuery("from Organization");
            assertTrue(((Organization) query.list().get(0)).getParent().getOrganizationRef().equals("organizationRef"));
            assertTrue(((Organization) query.list().get(0)).getName().equals("orgname"));

            // AnalysisSoftware
            Role role = new Role();
            RoleCvParam roleCvParam = new RoleCvParam();
            roleCvParam.setAccession("roleaccession");
            role.setCvParam(roleCvParam);
            session.save(role);
            ContactRole contactRole = new ContactRole();
            contactRole.setContact(org);
            contactRole.setRole(role);
            session.save(contactRole);
            AnalysisSoftware analysisSoftware = new AnalysisSoftware();
            analysisSoftware.setContactRole(contactRole);
            analysisSoftware.setCustomizations("thiscustomization");
            session.save(analysisSoftware);
            query = session.createQuery("from AnalysisSoftware");
            assertTrue(((AnalysisSoftware) query.list().get(0)).getCustomizations().equals("thiscustomization"));
            assertTrue(((AnalysisSoftware) query.list().get(0)).getContactRole().getRole().getCvParam().getAccession().equals("roleaccession"));
            assertTrue(((AnalysisSoftware) query.list().get(0)).getContactRole().getContact().getName().equals("orgname"));

            // Affiliations
            Affiliations affiliation = new Affiliations();
            affiliation.setOrganization(org);
            session.save(affiliation);
            query = session.createQuery("from Affiliations");
            assertTrue(((Affiliations) query.list().get(0)).getOrganization().getName().equals("orgname"));

            //Person
            Person person = new Person();
            person.setFirstName("Frank");
            List<Affiliations> affilList = person.getAffiliations();
            affilList.add(affiliation);
            session.save(person);
            query = session.createQuery("from Person");
            assertTrue(((Person) query.list().get(0)).getAffiliations().get(0).getOrganization().getName().equals("orgname"));
            assertTrue(((Person) query.list().get(0)).getFirstName().equals("Frank"));

            // AuditCollection
            AuditCollection auditCollection = new AuditCollection();
            auditCollection.getContactGroup().add(org);
            auditCollection.getContactGroup().add(person);
            session.save(auditCollection);
            query = session.createQuery("from AuditCollection");
            assertTrue(((AuditCollection) query.list().get(0)).getContactGroup().size() == 2);
            assertTrue(((AuditCollection) query.list().get(0)).getContactGroup().get(0).getName().equals("orgname"));
            assertTrue(((Person) ((AuditCollection) query.list().get(0)).getContactGroup().get(1)).getFirstName().equals("Frank"));

            // BibliographicReference
            BibliographicReference biblio = new BibliographicReference();
            biblio.setAuthors("Frank");
            session.save(biblio);
            query = session.createQuery("from BibliographicReference");
            assertTrue(((BibliographicReference) (query.list().get(0))).getAuthors().equals("Frank"));

            // Enzymes
            Enzyme enzyme = new Enzyme();
            enzyme.setMinDistance(new Integer(1));
            Enzymes enzymes = new Enzymes();
            enzymes.getEnzyme().add(enzyme);
            session.save(enzymes);
            query = session.createQuery("from Enzymes");
            assertTrue(((Enzymes)(query.list().get(0))).getEnzyme().size() > 0);
            assertTrue(((Enzymes)(query.list().get(0))).getEnzyme().get(0).getMinDistance().equals(1));

            //FragmentationTable
            Measure measure = new Measure();
            measure.setName("measurename");
            FragmentationTable fragmentationTable = new FragmentationTable();
            fragmentationTable.getMeasure().add(measure);
            session.save(fragmentationTable);
            query = session.createQuery("from FragmentationTable");
            assertTrue(((FragmentationTable)(query.list().get(0))).getMeasure().get(0).getName().equals("measurename"));
            session.getTransaction().commit();
        } finally {
            try {
                session.flush();
                session.close();
                factory.close(); // close at application end
            } catch (Exception e) {

            }
        }
    }

    @Test
    public void testProvider() throws Exception {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            Provider provider = unmarshaller.unmarshal(Provider.class);
            assertNotNull(provider);
            System.out.println("provider software ref " + provider.getSoftwareRef());
            assertTrue(provider.getSoftwareRef().equals("AS_mascot_parser"));
            session.save(provider);
            session.getTransaction().commit();
            Query query = session.createQuery("from Provider");
            List<Provider> providerList = query.list();
            Iterator<Provider> providerIt = providerList.iterator();
            provider = providerIt.next();
            assertTrue(provider.getSoftwareRef().equals("AS_mascot_parser"));
        } finally {
            try {
                session.flush();
                session.close();
                factory.close();
            } catch (Exception e) {

            }
        }
    }

    /**
     * Problems with list of contacts which is an abstract class
     *
     * @throws Exception
     */
    @Test
    public void testAuditCollection() throws Exception {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            AuditCollection auditCollection = unmarshaller.unmarshal(AuditCollection.class);
            assertNotNull(auditCollection);
            List<Contact> contactList = auditCollection.getContactGroup();
            Contact contact = contactList.get(0);
            assertTrue(contact.getId().equals("XX"));
            session.save(auditCollection);
            session.getTransaction().commit();


            /*
            Comment out for now until abstract class issue resolved. Issue is list abstract classes does not
            seem to work with table per concrete class strategy.

            Query query = session.createQuery("from AuditCollection");
            List<AuditCollection> auditCollectionList = query.list();
            System.out.println("Retrieved " + auditCollectionList.size() + " analysis software entries");
            Iterator<AuditCollection> it = auditCollectionList.iterator();
            while(it.hasNext()){
                auditCollection = it.next();
                Iterator<Contact> contactGroupIt = auditCollection.getContactGroup().iterator();
                while(contactGroupIt.hasNext()){
                    contact = contactGroupIt.next();
                    System.out.println("retrieved contact " + contact.getClass().getName());
                    if(contact instanceof Person){
                        System.out.println(((Person)contact).getId());
                    }
                }
            }    */
        } finally {
            try {
                session.flush();
                session.close();
                factory.close();
            } catch (Exception e) {

            }
        }

    }



    /**
     * Problems with base class which has a list of abstract classes.
     *
     * @throws Exception
     */
    @Test
    public void testSample() throws Exception {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            Sample sample = unmarshaller.unmarshal(Sample.class);
            assertNotNull(sample);
            session.save(sample);
            session.getTransaction().commit();


            Query query = session.createQuery("from Sample");
            List<Sample> sampleList = query.list();
            Iterator<Sample> sampleIt = sampleList.iterator();
            sample = sampleIt.next();
            assertTrue(sample.getName().equals("name23"));

            /*
            Comment out for now until abstract class issue resolved. Issue is list abstract classes does not
            seem to work with table per concrete class strategy.

            Query query = session.createQuery("from AuditCollection");
            List<AuditCollection> auditCollectionList = query.list();
            System.out.println("Retrieved " + auditCollectionList.size() + " analysis software entries");
            Iterator<AuditCollection> it = auditCollectionList.iterator();
            while(it.hasNext()){
                auditCollection = it.next();
                Iterator<Contact> contactGroupIt = auditCollection.getContactGroup().iterator();
                while(contactGroupIt.hasNext()){
                    contact = contactGroupIt.next();
                    System.out.println("retrieved contact " + contact.getClass().getName());
                    if(contact instanceof Person){
                        System.out.println(((Person)contact).getId());
                    }
                }
            }    */
        } finally {
            try {
                session.flush();
                session.close();
                factory.close();
            } catch (Exception e) {

            }
        }
    }


    /**
     * Confirmation done by eyeballing db, needs to be automated.
     *
     * @throws Exception
     */
    @Test
    public void testAnalysisSearchDatabase() throws Exception {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            AnalysisSearchDatabase analysisSearchDatabase = unmarshaller.unmarshal(AnalysisSearchDatabase.class);
            System.out.println("name " + analysisSearchDatabase.getName());
            session.save(analysisSearchDatabase);
            session.getTransaction().commit();

            Query query = session.createQuery("from AnalysisSearchDatabase");
            List<AnalysisSearchDatabase> analysisSearchDatabaseList = query.list();
            Iterator<AnalysisSearchDatabase> analysisSearchDatabaseIt = analysisSearchDatabaseList.iterator();
            analysisSearchDatabase = analysisSearchDatabaseIt.next();
            assertTrue(analysisSearchDatabase.getName().equals("SwissProt"));
        } finally {
            try {
                session.flush();
                session.close();
                factory.close();
            } catch (Exception e) {

            }
        }
    }

    /**
     * Problem caused by list of params.
     *
     * @throws Exception
     */
    @Test
    public void testDBSequence() throws Exception {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            DBSequence dbSequence = unmarshaller.unmarshal(DBSequence.class);
            /*System.out.println("db sequence length " + dbSequence.getSeq().length());
            System.out.println("dbsequenece accessions "+ dbSequence.getAccession());
            List<Param> params = dbSequence.getParamGroup();
            Iterator<Param> it = params.iterator();
            while(it.hasNext()){
                Param param = it.next();
                System.out.println("param " + param.getName());
            } */
            session.save(dbSequence);
            session.getTransaction().commit();

            Query query = session.createQuery("from DBSequence");
            List<DBSequence> dbSequenceList = query.list();
            Iterator<DBSequence> dbSequenceIt = dbSequenceList.iterator();
            dbSequence = dbSequenceIt.next();
            assertTrue(dbSequence.getId().equals("DBSeq_HSP7D_MANSE"));
        } finally {
            try {
                session.flush();
                session.close();
                factory.close();
            } catch (Exception e) {

            }
        }
    }

    /**
     * Problem :Peptide and Modification had references to param list.
     *
     * @throws Exception
     */
    @Test
    public void testSequenceCollection() throws Exception {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            SequenceCollection sequenceCollection = unmarshaller.unmarshal(SequenceCollection.class);
            session.save(sequenceCollection);
            session.getTransaction().commit();
            Query query = session.createQuery("from SequenceCollection");
            List<SequenceCollection> sequenceCollectionList = query.list();
            Iterator<SequenceCollection> sequenceCollectionIt = sequenceCollectionList.iterator();
            sequenceCollection = sequenceCollectionIt.next();
            assertTrue(sequenceCollection.getPeptide().size() > 0);
        } finally {
            try {
                session.flush();
                session.close();
                factory.close();
            } catch (Exception e) {

            }
        }

    }


    @Test
    public void testInputSpectra() throws Exception {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            InputSpectra inputSpectra = unmarshaller.unmarshal(InputSpectra.class);
            String spectraDataRef = inputSpectra.getSpectraDataRef();
            session.save(inputSpectra);
            session.getTransaction().commit();
            Query query = session.createQuery("from InputSpectra ");
            Iterator it = query.iterate();
            assertTrue((((InputSpectra) it.next()).getSpectraDataRef()).equals(spectraDataRef));
        } finally {
            try {
                session.flush();
                session.close();
                factory.close();
            } catch (Exception e) {

            }
        }
    }


    //  @Test
    public void testRetrieve() throws Exception {

        try {

            // Use persistence.xml configuration
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_manager");
            EntityManager em = emf.createEntityManager();
            // Work with the EM

            long MzIdentML_id = 1;
            em.getTransaction().begin();

            MzIdentML mzIdentML = em.find(MzIdentML.class, new Long(MzIdentML_id));

            if (mzIdentML == null) {
                System.out.println("Entity not found " + MzIdentML_id);
            }
            em.getTransaction().commit();


            Writer writer = new FileWriter("output_test2.xml");
            //Check marshaling back into a file
            MzIdentMLMarshaller marshaller = new MzIdentMLMarshaller();
            marshaller.marshall(mzIdentML, writer);

            em.close();
            emf.close(); // close at application end


        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
