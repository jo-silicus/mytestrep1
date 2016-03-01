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

public class EssAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {

    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel essAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/essx/";
        
        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** ESS Assessment Activity Answering Instructions * */
        List<String> answerInstruction = new ArrayList<String>();
        answerInstruction.add(langHelper.getAssesmentMessage(
                "essx.activityinstruction9", locale));

        ImageTextAssessmentModel essInstructionModel = new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("ess1.ess1.essheading",
                locale);
        /** Set the Sub Header attribute for ESS Assessment Trigram * */
        essInstructionModel.setSubHeader(subHeader);

        /** Set the Image Url attribute for ESS Assessment Trigram * */
        List<String> textorurlList = new ArrayList<String>();
        textorurlList.add(imageBase + "ess.gif");
        essInstructionModel.setTextOrUrl(textorurlList);
        essInstructionModel.setQuestionNo(0);

        /** Set the Instruction attribute for ESS Assessment Trigram * */
        List<String> instruction = new ArrayList<String>();
        instruction.add(langHelper.getAssesmentMessage(
                "essx.activityinstruction1", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "essx.activityinstruction2", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "essx.activityinstruction3", locale));
        essInstructionModel.setInstruction(instruction);

        /** Set the Answer Instruction attribute for ESS Assessment Trigram * */
        essInstructionModel.setAnswerInstruction(langHelper
                .getAssesmentMessage("essx.activityinstruction8", locale));

        /** Set the ACtivity time attribute for ESS Assessment Trigram * */
        essInstructionModel.setTime(langHelper.getAssesmentMessage(
                "essx.timer", locale));
        essInstructionModel.setLinkImageUrl(linkImageBase);
        /**
         * Set the Question Instruction size attribute for ESS Assessment
         * Trigram *
         */

        /** Set the model for 1st Assessment for ESS * */
        ImageTextAssessmentModel essAssessmentModel1 = new ImageTextAssessmentModel();

        essAssessmentModel1.setSubHeader(subHeader);
        List<String> textorurlList1 = new ArrayList<String>();
        textorurlList1.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext0.questiontext", locale));
        essAssessmentModel1.setTextOrUrl(textorurlList1);
        essAssessmentModel1.setQuestionNo(1);

        essAssessmentModel1.setInstruction(answerInstruction);
        essAssessmentModel1.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 1st Ess Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext10.choicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext11.choicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext12.choicetext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext13.choicetext", locale)));

        essAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd Assessment for ESS * */
        ImageTextAssessmentModel essAssessmentModel2 = new ImageTextAssessmentModel();

        essAssessmentModel2.setSubHeader(subHeader);
        List<String> textorurlList2 = new ArrayList<String>();
        textorurlList2.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext1.questiontext", locale));
        essAssessmentModel2.setTextOrUrl(textorurlList2);
        essAssessmentModel2.setQuestionNo(2);
        essAssessmentModel2.setInstruction(answerInstruction);
        essAssessmentModel2.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 2nd Ess Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext20.choicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext21.choicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext22.choicetext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext23.choicetext", locale)));

        essAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for ESS * */
        ImageTextAssessmentModel essAssessmentModel3 = new ImageTextAssessmentModel();

        essAssessmentModel3.setSubHeader(subHeader);
        List<String> textorurlList3 = new ArrayList<String>();
        textorurlList3.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext2.questiontext", locale)
                + ", ");
        textorurlList3.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext3.questiontext", locale));
        essAssessmentModel3.setTextOrUrl(textorurlList3);
        essAssessmentModel3.setQuestionNo(3);
        essAssessmentModel3.setInstruction(answerInstruction);
        essAssessmentModel3.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 3rd Ess Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext30.choicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext31.choicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext32.choicetext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext33.choicetext", locale)));

        essAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th Assessment for ESS * */
        ImageTextAssessmentModel essAssessmentModel4 = new ImageTextAssessmentModel();
        essAssessmentModel4.setQuestionNo(4);
        essAssessmentModel4.setSubHeader(subHeader);
        List<String> textorurlList4 = new ArrayList<String>();
        textorurlList4.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext3.questiontext", locale)
                + ", ");
        textorurlList4.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext5.questiontext", locale));
        essAssessmentModel4.setTextOrUrl(textorurlList4);

        essAssessmentModel4.setInstruction(answerInstruction);
        essAssessmentModel4.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 4th Ess Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext40.choicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext41.choicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext42.choicetext", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext43.choicetext", locale)));

        essAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th Assessment for ESS * */
        ImageTextAssessmentModel essAssessmentModel5 = new ImageTextAssessmentModel();

        essAssessmentModel5.setSubHeader(subHeader);

        List<String> textorurlList5 = new ArrayList<String>();
        textorurlList5.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext5.questiontext", locale)
                + ", ");
        textorurlList5.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext7.questiontext", locale));
        essAssessmentModel5.setTextOrUrl(textorurlList5);
        essAssessmentModel5.setQuestionNo(5);
        essAssessmentModel5.setInstruction(answerInstruction);
        essAssessmentModel5.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 5th Ess Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext50.choicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext51.choicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext52.choicetext", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext53.choicetext", locale)));

        essAssessmentModel5.setQuestionOptions(answerOptions5);

        /** Set the model for 6th Assessment for ESS * */
        ImageTextAssessmentModel essAssessmentModel6 = new ImageTextAssessmentModel();

        essAssessmentModel6.setSubHeader(subHeader);
        List<String> textorurlList6 = new ArrayList<String>();
        textorurlList6.add(langHelper.getExecmapMessage(
                "ess1.ess1.questiontext8.questiontext", locale));
        essAssessmentModel6.setTextOrUrl(textorurlList6);
        essAssessmentModel6.setQuestionNo(6);
        essAssessmentModel6.setInstruction(answerInstruction);
        essAssessmentModel6.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 6th Ess Assessment* */
        List<String> answerOptions6 = new ArrayList<String>();
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext60.choicetext", locale)));
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext61.choicetext", locale)));
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext62.choicetext", locale)));
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "ess1.ess1.choicetext63.choicetext", locale)));

        essAssessmentModel6.setQuestionOptions(answerOptions6);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * emsAssessmentModel
         */

        // List<ImageTextAssessmentModel> emsList =
        // (ArrayList)essAssessmentModel.getInstructionModel();
        List<ImageTextAssessmentModel> essList = new ArrayList<ImageTextAssessmentModel>();
        essList.add(essInstructionModel);
        essList.add(essAssessmentModel1);
        essList.add(essAssessmentModel2);
        essList.add(essAssessmentModel3);
        essList.add(essAssessmentModel4);
        essList.add(essAssessmentModel5);
        essList.add(essAssessmentModel6);
        essAssessmentModel.setInstructionModel(essList);

        return essAssessmentModel;

    }

}
