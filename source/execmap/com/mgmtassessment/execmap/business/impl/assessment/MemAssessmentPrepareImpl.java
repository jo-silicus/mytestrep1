/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * 
 * @author : KapilPra
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
 * TODO Write java docs comments for this type
 * 
 */

public class MemAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {

    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel memAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/memx/";
        
        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";

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
                "memx.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "memx.activityinstruction2", locale)));
        memInstructionModel.setInstruction(instructionList);

        /** Set the Answer Instruction attribute for MEM Assessment Trigram * */
        memInstructionModel.setAnswerInstruction(langHelper
                .getAssesmentMessage("memx.activityinstruction3", locale));

        /** Set the Question Number attribute for MEM Assessment Trigram * */
        memInstructionModel.setQuestionNo(0);
        memInstructionModel.setLinkImageUrl(linkImageBase);

        /**
         * Set the model for 1st Assessment for playing the sound in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel1 = new ImageTextAssessmentModel();
        memAssessmentModel1.setSubHeader(subHeader);

        List<String> soundpath = new ArrayList<String>();
        soundpath.add(imageBase + "q1.au");
        memAssessmentModel1.setTime("10");
        memAssessmentModel1.setTextOrUrl(soundpath);
        memAssessmentModel1.setQuestionNo(1);
        memAssessmentModel1.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.sound.questiontext0.questiontext", locale));
        memAssessmentModel1.setLinkImageUrl(linkImageBase);

        /** Set the model for Wait in the 1st Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel2 = new ImageTextAssessmentModel();
        memAssessmentModel2.setSubHeader(subHeader);

        memAssessmentModel2.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel2.setTime("5");
        memAssessmentModel2.setQuestionNo(1);
        memAssessmentModel2.setLinkImageUrl(linkImageBase);

        /** Set the model for Question in the 1st Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel3 = new ImageTextAssessmentModel();
        memAssessmentModel3.setSubHeader(subHeader);

        memAssessmentModel3.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext1.leaveout", locale));
        memAssessmentModel3.setQuestionNo(1);
        memAssessmentModel3.setLinkImageUrl(linkImageBase);

        /**
         * Set the model for 2nd Assessment for remembering the number in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel4 = new ImageTextAssessmentModel();
        memAssessmentModel4.setSubHeader(subHeader);

        memAssessmentModel4.setTime("10");
        List<String> number = new ArrayList<String>();
        number.add(langHelper.getExecmapMessage(
                "memx.memx.questiontext2.number", locale));

        memAssessmentModel4.setTextOrUrl(number);
        memAssessmentModel4.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.visual.questiontext0.remember", locale));

        memAssessmentModel4.setQuestionNo(2);
        memAssessmentModel4.setLinkImageUrl(linkImageBase);

        /** Set the model for Wait in the 2nd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel5 = new ImageTextAssessmentModel();
        memAssessmentModel5.setSubHeader(subHeader);

        memAssessmentModel5.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel5.setTime("5");
        memAssessmentModel5.setQuestionNo(2);
        memAssessmentModel5.setLinkImageUrl(linkImageBase);

        /** Set the model for Question in the 2nd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel6 = new ImageTextAssessmentModel();
        memAssessmentModel6.setSubHeader(subHeader);

        memAssessmentModel6.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext2.leaveout", locale));
        memAssessmentModel6.setQuestionNo(2);
        memAssessmentModel6.setLinkImageUrl(linkImageBase);

        /**
         * Set the model for 3rd Assessment for playing the sound in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel7 = new ImageTextAssessmentModel();
        memAssessmentModel7.setSubHeader(subHeader);

        List<String> soundpath3 = new ArrayList<String>();
        soundpath3.add(imageBase + "q3.au");
        memAssessmentModel7.setTime("10");
        memAssessmentModel7.setTextOrUrl(soundpath3);
        memAssessmentModel7.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.sound.questiontext0.questiontext", locale));
        memAssessmentModel7.setQuestionNo(3);
        memAssessmentModel7.setLinkImageUrl(linkImageBase);

        /** Set the model for Wait in the 3rd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel8 = new ImageTextAssessmentModel();
        memAssessmentModel8.setSubHeader(subHeader);

        memAssessmentModel8.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel8.setTime("5");
        memAssessmentModel8.setQuestionNo(3);
        memAssessmentModel8.setLinkImageUrl(linkImageBase);

        /** Set the model for Question in the 3rd Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel9 = new ImageTextAssessmentModel();
        memAssessmentModel9.setSubHeader(subHeader);
        memAssessmentModel9.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext3.questiontext", locale));
        memAssessmentModel9.setQuestionNo(3);
        memAssessmentModel9.setLinkImageUrl(linkImageBase);

        /**
         * Set the model for 4th Assessment for remembering the number in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel10 = new ImageTextAssessmentModel();
        memAssessmentModel10.setSubHeader(subHeader);

        memAssessmentModel10.setTime("10");
        List<String> number2 = new ArrayList<String>();
        number2.add(langHelper.getExecmapMessage(
                "memx.memx.questiontext4.number", locale));

        memAssessmentModel10.setTextOrUrl(number2);
        memAssessmentModel10.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.visual.questiontext0.remember", locale));
        memAssessmentModel10.setQuestionNo(4);
        memAssessmentModel10.setLinkImageUrl(linkImageBase);

        /** Set the model for Wait in the 4th Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel11 = new ImageTextAssessmentModel();
        memAssessmentModel11.setSubHeader(subHeader);

        memAssessmentModel11.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel11.setTime("5");
        memAssessmentModel11.setQuestionNo(4);
        memAssessmentModel11.setLinkImageUrl(linkImageBase);

        /** Set the model for Question in the 4th Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel12 = new ImageTextAssessmentModel();
        memAssessmentModel12.setSubHeader(subHeader);

        memAssessmentModel12.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext4.questiontext", locale));
        memAssessmentModel12.setQuestionNo(4);
        memAssessmentModel12.setLinkImageUrl(linkImageBase);

        /**
         * Set the model for 5th Assessment for remembering the options in MEM *
         */
        ImageTextAssessmentModel memAssessmentModel13 = new ImageTextAssessmentModel();
        memAssessmentModel13.setSubHeader(subHeader);
        memAssessmentModel13.setLinkImageUrl(linkImageBase);

