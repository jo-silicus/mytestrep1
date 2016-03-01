package com.mgmtassessment.execmap.data.dao.types;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author srivasvi
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class SearchResultMetadataVO {

	private String displayColumnName = new String();

	private String dataColumnName = new String();

	private String url = new String();

	/**
	 * @return Returns the dataColumnName.
	 */
	public String getDataColumnName() {
		return dataColumnName;
	}

	/**
	 * @param dataColumnName
	 *            The dataColumnName to set.
	 */
	public void setDataColumnName(String dataColumnName) {
		this.dataColumnName = dataColumnName;
	}

	/**
	 * @return Returns the displayColumnName.
	 */
	public String getDisplayColumnName() {
		return displayColumnName;
	}

	/**
	 * @param displayColumnName
	 *            The displayColumnName to set.
	 */
	public void setDisplayColumnName(String displayColumnName) {
		this.displayColumnName = displayColumnName;
	}

	public String toString() {
		return new ToStringBuilder(this).append("displayColumnName",
				getDisplayColumnName()).append("dataColumnName",
				getDataColumnName()).toString();
	}

	/**
	 * @return Returns the url.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            The url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}