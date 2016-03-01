/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : KapilPra 
 *  @date   : Sep 8, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
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

public class MemwsAssessmentPrepareImpl extends AbstractFacadeImpl implements
AssessmentPrepare {
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel memAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/memx/";

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        ImageTextAssessmentModel memInstructionModel = new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("memx.memx.memheading",
                locale);
        /** Set the Sub Header attribute for MEM Assessment Trigram * */

        memInstructionModel.setSubHeader(subHeader);

        List<String> textorurlList = new ArrayList<String>();

        /** Set the Time attribute for MEM Assessment Trigram * */
        memInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "memx.timer", locale)));

        /** Set the Instruction attribute for MEM Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "memx1.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "memx1.activityinstruction2", locale)));
        memInstructionModel.setInstruction(instructionList);

        /** Set the Answer Instruction attribute for MEM Assessment Trigram * */
        memInstructionModel.setAnswerInstruction(langHelper
                .getAssesmentMessage("memx1.activityinstruction3", locale));

        /** Set the Question Number attribute for MEM Assessment Trigram * */
        memInstructionModel.setQuestionNo(0);

     
        /**
         * Set the model for 1st Assessment for remembering the number in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel1 = new ImageTextAssessmentModel();
        memAssessmentModel1.setSubHeader(subHeader);

        memAssessmentModel1.setTime("10");
        List<String> number = new ArrayList<String>();
        number.add(langHelper.getExecmapMessage(
                "memx.memx.questiontext2.number", locale));

        memAssessmentModel1.setTextOrUrl(number);
        memAssessmentModel1.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.visual.questiontext0.remember", locale));

        memAssessmentModel1.setQuestionNo(1);

        /** Set the model for Wait in the 1st Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel2 = new ImageTextAssessmentModel();
        memAssessmentModel2.setSubHeader(subHeader);

        memAssessmentModel2.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel2.setTime("5");
        memAssessmentModel2.setQuestionNo(1);

        /** Set the model for Question in the 1st Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel3 = new ImageTextAssessmentModel();
        memAssessmentModel3.setSubHeader(subHeader);

        memAssessmentModel3.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext2.leaveout", locale));
        memAssessmentModel3.setQuestionNo(1);

       /**
         * Set the model for 2nd Assessment for remembering the number in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel4 = new ImageTextAssessmentModel();
        memAssessmentModel4.setSubHeader(subHeader);

        memAssessmentModel4.setTime("10");
        List<String> number2 = new ArrayList<String>();
        number2.add(langHelper.getExecmapMessage(
                "memx.memx.questiontext4.number", locale));

        memAssessmentModel4.setTextOrUrl(number2);
        memAssessmentModel4.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.visual.questiontext0.remember", locale));
        memAssessmentModel4.setQuestionNo(2);

        /** Set the model for Wait in the 2nd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel5 = new ImageTextAssessmentModel();
        memAssessmentModel5.setSubHeader(subHeader);

        memAssessmentModel5.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel5.setTime("5");
        memAssessmentModel5.setQuestionNo(2);

        /** Set the model for Question in the 2nd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel6 = new ImageTextAssessmentModel();
        memAssessmentModel6.setSubHeader(subHeader);

        memAssessmentModel6.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext4.questiontext", locale));
        memAssessmentModel6.setQuestionNo(2);

        /**
         * Set the model for 3rd Assessment for remembering the options in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel7 = new ImageTextAssessmentModel();
        memAssessmentModel7.setSubHeader(subHeader);

        List<String> options = new ArrayList<String>();
        options.add(langHelper.getExecmapMessage("memx.q5option1", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option2", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option3", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option4", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option5", locale));

        memAssessmentModel7.setQuestionOptions(options);
        memAssessmentModel7.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext5.questiontext", locale));
        memAssessmentModel7.setQuestionNo(3);
        memAssessmentModel7.setTime("10");

        /** Set the model for Wait in the 3rd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel8 = new ImageTextAssessmentModel();
        memAssessmentModel8.setSubHeader(subHeader);

        memAssessmentModel8.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel8.setTime("5");
        memAssessmentModel8.setQuestionNo(3);

        /** Set the model for first Question in the 3rd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel9 = new ImageTextAssessmentModel();
        memAssessmentModel9.setSubHeader(subHeader);

        memAssessmentModel9.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext5a.questiontext", locale));
        List<String> questionoptions = new ArrayList<String>();
        questionoptions.add(langHelper
                .getExecmapMessage("memx.q5Aopt1", locale));
        questionoptions.add(langHelper
                .getExecmapMessage("memx.q5Aopt2", locale));
        questionoptions.add(langHelper
                .getExecmapMessage("memx.q5Aopt3", locale));
        questionoptions.add(langHelper
                .getExecmapMessage("memx.q5Aopt4", locale));
        questionoptions.add(langHelper
                .getExecmapMessage("memx.q5Aopt5", locale));
        questionoptions.add(langHelper
                .getExecmapMessage("memx.q5Aopt6", locale));

        memAssessmentModel9.setQuestionOptions(questionoptions);
        memAssessmentModel9.setQuestionNo(3);

        /** Set the model for second Question in the 3rd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel10 = new ImageTextAssessmentModel();
        memAssessmentModel10.setSubHeader(subHeader);

        memAssessmentModel10.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext5b.questiontext", locale));
        List<String> questionoptions2 = new ArrayList<String>();
        questionoptions2.add(langHelper.getExecmapMessage("memx.q5Bopt1",
                locale));
        questionoptions2.add(langHelper.getExecmapMessage("memx.q5Bopt2",
                locale));
        questionoptions2.add(langHelper.getExecmapMessage("memx.q5Bopt3",
                locale));
        questionoptions2.add(langHelper.getExecmapMessage("memx.q5Bopt4",
                locale));
        questionoptions2.add(langHelper.getExecmapMessage("memx.q5Bopt5",
                locale));
        questionoptions2.add(langHelper.getExecmapMessage("memx.q5Bopt6",
                locale));

        memAssessmentModel10.setQuestionOptions(questionoptions2);
        memAssessmentModel10.setQuestionNo(3);
      
        /**
         * Add the Instruction Model and the AssessmentModel to the
         * escAssessmentModel
         */

        List<ImageTextAssessmentModel> memList = new ArrayList<ImageTextAssessmentModel>();
        memList.add(memInstructionModel);
        memList.add(memAssessmentModel1);
        memList.add(memAssessmentModel2);
        memList.add(memAssessmentModel3);

        memList.add(memAssessmentModel4);
        memList.add(memAssessmentModel5);
        memList.add(memAssessmentModel6);

        memList.add(memAssessmentModel7);
        memList.add(memAssessmentModel8);
        memList.add(memAssessmentModel9);
        memList.add(memAssessmentModel10);

        memAssessmentModel.setInstructionModel(memList);

        return memAssessmentModel;
    }
}
