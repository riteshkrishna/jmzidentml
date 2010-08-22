/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.ebi.jmzidml.xml.jaxb.adapters;
import uk.ac.ebi.jmzidml.model.mzidml.SpectraData;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

/**
 *
 * @author Ritesh
 */
public class SpectraDataAdapter extends AbstractResolvingAdapter<String, SpectraData>{

    public SpectraDataAdapter(MzIdentMLIndexer index, AdapterObjectCache cache) {
        super(index, cache);
    }

    public SpectraData unmarshal(String refId) {
        SpectraData retval = new SpectraData();
        return retval;
    }

    public String marshal(SpectraData spec) {
       return "";
    }

}
