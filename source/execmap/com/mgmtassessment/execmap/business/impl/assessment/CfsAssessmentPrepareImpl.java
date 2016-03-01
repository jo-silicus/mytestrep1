/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 16, 2006
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
 * This class is used for preparing the model for the CFS Assessment activity
 * model.
 * @author singhrau
 */

public class CfsAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {

    /**
     * this metod prepares the model for the cfs assessment trigram.
     * @param locale
     * @return cfsAssessmentModel
     */
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel cfsAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/cfs1/";

        /**The Base Path for the Navigation Images**/
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
        + "/images/LINKS/";

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        ImageTextAssessmentModel cfsInstructionModel =
                                         new ImageTextAssessmentModel();

        /** set the suheader attribute for cfs assessment Trigram * */
        String subHeader = langHelper.getExecmapMessage("cfs1.cfs1.heading",
                locale);
        /** set the answering instruction for cfs assessment Trigram * */
        String answerinstruction = langHelper.getAssesmentMessage(
                "cfsx.activityinstruction10", locale);

        /** Set the Sub Header attribute for cfs Assessment Trigram * */
        cfsInstructionModel.setSubHeader(subHeader);

        List<String> textorurlList = new ArrayList<String>();

        /** Set the Image Url attribute for cfs Assessment Trigram * */

        textorurlList.add(imageBase + "CFSSample.jpg");
        cfsInstructionModel.setTextOrUrl(textorurlList);
        cfsInstructionModel.setQuestionNo(0);
        cfsInstructionModel.setLinkImageUrl(linkImageBase);

