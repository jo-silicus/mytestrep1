/**
 *  * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
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

public class CmsAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel cmsAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/cmsx/";
        
        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/"; 

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** CMS Assessment Activity Answering Instructions * */
        List<String> answerInstruction = new ArrayList<String>();
        answerInstruction.add(langHelper.getAssesmentMessage(
                "cmsx.activityinstruction9", locale));

        ImageTextAssessmentModel cmsInstructionModel = new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("generic.cmsheading",
                locale);
        /** Set the Sub Header attribute for CMS Assessment Trigram * */
        cmsInstructionModel.setSubHeader(subHeader);

        /** Set the Image Url attribute for CMS Assessment Trigram * */
        List<String> textorurlList = new ArrayList<String>();
        textorurlList.add(imageBase + "cms2-s.jpg");

        cmsInstructionModel.setTextOrUrl(textorurlList);

        /** Set the Instruction attribute for CMS Assessment Trigram * */
        List<String> instruction = new ArrayList<String>();
        instruction.add(langHelper.getAssesmentMessage(
                "cmsx.activityinstruction1", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "cmsx.activityinstruction2", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "cmsx.activityinstruction6", locale));
        cmsInstructionModel.setInstruction(instruction);
        cmsInstructionModel.setLinkImageUrl(linkImageBase);

        /** Set the Answer Instruction attribute for CMS Assessment Trigram * */
        cmsInstructionModel.setAnswerInstruction(langHelper
                .getAssesmentMessage("cmsx.activityinstruction8", locale));
        cmsInstructionModel.setQuestionNo(0);

        /** Set the Activity Time attribute for CMS Assessment Trigram * */
        cmsInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "cmsx.timer", locale)));
        /** Set the Answer Options for CMS Instruction* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(imageBase + "cms2-s0.jpg");
        answerOptions.add(imageBase + "cms2-s1.jpg");
        answerOptions.add(imageBase + "cms2-s2.jpg");
        cmsInstructionModel.setQuestionOptions(answerOptions);

        /** Set the model for 1st Assessment for CMS * */
        ImageTextAssessmentModel cmsAssessmentModel1 = new ImageTextAssessmentModel();

        cmsAssessmentModel1.setSubHeader(subHeader);

        cmsAssessmentModel1.setTextOrUrl(textorurlList);
        cmsAssessmentModel1.setQuestionNo(1);
        cmsAssessmentModel1.setInstruction(answerInstruction);
        cmsAssessmentModel1.setAnswerInstruction(langHelper.getExecmapMessage(
                "cms2.cms2.questiontext4.questiontext", locale));
        cmsAssessmentModel1.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 1st CMS Assessment* */
        List<String> answerOptions1 = new ArrayList<String>();
        answerOptions1.add(imageBase + "Q1_a.jpg");
        answerOptions1.add(imageBase + "Q1_b.jpg");
        answerOptions1.add(imageBase + "Q1_c.jpg");
        cmsAssessmentModel1.setQuestionOptions(answerOptions1);

        /** Set the model for 2nd Assessment for CMS * */
        ImageTextAssessmentModel cmsAssessmentModel2 = new ImageTextAssessmentModel();

        cmsAssessmentModel2.setSubHeader(subHeader);
        cmsAssessmentModel2.setTextOrUrl(textorurlList);
        cmsAssessmentModel2.setQuestionNo(2);
        cmsAssessmentModel2.setInstruction(answerInstruction);
        cmsAssessmentModel2.setAnswerInstruction(langHelper.getExecmapMessage(
                "cms3.cms3.questiontext1.questiontext", locale));
        cmsAssessmentModel2.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 2nd CMS Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(imageBase + "Q2_a.jpg");
        answerOptions2.add(imageBase + "Q2_b.jpg");
        answerOptions2.add(imageBase + "Q2_c.jpg");
        cmsAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for CMS * */
        ImageTextAssessmentModel cmsAssessmentModel3 = new ImageTextAssessmentModel();

        cmsAssessmentModel3.setSubHeader(subHeader);
        cmsAssessmentModel3.setTextOrUrl(textorurlList);
        cmsAssessmentModel3.setQuestionNo(3);
        cmsAssessmentModel3.setInstruction(answerInstruction);
        cmsAssessmentModel3.setAnswerInstruction(langHelper.getExecmapMessage(
                "cms3.cms3.questiontext2.questiontext", locale));
        cmsAssessmentModel3.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 3rd CMS Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(imageBase + "Q3_a.jpg");
        answerOptions3.add(imageBase + "Q3_b.jpg");
        answerOptions3.add(imageBase + "Q3_c.jpg");
        cmsAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th Assessment for CMS * */
        ImageTextAssessmentModel cmsAssessmentModel4 = new ImageTextAssessmentModel();

        cmsAssessmentModel4.setSubHeader(subHeader);
        cmsAssessmentModel4.setTextOrUrl(textorurlList);
        cmsAssessmentModel4.setQuestionNo(4);
        cmsAssessmentModel4.setInstruction(answerInstruction);
        cmsAssessmentModel4.setAnswerInstruction(langHelper.getExecmapMessage(
                "cms3.cms3.questiontext3.questiontext", locale));
        cmsAssessmentModel4.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 4th CMS Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(imageBase + "Q4_a.jpg");
        answerOptions4.add(imageBase + "Q4_b.jpg");
        answerOptions4.add(imageBase + "Q4_c.jpg");
        cmsAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th Assessment for CMS * */
        ImageTextAssessmentModel cmsAssessmentModel5 = new ImageTextAssessmentModel();

        cmsAssessmentModel5.setSubHeader(subHeader);
        cmsAssessmentModel5.setTextOrUrl(textorurlList);
        cmsAssessmentModel5.setQuestionNo(5);
        cmsAssessmentModel5.setInstruction(answerInstruction);
        cmsAssessmentModel5.setAnswerInstruction(langHelper.getExecmapMessage(
                "cms3.cms3.questiontext4.questiontext", locale));
        cmsAssessmentModel5.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 5th CMS Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(imageBase + "Q5_a.jpg");
        answerOptions5.add(imageBase + "Q5_b.jpg");
        answerOptions5.add(imageBase + "Q5_c.jpg");
        cmsAssessmentModel5.setQuestionOptions(answerOptions5);

        /** Set the model for 6th Assessment for CMS * */
        ImageTextAssessmentModel cmsAssessmentModel6 = new ImageTextAssessmentModel();

        cmsAssessmentModel6.setSubHeader(subHeader);
        cmsAssessmentModel6.setTextOrUrl(textorurlList);
        cmsAssessmentModel6.setQuestionNo(6);
        cmsAssessmentModel6.setInstruction(answerInstruction);
        cmsAssessmentModel6.setAnswerInstruction(langHelper.getExecmapMessage(
                "cms3.cms3.questiontext5.questiontext", locale));
        cmsAssessmentModel6.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 6th CMS Assessment* */
        List<String> answerOptions6 = new ArrayList<String>();
        answerOptions6.add(imageBase + "Q6_a.jpg");
        answerOptions6.add(imageBase + "Q6_b.jpg");
        answerOptions6.add(imageBase + "Q6_c.jpg");
        cmsAssessmentModel6.setQuestionOptions(answerOptions6);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * cmsAssessmentModel
         */

        // List<ImageTextAssessmentModel> cmsList =
        // (ArrayList)cmsAssessmentModel.getInstructionModel();
        List<ImageTextAssessmentModel> cmsList = new ArrayList<ImageTextAssessmentModel>();
        cmsList.add(cmsInstructionModel);
        cmsList.add(cmsAssessmentModel1);
        cmsList.add(cmsAssessmentModel2);
        cmsList.add(cmsAssessmentModel3);
        cmsList.add(cmsAssessmentModel4);
        cmsList.add(cmsAssessmentModel5);
        cmsList.add(cmsAssessmentModel6);

        cmsAssessmentModel.setInstructionModel(cmsList);

        return cmsAssessmentModel;
    }
}
