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
 * This class is used for preparing the model for the CMI Assessment activity
 * model.
 * @author singhrau
 */
public class CmiAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
/**
 * this metod prepares the model for the cmi assessment trigram.
 * @param locale
 * @return CMIAssessmentModel
 */
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel CMIAssessmentModel =
                                    new AssessmentMainModel();

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";

        ImageTextAssessmentModel CMIInstructionModel =
                                          new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("cmi1.cmi1.heading",
                locale);

        /** set the answering instruction for cfs assessment Trigram * */
        String answerinstruction = langHelper.getAssesmentMessage(
                "cmix.activityinstruction8", locale);

        /** Set the Sub Header attribute for CMI Assessment Trigram * */
        CMIInstructionModel.setSubHeader(subHeader);
        CMIInstructionModel.setQuestionNo(0);
        CMIInstructionModel.setLinkImageUrl(linkImageBase);
        
        /**set the options to be shown on the instruction page**/
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel03.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel01.choice", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel02.choice", locale)));
        CMIInstructionModel.setQuestionOptions(answerOptions);

        /** Set the Time attribute for EMS Assessment Trigram * */
        CMIInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "cmix.timer", locale)));

        /** Set the Instruction attribute for CMI Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cmix.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cmix.activityinstruction2", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cmix.activityinstruction3", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cmix.activityinstruction4", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cmix.activityinstruction5", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cmix.activityinstruction6", locale)));

        CMIInstructionModel.setInstruction(instructionList);
        CMIInstructionModel.setAnswerInstruction(answerinstruction);

        /** Set the Answer Instruction attribute for CMI Assessment Trigram * */
        List<String> instructionList1 = new ArrayList<String>();
        instructionList1.add(langHelper.getAssesmentMessage(
                "cmix.activityinstruction9", locale));

        /** Set the model for 1st Assessment for CMI * */
        ImageTextAssessmentModel CMIAssessmentModel1 =
                                  new ImageTextAssessmentModel();

        CMIAssessmentModel1.setSubHeader(subHeader);
        CMIAssessmentModel1.setLinkImageUrl(linkImageBase);

        List<String> textorurlList1 = new ArrayList<String>();

        textorurlList1.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question1.text1", locale)));
        textorurlList1.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question1.text2", locale)));
        textorurlList1.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question1.text3", locale)));
        textorurlList1.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question1.text4", locale)));

        CMIAssessmentModel1.setTextOrUrl(textorurlList1);
        CMIAssessmentModel1.setQuestionNo(1);

        CMIAssessmentModel1.setInstruction(instructionList1);

        /** Set the Answer Options for 1st CMI Assessment* */
        CMIAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd Assessment for CMI * */
        ImageTextAssessmentModel CMIAssessmentModel2 =
                                            new ImageTextAssessmentModel();

        CMIAssessmentModel2.setSubHeader(subHeader);
        CMIAssessmentModel2.setLinkImageUrl(linkImageBase);

        List<String> textorurlList2 = new ArrayList<String>();
        textorurlList2.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question2.text1", locale)));
        textorurlList2.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question2.text2", locale)));
        textorurlList2.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question2.text3", locale)));
        textorurlList2.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question2.text4", locale)));

        CMIAssessmentModel2.setTextOrUrl(textorurlList2);
        CMIAssessmentModel2.setQuestionNo(2);
        CMIAssessmentModel2.setInstruction(instructionList1);

        /** Set the Answer Options for 2nd CMI Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel03.choice", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel01.choice", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel02.choice", locale)));

        CMIAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for CMI * */
        ImageTextAssessmentModel CMIAssessmentModel3 =
                                      new ImageTextAssessmentModel();

        CMIAssessmentModel3.setSubHeader(subHeader);
        CMIAssessmentModel3.setLinkImageUrl(linkImageBase);

        List<String> textorurlList3 = new ArrayList<String>();
        textorurlList3.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question3.text1", locale)));
        textorurlList3.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question3.text2", locale)));
        textorurlList3.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question3.text3", locale)));

        CMIAssessmentModel3.setTextOrUrl(textorurlList3);
        CMIAssessmentModel3.setQuestionNo(3);
        CMIAssessmentModel3.setInstruction(instructionList1);

        /** Set the Answer Options for 3rd CMI Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel03.choice", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel01.choice", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel02.choice", locale)));

        CMIAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th Assessment for CMI * */
        ImageTextAssessmentModel CMIAssessmentModel4 =
                                     new ImageTextAssessmentModel();

        CMIAssessmentModel4.setSubHeader(subHeader);
        CMIAssessmentModel4.setLinkImageUrl(linkImageBase);

        List<String> textorurlList4 = new ArrayList<String>();
        textorurlList4.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question4.text1", locale)));
        textorurlList4.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question4.text2", locale)));
        textorurlList4.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question4.text3", locale)));

        CMIAssessmentModel4.setTextOrUrl(textorurlList4);
        CMIAssessmentModel4.setQuestionNo(4);
        CMIAssessmentModel4.setInstruction(instructionList1);

        /** Set the Answer Options for 4th CMI Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel03.choice", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel01.choice", locale)));
        answerOptions4.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel02.choice", locale)));

        CMIAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th Assessment for CMI * */
        ImageTextAssessmentModel CMIAssessmentModel5 =
                                       new ImageTextAssessmentModel();

        CMIAssessmentModel5.setSubHeader(subHeader);
        CMIAssessmentModel5.setLinkImageUrl(linkImageBase);

        List<String> textorurlList5 = new ArrayList<String>();
        textorurlList5.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question5.text1", locale)));
        textorurlList5.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question5.text2", locale)));
        textorurlList5.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question5.text3", locale)));

        CMIAssessmentModel5.setTextOrUrl(textorurlList5);
        CMIAssessmentModel5.setQuestionNo(5);
        CMIAssessmentModel5.setInstruction(instructionList1);

        /** Set the Answer Options for 5th CMI Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel03.choice", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel01.choice", locale)));
        answerOptions5.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel02.choice", locale)));

        CMIAssessmentModel5.setQuestionOptions(answerOptions5);

        /** Set the model for 6th Assessment for CMI * */
        ImageTextAssessmentModel CMIAssessmentModel6 =
                                           new ImageTextAssessmentModel();

        CMIAssessmentModel6.setSubHeader(subHeader);
        CMIAssessmentModel6.setLinkImageUrl(linkImageBase);

        List<String> textorurlList6 = new ArrayList<String>();
        textorurlList6.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question6.text1", locale)));
        textorurlList6.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question6.text2", locale)));
        textorurlList6.add(new String(langHelper.getAssesmentMessage(
                "cmi1.question6.text3", locale)));

        CMIAssessmentModel6.setTextOrUrl(textorurlList6);
        CMIAssessmentModel6.setQuestionNo(6);
        CMIAssessmentModel6.setInstruction(instructionList1);

        /** Set the Answer Options for 6th CMI Assessment* */
        List<String> answerOptions6 = new ArrayList<String>();
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel03.choice", locale)));
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel01.choice", locale)));
        answerOptions6.add(new String(langHelper.getExecmapMessage(
                "cmi1.cmi1.choicelabel02.choice", locale)));

        CMIAssessmentModel6.setQuestionOptions(answerOptions6);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * CMIAssessmentModel
         */

        List<ImageTextAssessmentModel> CMIList =
                                   new ArrayList<ImageTextAssessmentModel>();

        CMIList.add(CMIInstructionModel);
        CMIList.add(CMIAssessmentModel1);
        CMIList.add(CMIAssessmentModel2);
        CMIList.add(CMIAssessmentModel3);
        CMIList.add(CMIAssessmentModel4);
        CMIList.add(CMIAssessmentModel5);
        CMIList.add(CMIAssessmentModel6);

        CMIAssessmentModel.setInstructionModel(CMIList);

        return CMIAssessmentModel;
    }

}
