/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : sharmrahu
 *  @date   : Sep 8, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.login.form;

import java.util.Map;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class LoginLanguagesForm
        extends ExecmapForm {
    
    Map languages;

    /**
     * @return Returns the languages.
     */
    public Map getLanguages() {
        return languages;
    }

    /**
     * @param languages The languages to set.
     */
    public void setLanguages(
            Map languages) {
        this.languages = languages;
    }
    

}
