/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.ebi.jmzidml.xml.jaxb.adapters;

import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftware;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 *
 * @author Ritesh
 */
public class AnalysisSoftwareAdapter extends AbstractResolvingAdapter<String, AnalysisSoftware>{

    public AnalysisSoftwareAdapter(MzIdentMLIndexer index, AdapterObjectCache cache) {
        super(index, cache);
    }

    public AnalysisSoftware unmarshal(String refId) {
        AnalysisSoftware retval = new AnalysisSoftware();
        return retval;
    }

    public String marshal(AnalysisSoftware spec) {
       return "";
    }

}
