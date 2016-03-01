/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Sep 9, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util.webapp;

import org.apache.struts.action.PlugIn;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.mgmtassessment.execmap.business.impl.company.CompanyManagerFacadeImpl;
import com.mgmtassessment.execmap.common.util.webapp.FileDeleteUtil;


/**
 * This plugin class is loaded on start up. The init method
 * starts a scheduler to run every specified interval. At 
 * the specified interval it deletes all the temporary
 * files in the specified directory.
 * @see strts-config file for plugin config for startup.
 * 
 * 
 */

public class FileScheduleCleanupPlugin implements PlugIn{
    
	/** Log factory for this class. * */
    private static Log     log = LogFactory
    .getLog(FileScheduleCleanupPlugin.class);

    /** Timer for the plugin **/ 
	Timer timer = null;
	
	/** Every time period this timer will run.
	 *  Example every 10 minutes. Default to every hour.
	 *  i.e 60*60*1000 
	 *  Note: The timePeriod should be in continous numbers.
	 *  No multiplication signs!
	 */
	String timePeriod = "3600000" ;
	
	/** Path where file will be deleted **/
	String filePath = null;
	
	/**
	 * public constructor
	 */
	public FileScheduleCleanupPlugin (){
		super();
	}
	
	/**
	 * Invoked by controller.
	 * starts the process scheduler runs as per config
	 * to delete files in the (Execmap)/html/reports/ dir
	 */
	public void init(ActionServlet servlet, ModuleConfig config){
		log.info("Initialised FilescheduleCleanUpPlugin");
		timer = new Timer();
	    Calendar date = Calendar.getInstance();
	    log.info("Delete File Directory: " + filePath);
	    try{
	       timer.scheduleAtFixedRate(new FileDeleteUtil(filePath),
	    		        date.getTime(), Long.parseLong(timePeriod));
	    }catch (IllegalArgumentException ex){
	    	log.fatal("Could Not Start Scheduler due to invalid parameters",ex);
	    }catch(IllegalStateException ex){
	    	log.fatal("Could Not Start Scheduler Due to " +
	    			"invalid timer state.",ex);
	    }
	}
	
	/**
	 * Invoked on shutdown
	 */
	public void destroy(){
		log.info("Destroying FilescheduleCleanUpPlugin"); 
		/** cancel the timer **/
     	timer.cancel();
     	timer = null;
 	}

	/**
	 * @return Returns the filePath.
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath The filePath to set.
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return Returns the timePeriod.
	 */
	public String getTimePeriod() {
		return timePeriod;
	}

	/**
	 * @param timePeriod The timePeriod to set.
	 */
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
}
