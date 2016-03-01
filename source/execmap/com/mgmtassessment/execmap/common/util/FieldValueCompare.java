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
 * Class to compare  value of a field to a given value.
 */

public class FieldValueCompare {
    /**
     * Method that compares the value of a to a given value.
     * @param bean
     * @param va
     * @param field,
     * @param errors
     * @param validator
     * @param request
     * @return true if the field has the same value else false.
     */
    public static boolean validateFieldValue(Object bean, ValidatorAction va,
            Field field, ActionMessages errors, Validator validator,
            HttpServletRequest request) {

        String value = ValidatorUtils.getValueAsString(bean, field
                .getProperty());
        String compareValue = field.getVarValue("value");
        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                if (!value.equalsIgnoreCase(compareValue)) {
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
        else
        {
            errors.add(field.getKey(), Resources.getActionMessage(
                    validator, request, va, field));
            return false;
        }
        return true;
    }
}
