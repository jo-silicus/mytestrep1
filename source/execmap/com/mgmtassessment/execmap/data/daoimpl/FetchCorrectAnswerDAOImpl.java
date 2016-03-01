/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : ChabraNi
 * @date : Aug 28, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mgmtassessment.execmap.data.daoapi.FetchCorrectAnswerDAO;

/**
 * Fetch the data from <SubTestCorrecTemp> table.
 */

public class FetchCorrectAnswerDAOImpl extends HibernateDaoSupport implements
        FetchCorrectAnswerDAO {
    /**
     * returns the list of correct answers.
     * @return List
     */
    public List getFetchCorrectAnswer() {
        return (getHibernateTemplate().find("from SubTestCorrecTemp as S where S.comp_id.subTestId in ('X','X1')"));
    }
}
