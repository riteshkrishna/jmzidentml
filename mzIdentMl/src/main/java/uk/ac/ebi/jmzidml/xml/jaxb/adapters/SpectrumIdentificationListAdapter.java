package uk.ac.ebi.jmzidml.xml.jaxb.adapters;

import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationList;
import uk.ac.ebi.jmzidml.xml.Constants;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 03-Sep-2010
 * @since 0.1
 */
public class SpectrumIdentificationListAdapter extends AbstractResolvingAdapter<String, SpectrumIdentificationList> {

    public SpectrumIdentificationListAdapter(MzIdentMLIndexer index, AdapterObjectCache cache) {
        super(index, cache);
    }

    public SpectrumIdentificationList unmarshal(String refId) {

        SpectrumIdentificationList retval;
        if (cache.getCachedObject(refId, AnalysisSearchDatabaseAdapter.class) != null) {
            retval = (SpectrumIdentificationList) cache.getCachedObject(refId, SpectrumIdentificationList.class);
            logger.debug("used cached value for ID: " + refId);
        } else {
            retval = super.unmarshal(refId, Constants.ReferencedType.SpectrumIdentificationList);
            cache.putInCache(refId, retval);
            logger.debug("cached object at ID: " + refId);
        }
        return retval;
    }

    public String marshal(SpectrumIdentificationList element) {
        if (element != null) {
            return element.getId();
        } else {
            return null;
        }
    }
}