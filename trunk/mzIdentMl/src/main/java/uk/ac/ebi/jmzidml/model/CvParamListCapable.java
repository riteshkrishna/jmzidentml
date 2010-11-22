package uk.ac.ebi.jmzidml.model;

import uk.ac.ebi.jmzidml.model.mzidml.CvParam;

import java.util.List;

/**
 * @author Florian Reisinger
 *         Date: 18-Nov-2010
 * @since 1.0
 */
public interface CvParamListCapable {

    /**
     *
     * @return A List of CvParam objects.
     */
    public List<CvParam> getCvParam();
}
