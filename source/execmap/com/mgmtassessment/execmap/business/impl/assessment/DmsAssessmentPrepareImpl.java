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
 * This class prepares model for the DMS Assessment
 * trigram.
 * @author singhrau
 *
 */

public class DmsAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {

    /**
     * This method prepares the model for dms assessment
     * trigram.
     * @param locale
     * @return dmsAssessmentModel
     */

    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel dmsAssessmentModel = new AssessmentMainModel();

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper)appCtxt
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

        dmsInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "dmsx.timer", locale)));

        /** Set the Instruction attribute for CMI Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "dmsx.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "dmsx.activityinstruction2", locale)));

        /** Set the Instruction attribute for dms Assessment Trigram * */
        dmsInstructionModel.setInstruction(instructionList);

        /** Set the Answer Instruction attribute for dms Assessment Trigram * */
        dmsInstructionModel.setAnswerInstruction(langHelper
                .getAssesmentMessage("dmsx.activityinstruction5", locale));

        /** Set the model for 1st Assessment for dms * */
        ImageTextAssessmentModel dmsAssessmentModel1 =
                                         new ImageTextAssessmentModel();

        dmsAssessmentModel1.setSubHeader(subHeader);

        List<String> textorurlList1 = new ArrayList<String>();

        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext0.questiontext", locale)));

        dmsAssessmentModel1.setTextOrUrl(textorurlList1);
        dmsAssessmentModel1.setQuestionNo(1);
        dmsAssessmentModel1.setInstruction(answerInstruction);

        /** Set the Answer Options for 1st dms Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext0.choicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext1.choicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext2.choicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext3.choicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext4.choicetext", locale)));

        dmsAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd Assessment for dms * */
        ImageTextAssessmentModel dmsAssessmentModel2 =
                                        new ImageTextAssessmentModel();

        dmsAssessmentModel2.setSubHeader(subHeader);
        dmsAssessmentModel2.setQuestionNo(2);
        dmsAssessmentModel2.setInstruction(answerInstruction);

        List<String> textorurlList2 = new ArrayList<String>();

        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext1.questiontext", locale)));

        dmsAssessmentModel2.setTextOrUrl(textorurlList2);

        /** Set the Answer Options for 2nd dms Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext5.choicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext6.choicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext7.choicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext8.choicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext9.choicetext", locale)));

        dmsAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for dms * */
        ImageTextAssessmentModel dmsAssessmentModel3 =
                                         new ImageTextAssessmentModel();

        dmsAssessmentModel3.setSubHeader(subHeader);
        dmsAssessmentModel3.setQuestionNo(3);
        dmsAssessmentModel3.setInstruction(answerInstruction);

        List<String> textorurlList3 = new ArrayList<String>();

        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext2.questiontext", locale)));

        dmsAssessmentModel3.setTextOrUrl(textorurlList3);

        /** Set the Answer Options for 3rd dms Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext10.choicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext11.choicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext12.choicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext13.choicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext14.choicetext", locale)));
        dmsAssessmentModel3.setQuestionOptions(answerOptions3);

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

        dmsAssessmentModel.setInstructionModel(dmsList);

        return dmsAssessmentModel;
    }

}
