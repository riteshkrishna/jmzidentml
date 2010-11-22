package uk.ac.ebi.jmzidml.xml.jaxb.marshaller.listeners;

import org.apache.log4j.Logger;
import uk.ac.ebi.jmzidml.model.ParamGroupCapable;
import uk.ac.ebi.jmzidml.model.mzidml.ParamAlternative;

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
        log.debug("Handling " + source.getClass() + " in beforeMarshal.");

        // Handle the cases were we have ParamGroups, CvParams, UserParams, etc...
        if (source instanceof ParamAlternative) {
            ((ParamAlternative)source).beforeMarshalOperation();
        } else if (source instanceof ParamGroupCapable) {
            ParamGroupCapable apg = (ParamGroupCapable) source;
            // we have to re-unite the CvParam and UserParam we split in the unmarshall process
            apg.updateParamList();
        }

        // Since the ID of a referenced object is updated when the referenced object is updated/added
        // and the object is not taken into account for the marshalling process, we don't really need
        // to do anything else here (regarding the automatic reference resolving).
    }

}