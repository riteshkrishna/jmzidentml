package uk.ac.ebi.jmzidml.xml.jaxb.marshaller.listeners;

import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.ParamAlternative;
import uk.ac.ebi.jmzidml.model.mzidml.ParamAlternativeList;
import uk.ac.ebi.jmzidml.model.mzidml.Sample;

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
    }

}