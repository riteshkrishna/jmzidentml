package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import uk.ac.ebi.JmzIdentMLParser;
import uk.ac.ebi.jmzidml.model.mzidml.MzIdentML;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLMarshaller;
import uk.ac.ebi.jmzidml.xml.io.MzIdentMLUnmarshaller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;

public class EntityManagerTest {

    @Test
    public void testPersist() throws Exception {

        try {
            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("Mascot_MSMS_example.mzid");
//            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("spec2_F001242.mzid");
//            URL xmlFileURL = JmzIdentMLParser.class.getClassLoader().getResource("output_test.xml");

            if (xmlFileURL != null) {

                // 1. parse file
                boolean aUseSpectrumCache = true;
                MzIdentMLUnmarshaller unmarshaller = new MzIdentMLUnmarshaller(xmlFileURL);
//                MzIdentML mzIdentML = unmarshaller.unmarshalFromXpath("/", MzIdentML.class);
                MzIdentML mzIdentML = (MzIdentML) unmarshaller.unmarshal(MzIdentML.class);


                // 2. store file to db

                // Use persistence.xml configuration
//                EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle10g_manager");
//                EntityManager em = emf.createEntityManager();
                // Use hibernate configuration files
                SessionFactory factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
                Session session = factory.openSession();
                // Work with the EM

                session.getTransaction().begin();

                session.persist(mzIdentML);

                session.getTransaction().commit();

                session.close();
                factory.close(); // close at application end


            } else {
                System.out.println("File not found");
            }

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    @Test
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
