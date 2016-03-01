
package com.mgmtassessment.execmap.data.dao.types;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author srivasvi
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class SearchMetadataVO {

	private String searchModule = new String();

	private String searchQueryKey = new String();

	private String searchPorstProcessorClass = new String();

	Collection searchResultMetadataVOCol = new ArrayList();

	Collection searchButtonMetadataVOCol = new ArrayList();

	/**
	 * @return Returns the searchModule.
	 */
	public String getSearchModule() {
		return searchModule;
	}

	/**
	 * @param searchModule
	 *            The searchModule to set.
	 */
	public void setSearchModule(String searchModule) {
		this.searchModule = searchModule;
	}

	/**
	 * @return Returns the searchQueryKey.
	 */
	public String getSearchQueryKey() {
		return searchQueryKey;
	}

	/**
	 * @param searchQueryKey
	 *            The searchQueryKey to set.
	 */
	public void setSearchQueryKey(String searchQueryKey) {
		this.searchQueryKey = searchQueryKey;
	}

	/**
	 * @return Returns the searchResultMetadataVOCol.
	 */
	public Collection getSearchResultMetadataVOCol() {
		return searchResultMetadataVOCol;
	}

	/**
	 * @param searchResultMetadataVOCol
	 *            The searchResultMetadataVOCol to set.
	 */
	public void setSearchResultMetadataVOCol(
			Collection searchResultMetadataVOCol) {
		this.searchResultMetadataVOCol = searchResultMetadataVOCol;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("searchModule", getSearchModule())
				.append("searchQueryKey", getSearchQueryKey())
				.append("search-post-processor", getSearchPorstProcessorClass())
				.append("searchResultMetadataVOCol",
						getSearchResultMetadataVOCol()).append(
						"searchButtonMetadataVOCol",
						getSearchButtonMetadataVOCol()).toString();
	}

	/**
	 * @return Returns the searchButtonMetadataVOCol.
	 */
	public Collection getSearchButtonMetadataVOCol() {
		return searchButtonMetadataVOCol;
	}

	/**
	 * @param searchButtonMetadataVOCol
	 *            The searchButtonMetadataVOCol to set.
	 */
	public void setSearchButtonMetadataVOCol(
			Collection searchButtonMetadataVOCol) {
		this.searchButtonMetadataVOCol = searchButtonMetadataVOCol;
	}

	public String getSearchPorstProcessorClass() {
		return searchPorstProcessorClass;
	}

	public void setSearchPorstProcessorClass(String searchPorstProcessorClass) {
		this.searchPorstProcessorClass = searchPorstProcessorClass;
	}
}