        /** Set the Time attribute for EMS Assessment Trigram * */
        cfsInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "cfsx.timer", locale)));

        /** Set the Instruction attribute for CFS Assessment Trigram * */
        List<String> instructionList = new ArrayList<String>();

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cfsx.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cfsx.activityinstruction2", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cfsx.activityinstruction3", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cfsx.activityinstruction4", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cfsx.activityinstruction5", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "cfsx.activityinstruction6", locale)));
        cfsInstructionModel.setAnswerInstruction(answerinstruction);
        cfsInstructionModel.setInstruction(instructionList);


        /** Set the Answer Instruction attribute for CFS Assessment Trigram * */
        List<String> instructionList1 = new ArrayList<String>();
        instructionList1.add(langHelper.getAssesmentMessage(
                "cfsx.activityinstruction11", locale));

        /** Set the model for 1st Assessment for cfs * */
        ImageTextAssessmentModel cfsAssessmentModel1 =
                                  new ImageTextAssessmentModel();

        List<String> textorurlList1 = new ArrayList<String>();

        cfsAssessmentModel1.setSubHeader(subHeader);

        textorurlList1.add(imageBase + "Q2.jpg");
        cfsAssessmentModel1.setTextOrUrl(textorurlList1);
        cfsAssessmentModel1.setInstruction(instructionList1);
        cfsAssessmentModel1.setQuestionNo(1);
        cfsAssessmentModel1.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 1st cfs Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(imageBase + "Q2_a.jpg");
        answerOptions.add(imageBase + "Q2_b.jpg");
        answerOptions.add(imageBase + "Q2_c.jpg");
        answerOptions.add(imageBase + "q2_d.jpg");
        answerOptions.add(imageBase + "Q2_e.jpg");
        cfsAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd Assessment for cfs * */
        ImageTextAssessmentModel cfsAssessmentModel2 =
                                    new ImageTextAssessmentModel();

        cfsAssessmentModel2.setSubHeader(subHeader);

        List<String> textorurlList2 = new ArrayList<String>();
        textorurlList2.add(imageBase + "Q4.jpg");
        cfsAssessmentModel2.setTextOrUrl(textorurlList2);
        cfsAssessmentModel2.setQuestionNo(2);
        cfsAssessmentModel2.setInstruction(instructionList1);
        cfsAssessmentModel2.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 2nd cfs Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(imageBase + "Q4_a.jpg");
        answerOptions2.add(imageBase + "q4_b.jpg");
        answerOptions2.add(imageBase + "Q4_c.jpg");
        answerOptions2.add(imageBase + "q4_d.jpg");
        answerOptions2.add(imageBase + "Q4_e.jpg");
        cfsAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for cfs * */
        ImageTextAssessmentModel cfsAssessmentModel3 =
                                            new ImageTextAssessmentModel();

        cfsAssessmentModel3.setSubHeader(subHeader);

        List<String> textorurlList3 = new ArrayList<String>();
        textorurlList3.add(imageBase + "Q6.jpg");
        cfsAssessmentModel3.setTextOrUrl(textorurlList3);
        cfsAssessmentModel3.setQuestionNo(3);
        cfsAssessmentModel3.setInstruction(instructionList1);
        cfsAssessmentModel3.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 3rd cfs Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(imageBase + "Q6_a.jpg");
        answerOptions3.add(imageBase + "Q6_b.jpg");
        answerOptions3.add(imageBase + "Q6_c.jpg");
        answerOptions3.add(imageBase + "Q6_d.jpg");
        answerOptions3.add(imageBase + "Q6_e.jpg");
        cfsAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th Assessment for cfs * */
        ImageTextAssessmentModel cfsAssessmentModel4 =
                                         new ImageTextAssessmentModel();

        cfsAssessmentModel4.setSubHeader(subHeader);

        List<String> textorurlList4 = new ArrayList<String>();
        textorurlList4.add(imageBase + "Q7.jpg");
        cfsAssessmentModel4.setTextOrUrl(textorurlList4);
        cfsAssessmentModel4.setQuestionNo(4);
        cfsAssessmentModel4.setLinkImageUrl(linkImageBase);
        cfsAssessmentModel4.setInstruction(instructionList1);

        /** Set the Answer Options for 4th cfs Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(imageBase + "Q7_a.jpg");
        answerOptions4.add(imageBase + "Q7_b.jpg");
        answerOptions4.add(imageBase + "Q7_c.jpg");
        answerOptions4.add(imageBase + "Q7_d.jpg");
        answerOptions4.add(imageBase + "Q7_e.jpg");
        cfsAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th Assessment for cfs * */
        ImageTextAssessmentModel cfsAssessmentModel5 =
                                       new ImageTextAssessmentModel();

        cfsAssessmentModel5.setSubHeader(subHeader);

        List<String> textorurlList5 = new ArrayList<String>();
        textorurlList5.add(imageBase + "Q8.jpg");
        cfsAssessmentModel5.setTextOrUrl(textorurlList5);
        cfsAssessmentModel5.setQuestionNo(5);
        cfsAssessmentModel5.setLinkImageUrl(linkImageBase);
        cfsAssessmentModel5.setInstruction(instructionList1);

        /** Set the Answer Options for 5th cfs Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(imageBase + "Q8_a.jpg");
        answerOptions5.add(imageBase + "Q8_b.jpg");
        answerOptions5.add(imageBase + "Q8_c.jpg");
        answerOptions5.add(imageBase + "Q8_d.jpg");
        answerOptions5.add(imageBase + "Q8_e.jpg");
        cfsAssessmentModel5.setQuestionOptions(answerOptions5);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * cfsAssessmentModel
         */

        List<ImageTextAssessmentModel> cfsList =
                                         new ArrayList<ImageTextAssessmentModel>();
        cfsList.add(cfsInstructionModel);
        cfsList.add(cfsAssessmentModel1);
        cfsList.add(cfsAssessmentModel2);
        cfsList.add(cfsAssessmentModel3);
        cfsList.add(cfsAssessmentModel4);
        cfsList.add(cfsAssessmentModel5);
        cfsAssessmentModel.setInstructionModel(cfsList);

        return cfsAssessmentModel;
    }

}
