/**
 * 
 */
package edu.pr.api.commons;

import java.util.Date;

/**
 * @author Devika Bhatt
 *
 */

public interface PropertyUtils 
{
	public static final String YES="Yes";
	public static final String NO="No";
	public static final String existingMember="true";
	public static final boolean newMember=false;
	
	public boolean isInvalidBooleanValue(String property) throws Exception;
	public boolean isInvalidPropertyValue(String property) throws Exception;
	public boolean isInvalidId(String property) throws Exception;
	public boolean isInvalidDeleteValue(String property) throws Exception;
	public boolean isTrueBooleanValue(String property) throws Exception;
	public boolean isEqualValues(String stringToCompare, String compareWith) throws Exception;
	public boolean isFutureDate(Date date) throws Exception;
}
