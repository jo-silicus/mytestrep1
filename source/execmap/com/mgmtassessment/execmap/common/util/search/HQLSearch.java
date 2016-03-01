package com.mgmtassessment.execmap.common.util.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;

import com.mgmtassessment.execmap.common.exceptions.ExecMapRuntimeException;

public class HQLSearch {
    // private static Logger log = Logger
    // .getLogger(HQLSearch.class);

    private static final String DELIM_SUB_QUERY     = "$SQL:";

    private static final String DELIM_AND           = " and ";

    private static final String DELIM_OR            = " or ";

    private static final String DELIM_START_BRACKET = "(";

    private static final String DELIM_END_BRACKET   = ")";

    private static final String DELIM_DOLLAR        = "$";

    private static final String DELIM_WHERE         = " where ";

    private static final String WHERE               = "where";

    private static final String DELIM_ORDER_BY      = " order by ";

    private static final String DELIM_GROUP_BY      = " group by ";

    public static final String  NULL_ATTRIB_MAP     = "Search Exception : Search Attribute Map is null";

    private static final String NULL_QUERY_KEY      = "Search Exception : Query key passed is null";

    private SessionFactory      sessionFactory;

    /**
     * TODO Method defined to handle IN clause in SQL search in HQLSearch.java
     * The definition of the query below is the deviation from the standard
     * practice of declaring all search queries in search-metadata.xml. This has
     * been done to implement the "IN" clause in SQL search. As and when
     * suitable, an implementation will be done in this class and consequently
     * the query will move to search-metadata.xml
     * 
     * @param String
     *            searchQuery
     * @return List ResultSet list
     * @throws NotFoundException
     * @throws IntellicueException
     */
    public List searchForQuery(String searchQuery)
    throws DataNotFoundException {

        List results = new ArrayList();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery(searchQuery);
            results = query.list();
            session.close();
            if (results.size() == 0)
                throw new DataNotFoundException("No results found");

        }
        finally {
            session.close();
        }
        return results;
    }

    /**
     * @param queryKey
     * @param searchParams
     * @return
     * @throws NotFoundException
     *
     */
    public List search(String queryKey, Map searchParams)
            throws DataNotFoundException, ExecMapRuntimeException {

        String searchQuery = getQueryFromKey(queryKey);
        // log.info("searchQuery is : "+searchQuery);
        // log.info("searchParams is : "+searchParams);
        List results = new ArrayList();
        Session session = sessionFactory.openSession();
        try {
            String paramSubstitutedQuery = getQuery(searchQuery, searchParams);
            // log.info("paramSubstitutedQuery is : "+paramSubstitutedQuery);
            Query query = session.createQuery(paramSubstitutedQuery);
            // log.info("query is : "+query);
            retrieveAndSetSearchParams(query, searchParams);
            results = query.list();
            // log.info("getReturnTypes types"+query.getReturnTypes());
            // log.info("getReturnAliases types"+query.getReturnAliases());
            // log.info("getNamedParameters types"+query.getNamedParameters());
            //

            session.close();
            if (results.size() == 0)
                throw new DataNotFoundException("No results found");

        }
        finally {
            session.close();
        }
        return results;
    }

    /**
     * @param queryKey
     * @return
     */
    public List search(String queryKey) throws DataNotFoundException {

        String searchQuery = getQueryFromKey(queryKey);
        List results = new ArrayList();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery(searchQuery);
            results = query.list();
            session.close();
            if (results.size() == 0)
                throw new DataNotFoundException("No results found");

        }
        finally {
            session.close();
        }

        return results;
    }

    /**
     * @param queryKey
     * @return
     * @throws Exception
     */
    // public List searchForDropdowns(String queryKey, boolean searchAlways,
    // ServletContext servletContext, Map searchParams) {
    //
    // String searchQuery = getQueryFromKey(queryKey);
    //
    // List results = new ArrayList();
    // if (searchAlways || servletContext.getAttribute(queryKey) == null) {
    // Session session = sessionFactory.openSession();
    // try {
    // String paramSubstitutedQuery = getQuery(searchQuery,
    // searchParams);
    // Query query = session.createQuery(paramSubstitutedQuery);
    // retrieveAndSetSearchParams(query, searchParams);
    // results = query.list();
    // servletContext.setAttribute(queryKey, results);
    // session.close();
    // }
    // catch (Exception e) {
    //
    // }
    //
    // finally {
    // session.close();
    // }
    // } else {
    // results = (List) servletContext.getAttribute(queryKey);
    // }
    //
    // return results;
    // }
    /**
     * @param queryKey
     * @param searchParams
     * @param jumpTo
     * @param prevPageInstance
     * @return
     * @throws Exception
     */

    /*
     * public Page search(String queryKey, Map searchParams, String jumpTo, Page
     * prevPageInstance) throws NotFoundException, CMSException { String
     * searchQuery = getQueryFromKey(queryKey); if (log.isInfoEnabled()) {
     * log.info("Query : " + searchQuery); } Page page = null; Session session =
     * sessionFactory.openSession(); try { String paramSubstitutedQuery =
     * getQuery(searchQuery, searchParams); Query query =
     * session.createQuery(paramSubstitutedQuery);
     * retrieveAndSetSearchParams(query, searchParams);
     *  if (log.isInfoEnabled()) {
     * for (int i = query.getReturnTypes().length; i > 0; i--)
     * log.info(query.getReturnTypes()[i - 1].getName()); } int jumpToPageNo =
     * 0; if (jumpTo != null && prevPageInstance != null) if
     * ("previous".equals(jumpTo)) jumpToPageNo =
     * prevPageInstance.getPreviousPageNumber(); else if ("next".equals(jumpTo))
     * jumpToPageNo = prevPageInstance.getNextPageNumber(); else if
     * ("last".equals(jumpTo)) jumpToPageNo =
     * prevPageInstance.getLastPageNumber(); page = Page.getPageInstance(query,
     * jumpToPageNo); if (page.getTotalNumberOfElements() == 0) throw new
     * NotFoundException(); } finally { session.close(); } return page; }
     */
    // /**
    // * @param obj1
    // * @param obj2
    // * @return
    // * @throws Exception
    // */
    // public Object searchById(Class cls, Serializable obj2) throws Exception {
    // if (obj2 == null)
    // throw new Exception();
    // Object obj3 = null;
    // Session session = sessionFactory.openSession();
    // try {
    // obj3 = session.get(cls, obj2);
    // if (obj3 == null)
    // throw new Exception();
    //
    // }
    // finally {
    // session.close();
    // }
    //
    // return obj3;
    // }
    /**
     * @param sessionFactory
     *            The sessionFactory to set.
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Set Query Parameters
     *
     * @param query
     * @param searchParams
     * @throws HibernateException
     */
    private void retrieveAndSetSearchParams(Query query, Map searchParams)
            throws HibernateException {
        // log.info("retrieveAndSetSearchParams ENTER: " + query);
        for (int i = 0; i < query.getNamedParameters().length; i++) {
            String paramName = query.getNamedParameters()[i];
            Object paramValue = searchParams.get(paramName);
            if (paramValue != null) {
                if (paramValue.getClass().isArray()) {
                    Object[] values = (Object[]) paramValue;
                    query.setParameterList(paramName, values);
                } else if (paramValue instanceof Collection) {
                    Collection values = (Collection) paramValue;
                    query.setParameterList(paramName, values);
                } else {

                    query.setParameter(paramName, paramValue);
                }
            }
            // if (log.isInfoEnabled()) {
            // log.info("Binding value " + paramValue + " to " + paramName);
            // log.info("paramName :"+paramName);
            // log.info("paramValue :"+paramValue);
            // log.info("retrieveAndSetSearchParams query :"+query);
            //
            // }
        }

        // if (log.isInfoEnabled()) {
        // log.info("The generated Query is " + query.getQueryString());
        // }
    }

    /**
     * Used to construct a query from the query template, picked from the
     * properties file whose key is specified in the queryKey paramter
     *
     * @param queryKey
     *            the key for the query template in the properties file
     * @param searchAttribs
     *            the attributes to be used for search, keys of which are
     *            present in the query template.
     * @return the constructed query string with the substitutions. Keys that
     *         were not supplied in the map and keys in the map that did not
     *         match with those in the template are discarded in the constructed
     *         query
     * @throws Exception
     *             thrown when query could not be construtced due to some
     *             invalid values / malformed query template
     */
    protected String getQuery(String searchQuery, Map attribMap)
            throws ExecMapRuntimeException {
        String key = null;
        StringBuffer searchQueryBuffer = null;

        if (searchQuery == null) {
            throw new ExecMapRuntimeException();
        }

        int subQueryIdentifierIndex = searchQuery.indexOf(DELIM_SUB_QUERY);

        // substitute any sub-query here
        if (subQueryIdentifierIndex != -1) {
            searchQueryBuffer = new StringBuffer(searchQuery);

            String truncatedQuery = searchQuery
                    .substring(subQueryIdentifierIndex + 5);

            // get first index of ')' that closes the truncated query
            int truncatedQueryDelimiterIndex = truncatedQuery.indexOf(')');
            String subQueryKey = truncatedQuery.substring(0,
                    truncatedQueryDelimiterIndex);
            searchQueryBuffer.replace(subQueryIdentifierIndex,
                    subQueryIdentifierIndex + 5 + truncatedQueryDelimiterIndex,
                    getQuery(subQueryKey, attribMap));
            searchQuery = searchQueryBuffer.toString();
        }

        // check for order by clause in query
        int orderByIndex = -1;
        String orderByClause = null;
        StringBuffer orderByClauseBuffer = null;

        if ((orderByIndex = searchQuery.indexOf(DELIM_ORDER_BY)) != -1) {
            orderByClause = searchQuery.substring(orderByIndex);
            searchQuery = searchQuery.substring(0, orderByIndex);

            orderByClauseBuffer = new StringBuffer(orderByClause);

            Iterator attribIterator = attribMap.keySet().iterator();

            while (attribIterator.hasNext()) {
                key = (String) attribIterator.next();

                if (key == null || attribMap.get(key) == null) {
                    continue;
                }

                int startIndex = orderByClause.indexOf(DELIM_DOLLAR + key);

                if (startIndex != -1) {
                    orderByClauseBuffer.replace(startIndex, startIndex
                            + (DELIM_DOLLAR + key).length(), ":" + key);
                }

                orderByClause = orderByClauseBuffer.toString();
            }
        }

        // check for group by clause in query
        int groupByIndex = -1;
        String groupByClause = null;

        if ((groupByIndex = searchQuery.indexOf(DELIM_GROUP_BY)) != -1) {
            groupByClause = searchQuery.substring(groupByIndex);
            searchQuery = searchQuery.substring(0, groupByIndex);
        }

        // check for where clause in query
        int whereIndex = -1;
        String whereClause = null;
        StringBuffer whereClauseBuffer = null;

        if ((whereIndex = searchQuery.indexOf(DELIM_WHERE)) != -1) {
            whereClause = searchQuery.substring(whereIndex + 6);
            searchQueryBuffer = new StringBuffer(searchQuery.substring(0,
                    whereIndex + 6));
            whereClauseBuffer = new StringBuffer(whereClause);
            // log.info("***whereClause :"+whereClause);
            // log.info("***searchQueryBuffer :"+searchQueryBuffer);

            Iterator attribIterator = attribMap.keySet().iterator();

            while (attribIterator.hasNext()) {
                key = (String) attribIterator.next();

                if (key == null || attribMap.get(key) == null) {
                    continue;
                }

                int startIndex = whereClause.indexOf(DELIM_DOLLAR + key);

                if (startIndex != -1) {
                    whereClauseBuffer.replace(startIndex, startIndex
                            + (DELIM_DOLLAR + key).length(), ":" + key);
                }

                whereClause = whereClauseBuffer.toString();
            }
            // log.info("***whereClause :"+whereClause);
            int queryStringIndex = -1;

            String preWhereClause = null;
            String postWhereClause = null;

            while ((queryStringIndex = whereClause.indexOf(DELIM_DOLLAR))
                    != -1) {
                postWhereClause = whereClause.substring(queryStringIndex + 1);

                int delimANDIndex = postWhereClause.indexOf(DELIM_AND);
                int delimORIndex = postWhereClause.indexOf(DELIM_OR);
                int delimBracketIndex = postWhereClause
                        .indexOf(DELIM_END_BRACKET);
                int substrPostion = -1;

                if (delimANDIndex != -1 || delimORIndex != -1
                        || delimBracketIndex != -1) {
                    delimANDIndex = (delimANDIndex == -1) ? Integer.MAX_VALUE
                            : delimANDIndex;
                    delimORIndex = (delimORIndex == -1) ? Integer.MAX_VALUE
                            : delimORIndex;
                    delimBracketIndex = (delimBracketIndex == -1)
                    ? Integer.MAX_VALUE
                            : delimBracketIndex;

                    substrPostion = ((delimANDIndex < delimORIndex)
                            && (delimANDIndex < delimBracketIndex))
                            ? delimANDIndex
                            : ((delimORIndex < delimANDIndex)
                                    && (delimORIndex < delimBracketIndex))
                                    ? delimORIndex
                                    : delimBracketIndex;

                    postWhereClause = (substrPostion > -1
                            && substrPostion < postWhereClause
                            .length()) ? postWhereClause
                            .substring(substrPostion) : postWhereClause;
                } else {
                    postWhereClause = "";
                }

                preWhereClause = whereClause.substring(0, queryStringIndex);
                // log.info("***preWhereClause :"+preWhereClause);
                // log.info("***postWhereClause :"+postWhereClause);
                delimANDIndex = preWhereClause.lastIndexOf(DELIM_AND);
                delimORIndex = preWhereClause.lastIndexOf(DELIM_OR);

                delimBracketIndex = preWhereClause
                        .lastIndexOf(DELIM_START_BRACKET);
                // log.info("***delimANDIndex :"+delimANDIndex);
                // log.info("***delimORIndex :"+delimORIndex);
                // log.info("***delimBracketIndex :"+delimBracketIndex);
                if (delimANDIndex != -1 || delimORIndex != -1
                        || delimBracketIndex != -1) {
                    delimANDIndex = (delimANDIndex == -1) ? Integer.MIN_VALUE
                            : delimANDIndex;
                    delimORIndex = (delimORIndex == -1) ? Integer.MIN_VALUE
                            : delimORIndex;
                    delimBracketIndex = (delimBracketIndex == -1)
                    ? Integer.MIN_VALUE
                            : delimBracketIndex;

                    substrPostion = ((delimANDIndex > delimORIndex)
                            && (delimANDIndex > delimBracketIndex))
                            ? delimANDIndex
                            : ((delimORIndex > delimANDIndex) &&
                                    (delimORIndex > delimBracketIndex))
                                    ? delimORIndex
                                    : (delimBracketIndex + DELIM_START_BRACKET
                                            .length());
                    preWhereClause = (substrPostion > -1 &&
                            substrPostion < preWhereClause
                            .length()) ? preWhereClause.substring(0,
                            substrPostion) : preWhereClause;
                } else {
                    preWhereClause = "";
                }

                // log.info("***preWhereClause :"+preWhereClause);
                // log.info("***postWhereClause :"+postWhereClause);

                // if (log.isDebugEnabled()) {
                // log.debug("Processing STEP1:");
                // log.debug("postWhereClause: " + postWhereClause);
                // log.debug("preWhereClause: " + preWhereClause);
                // }

                if (preWhereClause.trim().endsWith(DELIM_START_BRACKET)) {
                    if (postWhereClause.trim().startsWith(DELIM_AND.trim())) {
                        postWhereClause = " "
                                + postWhereClause.trim().substring(
                                        DELIM_AND.trim().length());
                    } else if (postWhereClause.trim().startsWith(
                            DELIM_OR.trim())) {
                        postWhereClause = " "
                                + postWhereClause.trim().substring(
                                        DELIM_OR.trim().length());
                    } else if (postWhereClause.trim().startsWith(
                            DELIM_END_BRACKET)) {
                        delimANDIndex = postWhereClause.indexOf(DELIM_AND);
                        delimORIndex = postWhereClause.indexOf(DELIM_OR);
                        if (delimANDIndex != -1 || delimORIndex != -1) {
                            delimANDIndex = (delimANDIndex == -1)
                            ? Integer.MAX_VALUE
                                    : delimANDIndex;
                            delimORIndex = (delimORIndex == -1)
                            ? Integer.MAX_VALUE
                                    : delimORIndex;

                            substrPostion = (delimANDIndex < delimORIndex)
                            ? (delimANDIndex + DELIM_AND
                                    .length())
                                    : (delimORIndex + DELIM_OR.length());
                            char[] initPortion = postWhereClause.substring(0,
                                    substrPostion).toCharArray();
                            postWhereClause = (substrPostion > -1 &&
                                    substrPostion < postWhereClause
                                    .length()) ? postWhereClause.substring(
                                    substrPostion).trim() : postWhereClause;

                            int count = 0;
                            for (int i = 0; i < initPortion.length; i++) {
                                if (DELIM_END_BRACKET.charAt(0) ==
                                    initPortion[i]) {
                                    count++;
                                }
                            }

                            preWhereClause = preWhereClause.trim().substring(0,
                                    preWhereClause.trim().length() - count);
                        } else {
                            if (postWhereClause.trim().startsWith(
                                    DELIM_END_BRACKET)) {
                                postWhereClause = "";
                                delimANDIndex = preWhereClause
                                        .lastIndexOf(DELIM_AND);
                                delimORIndex = preWhereClause
                                        .lastIndexOf(DELIM_OR);
                                if (delimANDIndex != -1 || delimORIndex != -1) {
                                    delimANDIndex = (delimANDIndex == -1)
                                    ? Integer.MIN_VALUE
                                            : delimANDIndex;
                                    delimORIndex = (delimORIndex == -1)
                                    ? Integer.MIN_VALUE
                                            : delimORIndex;

                                    substrPostion = (delimANDIndex
                                            > delimORIndex) ? delimANDIndex
                                            : delimORIndex;
                                    preWhereClause = (substrPostion > -1
                                            && substrPostion < preWhereClause
                                            .length()) ? preWhereClause
                                            .substring(0, substrPostion)
                                            : preWhereClause;
                                } else {
                                    preWhereClause = "";
                                }
                            }
                        }
                    }
                }

                // if (log.isDebugEnabled()) {
                // log.debug("Processing STEP2:");
                // log.debug("postWhereClause: " + postWhereClause);
                // log.debug("preWhereClause: " + preWhereClause);
                // }

                whereClause = preWhereClause + postWhereClause;

                // if (log.isDebugEnabled()) {
                // log.debug("At end of loop, WhereClause: " + whereClause);
                // }
            }

            if (whereClause.trim().startsWith(DELIM_AND.trim())) {
                whereClause = whereClause.trim().substring(
                        whereClause.indexOf(DELIM_AND.trim())
                                + DELIM_AND.trim().length());
            } else if (whereClause.trim().startsWith(DELIM_OR.trim())) {
                whereClause = whereClause.substring(whereClause
                        .indexOf(DELIM_OR.trim())
                        + DELIM_OR.trim().length());
            }

            whereClause = " " + whereClause.trim();
        } else {
            searchQueryBuffer = new StringBuffer(searchQuery);
        }

        // append where clause here
        if (whereIndex != -1) {
            searchQueryBuffer.insert(whereIndex + 6, whereClause);
        }

        searchQuery = searchQueryBuffer.toString().trim();

        // check for empty where clause
        if (searchQuery.endsWith(WHERE)) {
            int bufferIndex = searchQuery.length();
            searchQueryBuffer.delete(bufferIndex - 6, bufferIndex);
        }

        // append group by clause
        if (groupByIndex != -1) {
            searchQueryBuffer.append(groupByClause);
        }

        // append order by clause
        if (orderByIndex != -1) {
            searchQueryBuffer.append(orderByClause);
        }

        // if (log.isInfoEnabled()) {
        // log.info("Final Search SQL: " + searchQueryBuffer);
        // }

        return searchQueryBuffer.toString();
    }

    /**
     * Gets the query from a queryKey
     * 
     * @param queryKey
     * @return
     */
    protected String getQueryFromKey(String queryKey) {
        String searchQuery = SearchMetadataParser
                .getQueryValueFromKey(queryKey);
        return searchQuery;
    }

}
