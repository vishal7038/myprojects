/**
 * 
 */
package edu.pr.api.ui.multicheckbox;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Id;

/**
 * @author Devika Bhatt
 *
 */

public class MultiCheckBoxUtil 
{
	private Field id;
	private Field checkBox;
	private Class targetClass;
	
	public MultiCheckBoxUtil(Class clazz) throws Exception
	{
		this.targetClass= clazz;
		setFields();
	}
	
	private void setFields() throws Exception
	{
		for(Field field : this.targetClass.getDeclaredFields())
		{
			if(field.isAnnotationPresent(CheckBox.class) && field.getType() == String.class)
			{
				field.setAccessible(true);
				this.checkBox = field;
			}
			//else if(field.isAnnotationPresent(Id.class) && (field.getType() == String.class || field.getType().isPrimitive()))
			else if(field.isAnnotationPresent(Id.class) && (field.getType() == String.class))
			{
				field.setAccessible(true);
				this.id = field;
			}
		}
		
		if(this.id==null)
		{
			throw new Exception("id field null.");
		}
		
		if(this.checkBox==null)
		{
			throw new Exception("checkbox fied null.");
		}
	}
	
	public List getUserSelection(List fromUI) throws Exception
	{
		List userSelection = new ArrayList();
		
		Iterator it = fromUI.iterator();
		while(it.hasNext())
		{	
			Object operand = it.next();
			
			System.out.println("MultiCheckBoxUtil.getUserSelection() operand = " + operand);
			System.out.println("MultiCheckBoxUtil.getUserSelection() this.checkBox = " + this.checkBox);
			
			if(operand.getClass() ==  targetClass)
			{
				String id = (String)this.id.get(operand);
				String checkBox = (String)this.checkBox.get(operand);
				
				if(id!=null && id.equalsIgnoreCase(checkBox))
				{
					userSelection.add(operand);
				}
			}
			else
			{
				throw new Exception("MultiCheckBoxUtil.prepareGUI() : FromUI list should not contian object of another class specifed in constructor.");
			}
			
		}
		
		return userSelection;
	}
	
	public List prepareGUI(List entireList, List userList) throws Exception
	{
		Iterator itEntireList = entireList.iterator();
		while(itEntireList.hasNext())
		{	
			Object operand = itEntireList.next();
			
			if(operand.getClass() ==  targetClass)
			{
				String operandId = this.id.get(operand).toString();
				
				Iterator itUserList = userList.iterator();
				while(itUserList.hasNext())
				{	
					Object user = itUserList.next();
					
					if(operand.getClass() ==  targetClass)
					{
						String userId = this.id.get(user).toString();
						
						if(operandId!=null && userId!=null && operandId.equalsIgnoreCase(userId))
						{
							this.checkBox.set(operand, operandId);
							break;
						}
					}
					else
					{
						throw new Exception("MultiCheckBoxUtil.prepareGUI() : User list should not contian object of another class specifed in constructor.");
					}
					
				}
			}
			else
			{
				throw new Exception("MultiCheckBoxUtil.prepareGUI() : Entire list should not contian object of another class specifed in constructor.");
			}
			
		}
		
		return entireList;
	}
}
