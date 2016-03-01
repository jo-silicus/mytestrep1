/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.api.assessment;

import java.util.Locale;

import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;
import com.mgmtassessment.execmap.business.model.AssessmentMainModel;

/**
 * This is the interface used for preparing the
 * model for a trigram assessment activity.
 * @author singhrau
 *
 */

public interface AssessmentPrepare extends AbstractFacade {

    /**
     * This method prepares the model for a trigram assessment activity. Note:
     * This is a common interface for preparing models for all trigram
     * activities. This method will be invoked by method
     * prepareModelForActivity() in
     *
     * @see AssessmentManagerFacadeImpl.java
     * @see ApplicationContext.xml for implementation for implementation for
     *      this Interface. It prepares model based on the logged user locale
     * @param Locale
     * @return model
     */

    public AssessmentMainModel prepareModel(Locale locale);

}
