/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 18, 2006
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
 * This class is used for preparing the model for the CSR Assessment activity
 * model.
 * @author singhrau
 */
public class CsrAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
    /**
     * this metod prepares the model for the csr assessment trigram.
     * @param locale
     * @return csrAssessmentModel
     */
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel csrAssessmentModel = new AssessmentMainModel();

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** The Image Base path for the instruction page image * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/csrX/";
        
        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";

        ImageTextAssessmentModel csrInstructionModel =
                                            new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("generic.csrheading",
                locale);

   /** Set the Sub Header attribute for csr Assessment Trigram  question number
         * andimage link url for the navigation options* */
        csrInstructionModel.setSubHeader(subHeader);
        csrInstructionModel.setQuestionNo(0);
        csrInstructionModel.setLinkImageUrl(linkImageBase);

   /**
    * Set the path for the image to be shown on the instruction page
    */
        List textorurlListInst = new ArrayList();
        textorurlListInst.add(imageBase+"csr_inst.gif");
        csrInstructionModel.setTextOrUrl(textorurlListInst);
        /** set the answering instruction for cfs assessment Trigram * */
        String answerinstruction = langHelper.getAssesmentMessage(
                "csrx.activityinstruction8", locale);

        /** Set the Time attribute for EMS Assessment Trigram * */
        csrInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "csrx.timer", locale)));

        /** Set the Instruction attribute for csr Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "csrx.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "csrx.activityinstruction2", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "csrx.activityinstruction3", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "csrx.activityinstruction4", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "csrx.activityinstruction7", locale)));

        csrInstructionModel.setInstruction(instructionList);
        csrInstructionModel.setAnswerInstruction(answerinstruction);

        /** Set the Answer Instruction attribute for csr Assessment Trigram * */
        List<String> instructionList1 = new ArrayList<String>();
        instructionList1.add(langHelper.getAssesmentMessage(
                "csrx.activityinstruction7", locale));
        instructionList1.add(langHelper.getAssesmentMessage(
                "csrx.activityinstruction8", locale));

        /** Set the model for 1st Assessment for csr * */
        ImageTextAssessmentModel csrAssessmentModel1 =
                                      new ImageTextAssessmentModel();

        csrAssessmentModel1.setSubHeader(subHeader);
        csrAssessmentModel1.setLinkImageUrl(linkImageBase);

        List<String> textorurlList1 = new ArrayList<String>();

        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.questiontext10.questiontext", locale)));
        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.questiontext11.questiontext", locale)));
        textorurlList1.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.questiontext12.questiontext", locale)));

        csrAssessmentModel1.setTextOrUrl(textorurlList1);
        csrAssessmentModel1.setQuestionNo(1);
        csrAssessmentModel1.setInstruction(instructionList1);

        /** Set the Answer Options for 1st csr Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage10.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage12.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage11.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "cmu3a.cmu3a.choicetext02.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage14.choice", locale)));

        csrAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd Assessment for csr * */
        ImageTextAssessmentModel csrAssessmentModel2 =
                                         new ImageTextAssessmentModel();

        csrAssessmentModel2.setSubHeader(subHeader);
        csrAssessmentModel2.setLinkImageUrl(linkImageBase);

        List<String> textorurlList2 = new ArrayList<String>();
        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext10.questiontext", locale)));
        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.questiontext31.questiontext", locale)));
        textorurlList2.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext12.questiontext", locale)));

        csrAssessmentModel2.setTextOrUrl(textorurlList2);
        csrAssessmentModel2.setQuestionNo(2);
        csrAssessmentModel2.setInstruction(instructionList1);

        /** Set the Answer Options for 2nd csr Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage10.choice", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "cmu4a.cmu4a.choicetext114.choice", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage32.choice", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage33.choice", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage34.choice", locale)));

        csrAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for csr * */
        ImageTextAssessmentModel csrAssessmentModel3 =
                                            new ImageTextAssessmentModel();

        csrAssessmentModel3.setSubHeader(subHeader);
        csrAssessmentModel3.setLinkImageUrl(linkImageBase);

        List<String> textorurlList3 = new ArrayList<String>();
        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.questiontext40.questiontext", locale)));
        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.questiontext41.questiontext", locale)));
        textorurlList3.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext22.questiontext", locale)));

        csrAssessmentModel3.setTextOrUrl(textorurlList3);
        csrAssessmentModel3.setQuestionNo(3);
        csrAssessmentModel3.setInstruction(instructionList1);

        /** Set the Answer Options for 3rd csr Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "generic.start", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "cmu4a.cmu4a.choicetext32.choice", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage42.choice", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage43.choice", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "csr1.csr1.choiceimage44.choice", locale)));
        csrAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th Assessment for csr * */
        ImageTextAssessmentModel csrAssessmentModel4 =
                                           new ImageTextAssessmentModel();

        csrAssessmentModel4.setSubHeader(subHeader);
        csrAssessmentModel4.setLinkImageUrl(linkImageBase);

        List<String> textorurlList4 = new ArrayList<String>();
        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext40.questiontext", locale)));
        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext41.questiontext", locale)));
        textorurlList4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext42.questiontext", locale)));

        csrAssessmentModel4.setTextOrUrl(textorurlList4);
        csrAssessmentModel4.setQuestionNo(4);
        csrAssessmentModel4.setInstruction(instructionList1);

        /** Set the Answer Options for 4th csr Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage40.choice", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage41.choice", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage42.choice", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage43.choice", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage44.choice", locale)));
        csrAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th Assessment for csr * */
        ImageTextAssessmentModel csrAssessmentModel5 =
                                         new ImageTextAssessmentModel();

        csrAssessmentModel5.setSubHeader(subHeader);
        csrAssessmentModel5.setLinkImageUrl(linkImageBase);

        List<String> textorurlList5 = new ArrayList<String>();
        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext60.questiontext", locale)));
        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext61.questiontext", locale)));
        textorurlList5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.questiontext62.questiontext", locale)));

        csrAssessmentModel5.setTextOrUrl(textorurlList5);
        csrAssessmentModel5.setQuestionNo(5);
        csrAssessmentModel5.setInstruction(instructionList1);

        /** Set the Answer Options for 5th csr Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage60.choice", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage61.choice", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage62.choice", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage63.choice", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "csr2.csr2.choiceimage64.choice", locale)));

        csrAssessmentModel5.setQuestionOptions(answerOptions5);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * csrAssessmentModel
         */

        List<ImageTextAssessmentModel> csrList =
                                   new ArrayList<ImageTextAssessmentModel>();

        csrList.add(csrInstructionModel);
        csrList.add(csrAssessmentModel1);
        csrList.add(csrAssessmentModel2);
        csrList.add(csrAssessmentModel3);
        csrList.add(csrAssessmentModel4);
        csrList.add(csrAssessmentModel5);

        csrAssessmentModel.setInstructionModel(csrList);

        return csrAssessmentModel;
    }

}
