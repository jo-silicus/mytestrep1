/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Aug 7, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util;

import java.util.ResourceBundle;
import java.util.Locale;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class TranslateMessageHelper {
	

      public String getAssesmentMessage( final String key, final Locale locale){
    	  
    	       ResourceBundle rsrcAssesmentBundle = ResourceBundle.
               getBundle(IConstants.ASSESMENT_MESSAGE_RESOURCE, locale);
    	       return rsrcAssesmentBundle.getString(key);
    	       
      }
      
      public String getExecmapMessage( final String key, final Locale locale){
    	  
	       ResourceBundle rsrcExecmapBundle = ResourceBundle.
           getBundle(IConstants.EXECMAP_MESSAGE_RESOURCE, locale);
	       return rsrcExecmapBundle.getString(key);
	  }
}
