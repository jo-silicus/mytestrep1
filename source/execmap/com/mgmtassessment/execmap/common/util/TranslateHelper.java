/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 9, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.common.util;

import java.util.Locale;
import java.util.Map;

/**
 * TODO Write java docs comments for this type
 */

public interface TranslateHelper {

    /**
     * This method gets the language translated message as per the key specified
     * for a Locale in the.
     *
     * @see AssessmentResources.properties file
     * @param key
     * @param local
     * @return String of translated text
     */
    public String getAssesmentMessage(
            String key, Locale local);

    /**
     * This method gets the language translated message as per the key specified
     * for a Locale in the.
     *
     * @see ExecmapResources.properties file
     * @param key
     * @param local
     * @return String of translated text.
     */

    public String getExecmapMessage(
            String key, Locale local);

    /**
     * This method gets the value for the key.
     *
     * @see ApplicationResources.properties file
     * @param key
     * @return String value of key .
     */

    public String getApplicationMessage(
            String key);


    /**
     * This method gets the value for the key.
     *
     * @see mail.properties file
     * @param key
     * @return String value of key .
     */
    public String getMailMessage(
            String key);

    /**
     * This method gets the value for the key.
     *
     * @see Language.properties file
     * @return Map containing all the langue value pairs.
     */

    public Map getLanguages();
}
