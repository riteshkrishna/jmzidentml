package uk.ac.ebi.jmzidml.model.utils;

import uk.ac.ebi.jmzidml.model.mzidml.CvParam;
import uk.ac.ebi.jmzidml.model.mzidml.UserParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Florian Reisinger
 *         Date: 18-Oct-2010
 * @since 0.2
 */
public class ParamUpdater {

    public static <T extends CvParam> T updateCvParamSubclass(CvParam input, Class<T> cvParamSubClass) throws IllegalAccessException, InstantiationException {
        if (input != null) {
            // create a tmp holder of the new ParamSubclass
            T newParam = cvParamSubClass.newInstance();

            // copy fields
            newParam.setAccession( input.getAccession() );
            newParam.setCv( input.getCv() );
            newParam.setCvRef( input.getCvRef() );
            newParam.setName( input.getName() );
            newParam.setValue( input.getValue() );
            newParam.setUnitAccession( input.getUnitAccession() );
            newParam.setUnitName( input.getUnitName() );
            newParam.setUnitCvRef( input.getUnitCvRef() );

            // replace old with new
            return newParam;
        }
        return null;
    }

    public static <T extends CvParam> void updateCvParamSubclassesList(List<CvParam> inputs, Class<T> cvParamSubClass) throws InstantiationException, IllegalAccessException {
        if (inputs != null && inputs.size() > 0) {
            // create tmp holder
            List<T> newList = new ArrayList<T>();

            // copy values to new SubClasses
            for (CvParam cvParam : inputs) {
                newList.add(updateCvParamSubclass(cvParam, cvParamSubClass));
            }

            // switch list content
            inputs.clear();
            inputs.addAll(newList);
        }
    }

    public static <T extends UserParam> T updateUserParamSubclass(UserParam input, Class<T> userParamSubClass) throws IllegalAccessException, InstantiationException {
        if (input != null) {
            // create a tmp holder of the new ParamSubclass
            T newParam = userParamSubClass.newInstance();

            // copy fields
            newParam.setName( input.getName() );
            newParam.setValue( input.getValue() );
            newParam.setUnitAccession( input.getUnitAccession() );
            newParam.setUnitName( input.getUnitName() );
            newParam.setUnitCvRef( input.getUnitCvRef() );

            // replace old with new
            return newParam;
        }
        return null;
    }

    public static <T extends UserParam> void updateUserParamSubclassesList(List<UserParam> inputs, Class<T> userParamSubClass) throws InstantiationException, IllegalAccessException {
        if (inputs != null && inputs.size() > 0) {
            // create tmp holder
            List<T> newList = new ArrayList<T>();

            // copy values to new SubClasses
            for (UserParam userParam : inputs) {
                newList.add(updateUserParamSubclass(userParam, userParamSubClass));
            }

            // switch list content
            inputs.clear();
            inputs.addAll(newList);
        }
    }

}
