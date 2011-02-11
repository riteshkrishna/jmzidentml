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
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLMarshaller;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class EntityManagerTest {



    /*
           Unmarshall AnalysisSoftwareList from the xml file and persist to the database.
     */
   /* @Test
    public void testUnmarshallAndPersistAnalysisSoftwareList() throws Exception {
        SessionFactory factory=null;
        Session session = null;

        try{
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            if (xmlFileURL != null) {
                // 1. parse file
                boolean aUseSpectrumCache = true;
                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
                factory = new Configuration().configure("/META-INF/hibernate.cfg.xml").buildSessionFactory();
                session = factory.openSession();
                // check the same in another way
                AnalysisSoftwareList asList = unmarshaller.unmarshal(AnalysisSoftwareList.class);
                for (AnalysisSoftware as : asList.getAnalysisSoftware()) {
                    try{
                        System.out.println("Processing AnalysisSoftware " + as.getSoftwareName());
                        session.save(as);

                        /*
                            TODO Automate retrieval and confirmation so eyeballing db
                            isnt necessary

                         */
                     /*
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(Exception e){
            Assert.fail();
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
            factory.close(); // close at application end
        }
    }
        */
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
            try{
                URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
//            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("spec2_F001242.mzid");
//            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("output_test.xml");

                if (xmlFileURL != null) {
                    boolean aUseSpectrumCache = true;
                    MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
                    factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
                    session = factory.openSession();
                    session.beginTransaction();
                    // check the same in another way
                    AnalysisSoftwareList asList = unmarshaller.unmarshal(AnalysisSoftwareList.class);
                    for (AnalysisSoftware as : asList.getAnalysisSoftware()) {
                        try{
                            System.out.println("Processing AnalysisSoftware " + as.getName());
                            as.setCustomizations("Modified customization");
                            System.out.println("set new value for customizations");
                            session.save(as);
                            System.out.println("session saved");
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    session.getTransaction().commit();
                    Query query = session.createQuery("from AnalysisSoftware");
                    List<AnalysisSoftware> analysisSoftwareList = query.list();
                    System.out.println("Retrieved " + analysisSoftwareList.size() + " analysis software entries");
                    Iterator<AnalysisSoftware> it = analysisSoftwareList.iterator();
                    while(it.hasNext()){
                        AnalysisSoftware analysisSoftware = it.next();
                        System.out.println("Retrieved analysis software with customizations " + analysisSoftware.getCustomizations());
                    }

                    MzIdentMLMarshaller m = new MzIdentMLMarshaller();
                    assertNotNull(m);
                    writer = new FileWriter("testUnmarshallAndPersistAnalysisSoftwareListWithModifications.xml");
                    writer.write(m.createMzIdentMLStartTag("1") +"\n");
                    m.marshall(asList, writer);
                    writer.write("\n");
                    writer.write(m.createMzIdentMLClosingTag());
                }
            }catch(Exception e){
                //e.printStackTrace();
            }finally{
                try{
                    session.flush();
                    session.close();
                    factory.close(); // close at application end
                }catch(Exception e){

                }
            }
        }



    @Test
    public void testPersistNewObjects() throws Exception {
        SessionFactory factory=null;
        Session session = null;

        try {
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            boolean aUseSpectrumCache = true;
                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
                Cv cv = (Cv) unmarshaller.unmarshal(Cv.class);
                assertNotNull(cv);
                //CvParam cvParam = new CvParam();
                //cvParam.setName("testcvparam");
                factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
                session = factory.openSession();
                session.getTransaction().begin();
                session.save(cv);
                session.save(cv);
                CvList cvList = new CvList();
                List list = cvList.getCv();
                list.add(cv);
                cv = new Cv();
                session.save(cv);
                list.add(cv);
                session.save(cvList);
                //cvParam.setCv(cv);
                //session.save(cvParam);
                AmbiguousResidue ambRes = new AmbiguousResidue();
                ambRes.setCode("testcode");
                session.save(ambRes);
                FileFormat fileFormat = new FileFormat();
               // fileFormat.setCvParam(cvParam);
                session.save(fileFormat);
                fileFormat = new FileFormat();
               // fileFormat.setCvParam(cvParam);
                session.save(fileFormat);
                ExternalData externalData = new ExternalData();
                externalData.setFileFormat(fileFormat);
                session.save(externalData);
                Filter filter = new Filter();
                session.save(filter);
                FragmentArray fragmentArray = new FragmentArray();
                session.save(fragmentArray);
                DatabaseFilters databaseFilters = new DatabaseFilters();
                databaseFilters.getFilter().add(filter);
                session.save(databaseFilters);
                AnalysisSearchDatabase analysisSearchDatabase = new AnalysisSearchDatabase();
                List<CvParam> searchDbList = analysisSearchDatabase.getCvParam();
               // searchDbList.add(cvParam);
                session.save(analysisSearchDatabase);
                Organization org = new Organization();
                Organization.Parent parent = new Organization.Parent();
                org.setParent(parent);
                session.save(org);
                Role role = new Role();
               // role.setCvParam(cvParam);
                session.save(role);
                ContactRole contactRole = new ContactRole();
                contactRole.setContact(org);
                contactRole.setRole(role);
                session.save(contactRole);
                AnalysisSoftware analysisSoftware = new AnalysisSoftware();
                analysisSoftware.setContactRole(contactRole);
                session.save(analysisSoftware);
                Affiliations affiliation = new Affiliations();
                affiliation.setOrganization(org);
                session.save(affiliation);
                Person person = new Person();
                person.setFirstName("Frank");
                List<Affiliations> affilList = person.getAffiliations();
                affilList.add(affiliation);
                session.save(person);
                AuditCollection auditCollection = new AuditCollection();
                auditCollection.getContactGroup().add(org);
                auditCollection.getContactGroup().add(person);
                session.save(auditCollection);
                BibliographicReference biblio = new BibliographicReference();
                biblio.setAuthors("Frank");
                session.save(biblio);
                Enzyme enzyme = new Enzyme();
                enzyme.setMinDistance(new Integer(1));
                Enzymes enzymes = new Enzymes();
                enzymes.getEnzyme().add(enzyme);
                session.save(enzymes);
                session.save(enzyme);
                Measure measure = new Measure();
                //measure.getCvParam().add(cvParam);
                FragmentationTable fragmentationTable = new FragmentationTable();
                fragmentationTable.getMeasure().add(measure);
                session.save(fragmentationTable);
                session.getTransaction().commit();
        } catch (Exception e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally{
            try{
                session.flush();
                session.close();
                factory.close(); // close at application end
            }catch(Exception e){

            }
        }
    }

    @Test
    public void testProvider() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
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
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }
    }

    /**
     * Problems with list of contacts which is an abstract class
     * @throws Exception
     */
    @Test
    public void testAuditCollection() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
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
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }

    }

    /**
     * Contains a reference to Sample which has a problem with a list of abstract base classes.
     *
     * @throws Exception
     */
    @Test
    public void testAnalysisSampleCollection() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            AnalysisSampleCollection analysisSampleCollection = unmarshaller.unmarshal(AnalysisSampleCollection.class);
            assertNotNull(analysisSampleCollection);
            session.save(analysisSampleCollection);
            session.getTransaction().commit();
            Query query = session.createQuery("from AnalysisSampleCollection");
            List<AnalysisSampleCollection> analysisSampleCollectionList = query.list();
            Iterator<AnalysisSampleCollection> analysisSampleCollectionIt = analysisSampleCollectionList.iterator();
            analysisSampleCollection = analysisSampleCollectionIt.next();
            assertNotNull(analysisSampleCollection);
            Iterator<Sample> sampleIt = analysisSampleCollection.getSample().iterator();
            assertTrue(sampleIt.hasNext());
            assertTrue(analysisSampleCollection.getSample().iterator().next().getName().equals("name23"));
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }

    }

    /**
     * Problems with base class which has a list of abstract classes.
     *
     * @throws Exception
     */
    @Test
    public void testSample() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
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
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }
    }

    /**
     * Doesnt work yet. Dependencies not completed.
     * @throws Exception
     */
    /*
    @Test
    public void testRetrieveProteinDetection() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            ProteinDetection proteinDetection = unmarshaller.unmarshal(ProteinDetection.class);
            assertNotNull(proteinDetection);
            assertTrue(proteinDetection.getId().equals("PD_1"));
            session.save(proteinDetection);
            session.getTransaction().commit();
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }
    }         */


    @Test
    public void testAnalysisSearchDatabase() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
            MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
            AnalysisSearchDatabase analysisSearchDatabase = unmarshaller.unmarshal(AnalysisSearchDatabase.class);
            session.save(analysisSearchDatabase);
            session.getTransaction().commit();
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }
    }

    /**
     * Problem caused by list of params.
     *
     * @throws Exception
     */
    @Test
    public void testDBSequence() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
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
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }
    }

    /**
     *  Problem :Peptide and Modification had references to param list.
     * @throws Exception
     */
    @Test
    public void testSequenceCollection() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
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
            assertTrue(sequenceCollection.getPeptide().size()>0);
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }

    }


    @Test
    public void testSearchDatabase() throws Exception{
        SessionFactory factory = null;
        Session session = null;
        try{
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
            assertTrue(sequenceCollection.getPeptide().size()>0);
        }finally{
            try{
                session.flush();
                session.close();
                factory.close();
            }catch(Exception e){

            }
        }

    }

    @Test
    public void testSpectrumIdentification() throws Exception{
        SessionFactory factory = null;
            Session session = null;
            try{
                factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
                session = factory.openSession();
                session.beginTransaction();
                URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
                SpectrumIdentification spectrumIdentification = unmarshaller.unmarshal(SpectrumIdentification.class);
                String name = spectrumIdentification.getName();
                session.save(spectrumIdentification);
                session.getTransaction().commit();
                Query query = session.createQuery("from SpectrumIdentification");
                assertTrue(spectrumIdentification.getName().equals(name));
            }catch(Exception e){
                e.printStackTrace();
            }


            finally{
                try{
                    session.flush();
                    session.close();
                    factory.close();
                }catch(Exception e){

                }
            }
    }

    @Test
    public void testInputSpectra() throws Exception{
        SessionFactory factory = null;
            Session session = null;
            try{
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
                assertTrue(inputSpectra.getSpectraDataRef().equals(spectraDataRef));
            }finally{
                try{
                    session.flush();
                    session.close();
                    factory.close();
                }catch(Exception e){

                }
            }
    }

    @Test
    public void testSearchModification() throws Exception{
        SessionFactory factory = null;
        Session session = null;
            try{
                factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
                session = factory.openSession();
                session.beginTransaction();
                URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
                SearchModification searchModification = unmarshaller.unmarshal(SearchModification.class);
                session.save(searchModification);
                session.getTransaction().commit();
                Query query = session.createQuery("from SearchModification");

            }catch(Exception e){
             e.printStackTrace();
            }
            finally
            {
                try{
                    session.flush();
                    session.close();
                    factory.close();
                }catch(Exception e){

                }
            }
    }

    /**
     * Setting modparams line in MzIdentMLElement to:
     *     ModParam                        ("ModParam",                        true, "/mzIdentML/AnalysisProtocolCollection/SpectrumIdentificationProtocol/ModificationParams/SearchModification",                                                                                                                                            false, false, ModParam.class,                       ModParamCvParam.class,                      null,                                           false,  null),
     *     allows unmarshalling to succeed
     * @throws Exception
     */
    @Test
    public void testModParams() throws Exception{
        SessionFactory factory = null;
        Session session = null;
            try{
                factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
                session = factory.openSession();
                session.beginTransaction();
                URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
                ModParam modParam = unmarshaller.unmarshal(ModParam.class);
                System.out.println("modparam " + modParam.getResidues());
                session.save(modParam);
                session.getTransaction().commit();
                Query query = session.createQuery("from ModParam");

            }finally{
                try{
                    session.flush();
                    session.close();
                    factory.close();
                }catch(Exception e){

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
