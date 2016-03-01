/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : kapilpra
 * @date : Aug 29, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.webapp.AnswerListModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerListMultiModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerModel;
import com.mgmtassessment.execmap.data.dao.types.SubTestCorrecTemp;
import com.mgmtassessment.execmap.data.daoapi.FetchCorrectAnswerDAO;
import com.mgmtassessment.execmap.data.daoapi.RawMaxScore;

/**
 * Calculate the raw and maximum score for a particular trigram id and a subtest
 * id which are passed to the functions.
 */

public class RawMaxScoreImpl extends AbstractFacadeImpl implements RawMaxScore {

    /**
     * log variable for system health check.
     */
    private static Log            log = LogFactory
                                              .getLog(RawMaxScoreImpl.class);

    /**
     * depicts the flag for visual and audio ability of a person.
     */
    private char                  audioFlag;

    /**
     * DAO class for Fetch the correct answers for all tests.
     */
    private FetchCorrectAnswerDAO fetchCorrectAnswerDAO;

    /**
     * @param answerModel
     *            AnswerModel for all tests. It contains all the information
     *            regarding test. This method calculates the rawScore for a
     *            particular Info object.
     * @param languageid Language variable
     * @return Raw Score
     */
    @SuppressWarnings("unchecked")
    public BigDecimal calculateRawScore(AnswerModel answerModel,
                       String languageid) {
        double raw_score = 0.0;
        String trigramID = answerModel.getTriGram();
        String subTestID = "X";
        List userAnswerList = answerModel.getAnswerList();
        Map userAnswersMap = new HashMap();
        Iterator userAnswerListIterator = userAnswerList.iterator();
        log.info("Make a HashMap of questionID and multiAnswerModel lisr");
        while (userAnswerListIterator.hasNext()) {
            AnswerListModel answerListModel = (AnswerListModel)
                                               userAnswerListIterator.next();
            userAnswersMap.put(answerListModel.getTestQuestionId().toString(),
                    answerListModel.getMultiAnsModel());
        }
        List filterAnswerList = new ArrayList();
        if (trigramID.equals("MEMWS")) {
            trigramID = "MEM";
            subTestID = "X1";
        }
        log
                .info("Fetching correct answers from DAO class and"
                       + " filtering them according to TrigramID and language");
        fetchCorrectAnswerDAO = (FetchCorrectAnswerDAO)
                            appCtxt.getBean("FetchCorrectAnswerDAO");
        List answersList = fetchCorrectAnswerDAO.getFetchCorrectAnswer();
        Iterator answersListIterator = answersList.iterator();
        while (answersListIterator.hasNext()) {
            SubTestCorrecTemp subTstCorrecTemp = (SubTestCorrecTemp)
                                answersListIterator.next();
            if (trigramID.equalsIgnoreCase(subTstCorrecTemp.getComp_id()
                    .getTriId().trim())
                    && "X".equalsIgnoreCase(subTstCorrecTemp.getComp_id()
                            .getSubTestId().trim())
                    && languageid.equalsIgnoreCase(subTstCorrecTemp.getComp_id()
                            .getLangId().trim())) { // filter for language
                filterAnswerList.add(subTstCorrecTemp);
            }
        }
        userAnswerListIterator = userAnswerList.iterator();
        String str_qno = null;
        if ("ESSX".equals(trigramID + subTestID)) {
            log.info("Calculating raw score for ESSX.");
            while (userAnswerListIterator.hasNext()) {
                str_qno = ""
                        + ((AnswerListModel)
                        userAnswerListIterator.next()).getTestQuestionId();
                List multianswerList = ((List)
                                 userAnswersMap.get(str_qno));
                if (multianswerList != null) {
                    Iterator filterAnswerListIterator = filterAnswerList
                            .iterator();
                    Map answersMarksMap = new HashMap();
                   while (filterAnswerListIterator.hasNext()) {
              SubTestCorrecTemp subTestCorrecTemp = (SubTestCorrecTemp)
                                        filterAnswerListIterator.next();
                        if ((subTestCorrecTemp.getComp_id().getQuesId()
                                .toString().trim()).equals(str_qno)) {
                            answersMarksMap.put(new Integer((subTestCorrecTemp
                                    .getComp_id().getAnsId()).intValue()),
                                    new Float((subTestCorrecTemp.getMarks())
                                            .floatValue()));
                        }
                    }
                    if (multianswerList.size() <= answersMarksMap.size()) {
                        Iterator multianswerListIterator = multianswerList
                                .iterator();
                        while (multianswerListIterator.hasNext()) {
              AnswerListMultiModel answerListMultiModel = (AnswerListMultiModel)
                              multianswerListIterator.next();
                            Integer answerID = new Integer(
                                    (answerListMultiModel.getAnswerNoStartPos())
                                            .intValue());
                            if (answersMarksMap.containsKey(answerID)) {
                                raw_score += (Float)
                                       answersMarksMap.get(answerID);
                            }
                        }
                    }
                }
            }
        } else if ("NSTX".equalsIgnoreCase(trigramID + subTestID)) {
            log.info("Calculating raw score for NSTX.");
            while (userAnswerListIterator.hasNext()) {
                str_qno = ""
                        + ((AnswerListModel)
                        userAnswerListIterator.next()).getTestQuestionId();
                List multianswerList = ((List)
                      userAnswersMap.get(str_qno));
                if (multianswerList != null) {
                    Iterator filterAnswerListIterator = filterAnswerList
                            .iterator();
                    Map answersMarksMap = new HashMap();
                    while (filterAnswerListIterator.hasNext()) {
            SubTestCorrecTemp subTestCorrecTemp = (SubTestCorrecTemp)
                                     filterAnswerListIterator.next();
                        Map endposMarksMap = new HashMap();
                        if (subTestCorrecTemp.getComp_id().getQuesId()
                                .toString().equals(str_qno)) {
                            endposMarksMap.put(new Integer((subTestCorrecTemp
                                    .getEndPos()).intValue()),
                                    new Float((subTestCorrecTemp.getMarks())
                                            .floatValue()));
                            answersMarksMap.put(new Integer((subTestCorrecTemp
                                    .getStPos()).intValue()), endposMarksMap);
                        }
                    }
                    if (multianswerList.size() <= answersMarksMap.size()) {
                        Iterator multianswerListIterator = multianswerList
                                .iterator();
                        while (multianswerListIterator.hasNext()) {
            AnswerListMultiModel answerListMultiModel = (AnswerListMultiModel)
                               multianswerListIterator.next();
                            Integer startPos = new Integer(
                                    (answerListMultiModel.getAnswerNoStartPos())
                                            .intValue());
                            Integer endPos = new Integer((answerListMultiModel
                                    .getAnswerNoEndPos()).intValue());
                            if (answersMarksMap.containsKey(startPos)) {
                                HashMap checkendpos = (HashMap)
                                          answersMarksMap.get(startPos);
                                if (checkendpos.containsKey(endPos)) {
                                    raw_score += (Float)
                                               checkendpos.get(endPos);
                                }
                            }
                        }
                    }
                }
            }
        } else if ("DMSX".equalsIgnoreCase(trigramID + subTestID)) {
            log.info("Calculating raw score for DMSX.");
            Map correctAnswersQuesMap = new HashMap();
            Iterator filterAnswerListIterator = filterAnswerList.iterator();
            while (userAnswerListIterator.hasNext()) {
             AnswerListModel answerListModel = (AnswerListModel)
                            userAnswerListIterator.next();
                String questionID = answerListModel.getTestQuestionId()
                        .toString();
                while (filterAnswerListIterator.hasNext()) {
             SubTestCorrecTemp subTestCorrecTemp = (SubTestCorrecTemp)
                            filterAnswerListIterator.next();
                    if (subTestCorrecTemp.getComp_id().getQuesId().toString()
                            .trim().equals(questionID)) {
                        correctAnswersQuesMap.put(subTestCorrecTemp
                                .getComp_id().getAnsId().toString().trim(),
                                subTestCorrecTemp.getMarks());
                    }
                }
                if (!(answerListModel.getAnswerNo().toString().
                                          indexOf("0") >= 0)) {
                raw_score += (Float)
                             ((BigDecimal)
                             correctAnswersQuesMap
                        .get(answerListModel.getAnswerNo().toString()))
                        .floatValue();
                }
            }
        } else if ("MEMX".equalsIgnoreCase(trigramID + subTestID)) {
            log.info("Calculating raw score for MEMX.");
            float audioScore = 0.0f;
            float visualScore = 0.0f;
            char voiceFlag = 0;
            while (userAnswerListIterator.hasNext()) {
                str_qno = ""
                        + ((AnswerListModel)
                         userAnswerListIterator.next())
                                .getTestQuestionId();
                ArrayList multianswerList = ((ArrayList)
                                 userAnswersMap.get(str_qno));
                if (str_qno.equals("1") || str_qno.equals("2")) {
                    if (multianswerList != null) {
                        Iterator filterAnswerListIterator = filterAnswerList
                                .iterator();
                        Map answersMarksMap = new HashMap();
                        while (filterAnswerListIterator.hasNext()) {
                            SubTestCorrecTemp subTestCorrecTemp =
                                 (SubTestCorrecTemp)
                                 filterAnswerListIterator.next();
                            if ((subTestCorrecTemp.getComp_id().getQuesId()
                                    .toString().trim()).equals(str_qno)) {
                                answersMarksMap.put(new Integer(
                                        (subTestCorrecTemp.getComp_id()
                                                .getAnsId()).intValue()),
                                        new Float(
                                                (subTestCorrecTemp.getMarks())
                                                        .floatValue()));
                            }
                        }
                        if (multianswerList.size() <= answersMarksMap.size()) {
                            Iterator multianswerListIterator = multianswerList
                                    .iterator();
                            while (multianswerListIterator.hasNext()) {
            AnswerListMultiModel answerListMultiModel = (AnswerListMultiModel)
                                    multianswerListIterator.next();
                                Integer answerID = new Integer(
                                        (answerListMultiModel
                                                .getAnswerNoStartPos())
                                                .intValue());
                                if (answersMarksMap.containsKey(answerID)) {
                                    raw_score += (Float)
                                            answersMarksMap.get(answerID);
                                    if (str_qno.equals("1")) {
                                        audioScore += (Float)
                                            answersMarksMap.get(answerID);
                                    } else {
                                        visualScore += (Float)
                                            answersMarksMap.get(answerID);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    Iterator filterAnswerListIterator = filterAnswerList
                            .iterator();
                    Map seqansMarksMap = new HashMap();
                    while (filterAnswerListIterator.hasNext()) {
           SubTestCorrecTemp subTestCorrecTemp = (SubTestCorrecTemp)
                                  filterAnswerListIterator.next();
                        Map answersMarksMap = new HashMap();
                        if ((subTestCorrecTemp.getComp_id().getQuesId()
                                .toString().trim()).equals(str_qno)) {
                            answersMarksMap.put(subTestCorrecTemp.getComp_id()
                                    .getAnsId().toString(),
                                    new Float((subTestCorrecTemp.getMarks())
                                            .floatValue()));
                            seqansMarksMap.put(subTestCorrecTemp.getSeqId()
                                    .toString(), answersMarksMap);
                        }
                    }
                    if (multianswerList.size() <= seqansMarksMap.size()) {
                        Iterator multianswerListIterator = multianswerList
                                .iterator();
                        int sequenceID = 0;
                        while (multianswerListIterator.hasNext()) {
           AnswerListMultiModel answerListMultiModel = (AnswerListMultiModel)
                                multianswerListIterator.next();
                            Integer answerID = new Integer(
                                    (answerListMultiModel.getAnswerNoStartPos())
                                            .intValue());
                            Map checkAnswerMap = (HashMap)
                                    seqansMarksMap.get(++sequenceID + "");
                 if (checkAnswerMap.containsKey(answerID.toString())) {
                                raw_score += (Float)
                                      checkAnswerMap.get(answerID.toString());
                                if (str_qno.equals("3")) {
                                    audioScore += (Float)
                                      checkAnswerMap.get(answerID.toString());
                                } else {
                                    visualScore += (Float)
                                      checkAnswerMap.get(answerID.toString());
                                }
                            }
                        }
                    }
                }
            }
            /**
             * setting voiceFlag depending on conditions. A for Auditory, V for
             * Visual and B for Balanced
             */
            if (audioScore > visualScore) {
                voiceFlag = 'A';
            } else if (audioScore < visualScore) {
                voiceFlag = 'V';
            } else if (audioScore == visualScore) {
                voiceFlag = 'B';
            }

            // setting audioFlag value in instance variable in ExecMap user
            audioFlag = voiceFlag;
        } else if ((trigramID + subTestID).equalsIgnoreCase("MEMX1")) {
            while (userAnswerListIterator.hasNext()) {
                str_qno = ""
                        + ((AnswerListModel)
                             userAnswerListIterator.next()).getTestQuestionId();
                ArrayList multianswerList = ((ArrayList)
                              userAnswersMap.get(str_qno));
                if (str_qno.equals("1")) {
                    if (multianswerList != null) {
                        Iterator filterAnswerListIterator = filterAnswerList
                                .iterator();
                        Map answersMarksMap = new HashMap();
                        while (filterAnswerListIterator.hasNext()) {
                SubTestCorrecTemp subTestCorrecTemp = (SubTestCorrecTemp)
                             filterAnswerListIterator.next();
                            if ((subTestCorrecTemp.getComp_id().getQuesId()
                                    .toString().trim()).equals(str_qno)) {
                                answersMarksMap.put(new Integer(
                                        (subTestCorrecTemp.getComp_id()
                                                .getAnsId()).intValue()),
                                        new Float(
                                                (subTestCorrecTemp.getMarks())
                                                        .floatValue()));
                            }
                        }
                        if (multianswerList.size() <= answersMarksMap.size()) {
                            Iterator multianswerListIterator = multianswerList
                                    .iterator();
                            while (multianswerListIterator.hasNext()) {
             AnswerListMultiModel answerListMultiModel = (AnswerListMultiModel)
                                  multianswerListIterator.next();
                                Integer answerID = new Integer(
                                        (answerListMultiModel
                                                .getAnswerNoStartPos())
                                                .intValue());
                                if (answersMarksMap.containsKey(answerID)) {
                                    raw_score += (Float)
                                        answersMarksMap.get(answerID);
                                }
                            }
                        }
                    }
                } else {
                    Iterator filterAnswerListIterator = filterAnswerList
                            .iterator();
                    Map seqansMarksMap = new HashMap();
                    while (filterAnswerListIterator.hasNext()) {
             SubTestCorrecTemp subTestCorrecTemp = (SubTestCorrecTemp)
                             filterAnswerListIterator.next();
                        Map answersMarksMap = new HashMap();
                        if ((subTestCorrecTemp.getComp_id().getQuesId()
                                .toString().trim()).equals(str_qno)) {
                            answersMarksMap.put(subTestCorrecTemp.getComp_id()
                                    .getAnsId().toString(),
                                    new Float((subTestCorrecTemp.getMarks())
                                            .floatValue()));
                            seqansMarksMap.put(subTestCorrecTemp.getSeqId()
                                    .toString(), answersMarksMap);
                        }
                    }
                    if (multianswerList.size() <= seqansMarksMap.size()) {
                        Iterator multianswerListIterator = multianswerList
                                .iterator();
                        int sequenceID = 0;
                        while (multianswerListIterator.hasNext()) {
             AnswerListMultiModel answerListMultiModel = (AnswerListMultiModel)
                                   multianswerListIterator.next();
                            Integer answerID = new Integer(
                                    (answerListMultiModel.getAnswerNoStartPos())
                                            .intValue());
                            Map checkAnswerMap = (HashMap)
                                        seqansMarksMap.get(++sequenceID + "");
                        if (checkAnswerMap.containsKey(answerID.toString())) {
                                raw_score += (Float)
                                        checkAnswerMap.get(answerID.toString());
                            }
                        }
                    }
                }

            }
            // setting audioFlag value in instance variable in ExecMap user
            audioFlag = 'V';
        } else {
            log.info("Calculating raw score for other tests.");
            Map correctAnswersQuesMap = new HashMap();
            Iterator filterAnswerListIterator = filterAnswerList.iterator();
            while (filterAnswerListIterator.hasNext()) {
             SubTestCorrecTemp subTestCorrecTemp = (SubTestCorrecTemp)
                         filterAnswerListIterator.next();
                LinkedList answersmarks = new LinkedList();
                answersmarks.addLast(subTestCorrecTemp.getComp_id().getAnsId()
                        .toString());
                answersmarks.addLast(new Float(subTestCorrecTemp.getMarks()
                        .floatValue()));
                correctAnswersQuesMap.put(subTestCorrecTemp.getComp_id()
                        .getQuesId().toString(), answersmarks);
            }
            while (userAnswerListIterator.hasNext()) {
                AnswerListModel answerListModel = (AnswerListModel)
                         userAnswerListIterator.next();
                String questionID = answerListModel.getTestQuestionId()
                        .toString();
                LinkedList tempList = (LinkedList)
                      correctAnswersQuesMap.get(questionID);
                if (answerListModel.getAnswerNo().toString().equals(
                        tempList.get(0))) {
                    raw_score += (Float)
                                  tempList.get(1);
                }
            }
        }
        return new BigDecimal(raw_score);
    } // END of calculateRawScore

    /**
     * returns the flag value depending on audio and visual capability in MEMX
     * Test for ExecMap user.
     */
    public char getAudioFlag() {
        return audioFlag;
    }
}