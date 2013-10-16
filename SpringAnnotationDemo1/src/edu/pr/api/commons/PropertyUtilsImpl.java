/**
 * 
 */
package edu.pr.api.commons;

import java.io.Serializable;
import java.util.Date;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Devika Bhatt
 *
 */

public class PropertyUtilsImpl implements PropertyUtils, Serializable
{
	public boolean isInvalidBooleanValue(String property) throws Exception
	{
		if(property!=null && (property.equalsIgnoreCase("true") || property.equalsIgnoreCase("false")
				|| property.equalsIgnoreCase("yes") || property.equalsIgnoreCase("no")))
		{
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean isInvalidPropertyValue(String property) throws Exception
	{
		if(property==null || property.equals("") || property.equalsIgnoreCase("-1")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isInvalidId(String property) throws Exception
	{
		if(property==null || property.equals("") || property.equalsIgnoreCase("-1")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isInvalidDeleteValue(String property) throws Exception
	{
		if(property==null || (!property.equals(PropertyUtils.YES) && !property.equals(PropertyUtils.NO)))
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isTrueBooleanValue(String property) throws Exception
	{
		if(property!=null && (property.equalsIgnoreCase("true") || property.equalsIgnoreCase("yes")))
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isEqualValues(String stringToCompare, String compareWith) throws Exception
	{
		if(stringToCompare!=null && !stringToCompare.equals("") && stringToCompare.equalsIgnoreCase(compareWith))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isFutureDate(Date date) throws Exception
	{
		if(date!=null && !date.before(DateUtils.getSystemDate()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
