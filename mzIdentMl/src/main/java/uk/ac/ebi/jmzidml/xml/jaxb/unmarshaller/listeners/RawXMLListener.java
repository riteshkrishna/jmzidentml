package uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.listeners;

import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.mzidml.ParamAlternative;
import uk.ac.ebi.jmzidml.model.mzidml.ParamAlternativeList;
import uk.ac.ebi.jmzidml.model.mzidml.Sample;

import javax.xml.bind.Unmarshaller;

/**
 * Listener to handle class specific pre/post processing steps during unmarshalling.
 * @author Florian Reisinger
 *         Date: 21-Sep-2010
 * @since 0.1
 */
public class RawXMLListener extends Unmarshaller.Listener {

    private static final Logger log = Logger.getLogger(RawXMLListener.class);

    @Override
    public void afterUnmarshal(Object target, Object parent) {
        log.debug("  unmarshalled: " + target.getClass());
        if(target instanceof ParamAlternative) {
            log.debug("Calling ParamAlternative specific 'afterUnmarshalOperation'.");
            ((ParamAlternative)target).afterUnmarshalOperation();
        }
        if (target instanceof ParamAlternativeList) {
            log.debug("Calling ParamAlternativeList specific 'afterUnmarshalOperation'.");
            ((ParamAlternativeList)target).afterUnmarshalOperation();
        }
        if (target instanceof Sample) {
            log.debug("Calling Sample specific 'afterUnmarshalOperation'.");
            ((Sample)target).afterUnmarshalOperation();
        }
    }

}