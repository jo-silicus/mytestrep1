/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * 
 * @author : KapilPra
 * @date : Aug 18, 2006
 * @version:
 * 
 * @history Description Reference Name Date
 * 
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
 * TODO Write java docs comments for this type
 * 
 */

public class EscAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel escAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/escx/";
        
        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** ESC Assessment Activity Answering Instructions * */
        List<String> answerInstruction = new ArrayList<String>();
        answerInstruction.add(langHelper.getAssesmentMessage(
                "emsx.activityinstruction6", locale));

        ImageTextAssessmentModel escInstructionModel = new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("generic.escheading",
                locale);
        /** Set the Sub Header attribute for ESC Assessment Trigram * */
        escInstructionModel.setSubHeader(subHeader);

        /** Set the Activity Time attribute for ESC Assessment Trigram * */
        escInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "escx.timer", locale)));
        escInstructionModel.setQuestionNo(0);

        escInstructionModel.setAnswerInstruction(new String(langHelper
                .getAssesmentMessage("escx.activityinstruction2", locale)));
        escInstructionModel.setLinkImageUrl(linkImageBase);

        /** Set the Image Url attribute for ESC Assessment Trigram * */
        List<String> textorurlList = new ArrayList<String>();
        textorurlList.add(imageBase + "Qi_b.jpg");
        escInstructionModel.setTextOrUrl(textorurlList);

        /** Set the Instruction attribute for ESC Assessment Trigram * */
        List<String> instruction = new ArrayList<String>();
        instruction.add(new String(langHelper.getAssesmentMessage(
                "escx.activityinstruction1", locale)));
        instruction.add(new String(langHelper.getAssesmentMessage(
                "escx.activityinstruction2", locale)));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction11", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction12", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction13", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction14", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction15", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction16", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction6", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction7", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "escx.activityinstruction8", locale));
        escInstructionModel.setInstruction(instruction);

        /** Set the Answer Instruction attribute for ESC Assessment Trigram * */
        escInstructionModel.setAnswerInstruction(langHelper
                .getAssesmentMessage("escx.activityinstruction4", locale));

        /** Set the Answer Options for ESC Instruction* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "esc1.esc1.choiceimage0.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "esc1.esc1.choiceimage1.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "esc1.esc1.choiceimage2.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "esc1.esc1.choiceimage3.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "esc1.esc1.choiceimage4.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "esc1.esc1.choiceimage5.choice", locale)));
        escInstructionModel.setQuestionOptions(answerOptions);

        /** Set the model for 1st Assessment for ESC * */
        ImageTextAssessmentModel escAssessmentModel1 = new ImageTextAssessmentModel();

        escAssessmentModel1.setTextOrUrl(textorurlList);
        escAssessmentModel1.setQuestionNo(1);
        escAssessmentModel1.setInstruction(answerInstruction);
        escAssessmentModel1.setAnswerInstruction(langHelper.getExecmapMessage(
                "esc1.esc1.questiontext4.questiontext", locale));

        escAssessmentModel1.setQuestionOptions(answerOptions);
        escAssessmentModel1.setLinkImageUrl(linkImageBase);

        /** Set the model for 2nd Assessment for ESC * */
        ImageTextAssessmentModel escAssessmentModel2 = new ImageTextAssessmentModel();

        escAssessmentModel2.setSubHeader(subHeader);

        escAssessmentModel2.setTextOrUrl(textorurlList);
        escAssessmentModel2.setQuestionNo(2);
        escAssessmentModel2.setInstruction(answerInstruction);
        escAssessmentModel2.setAnswerInstruction(langHelper.getExecmapMessage(
                "esc1.esc1.questiontext5.questiontext", locale));

        /** Set the Answer Options for 2nd ESC Assessment* */

        escAssessmentModel2.setQuestionOptions(answerOptions);
        escAssessmentModel2.setLinkImageUrl(linkImageBase);

        /** Set the model for 3rd Assessment for ESC * */
        ImageTextAssessmentModel escAssessmentModel3 = new ImageTextAssessmentModel();

        escAssessmentModel3.setSubHeader(subHeader);

        escAssessmentModel3.setTextOrUrl(textorurlList);
        escAssessmentModel3.setQuestionNo(3);
        escAssessmentModel3.setInstruction(answerInstruction);
        escAssessmentModel3.setAnswerInstruction(langHelper.getExecmapMessage(
                "esc1.esc1.questiontext6.questiontext", locale));

        /** Set the Answer Options for 3rd ESC Assessment* */

        escAssessmentModel3.setQuestionOptions(answerOptions);
        escAssessmentModel3.setLinkImageUrl(linkImageBase);

        /** Set the model for 4th Assessment for ESC * */
        ImageTextAssessmentModel escAssessmentModel4 = new ImageTextAssessmentModel();

        escAssessmentModel4.setSubHeader(subHeader);

        escAssessmentModel4.setTextOrUrl(textorurlList);
        escAssessmentModel4.setQuestionNo(4);
        escAssessmentModel4.setInstruction(answerInstruction);
        escAssessmentModel4.setAnswerInstruction(langHelper.getExecmapMessage(
                "esc1.esc1.questiontext7.questiontext", locale));

        /** Set the Answer Options for 4th ESC Assessment* */

        escAssessmentModel4.setQuestionOptions(answerOptions);
        escAssessmentModel4.setLinkImageUrl(linkImageBase);

        /** Set the model for 5th Assessment for ESC * */
        ImageTextAssessmentModel escAssessmentModel5 = new ImageTextAssessmentModel();

        escAssessmentModel5.setSubHeader(subHeader);

        escAssessmentModel5.setTextOrUrl(textorurlList);
        escAssessmentModel5.setQuestionNo(5);
        escAssessmentModel5.setInstruction(answerInstruction);
        escAssessmentModel5.setAnswerInstruction(langHelper.getExecmapMessage(
                "esc1.esc1.questiontext8.questiontext", locale));

        /** Set the Answer Options for 5th ESC Assessment* */

        escAssessmentModel5.setQuestionOptions(answerOptions);
        escAssessmentModel5.setLinkImageUrl(linkImageBase);

        /** Set the model for 6th Assessment for ESC * */
        ImageTextAssessmentModel escAssessmentModel6 = new ImageTextAssessmentModel();

        escAssessmentModel6.setSubHeader(subHeader);

        escAssessmentModel6.setTextOrUrl(textorurlList);
        escAssessmentModel6.setQuestionNo(6);
        escAssessmentModel6.setInstruction(answerInstruction);
        escAssessmentModel6.setAnswerInstruction(langHelper.getExecmapMessage(
                "esc1.esc1.questiontext9.questiontext", locale));

        /** Set the Answer Options for 6th ESC Assessment* */

        escAssessmentModel6.setQuestionOptions(answerOptions);
        escAssessmentModel6.setLinkImageUrl(linkImageBase);
        /**
         * Add the Instruction Model and the AssessmentModel to the
         * escAssessmentModel
         */

        // List<ImageTextAssessmentModel> escList =
        // (ArrayList)escAssessmentModel.getInstructionModel();
        List<ImageTextAssessmentModel> escList = new ArrayList<ImageTextAssessmentModel>();
        escList.add(escInstructionModel);
        escList.add(escAssessmentModel1);
        escList.add(escAssessmentModel2);
        escList.add(escAssessmentModel3);
        escList.add(escAssessmentModel4);
        escList.add(escAssessmentModel5);
        escList.add(escAssessmentModel6);

        escAssessmentModel.setInstructionModel(escList);

        return escAssessmentModel;
    }
}
