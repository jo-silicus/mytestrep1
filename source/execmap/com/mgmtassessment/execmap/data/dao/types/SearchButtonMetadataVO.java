
package com.mgmtassessment.execmap.data.dao.types;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author srivasvi
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class SearchButtonMetadataVO {

	private String displayButtonName = new String();

	private String onClickAction = new String();

	/**
	 * @return Returns the displayButtonName.
	 */
	public String getDisplayButtonName() {
		return displayButtonName;
	}

	/**
	 * @param displayButtonName
	 *            The displayButtonName to set.
	 */
	public void setDisplayButtonName(String displayButtonName) {
		this.displayButtonName = displayButtonName;
	}

	/**
	 * @return Returns the onClickAction.
	 */
	public String getOnClickAction() {
		return onClickAction;
	}

	/**
	 * @param onClickAction
	 *            The onClickAction to set.
	 */
	public void setOnClickAction(String onClickAction) {
		this.onClickAction = onClickAction;
	}

	public String toString() {
		return new ToStringBuilder(this).append("displayButtonName",
				getDisplayButtonName()).append("onClickAction",
				getOnClickAction()).toString();
	}

}