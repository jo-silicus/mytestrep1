
package com.mgmtassessment.execmap.common.util.search;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.mgmtassessment.execmap.data.dao.types.SearchButtonMetadataVO;
import com.mgmtassessment.execmap.data.dao.types.SearchMetadataVO;
import com.mgmtassessment.execmap.data.dao.types.SearchResultMetadataVO;

/**
 * @author srivasvi TODO To change the template for this generated type comment
 *         go to Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchMetadataParser {

 
    public static SearchMetadataVO convertXMLToVO(String moduleName) {
        DocumentBuilder builder = null;
        SearchMetadataVO searchMetadataVO = new SearchMetadataVO();

        if (builder == null) {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();

            try {
                builder = factory.newDocumentBuilder();
            }
            catch (ParserConfigurationException pce) {
                // throw new FMSException(IProfile.PARSER_EXCEPTION_MESSAGE);
            }
        }

        Document document = null;

        ByteArrayInputStream bis = null;

        try {
            bis = new ByteArrayInputStream(read(getXMLFileName()));
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            document = builder.parse(bis);
        }
        catch (IOException ioe) {
            // will never happen
        }
        catch (SAXException spe) {
            // throw new FMSException(IProfile.SAX_EXCEPTION_MESSAGE);
        }

        Element searchMeatadata = document.getDocumentElement();

        NodeList searchModules = searchMeatadata
                .getElementsByTagName("search-module");

        int countSearchModules = searchModules.getLength();
        for (int i = 0; i < countSearchModules; i++) {

            Element searchModule = (Element) searchModules.item(i);

            String searchModuleName = searchModule.getAttribute("name");

            if (searchModuleName != null && searchModuleName.equals(moduleName)) {

                searchMetadataVO.setSearchModule(searchModuleName);

                NodeList searchQueries = searchModule
                        .getElementsByTagName("search-query");
                Element searchQuery = (Element) searchQueries.item(0);

                searchMetadataVO.setSearchQueryKey(searchQuery
                        .getAttribute("key-name"));

                NodeList searchPostProcessors = searchModule
                        .getElementsByTagName("search-post-processor");
                if (searchPostProcessors.getLength() > 0) {
                    Element searchPostProcessor = (Element) searchPostProcessors
                            .item(0);

                    searchMetadataVO
                            .setSearchPorstProcessorClass(searchPostProcessor
                                    .getAttribute("class"));
                }

                setResultMetadata(searchMetadataVO, searchModule);
                setButtonMetadata(searchMetadataVO, searchModule);
            }

        }

        return searchMetadataVO;
    }

    public static byte[] read(String file) throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("com/mgmtassessment/execmap/" +
                "common/util/search/search-metadata.xml");
        byte[] data = new byte[in.available()];
        in.read(data);
        return data;
    }

   public static String getXMLFileName() {



        URL searchUrl = Thread.currentThread()
        .getContextClassLoader().getResource("com/mgmtassessment/execmap/" +
                "common/util/search/search-metadata.xml");


        String fileName = searchUrl.getFile();

        return fileName;
    }

    public static void setResultMetadata(SearchMetadataVO searchMetadataVO,
            Element searchModule) {
        NodeList resultMetadatas = searchModule
                .getElementsByTagName("result-metadata");
        Element resultMetadata = (Element) resultMetadatas.item(0);

        NodeList columns = resultMetadata.getElementsByTagName("column");

        int count = columns.getLength();
        for (int j = 0; j < count; j++) {
            SearchResultMetadataVO searchResultMetadataVO =
                new SearchResultMetadataVO();
            Element column = (Element) columns.item(j);
            String displayColumnName = column
                    .getAttribute("display-column-name");
            searchResultMetadataVO.setDisplayColumnName(displayColumnName);

            String dataColumnName = column.getAttribute("data-column-name");
            searchResultMetadataVO.setDataColumnName(dataColumnName);

            NodeList urls = column.getElementsByTagName("url");
            if (urls.getLength() > 0) {
                Element urlElement = (Element) urls.item(0);
                Text urlText = (Text) urlElement.getFirstChild();
                String url = urlText.getData();
                searchResultMetadataVO.setUrl(url);
            }

            searchMetadataVO.getSearchResultMetadataVOCol().add(
                    searchResultMetadataVO);

        }
    }

    public static void setButtonMetadata(SearchMetadataVO searchMetadataVO,
            Element searchModule) {
        NodeList buttonMetadatas = searchModule
                .getElementsByTagName("button-metadata");
        Element buttonMetadata = (Element) buttonMetadatas.item(0);

        NodeList buttons = buttonMetadata.getElementsByTagName("button");

        int count = buttons.getLength();
        for (int j = 0; j < count; j++) {
            SearchButtonMetadataVO searchButtonMetadataVO =
                new SearchButtonMetadataVO();
            Element button = (Element) buttons.item(j);
            String displayButtonName = button
                    .getAttribute("display-button-name");
            searchButtonMetadataVO.setDisplayButtonName(displayButtonName);

            NodeList onClickActions = button
                    .getElementsByTagName("on-click-action");
            if (onClickActions.getLength() > 0) {
                Element onClickActionElement = (Element) onClickActions.item(0);
                Text onClickActionText = (Text) onClickActionElement
                        .getFirstChild();
                String onClickActionValue = onClickActionText.getData();
                searchButtonMetadataVO.setOnClickAction(onClickActionValue);
            }

            searchMetadataVO.getSearchButtonMetadataVOCol().add(
                    searchButtonMetadataVO);

        }
    }

    public static String getQueryValueFromKey(String key) {
        DocumentBuilder builder = null;

        if (builder == null) {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();

            try {
                builder = factory.newDocumentBuilder();
            }
            catch (ParserConfigurationException pce) {
                // throw new FMSException(IProfile.PARSER_EXCEPTION_MESSAGE);
            }
        }

        Document document = null;

        ByteArrayInputStream bis = null;

        try {
            bis = new ByteArrayInputStream(read(getXMLFileName()));
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            document = builder.parse(bis);
        }
        catch (IOException ioe) {
            // will never happen
        }
        catch (SAXException spe) {
            // throw new FMSException(IProfile.SAX_EXCEPTION_MESSAGE);
        }

        Element searchMeatadata = document.getDocumentElement();

        NodeList keyQueryMappings = searchMeatadata
                .getElementsByTagName("key-query-mapping");
        Element keyQueryMapping = (Element) keyQueryMappings.item(0);

        NodeList searchQueries = keyQueryMapping
                .getElementsByTagName("search-query");

        String queryValue = null;

        int count = searchQueries.getLength();
        for (int i = 0; i < count; i++) {

            Element searchQuery = (Element) searchQueries.item(i);

            String searchKeyName = searchQuery.getAttribute("key-name");

            NodeList searchQueryValues = searchQuery
                    .getElementsByTagName("query-value");
            Element searchQueryValueElement = (Element) searchQueryValues
                    .item(0);
            Text searchQueryValueText = (Text) searchQueryValueElement
                    .getFirstChild();

            if (searchKeyName != null && searchKeyName.equals(key)) {
                queryValue = searchQueryValueText.getData();
            }

        }

        return queryValue;

    }

}