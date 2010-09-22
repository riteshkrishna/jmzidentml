/**
 *
 * @author Ritesh
 */
package uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache;


import uk.ac.ebi.jmzidml.model.MzIdentMLObject;

import java.util.HashMap;
import java.util.Map;


public class AdapterObjectCache {

    // ToDo: check caching as it does not seem to work for the hibernate persising issue raised by Andreas, resulting in multiple entries in the DB for the same referenced XML param
    //todo: configure caching levels so that individual object classes are/aren't cached at runtime
    private Map<Class, Map<String, MzIdentMLObject>> cache = new HashMap<Class, Map<String, MzIdentMLObject>>();

    public void putInCache(String id, MzIdentMLObject object) {

        Class cls = object.getClass();
        Map<String, MzIdentMLObject> classCache = cache.get(cls);
        if (classCache == null) {
            classCache = new HashMap<String, MzIdentMLObject>();
            cache.put(cls, classCache);
        }
        classCache.put(id, object);

    }

    public MzIdentMLObject getCachedObject(String id, Class cls) {

        Map<String, MzIdentMLObject> classCache = cache.get(cls);
        if (classCache == null) {
            return null;
        }
        return classCache.get(id);

    }
}
