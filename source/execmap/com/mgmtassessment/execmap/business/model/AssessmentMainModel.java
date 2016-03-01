/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.model;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

import java.util.List;


/**
 * this is the main model for the
 * assessment activity.
 */

public class AssessmentMainModel extends AbstractModel {

    /**
     * This collection will hold all models for an activity. Typically this
     * collection will contain an Instruction type Model and a set of
     * AssessmentModels.
     */

    List instructionModel;

    /**
     * @return Returns the instructionModel.
     */
    public List getInstructionModel() {
        return instructionModel;
    }

    /**
     * @param instructionModel The instructionModel to set.
     */
    public void setInstructionModel(List instructionModel) {
        this.instructionModel = instructionModel;
    }

}
