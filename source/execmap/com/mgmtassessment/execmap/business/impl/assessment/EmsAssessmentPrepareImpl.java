/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 11, 2006
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
 * This class is used for preparing the model for the EMS Assessment activity
 * model.
 * @author singhrau
 */

public class EmsAssessmentPrepareImpl extends AbstractFacadeImpl implements
        AssessmentPrepare {
    /**
     * this metod prepares the model for the csr assessment trigram.
     * @param locale
     * @return emsAssessmentModel
     */
    public AssessmentMainModel prepareModel(Locale locale) {

        AssessmentMainModel emsAssessmentModel = new AssessmentMainModel();

        /** The Image Base path * */
        String imageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/emsX/";

        /** The Base Path for the Navigation Images* */
        String linkImageBase = "/execmap/I18n/" + locale.getLanguage()
                + "/images/LINKS/";

        /** Get the language Translator from the Application Context * */
        TranslateHelper langHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");

        /** EMS Assessment Activity Answering Instructions * */
        String answerInstruction = langHelper.getAssesmentMessage(
                "emsx.activityinstruction6", locale);

        ImageTextAssessmentModel emsInstructionModel =
                                        new ImageTextAssessmentModel();

        String subHeader = langHelper.getExecmapMessage("generic.emsheading",
                locale);
        /** Set the Sub Header attribute for EMS Assessment Trigram * */

        emsInstructionModel.setSubHeader(subHeader);

        List<String> textorurlList = new ArrayList<String>();

        /** Set the Image Url attribute for EMS Assessment Trigram * */
        textorurlList.add(imageBase + "ems.jpg");
        emsInstructionModel.setTextOrUrl(textorurlList);
        emsInstructionModel.setQuestionNo(0);
        emsInstructionModel.setLinkImageUrl(linkImageBase);

        /** Set the Time attribute for EMS Assessment Trigram * */
        emsInstructionModel.setTime(new String(langHelper.getAssesmentMessage(
                "emsx.timer", locale)));

        List<String> instructionList = new ArrayList<String>();

        /** Set the Instruction attribute for EMS Assessment Trigram * */

        instructionList.add(new String(langHelper.getAssesmentMessage(
                "emsx.activityinstruction1", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "emsx.activityinstruction2", locale)));
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "emsx.activityinstruction3", locale)));
        emsInstructionModel.setInstruction(instructionList);

        /** Set the Answer Instruction attribute for EMS Assessment Trigram * */
        instructionList.add(new String(langHelper.getAssesmentMessage(
                "emsx.activityinstruction5", locale)));

        List<String> instructionList1 = new ArrayList<String>();
        instructionList1.add(langHelper.getAssesmentMessage(
                "emsx.activityinstruction6", locale));

        /** Set the model for 1st Assessment for EMS * */
        ImageTextAssessmentModel emsAssessmentModel1 =
                                    new ImageTextAssessmentModel();
        List<String> textorurlList1 = new ArrayList<String>();
        emsAssessmentModel1.setSubHeader(subHeader);
        textorurlList1.add(imageBase + "Image1.jpg");

        emsAssessmentModel1.setTextOrUrl(textorurlList1);
        emsAssessmentModel1.setQuestionNo(1);

        emsAssessmentModel1.setInstruction(instructionList1);
        emsAssessmentModel1.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 1st Ems Assessment* */
        List<String> answerOptions = new ArrayList<String>();
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "emsx.emsx.questiontext10.questiontext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "emsx.emsx.questiontext11.questiontext", locale)));
        answerOptions.add(new String(langHelper.getExecmapMessage(
                "emsx.emsx.questiontext12.questiontext", locale)));

        emsAssessmentModel1.setQuestionOptions(answerOptions);

        /** Set the model for 2nd Assessment for EMS * */
        ImageTextAssessmentModel emsAssessmentModel2 =
                                        new ImageTextAssessmentModel();

        emsAssessmentModel2.setSubHeader(subHeader);
        List<String> textorurlList2 = new ArrayList<String>();
        textorurlList2.add(imageBase + "Image2.jpg");
        emsAssessmentModel2.setTextOrUrl(textorurlList2);
        emsAssessmentModel2.setQuestionNo(2);
        emsAssessmentModel2.setInstruction(instructionList1);
        emsAssessmentModel2.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 2nd Ems Assessment* */
        List<String> answerOptions2 = new ArrayList<String>();
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ems3.ems3.questiontext20.questiontext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ems3.ems3.questiontext21.questiontext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ems3.ems3.questiontext22.questiontext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ems3.ems3.questiontext23.questiontext", locale)));
        answerOptions2.add(new String(langHelper.getExecmapMessage(
                "ems3.ems3.questiontext24.questiontext", locale)));
        emsAssessmentModel2.setQuestionOptions(answerOptions2);

        /** Set the model for 3rd Assessment for EMS * */
        ImageTextAssessmentModel emsAssessmentModel3 =
                                           new ImageTextAssessmentModel();

        emsAssessmentModel3.setSubHeader(subHeader);
        List<String> textorurlList3 = new ArrayList<String>();
        textorurlList3.add(imageBase + "Image3.jpg");
        emsAssessmentModel3.setTextOrUrl(textorurlList3);
        emsAssessmentModel3.setQuestionNo(3);
        emsAssessmentModel3.setInstruction(instructionList1);
        emsAssessmentModel3.setLinkImageUrl(linkImageBase);

        /** Set the Answer Options for 3rd Ems Assessment* */
        List<String> answerOptions3 = new ArrayList<String>();
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ems4.ems4.questiontext30.questiontext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ems4.ems4.questiontext31.questiontext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ems4.ems4.questiontext32.questiontext", locale)));
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ems4.ems4.questiontext33.questiontext", locale)));
        emsAssessmentModel3.setQuestionOptions(answerOptions3);
        answerOptions3.add(new String(langHelper.getExecmapMessage(
                "ems4.ems4.questiontext34.questiontext", locale)));

        /**
         * Add the Instruction Model and the AssessmentModel to the
         * emsAssessmentModel
         */

        // List<ImageTextAssessmentModel> emsList =
        // (ArrayList)emsAssessmentModel.getInstructionModel();
        List<ImageTextAssessmentModel> emsList =
                                     new ArrayList<ImageTextAssessmentModel>();
        emsList.add(emsInstructionModel);
        emsList.add(emsAssessmentModel1);
        emsList.add(emsAssessmentModel2);
        emsList.add(emsAssessmentModel3);

        /**
         * determine the number of questions in activity
         */

        emsAssessmentModel.setInstructionModel(emsList);

        return emsAssessmentModel;
    }

}
