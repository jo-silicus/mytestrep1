/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * 
 * @author : KapilPra
 * @date : Aug 30, 2006
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

public class NfuAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel nfuAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/nfux/";

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** Set the Instruction attribute for NFU Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nfux.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nfux.activityinstruction2", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nfux.activityinstruction3", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nfux.activityinstruction4", locale)));

        /** Set the Sub Header attribute for NFU Assessment Trigram * */
        String subHeader = langHelper.getExecmapMessage("nfux.nfux.nfuheading",
                locale);

        /*
         * ImageTextAssessmentModel nfuInstructionModel = new
         * ImageTextAssessmentModel();
         * nfuInstructionModel.setSubHeader(subHeader);
         * 
         *//** Set the Time attribute for NFU Assessment Trigram * */
        /*
         * nfuInstructionModel.setTime(new
         * String(langHelper.getAssesmentMessage( "escx.timer", locale)));
         * 
         * nfuInstructionModel.setInstruction(instructionList);
         * 
         *//** Set the Answer Instruction attribute for NFU Assessment Trigram * */
        /*
         * nfuInstructionModel.setAnswerInstruction(langHelper
         * .getAssesmentMessage("nfux.activityinstruction3", locale));
         * 
         *//** Set the Question Number attribute for NFU Assessment Trigram * */
        /*
         * nfuInstructionModel.setQuestionNo(0);
         */

        /**
         * Set the model for 1st Assessment for playing the sound in NFU *
         */
        ImageTextAssessmentModel nfuAssessmentModel1 = new ImageTextAssessmentModel();
        nfuAssessmentModel1.setSubHeader(subHeader);
        nfuAssessmentModel1.setInstruction(instructionList);
        nfuAssessmentModel1.setTime("20");
        nfuAssessmentModel1.setAnswerInstruction("180");
        nfuAssessmentModel1.setQuestionNo(1);

        List<String> questionoptions = new ArrayList<String>();
        questionoptions.add(langHelper.getExecmapMessage(
                "nfux.Question1.number1", locale));
        questionoptions.add(langHelper.getExecmapMessage(
                "nfux.Question1.number2", locale));
        questionoptions.add(langHelper.getExecmapMessage(
                "nfux.Question1.number1", locale));
        questionoptions.add(langHelper.getExecmapMessage(
                "nfux.Question1.number3", locale));
        nfuAssessmentModel1.setQuestionOptions(questionoptions);
        /** Set the model for Wait in the 1st Assessment for NFU * */

        ImageTextAssessmentModel nfuAssessmentModel2 = new ImageTextAssessmentModel();
        nfuAssessmentModel2.setSubHeader(subHeader);

        nfuAssessmentModel2.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        nfuAssessmentModel2.setTime("5");
        nfuAssessmentModel2.setQuestionNo(1);

        /** Set the model for Question in the 1st Assessment for NFU * */

        ImageTextAssessmentModel nfuAssessmentModel3 = new ImageTextAssessmentModel();
        nfuAssessmentModel3.setSubHeader(subHeader);
        List<String> textorurlList = new ArrayList<String>();
        textorurlList.add(new String(langHelper.getAssesmentMessage(
                "nfux.nfux.questiontext1.questiontext", locale)));
        nfuAssessmentModel3.setTextOrUrl(textorurlList);
        nfuAssessmentModel3.setQuestionNo(1);

        List<String> questionoptions3 = new ArrayList<String>();
        questionoptions3.add(langHelper.getExecmapMessage(
                "nfux.number1.option1", locale));
        questionoptions3.add(langHelper.getExecmapMessage(
                "nfux.number1.option2", locale));
        questionoptions3.add(langHelper.getExecmapMessage(
                "nfux.number1.option3", locale));
        questionoptions3.add(langHelper.getExecmapMessage(
                "nfux.number1.option4", locale));
        questionoptions3.add(langHelper.getExecmapMessage(
                "nfux.number1.option5", locale));
        nfuAssessmentModel3.setQuestionOptions(questionoptions3);

        /**
         * Set the model for 2nd Assessment for playing the sound in NFU *
         */
        ImageTextAssessmentModel nfuAssessmentModel4 = new ImageTextAssessmentModel();
        nfuAssessmentModel4.setSubHeader(subHeader);
        nfuAssessmentModel4.setInstruction(instructionList);
        nfuAssessmentModel4.setTime("20");
        nfuAssessmentModel4.setQuestionNo(2);

        List<String> questionoptions4 = new ArrayList<String>();
        questionoptions4.add(langHelper.getExecmapMessage(
                "nfux.Question2.number1", locale));
        questionoptions4.add(langHelper.getExecmapMessage(
                "nfux.Question2.number2", locale));
        questionoptions4.add(langHelper.getExecmapMessage(
                "nfux.Question2.number3", locale));
        questionoptions4.add(langHelper.getExecmapMessage(
                "nfux.Question2.number4", locale));
        nfuAssessmentModel4.setQuestionOptions(questionoptions4);

        /** Set the model for Wait in the 2nd Assessment for NFU * */

        ImageTextAssessmentModel nfuAssessmentModel5 = new ImageTextAssessmentModel();
        nfuAssessmentModel5.setSubHeader(subHeader);

        nfuAssessmentModel5.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        nfuAssessmentModel5.setTime("5");
        nfuAssessmentModel5.setQuestionNo(2);

        /** Set the model for Question in the 2nd Assessment for NFU * */

        ImageTextAssessmentModel nfuAssessmentModel6 = new ImageTextAssessmentModel();
        nfuAssessmentModel6.setSubHeader(subHeader);
        List<String> textorurlList6 = new ArrayList<String>();
        nfuAssessmentModel6.setTextOrUrl(textorurlList);
        nfuAssessmentModel6.setQuestionNo(2);

        List<String> questionoptions6 = new ArrayList<String>();
        questionoptions6.add(langHelper.getExecmapMessage(
                "nfux.number2.option1", locale));
        questionoptions6.add(langHelper.getExecmapMessage(
                "nfux.number2.option2", locale));
        questionoptions6.add(langHelper.getExecmapMessage(
                "nfux.number2.option3", locale));
        questionoptions6.add(langHelper.getExecmapMessage(
                "nfux.number2.option4", locale));
        questionoptions6.add(langHelper.getExecmapMessage(
                "nfux.number2.option5", locale));
        nfuAssessmentModel6.setQuestionOptions(questionoptions6);

        /**
         * Set the model for 3rd Assessment for playing the sound in NFU *
         */
        ImageTextAssessmentModel nfuAssessmentModel7 = new ImageTextAssessmentModel();
        nfuAssessmentModel7.setSubHeader(subHeader);
        nfuAssessmentModel7.setInstruction(instructionList);
        nfuAssessmentModel7.setTime("20");
        nfuAssessmentModel7.setQuestionNo(3);

        List<String> questionoptions7 = new ArrayList<String>();
        questionoptions7.add(langHelper.getExecmapMessage(
                "nfux.Question3.number1", locale));
        questionoptions7.add(langHelper.getExecmapMessage(
                "nfux.Question3.number2", locale));
        questionoptions7.add(langHelper.getExecmapMessage(
                "nfux.Question3.number3", locale));
        questionoptions7.add(langHelper.getExecmapMessage(
                "nfux.Question3.number4", locale));
        nfuAssessmentModel7.setQuestionOptions(questionoptions7);

        /** Set the model for Wait in the 3rd Assessment for NFU * */

        ImageTextAssessmentModel nfuAssessmentModel8 = new ImageTextAssessmentModel();
        nfuAssessmentModel8.setSubHeader(subHeader);

        nfuAssessmentModel8.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        nfuAssessmentModel8.setTime("5");
        nfuAssessmentModel8.setQuestionNo(3);

        /** Set the model for Question in the 3rd Assessment for NFU * */

        ImageTextAssessmentModel nfuAssessmentModel9 = new ImageTextAssessmentModel();
        nfuAssessmentModel9.setSubHeader(subHeader);
        nfuAssessmentModel9.setTextOrUrl(textorurlList);
        nfuAssessmentModel9.setQuestionNo(3);

        List<String> questionoptions9 = new ArrayList<String>();
        questionoptions9.add(langHelper.getExecmapMessage(
                "nfux.number3.option1", locale));
        questionoptions9.add(langHelper.getExecmapMessage(
                "nfux.number3.option2", locale));
        questionoptions9.add(langHelper.getExecmapMessage(
                "nfux.number3.option3", locale));
        questionoptions9.add(langHelper.getExecmapMessage(
                "nfux.number3.option4", locale));
        questionoptions9.add(langHelper.getExecmapMessage(
                "nfux.number3.option5", locale));
        nfuAssessmentModel9.setQuestionOptions(questionoptions9);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * escAssessmentModel
         */

        List<ImageTextAssessmentModel> nfuList = new ArrayList<ImageTextAssessmentModel>();
        nfuList.add(nfuAssessmentModel1);
        nfuList.add(nfuAssessmentModel2);
        nfuList.add(nfuAssessmentModel3);
        
        nfuList.add(nfuAssessmentModel4);
        nfuList.add(nfuAssessmentModel5);
        nfuList.add(nfuAssessmentModel6);
        
        nfuList.add(nfuAssessmentModel7);
        nfuList.add(nfuAssessmentModel8);
        nfuList.add(nfuAssessmentModel9);

        nfuAssessmentModel.setInstructionModel(nfuList);

        return nfuAssessmentModel;
    }
}