        List<String> options = new ArrayList<String>();
        options.add(langHelper.getExecmapMessage("memx.q5option1", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option2", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option3", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option4", locale));
        options.add(langHelper.getExecmapMessage("memx.q5option5", locale));

        memAssessmentModel13.setQuestionOptions(options);
        memAssessmentModel13.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext5.questiontext", locale));
        memAssessmentModel13.setQuestionNo(5);
        memAssessmentModel13.setTime("10");

        /** Set the model for Wait in the 5th Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel14 = new ImageTextAssessmentModel();
        memAssessmentModel14.setSubHeader(subHeader);

        memAssessmentModel14.setAnswerInstruction(langHelper.getExecmapMessage(
                "generic.wait_please", locale));
        memAssessmentModel14.setTime("5");
        memAssessmentModel14.setQuestionNo(5);
        memAssessmentModel14.setLinkImageUrl(linkImageBase);

        /** Set the model for first Question in the 5th Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel15 = new ImageTextAssessmentModel();
        memAssessmentModel15.setSubHeader(subHeader);

        memAssessmentModel15.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext5a.questiontext", locale));
        memAssessmentModel15.setLinkImageUrl(linkImageBase);
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

        memAssessmentModel15.setQuestionOptions(questionoptions);
        memAssessmentModel15.setQuestionNo(5);

        /** Set the model for second Question in the 5th Assessment for MEM * */

        ImageTextAssessmentModel memAssessmentModel16 = new ImageTextAssessmentModel();
        memAssessmentModel16.setSubHeader(subHeader);

        memAssessmentModel16.setAnswerInstruction(langHelper.getExecmapMessage(
                "memx.memx.questiontext5b.questiontext", locale));
        memAssessmentModel16.setLinkImageUrl(linkImageBase);
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

        memAssessmentModel16.setQuestionOptions(questionoptions2);
        memAssessmentModel16.setQuestionNo(5);
      
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
        memList.add(memAssessmentModel11);
        memList.add(memAssessmentModel12);

        memList.add(memAssessmentModel13);
        memList.add(memAssessmentModel14);
        memList.add(memAssessmentModel15);
        memList.add(memAssessmentModel16);

        memAssessmentModel.setInstructionModel(memList);

        return memAssessmentModel;
    }

}