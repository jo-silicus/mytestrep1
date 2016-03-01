/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 30, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.mgmtassessment.execmap.business.api.assessment.AssessmentPrepare;
import com.mgmtassessment.execmap.business.model.AssessmentMainModel;
import com.mgmtassessment.execmap.business.model.ImageTextAssessmentModel;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.TranslateHelper;

/**
 * This class prepares the model for the the suboptions related to question
 * number three of the dms assessment trigram.
 * @author singhrau
 *
 */

public class Dms3AssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {

    /**
     * This method prepares the model for the the suboptions related to question
     * number three of the dms assessment trigram.
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

        /** Set the model for 1st option of question 3 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel1 =
                                 new ImageTextAssessmentModel();

        dmsAssessmentModel1.setSubHeader(subHeader);
        dmsAssessmentModel1.setQuestionNo(3);
        List<String> textorurlList1 = new ArrayList<String>();

        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext2.questiontext", locale)));
        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext10.choicetext", locale)));
        dmsAssessmentModel1.setTextOrUrl(textorurlList1);
        dmsAssessmentModel1.setInstruction(answerInstruction);

        /** Set the Answer subOptions for 1st option dms Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext50.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext51.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext52.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext53.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext54.subchoicetext", locale)));

        dmsAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd option of question 3 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel2 =
                                     new ImageTextAssessmentModel();

        dmsAssessmentModel2.setSubHeader(subHeader);
        dmsAssessmentModel2.setQuestionNo(3);
        dmsAssessmentModel2.setInstruction(answerInstruction);

        List<String> textorurlList2 = new ArrayList<String>();

        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext2.questiontext", locale)));
        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext11.choicetext", locale)));

        dmsAssessmentModel2.setTextOrUrl(textorurlList2);

        /** Set the Answer subOptions for 2nd option for dms Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext55.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext56.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext57.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext58.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext59.subchoicetext", locale)));

        dmsAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd option of question 3 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel3 =
                                    new ImageTextAssessmentModel();

        dmsAssessmentModel3.setSubHeader(subHeader);
        dmsAssessmentModel3.setQuestionNo(3);
        dmsAssessmentModel3.setInstruction(answerInstruction);

        List<String> textorurlList3 = new ArrayList<String>();

        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext2.questiontext", locale)));
        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext12.choicetext", locale)));
        dmsAssessmentModel3.setTextOrUrl(textorurlList3);

        /** Set the Answer subOptions for 3rd option for dms Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext60.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext61.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext62.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext63.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext64.subchoicetext", locale)));
        dmsAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th option of question 3 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel4 =
                                        new ImageTextAssessmentModel();

        dmsAssessmentModel4.setSubHeader(subHeader);
        dmsAssessmentModel4.setQuestionNo(3);
        dmsAssessmentModel4.setInstruction(answerInstruction);

        List<String> textorurlList4 = new ArrayList<String>();

        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext2.questiontext", locale)));
        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext13.choicetext", locale)));
        dmsAssessmentModel4.setTextOrUrl(textorurlList4);

        /** Set the Answer subOptions for 4th option of dms Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext65.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext66.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext67.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext68.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext69.subchoicetext", locale)));
        dmsAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th option of question 3 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel5 =
                                      new ImageTextAssessmentModel();

        dmsAssessmentModel5.setSubHeader(subHeader);
        dmsAssessmentModel5.setQuestionNo(3);
        dmsAssessmentModel5.setInstruction(answerInstruction);

        List<String> textorurlList5 = new ArrayList<String>();

        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext2.questiontext", locale)));
        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext14.choicetext", locale)));
        dmsAssessmentModel5.setTextOrUrl(textorurlList5);
     
        /** Set the Answer subOptions for 5th option for dms Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext70.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext71.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext72.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext73.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext74.subchoicetext", locale)));
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
