/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 29, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.assessment;

import java.util.List;

import com.mgmtassessment.execmap.business.api.assessment.AssessmentPrepare;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.business.model.AssessmentMainModel;
import com.mgmtassessment.execmap.business.model.ImageTextAssessmentModel;

import com.mgmtassessment.execmap.common.util.TranslateHelper;

import java.util.Locale;

import java.util.ArrayList;

/**
 * This class prepares the model for the suboptions related to question
 * number one of the dms assessment trigram.
 * @author singhrau
 *
 */

public class Dms1AssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {

    /**
     * This method prepares the model for the suboptions related to question
     * number one of the dms assessment trigram.
     * @param locale
     * @return dmsAssessmentModel
     */

     public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel dmsAssessmentModel = new AssessmentMainModel();

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** dms Assessment Activity Answering Instructions * */
        List answerInstruction = new ArrayList<String>();

        answerInstruction.add(langHelper.getAssesmentMessage(
                "dmsx.activityinstruction6", locale));

        ImageTextAssessmentModel dmsInstructionModel =
                                       new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("dmsx.dmsx.dmsheading",
                locale);
        /** Set the Sub Header attribute for dms Assessment Trigram * */
        dmsInstructionModel.setSubHeader(subHeader);
        dmsInstructionModel.setQuestionNo(0);

        // dmsInstructionModel.setTime(new String(langHelper.
        // getAssesmentMessage("dmsx.timer",locale)));

        /** Set the model for 1st option of question 1 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel1 =
                                   new ImageTextAssessmentModel();

        dmsAssessmentModel1.setSubHeader(subHeader);

        List<String> textorurlList1 = new ArrayList<String>();

        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext0.questiontext", locale)));
        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext0.choicetext", locale)));
        dmsAssessmentModel1.setTextOrUrl(textorurlList1);
        dmsAssessmentModel1.setQuestionNo(1);
        dmsAssessmentModel1.setInstruction(answerInstruction);

        /** Set the Answer subOptions for 1st option for dms* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext0.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext1.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext2.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext3.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext4.subchoicetext", locale)));

        dmsAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd option of question 1 for dms* */
        ImageTextAssessmentModel dmsAssessmentModel2 =
                                      new ImageTextAssessmentModel();

        dmsAssessmentModel2.setSubHeader(subHeader);
        dmsAssessmentModel2.setQuestionNo(1);
        dmsAssessmentModel2.setInstruction(answerInstruction);

        List<String> textorurlList2 = new ArrayList<String>();

        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext0.questiontext", locale)));
        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext1.choicetext", locale)));

        dmsAssessmentModel2.setTextOrUrl(textorurlList2);

        /** Set the Answer subOptions 2nd  option for dms* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext5.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext6.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext7.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext8.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext9.subchoicetext", locale)));

        dmsAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd option of question 1 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel3 =
                                        new ImageTextAssessmentModel();

        dmsAssessmentModel3.setSubHeader(subHeader);
        dmsAssessmentModel3.setQuestionNo(1);
        dmsAssessmentModel3.setInstruction(answerInstruction);

        List<String> textorurlList3 = new ArrayList<String>();

        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext0.questiontext", locale)));
        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext2.choicetext", locale)));
        dmsAssessmentModel3.setTextOrUrl(textorurlList3);

        /** Set the Answer subOptions for 3rd option for dms* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext10.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext11.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext12.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext13.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext14.subchoicetext", locale)));
        dmsAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th option of question 1 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel4 =
                                    new ImageTextAssessmentModel();

        dmsAssessmentModel4.setSubHeader(subHeader);
        dmsAssessmentModel4.setQuestionNo(1);
        dmsAssessmentModel4.setInstruction(answerInstruction);

        List<String> textorurlList4 = new ArrayList<String>();

        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext0.questiontext", locale)));
        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext3.choicetext", locale)));
        dmsAssessmentModel4.setTextOrUrl(textorurlList4);

        /** Set the Answer subOptions for 4th option for dms* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext15.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext16.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext17.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext18.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext19.subchoicetext", locale)));
        dmsAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th option of question 1 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel5 =
                                   new ImageTextAssessmentModel();

        dmsAssessmentModel5.setSubHeader(subHeader);
        dmsAssessmentModel5.setQuestionNo(1);
        dmsAssessmentModel5.setInstruction(answerInstruction);

        List<String> textorurlList5 = new ArrayList<String>();

        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext0.questiontext", locale)));
        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext4.choicetext", locale)));
        dmsAssessmentModel5.setTextOrUrl(textorurlList5);

        /** Set the Answer subOptions for 5th option for dms* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext20.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext21.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext22.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext23.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext24.subchoicetext", locale)));
        dmsAssessmentModel5.setQuestionOptions(answerOptions5);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * dmsAssessmentModel
         */


        List<ImageTextAssessmentModel> dmsList =
                              new ArrayList<ImageTextAssessmentModel>();
        dmsList.add(dmsInstructionModel);
        dmsList.add(dmsAssessmentModel1);
        dmsList.add(dmsAssessmentModel2);
        dmsList.add(dmsAssessmentModel3);
        dmsList.add(dmsAssessmentModel4);
        dmsList.add(dmsAssessmentModel5);

        dmsAssessmentModel.setInstructionModel(dmsList);

        return dmsAssessmentModel;
    }

}
