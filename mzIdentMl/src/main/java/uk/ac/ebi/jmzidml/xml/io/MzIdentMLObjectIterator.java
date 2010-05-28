/*
 * Date: 22/7/2008
 * Author: rcote
 * File: uk.ac.ebi.jmzml.xml.io.MzMLObjectIterator
 *
 * jmzml is Copyright 2008 The European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 */

package uk.ac.ebi.jmzidml.xml.io;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import uk.ac.ebi.jmzidml.model.MzIdentMLObject;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.cache.AdapterObjectCache;
import uk.ac.ebi.jmzidml.xml.jaxb.unmarshaller.filters.MzIdentMLNamespaceFilter;
import uk.ac.ebi.jmzidml.xml.xxindex.MzIdentMLIndexer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;
import java.util.Iterator;

public class MzIdentMLObjectIterator<X extends MzIdentMLObject> implements Iterator<X> {

    private static Logger logger = Logger.getLogger(MzIdentMLObjectIterator.class);

    private MzIdentMLIndexer index;

    private Iterator<String> innerXpathIterator;
    private String xpath;
    private Class cls;
    private AdapterObjectCache cache;
    private boolean useSpectrumCache = true;

    //package level constructor!
    MzIdentMLObjectIterator(String xpath, Class cls, MzIdentMLIndexer index, AdapterObjectCache cache) {
        this(xpath, cls, index, cache, true);
    }

    MzIdentMLObjectIterator(String xpath, Class cls, MzIdentMLIndexer index, AdapterObjectCache cache, boolean aUseSpectrumCache) {
        innerXpathIterator = index.getXmlStringIterator(xpath);
        this.xpath = xpath;
        this.cls = cls;
        this.index = index;
        this.cache = cache;
        this.useSpectrumCache = aUseSpectrumCache;
    }


    public boolean hasNext() {
        return innerXpathIterator.hasNext();
    }

    public X next() {

        try {
            String xmlSt = innerXpathIterator.next();

            if (logger.isDebugEnabled()) {
                logger.trace("XML to unmarshal: " + xmlSt);
            }

            //required for the addition of namespaces to top-level objects
            MzIdentMLNamespaceFilter xmlFilter = new MzIdentMLNamespaceFilter();
            //initializeUnmarshaller will assign the proper reader to the xmlFilter
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
            //unmarshall the desired object
            JAXBElement<X> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(xmlSt))), cls);

            X retval = holder.getValue();

            if (logger.isDebugEnabled()) {
                logger.debug("unmarshalled object = " + retval);
            }

            return retval;
        } catch (JAXBException e) {
            logger.error("MzMLObjectIterator.next", e);
            throw new IllegalStateException("Could not unmarshal object at xpath:" + xpath);
        }

    }

    public void remove() {
        throw new UnsupportedOperationException(MzIdentMLObjectIterator.class.getName() + " can't be used to remove objects while iterating");
    }

}
