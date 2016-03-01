/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 7, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;

/**
 * TODO Write java docs comments for this type
 */

public class TranslateHelperImpl implements TranslateHelper {

    /**
     * This method gets the language translated message as per the key specified
     * for a Locale in the
     * 
     * @see AssessmentResources.properties file
     * @param key
     * @param locale
     * @return String of translated text.
     */
    public String getAssesmentMessage(final String key, final Locale locale) {
        ResourceBundle rsrcAssesmentBundle = ResourceBundle.getBundle(
                IConstants.ASSESMENT_MESSAGE_RESOURCE, locale);
        return rsrcAssesmentBundle.getString(key);

    }

    /**
     * This method gets the language translated message as per the key specified
     * for a Locale in the
     * 
     * @see ExecmapResources.properties file
     * @param key
     * @param locale
     * @return String of translated text.
     */
    public String getExecmapMessage(final String key, final Locale locale) {
        ResourceBundle rsrcExecmapBundle = ResourceBundle.getBundle(
                IConstants.EXECMAP_MESSAGE_RESOURCE, locale);
        return rsrcExecmapBundle.getString(key);
    }

    /**
     * This method gets the value for the key.
     * 
     * @see ApplicationResources.properties file
     * @param key
     * @return String value of key .
     */

    public String getApplicationMessage(String key) {
        ResourceBundle rsrcApplicationBundle = ResourceBundle
                .getBundle(IConstants.APPLICARION_MESSAGE_RESOURCE);
        return rsrcApplicationBundle.getString(key);

    }

    /**
     * This method gets the value for the key.
     * 
     * @see Language.properties file
     * @return Map containing all the langue value pairs.
     */

    public Map getLanguages() {
        ResourceBundle rsrcLanguageBundle = ResourceBundle
                .getBundle(IConstants.LANGUAGE_RESOURCE);
        Enumeration<String> languages = rsrcLanguageBundle.getKeys();
        Map languageMap = new HashMap();
        while (languages.hasMoreElements()) {
            String languageKey = languages.nextElement();
            String languageValue = rsrcLanguageBundle.getString(languageKey);
            languageMap.put(languageKey, languageValue);
        }
        return languageMap;

    }

    /**
     * This method gets the value for the key.
     * 
     * @see Mail.properties file
     * @param key
     * @return String value of key .
     */
    public String getMailMessage(String key) {
        ResourceBundle rsrcApplicationBundle = ResourceBundle
                .getBundle(IConstants.MAIL_RESOURCE);
        return rsrcApplicationBundle.getString(key);

    }

}
