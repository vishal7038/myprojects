/**
 * 
 */
package edu.pr.api.commons;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Devika Bhatt
 *
 */
public class DateUtils 
{
	public static final SimpleDateFormat sdf= new SimpleDateFormat("dd MMM, yyyy");
	public static final SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");
	
	public synchronized static Date queryFromDate(Date fromDate) throws Exception
	{
		if(fromDate == null){
			fromDate = new Date(0);
		}
		
		return fromDate;
	}
	
	public synchronized static Date queryToDate(Date toDate) throws Exception
	{
		if(toDate == null){
			toDate = new Date(System.currentTimeMillis());
		}
		
		return toDate;
	}
	   
	/**
	 * Convert String date formated in "dd MMM, yyyy" to sql date.
	 * @param stringDate
	 * @return
	 * @throws Exception
	 */
	public synchronized static Date convertStringToSqlDate(String stringDate)throws Exception
	{
		   Date date = null;
		   
		   if(stringDate==null || stringDate.equals("")){
			   return date;
		   }	   
		   try
		   {
		   //	date = new Date(sdf.parse(stringDate).getTime());
				date = new Date(sdf1.parse(stringDate).getTime());
		   }
		   catch(Exception e)
		   {
			    System.out.println("DateUtils.stringToSqlDate() :: " + e.getMessage());
		   }
		   return date;  
		    
	}
    
    public synchronized static Date getSystemDate() throws Exception
    {
    	return new Date(new java.util.Date().getTime());
    }
    
    public synchronized static Date getOneMonthPreviousDate() throws Exception
    {
    	Calendar calendar = GregorianCalendar.getInstance();
    	calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
    	
    	return new Date(calendar.getTimeInMillis());
    }
    
    public synchronized static Date getOneDayPreviousDate(Date date) throws Exception
    {
    	final long MILLIS_IN_A_DAY = 1000*60*60*24;  
    	return new Date(date.getTime() - MILLIS_IN_A_DAY); 
    }

    public synchronized static String convertSqlDateToString(Date date)throws Exception
    {
	   String stringDate = "";
   
	    if(date==null){
		   return stringDate;
	    }	   
	    try
	    {
	      //stringDate = sdf.format(date);
	      stringDate = sdf1.format(date);
	    }
	    catch(Exception e)
	    {
		    System.out.println("DateUtils.convertSqlDateToString() :: " + e.getMessage());
		}
		    return stringDate;
	}
    
    public synchronized static Date addNoOfMonthsToDate(Date fromDate,int no) throws Exception
    {
    	Calendar calendar = GregorianCalendar.getInstance();
    	calendar.setTime(fromDate);
    	calendar.add(Calendar.MONTH,no);
    	calendar.add(Calendar.DATE,-1);
    	return new Date(calendar.getTimeInMillis());
    }
    
    public synchronized static Date addNoOfDaysToDate(Date date,int no) throws Exception
    {
    	Calendar calendar = GregorianCalendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.DATE,no);
    	return new Date(calendar.getTimeInMillis());
    }
    
}
