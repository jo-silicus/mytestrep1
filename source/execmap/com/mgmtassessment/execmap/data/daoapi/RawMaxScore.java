/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : ChabraNi
 *  @date   : Aug 28, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.math.BigDecimal;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;
import com.mgmtassessment.execmap.common.util.webapp.AnswerModel;

/**
 * Calculate the raw and maximum score for a particular trigram id
 * and a subtest id which are passed to the functions.
 */

public interface RawMaxScore extends AbstractFacade {
    /**
     * @param answerModel
     *            AnswerModel for all tests. It contains all the information
     *            regarding test. This method calculates the rawScore for a
     *            particular Info object.
     * @param languageid Language variable
     * @return Raw Score
     */
    BigDecimal calculateRawScore(AnswerModel answerModel, String languageid);
 }
