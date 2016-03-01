/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 22, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.common.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

/**
 * Class to compare two fields if they contain the same content.
 */

public class FieldCompare {
    /**
     * Method that compares two fields if they contain the same content.
     * @param bean
     * @param va
     * @param field,
     * @param errors
     * @param validator
     * @param request
     * @return true if the fields have the same value else false.
     */
    public static boolean validateTwoFields(Object bean, ValidatorAction va,
            Field field, ActionMessages errors, Validator validator,
            HttpServletRequest request) {

        String value = ValidatorUtils.getValueAsString(bean, field
                .getProperty());
        String sProperty2 = field.getVarValue("secondProperty");
        String value2 = ValidatorUtils.getValueAsString(bean, sProperty2);
        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                if (!value.equals(value2)) {
                    errors.add(field.getKey(), Resources.getActionMessage(
                            validator, request, va, field));

                    return false;
                }
            }
            catch (Exception e) {
                errors.add(field.getKey(), Resources.getActionMessage(
                        validator, request, va, field));
                return false;
            }
        }

        return true;
    }
}
