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
 * Class to compare a field if they contains some
 * special characters or not.
 */

public class SpecialCharactes {
    /**
     * Method that compares a field if they contains some
     * special characters or not.
     * @param bean
     * @param va
     * @param field,
     * @param errors
     * @param validator
     * @param request
     * @return true if the field doesnot contain special characters
     * else false.
     */
    public static boolean validateSpecialCharactes(Object bean, ValidatorAction va,
            Field field, ActionMessages errors, Validator validator,
            HttpServletRequest request) {

        String value = ValidatorUtils.getValueAsString(bean, field
                .getProperty());
        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                boolean hash=value.contains("#".subSequence(0,1));
                boolean ampersand=value.contains("&".subSequence(0,1));
                if (hash || ampersand) {
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
