/*
* Date: 26/5/2010
* Adopted by - Ritesh
*
*/

package uk.ac.ebi.jmzidml.xml.xxindex;


import psidev.psi.tools.xxindex.index.IndexElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public interface MzIdentMLIndexer {

    public Iterator<String> getXmlStringIterator(String xpathExpression);

//    public String getXmlString(String ID, Constants.ReferencedType type);

    public int getCount(String xpathExpression);

    public String getXmlString(String ID, Class clazz);

    public List<IndexElement> getIndexElements(String xpathExpression);

    public Set<String> getXpath();

    public String getMzIdentMLAttributeXMLString();
}
