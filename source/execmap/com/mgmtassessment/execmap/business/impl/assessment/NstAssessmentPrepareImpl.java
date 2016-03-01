/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 29, 2006
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
 * This class prepares the Instruction page as well as All the Questions and
 * Answers.
 *
 */

public class NstAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {

    /**
     * This method prepares model for the NST instruction page
     * and Test Page.
     *
     * @param locale
     */
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel NSTAssessmentModel = new AssessmentMainModel();

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");
        ImageTextAssessmentModel NSTInstructionModel =
            new ImageTextAssessmentModel();
        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
              + "/images/nst/";
        
        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/"; 
        
        String subHeader = langHelper.getExecmapMessage("nst2a.nst2a.heading",
                locale);
        /** Set the Image Url attribute for cfs Assessment Trigram * */

        /** Set the Sub Header attribute for NST Assessment Trigram * */
        NSTInstructionModel.setSubHeader(subHeader);

        NSTInstructionModel.setQuestionNo(0);
        /** Set the Time attribute for NST Assessment Trigram * */
        NSTInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "nstx.timer", locale)));
        NSTInstructionModel.setLinkImageUrl(linkImageBase);

        /** Set the Instruction attribute for NST Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nstx.activityinstruction1", locale)));

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nstx.activityinstruction2", locale)));

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nstx.activityinstruction3", locale)));

        /** Set the Instruction attribute for NST Assessment Trigram * */
        List<String> textorurlList = new ArrayList<String>();

        textorurlList.add(imageBase + "nst_Inst.jpg");

        List<String> questionOptions = new ArrayList<String>();

        questionOptions.add(new String(langHelper.getAssesmentMessage(
                "nstx.activityinstruction5", locale)));

        String answerInst = imageBase + "Qi_b.jpg";

        NSTInstructionModel.setInstruction(instructionList);
        NSTInstructionModel.setTextOrUrl(textorurlList);
        NSTInstructionModel.setQuestionOptions(questionOptions);
        NSTInstructionModel.setAnswerInstruction(answerInst);

        /** Set the model for 1st Assessment for NST * */

        ImageTextAssessmentModel NSTInstructionModel1 =
            new ImageTextAssessmentModel();

        String answerInst1 = langHelper.getExecmapMessage(
                "nst2a.nst2a.questionlabel", locale);

        String question1 = langHelper.getExecmapMessage(
                "nst2a.nst2a.str0.questiontext", locale);

        List<String> questionOptions1 = new ArrayList<String>();

        for (int i = 0; i < question1.length(); i++) {
            String questionChar = "" + question1.charAt(i);
            questionOptions1.add(questionChar);

        }
        NSTInstructionModel1.setSubHeader(subHeader);
        NSTInstructionModel1.setQuestionNo(1);
        NSTInstructionModel1.setAnswerInstruction(answerInst1);
        NSTInstructionModel1.setQuestionOptions(questionOptions1);
        NSTInstructionModel1.setLinkImageUrl(linkImageBase);

        /** Set the model for 2nd Assessment for NST * */

        ImageTextAssessmentModel NSTInstructionModel2 =
            new ImageTextAssessmentModel();

        String answerInst2 = langHelper.getExecmapMessage(
                "nst2a.nst2a.questionlabel", locale);

        String question2 = langHelper.getExecmapMessage(
                "nst2a.nst2a.str1.questiontext", locale);

        List<String> questionOptions2 = new ArrayList<String>();

        for (int i = 0; i < question2.length(); i++) {
            String questionChar2 = "" + question2.charAt(i);
            questionOptions2.add(questionChar2);

        }
        NSTInstructionModel2.setSubHeader(subHeader);
        NSTInstructionModel2.setQuestionNo(2);
        NSTInstructionModel2.setAnswerInstruction(answerInst2);
        NSTInstructionModel2.setQuestionOptions(questionOptions2);
        NSTInstructionModel2.setLinkImageUrl(linkImageBase);

        /** Set the model for 3nd Assessment for NST * */

        ImageTextAssessmentModel NSTInstructionModel3 =
            new ImageTextAssessmentModel();

        String answerInst3 = langHelper.getExecmapMessage(
                "nst2a.nst2a.questionlabel", locale);

        String question3 = langHelper.getExecmapMessage(
                "nst2a.nst2a.str2.questiontext", locale);

        List<String> questionOptions3 = new ArrayList<String>();

        for (int i = 0; i < question3.length(); i++) {
            String questionChar3 = "" + question3.charAt(i);
            questionOptions3.add(questionChar3);

        }
        NSTInstructionModel3.setSubHeader(subHeader);
        NSTInstructionModel3.setQuestionNo(3);
        NSTInstructionModel3.setAnswerInstruction(answerInst3);
        NSTInstructionModel3.setQuestionOptions(questionOptions3);
        NSTInstructionModel3.setLinkImageUrl(linkImageBase);

        /** Set the model for 4th Assessment for NST * */

        ImageTextAssessmentModel NSTInstructionModel4 =
            new ImageTextAssessmentModel();

        String answerInst4 = langHelper.getExecmapMessage(
                "nst2a.nst2a.questionlabel", locale);

        String question4 = langHelper.getExecmapMessage(
                "nst2a.nst2a.str3.questiontext", locale);

        List<String> questionOptions4 = new ArrayList<String>();

        for (int i = 0; i < question4.length(); i++) {
            String questionChar4 = "" + question4.charAt(i);
            questionOptions4.add(questionChar4);

        }
        NSTInstructionModel4.setSubHeader(subHeader);
        NSTInstructionModel4.setQuestionNo(4);
        NSTInstructionModel4.setAnswerInstruction(answerInst4);
        NSTInstructionModel4.setQuestionOptions(questionOptions4);
        NSTInstructionModel4.setLinkImageUrl(linkImageBase);

        /** Set the model for 5th Assessment for NST * */

        ImageTextAssessmentModel NSTInstructionModel5 =
            new ImageTextAssessmentModel();

        String answerInst5 = langHelper.getExecmapMessage(
                "nst2a.nst2a.questionlabel", locale);

        String question5 = langHelper.getExecmapMessage(
                "nst2a.nst2a.str4.questiontext", locale);

        List<String> questionOptions5 = new ArrayList<String>();

        for (int i = 0; i < question5.length(); i++) {
            String questionChar5 = "" + question5.charAt(i);
            questionOptions5.add(questionChar5);

        }
        NSTInstructionModel5.setSubHeader(subHeader);
        NSTInstructionModel5.setQuestionNo(5);
        NSTInstructionModel5.setAnswerInstruction(answerInst5);
        NSTInstructionModel5.setQuestionOptions(questionOptions5);
        NSTInstructionModel5.setLinkImageUrl(linkImageBase);

        List<ImageTextAssessmentModel> nstList =
            new ArrayList<ImageTextAssessmentModel>();
        nstList.add(NSTInstructionModel);
        nstList.add(NSTInstructionModel1);
        nstList.add(NSTInstructionModel2);
        nstList.add(NSTInstructionModel3);
        nstList.add(NSTInstructionModel4);
        nstList.add(NSTInstructionModel5);

        NSTAssessmentModel.setInstructionModel(nstList);

        return NSTAssessmentModel;

    }

}
