package uk.ac.ebi.jmzidml.xml.jaxb.adapters;

import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSearchDatabase;
import uk.ac.ebi.jmzidml.xml.Constants;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 02-Sep-2010
 * @since 0.1
 */
public class AnalysisSearchDatabaseAdapter extends AbstractResolvingAdapter<String, AnalysisSearchDatabase> {

    public AnalysisSearchDatabaseAdapter(MzIdentMLIndexer index, AdapterObjectCache cache) {
        super(index, cache);
    }

    public AnalysisSearchDatabase unmarshal(String refId) {

        AnalysisSearchDatabase retval;
        if (cache.getCachedObject(refId, AnalysisSearchDatabase.class) != null) {
            retval = (AnalysisSearchDatabase) cache.getCachedObject(refId, AnalysisSearchDatabase.class);
            logger.debug("used cached value for ID: " + refId);
        } else {
            retval = super.unmarshal(refId, Constants.ReferencedType.AnalysisSearchDatabase);
            cache.putInCache(refId, retval);
            logger.debug("cached object at ID: " + refId);
        }
        return retval;
    }

    public String marshal(AnalysisSearchDatabase sdb) {
        if (sdb != null) {
            return sdb.getId();
        } else {
            return null;
        }
    }
}