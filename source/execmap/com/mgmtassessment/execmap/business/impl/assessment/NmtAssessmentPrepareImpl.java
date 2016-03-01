/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 19, 2006
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
 * This class is used for preparing the model for the NMT Assessment activity
 * model.
 * @author singhrau
 */

public class NmtAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
    /**
     * this metod prepares the model for the csr assessment trigram.
     * @param locale
     * @return NmtAssessmentModel
     */
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel NmtAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/nmt/";

        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** Nmt Assessment Activity Answering Instructions * */
        String answerInstruction = langHelper.getAssesmentMessage(
                "cmix.activityinstruction9", locale);
        ImageTextAssessmentModel NmtInstructionModel =
                                            new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("nmt1.nmt1.nmtheading",
                locale);
        /** Set the Sub Header attribute for Nmt Assessment Trigram * */
        NmtInstructionModel.setSubHeader(subHeader);

        /** set the answering instruction for cfs assessment Trigram * */
        String answerinstruction = langHelper.getAssesmentMessage(
                "nmtx.activityinstruction8", locale);

        NmtInstructionModel.setLinkImageUrl(linkImageBase);

        NmtInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "nmtx.timer", locale)));
        NmtInstructionModel.setQuestionNo(0);
        /** Set the Image Url attribute for Nmt Assessment Trigram * */
        List<String> textorurlList = new ArrayList<String>();

        textorurlList.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.instruction.questiontext1", locale)));
        textorurlList.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.instruction.questiontext2", locale)));
        NmtInstructionModel.setTextOrUrl(textorurlList);

        /** Set the Answer Options for Nmt Instruction* */
        List<String> answerOptionsinst = new ArrayList<String>();
        answerOptionsinst.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage00.choiceimage", locale)));
        answerOptionsinst.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage01.choiceimage", locale)));
        NmtInstructionModel.setQuestionOptions(answerOptionsinst);

        /** Set the Instruction attribute for CMI Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nmtx.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nmtx.activityinstruction2", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nmtx.activityinstruction3", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nmtx.activityinstruction4", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "nmtx.activityinstruction6", locale)));

        /** Set the Instruction attribute for Nmt Assessment Trigram * */
        NmtInstructionModel.setInstruction(instructionList);

        /** Set the Answer Instruction attribute for Nmt Assessment Trigram * */
        NmtInstructionModel.setAnswerInstruction(answerinstruction);

        /** Set the model for 1st Assessment for Nmt * */
        ImageTextAssessmentModel NmtAssessmentModel1 =
                                       new ImageTextAssessmentModel();

        NmtAssessmentModel1.setSubHeader(subHeader);
        NmtAssessmentModel1.setLinkImageUrl(linkImageBase);

        List<String> textorurlList1 = new ArrayList<String>();

        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext6.questiontext1", locale)));
        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext6.questiontext2", locale)));

        NmtAssessmentModel1.setTextOrUrl(textorurlList1);
        NmtAssessmentModel1.setQuestionNo(1);

        NmtAssessmentModel1.setInstruction(textorurlList1);

        /** Set the Answer Options for 1st Nmt Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage00.choiceimage", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage01.choiceimage", locale)));

        NmtAssessmentModel1.setQuestionOptions(answerOptionsinst);

        /** Set the model for 2nd Assessment for Nmt * */
        ImageTextAssessmentModel NmtAssessmentModel2 =
                                            new ImageTextAssessmentModel();

        NmtAssessmentModel2.setSubHeader(subHeader);
        NmtAssessmentModel2.setLinkImageUrl(linkImageBase);

        List<String> textorurlList2 = new ArrayList<String>();

        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext7.questiontext1", locale)));
        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext7.questiontext2", locale)));

        NmtAssessmentModel2.setTextOrUrl(textorurlList2);
        NmtAssessmentModel2.setQuestionNo(2);
        NmtAssessmentModel2.setInstruction(textorurlList1);

        /** Set the Answer Options for 2nd Nmt Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage00.choiceimage", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage01.choiceimage", locale)));

        NmtAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for Nmt * */
        ImageTextAssessmentModel NmtAssessmentModel3 =
                                            new ImageTextAssessmentModel();

        NmtAssessmentModel3.setSubHeader(subHeader);
        NmtAssessmentModel3.setLinkImageUrl(linkImageBase);

        List<String> textorurlList3 = new ArrayList<String>();

        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext8.questiontext1", locale)));
        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext8.questiontext2", locale)));

        NmtAssessmentModel3.setTextOrUrl(textorurlList3);
        NmtAssessmentModel3.setQuestionNo(3);
        NmtAssessmentModel3.setInstruction(textorurlList1);

        /** Set the Answer Options for 3rd Nmt Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage00.choiceimage", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage01.choiceimage", locale)));
        NmtAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th Assessment for Nmt * */
        ImageTextAssessmentModel NmtAssessmentModel4 =
                                          new ImageTextAssessmentModel();

        NmtAssessmentModel4.setSubHeader(subHeader);
        NmtAssessmentModel4.setLinkImageUrl(linkImageBase);

        List<String> textorurlList4 = new ArrayList<String>();

        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext9.questiontext1", locale)));
        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext9.questiontext2", locale)));

        NmtAssessmentModel4.setTextOrUrl(textorurlList4);
        NmtAssessmentModel4.setQuestionNo(4);
        NmtAssessmentModel4.setInstruction(textorurlList1);

        /** Set the Answer Options for 4th Nmt Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage00.choiceimage", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage01.choiceimage", locale)));

        NmtAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th Assessment for Nmt * */
        ImageTextAssessmentModel NmtAssessmentModel5 =
                                           new ImageTextAssessmentModel();

        NmtAssessmentModel5.setSubHeader(subHeader);
        NmtAssessmentModel5.setLinkImageUrl(linkImageBase);

        List<String> textorurlList5 = new ArrayList<String>();

        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext10.questiontext1", locale)));
        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext10.questiontext2", locale)));

        NmtAssessmentModel5.setTextOrUrl(textorurlList5);
        NmtAssessmentModel5.setQuestionNo(5);
        NmtAssessmentModel5.setInstruction(textorurlList1);

        /** Set the Answer Options for 5th Nmt Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage00.choiceimage", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage01.choiceimage", locale)));
        NmtAssessmentModel5.setQuestionOptions(answerOptions5);

        /** Set the model for 6th Assessment for Nmt * */
        ImageTextAssessmentModel NmtAssessmentModel6 =
                                            new ImageTextAssessmentModel();

        NmtAssessmentModel6.setSubHeader(subHeader);
        NmtAssessmentModel6.setLinkImageUrl(linkImageBase);

        List<String> textorurlList6 = new ArrayList<String>();

        textorurlList6.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext11.questiontext1", locale)));
        textorurlList6.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.questiontext11.questiontext2", locale)));

        NmtAssessmentModel6.setTextOrUrl(textorurlList6);
        NmtAssessmentModel6.setQuestionNo(6);
        NmtAssessmentModel6.setInstruction(textorurlList1);

        /** Set the Answer Options for 6th Nmt Assessment* */
        List<String> answerOptions6 = new ArrayList<String>();
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage00.choiceimage", locale)));
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "nmt1.nmt1.choiceimage01.choiceimage", locale)));

        NmtAssessmentModel6.setQuestionOptions(answerOptions6);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * NmtAssessmentModel
         */

        // List<ImageTextAssessmentModel> NmtList =
        // (ArrayList)NmtAssessmentModel.getInstructionModel();
        List<ImageTextAssessmentModel> NmtList =
                                     new ArrayList<ImageTextAssessmentModel>();
        NmtList.add(NmtInstructionModel);
        NmtList.add(NmtAssessmentModel1);
        NmtList.add(NmtAssessmentModel2);
        NmtList.add(NmtAssessmentModel3);
        NmtList.add(NmtAssessmentModel4);
        NmtList.add(NmtAssessmentModel5);
        NmtList.add(NmtAssessmentModel6);

        NmtAssessmentModel.setInstructionModel(NmtList);

        return NmtAssessmentModel;
    }

}
