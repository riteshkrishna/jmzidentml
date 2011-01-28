package uk.ac.ebi.jmzidml.persistence.hibernate;

import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: 20-Sep-2010
 * Time: 14:14:37
 * To change this template use File | Settings | File Templates.
 */
public class TestNamingStrategy extends DefaultComponentSafeNamingStrategy {


    private static Integer identifierLengthLimit = 30;

    @Override
    public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
        if (propertyEntityName.length() > 24) {
            propertyEntityName = propertyEntityName.substring(0, 23);
        }

        if (referencedColumnName != null && referencedColumnName.length() > 5) {
            Integer beginIndex = referencedColumnName.length() - (identifierLengthLimit - propertyEntityName.length());
            if (beginIndex < 0) {
                beginIndex = 0;
            }

            referencedColumnName = referencedColumnName.substring(beginIndex, referencedColumnName.length());
        }

        String tmp =
                super.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName, referencedColumnName);

        if (tmp != null && tmp.length() > 30) {

            tmp = tmp.substring(0, 29);

        }

        return tmp;


    }

    @Override
    public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity, String associatedEntityTable, String propertyName) {

        if (ownerEntityTable.length() > 24) {
            ownerEntityTable = ownerEntityTable.substring(0, 23);
        }

        if (associatedEntityTable != null && associatedEntityTable.length() > 5) {
            Integer beginIndex = associatedEntityTable.length() - (identifierLengthLimit - ownerEntityTable.length());
            if (beginIndex < 0) {
                beginIndex = 0;
            }

            associatedEntityTable = associatedEntityTable.substring(beginIndex, associatedEntityTable.length());
        }

        String tmp =
                super.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable, propertyName);

        if (tmp != null && tmp.length() > 30) {

            tmp = tmp.substring(0, 29);
            
        }

        return tmp;
    }


}