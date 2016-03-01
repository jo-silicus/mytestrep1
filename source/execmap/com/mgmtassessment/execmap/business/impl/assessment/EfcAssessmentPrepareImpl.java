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

public class EfcAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel efcAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/efcx/";
        
        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";


        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** EFC Assessment Activity Answering Instructions * */
        List<String> answerInstruction = new ArrayList<String>();
        answerInstruction.add(langHelper.getAssesmentMessage(
                "efcx.activityinstruction5", locale));

        ImageTextAssessmentModel efcInstructionModel = new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("efc1.efc1.efcheading",
                locale);
        /** Set the Sub Header attribute for EFC Assessment Trigram * */
        efcInstructionModel.setSubHeader(subHeader);

        /** Set the Image Url attribute for EFC Assessment Trigram * */
        List<String> textorurlList = new ArrayList<String>();
        textorurlList.add(imageBase + "efc.jpg");
        efcInstructionModel.setTextOrUrl(textorurlList);
        efcInstructionModel.setQuestionNo(0);
        efcInstructionModel.setLinkImageUrl(linkImageBase);

        /** Set the Instruction attribute for EFC Assessment Trigram * */
        List<String> instruction = new ArrayList<String>();
        instruction.add(langHelper.getAssesmentMessage(
                "efcx.activityinstruction1", locale));
        instruction.add(langHelper.getAssesmentMessage(
                "efcx.activityinstruction2", locale));
        efcInstructionModel.setInstruction(instruction);

        /** Set the Answer Instruction attribute for EFC Assessment Trigram * */
        efcInstructionModel.setAnswerInstruction(langHelper
                .getAssesmentMessage("efcx.activityinstruction5", locale));

        /** Set the Activity timer attribute for EFC Assessment Trigram * */
        efcInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "efcx.timer", locale)));

        /** Set the model for 1st Assessment for EFC * */
        ImageTextAssessmentModel efcAssessmentModel1 = new ImageTextAssessmentModel();

        efcAssessmentModel1.setSubHeader(subHeader);
        List<String> textorurlList1 = new ArrayList<String>();
        textorurlList1.add(imageBase + "efc-q6-0.jpg");
        efcAssessmentModel1.setTextOrUrl(textorurlList1);
        efcAssessmentModel1.setQuestionNo(1);
        efcAssessmentModel1.setInstruction(answerInstruction);
        efcAssessmentModel1.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 1st EFC Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(imageBase + "efc-q6-1.jpg");
        answerOptions.add(imageBase + "efc-q6-2.jpg");
        answerOptions.add(imageBase + "efc-q6-3.jpg");
        answerOptions.add(imageBase + "efc-q6-4.jpg");
        answerOptions.add(imageBase + "efc-q6-5.jpg");
        efcAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd Assessment for EFC * */
        ImageTextAssessmentModel efcAssessmentModel2 = new ImageTextAssessmentModel();

        efcAssessmentModel2.setSubHeader(subHeader);
        List<String> textorurlList2 = new ArrayList<String>();
        textorurlList2.add(imageBase + "efc-q7-0.jpg");
        efcAssessmentModel2.setTextOrUrl(textorurlList2);
        efcAssessmentModel2.setQuestionNo(2);
        efcAssessmentModel2.setInstruction(answerInstruction);
        efcAssessmentModel2.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 2nd EFC Assessment* */
        List<String> answerOptions1 = new ArrayList<String>();
        answerOptions1.add(imageBase + "efc-q7-1.jpg");
        answerOptions1.add(imageBase + "efc-q7-2.jpg");
        answerOptions1.add(imageBase + "efc-q7-3.jpg");
        answerOptions1.add(imageBase + "efc-q7-4.jpg");
        answerOptions1.add(imageBase + "efc-q7-5.jpg");
        efcAssessmentModel2.setQuestionOptions(answerOptions1);

        /** Set the model for 3rd Assessment for EFC * */
        ImageTextAssessmentModel efcAssessmentModel3 = new ImageTextAssessmentModel();

        efcAssessmentModel3.setSubHeader(subHeader);
        List<String> textorurlList3 = new ArrayList<String>();
        textorurlList3.add(imageBase + "efc-q8-0.jpg");
        efcAssessmentModel3.setTextOrUrl(textorurlList3);
        efcAssessmentModel3.setQuestionNo(3);
        efcAssessmentModel3.setInstruction(answerInstruction);
        efcAssessmentModel3.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 3rd EFC Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(imageBase + "efc-q8-1.jpg");
        answerOptions3.add(imageBase + "efc-q8-2.jpg");
        answerOptions3.add(imageBase + "efc-q8-3.jpg");
        answerOptions3.add(imageBase + "efc-q8-4.jpg");
        answerOptions3.add(imageBase + "efc-q8-5.jpg");
        efcAssessmentModel3.setQuestionOptions(answerOptions3);

        /** Set the model for 4th Assessment for EFC * */
        ImageTextAssessmentModel efcAssessmentModel4 = new ImageTextAssessmentModel();

        efcAssessmentModel4.setSubHeader(subHeader);

        List<String> textorurlList4 = new ArrayList<String>();
        textorurlList4.add(imageBase + "efc-q9-0.jpg");
        efcAssessmentModel4.setTextOrUrl(textorurlList4);
        efcAssessmentModel4.setQuestionNo(4);

        efcAssessmentModel4.setInstruction(answerInstruction);
        efcAssessmentModel4.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 4th EFC Assessment* */
        List<String> answerOptions4 = new ArrayList<String>();
        answerOptions4.add(imageBase + "efc-q9-1.jpg");
        answerOptions4.add(imageBase + "efc-q9-2.jpg");
        answerOptions4.add(imageBase + "efc-q9-3.jpg");
        answerOptions4.add(imageBase + "efc-q9-4.jpg");
        answerOptions4.add(imageBase + "efc-q9-5.jpg");
        efcAssessmentModel4.setQuestionOptions(answerOptions4);

        /** Set the model for 5th Assessment for EFC * */
        ImageTextAssessmentModel efcAssessmentModel5 = new ImageTextAssessmentModel();

        efcAssessmentModel5.setSubHeader(subHeader);

        List<String> textorurlList5 = new ArrayList<String>();
        textorurlList5.add(imageBase + "efc-q10-0.jpg");
        efcAssessmentModel5.setTextOrUrl(textorurlList5);
        efcAssessmentModel5.setQuestionNo(5);

        efcAssessmentModel5.setInstruction(answerInstruction);
        efcAssessmentModel5.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 5th EFC Assessment* */
        List<String> answerOptions5 = new ArrayList<String>();
        answerOptions5.add(imageBase + "efc-q10-1.jpg");
        answerOptions5.add(imageBase + "efc-q10-2.jpg");
        answerOptions5.add(imageBase + "efc-q10-3.jpg");
        answerOptions5.add(imageBase + "efc-q10-4.jpg");
        answerOptions5.add(imageBase + "efc-q10-5.jpg");
        efcAssessmentModel5.setQuestionOptions(answerOptions5);

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * efcAssessmentModel
         */

        // List<ImageTextAssessmentModel> efcList =
        // (ArrayList)efcAssessmentModel.getInstructionModel();
        List<ImageTextAssessmentModel> efcList = new ArrayList<ImageTextAssessmentModel>();
        efcList.add(efcInstructionModel);
        efcList.add(efcAssessmentModel1);
        efcList.add(efcAssessmentModel2);
        efcList.add(efcAssessmentModel3);
        efcList.add(efcAssessmentModel4);
        efcList.add(efcAssessmentModel5);

        efcAssessmentModel.setInstructionModel(efcList);

        return efcAssessmentModel;
    }

}
