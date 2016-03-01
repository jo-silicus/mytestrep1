/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Sep 16, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util.webapp;

import java.io.File;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This is a utility class which deletes the all the 
 * report html files in the execmap/html/report folder.
 * The invocation for this class gets triggered by the 
 * timer scheduler @link <code>FileScheduleCleanupPlugin.java
 * </code>  
 * 
 */

public class FileDeleteUtil extends TimerTask {
	
     private static Log  log = LogFactory
    .getLog(FileDeleteUtil.class);

	  /** file delete dir **/
	  String fileDeleteDir = null;
	  
	  /** Public constructor **/
	  public FileDeleteUtil(String delDir){
		  fileDeleteDir = delDir;
	  }
	  
	  public void run() {
		  log.info("Now begining to delete report files...");
		  File dir = new File(fileDeleteDir);
		  deleteDir(dir);
		  log.info("End deleteing report files.");
	  }
	
      /**
       * util method to delete all files in th directory.
       * @param dir
       */ 	
	  public static void deleteDir(File dir) {
	     if (dir.isDirectory()) {
	            String[] children = dir.list();
	            for (int i=0; i<children.length; i++) {
	                 File file = new File(dir, children[i]);
	                 log.info("Deleting file:" + file.toString());
	                 file.delete();
	            }
	     }
	  }
}