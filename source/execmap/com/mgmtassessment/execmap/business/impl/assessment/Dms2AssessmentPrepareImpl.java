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
 * number two of the dms assessment trigram.
 * @author singhrau
 *
 */

public class Dms2AssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
   /**
    * This method prepares the model for the the suboptions related to question
    * number two of the dms assessment trigram.
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


        /** Set the model for 1st option of question 2 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel1 =
                                    new ImageTextAssessmentModel();

        dmsAssessmentModel1.setSubHeader(subHeader);

        List<String> textorurlList1 = new ArrayList<String>();

        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext1.questiontext", locale)));
        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext5.choicetext", locale)));
        dmsAssessmentModel1.setTextOrUrl(textorurlList1);
        dmsAssessmentModel1.setQuestionNo(2);
        dmsAssessmentModel1.setInstruction(answerInstruction);

        /** Set the Answer subOptions of 1st option for dms Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext25.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext26.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext27.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext28.subchoicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext29.subchoicetext", locale)));

        dmsAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd option of question 2 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel2 =
                                      new ImageTextAssessmentModel();

        dmsAssessmentModel2.setSubHeader(subHeader);
        dmsAssessmentModel2.setQuestionNo(2);
        dmsAssessmentModel2.setInstruction(answerInstruction);

        List<String> textorurlList2 = new ArrayList<String>();

        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext1.questiontext", locale)));
        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext6.choicetext", locale)));

        dmsAssessmentModel2.setTextOrUrl(textorurlList2);

        /** Set the Answer subOptions for 2nd option for dms Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext30.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext31.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext32.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext33.subchoicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext34.subchoicetext", locale)));

        dmsAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd option of question 2 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel3 =
                                      new ImageTextAssessmentModel();

        dmsAssessmentModel3.setSubHeader(subHeader);
        dmsAssessmentModel3.setQuestionNo(2);
        dmsAssessmentModel3.setInstruction(answerInstruction);

        List<String> textorurlList3 = new ArrayList<String>();

        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext1.questiontext", locale)));
        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext7.choicetext", locale)));
        dmsAssessmentModel3.setTextOrUrl(textorurlList3);

        /** Set the Answer Options for 3rd option for dms Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext35.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext36.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext37.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext38.subchoicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext39.subchoicetext", locale)));
        dmsAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th option of question 2 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel4 =
                                        new ImageTextAssessmentModel();

        dmsAssessmentModel4.setSubHeader(subHeader);
        dmsAssessmentModel4.setQuestionNo(2);
        dmsAssessmentModel4.setInstruction(answerInstruction);

        List<String> textorurlList4 = new ArrayList<String>();

        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext1.questiontext", locale)));
        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext8.choicetext", locale)));
        dmsAssessmentModel4.setTextOrUrl(textorurlList4);

        /** Set the Answer Options for 4th option for dms Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext40.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext41.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext42.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext43.subchoicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext44.subchoicetext", locale)));
        dmsAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th option of question 2 for dms * */
        ImageTextAssessmentModel dmsAssessmentModel5 =
                                            new ImageTextAssessmentModel();

        dmsAssessmentModel5.setSubHeader(subHeader);
        dmsAssessmentModel5.setQuestionNo(2);
        dmsAssessmentModel5.setInstruction(answerInstruction);

        List<String> textorurlList5 = new ArrayList<String>();

        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.questiontext1.questiontext", locale)));
        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.choicetext9.choicetext", locale)));
        dmsAssessmentModel5.setTextOrUrl(textorurlList5);

        /** Set the Answer Options for 5th option for dms Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext45.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext46.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext47.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext48.subchoicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "dmsx.dmsx.subchoicetext49.subchoicetext", locale)));
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
