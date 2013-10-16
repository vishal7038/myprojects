/**
 * 
 */
package edu.pr.api.commons;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * @author Devika Bhatt
 *
 */

public class CollectionUtils
{
	public static void removeObjectOfId(Collection li, Class clazz, String id) throws Exception
	{
		new CollectionUtils().processRemoveObjectOfId(li, clazz, id);
	}
	
	public void processRemoveObjectOfId(Collection li, Class clazz, String id) throws Exception
	{
		Iterator it = li.iterator();
		
		while(it.hasNext())
		{	
			Object o = it.next();
			
			for(Field f : o.getClass().getDeclaredFields())
			{
				if(f.isAnnotationPresent(clazz))
				{
					if(f.getType() == String.class || f.getType().isPrimitive())
					{
							f.setAccessible(true);
							String key = f.get(o).toString();
							if(id.equalsIgnoreCase(key))
							{
								it.remove();
								break;
							}
					}
				}
			}
			
			List<Method> declaredMethods  = new ArrayList<Method>(Arrays.asList(o.getClass().getDeclaredMethods()));
			declaredMethods.addAll(new ArrayList<Method>(Arrays.asList(o.getClass().getMethods())));
			
			//for(Method f : o.getClass().getDeclaredMethods())
			for(Method f : declaredMethods)
			{
				if(f.isAnnotationPresent(clazz))
				{
					if(f.getReturnType() == String.class || f.getReturnType().isPrimitive())
					{
							f.setAccessible(true);
							String key = f.invoke(o, new Object[]{}).toString();
							
							if(id.equalsIgnoreCase(key))
							{
								it.remove();
								break;
							}
					}
				}
			}
		}
	}
	
	////===========================================
	
	public static Object getObjectOfId(Collection li, Class clazz, String id) throws Exception
	{
		return new CollectionUtils().processGetObjectOfId(li, clazz, id);
	}
	
	public Object processGetObjectOfId(Collection li, Class clazz, String id) throws Exception
	{
		Iterator it = li.iterator();
		
		while(it.hasNext())
		{	
			Object o = it.next();
			
			for(Field f : o.getClass().getDeclaredFields())
			{
				if(f.isAnnotationPresent(clazz))
				{
					if(f.getType() == String.class || f.getType().isPrimitive())
					{
							f.setAccessible(true);
							String key = f.get(o).toString();
							if(id.equalsIgnoreCase(key))
							{
								//it.remove();
								//break;
								return o;
								
							}
					}
				}
			}
			
			
			List<Method> declaredMethods  = new ArrayList<Method>(Arrays.asList(o.getClass().getDeclaredMethods()));
			declaredMethods.addAll(new ArrayList<Method>(Arrays.asList(o.getClass().getMethods())));
			
			//for(Method f : o.getClass().getDeclaredMethods())
			for(Method f : declaredMethods)
			{
				if(f.isAnnotationPresent(clazz))
				{
					if(f.getReturnType() == String.class || f.getReturnType().isPrimitive())
					{
							f.setAccessible(true);
							String key = f.invoke(o, new Object[]{}).toString();
							
							if(id.equalsIgnoreCase(key))
							{
								//it.remove();
								//break;
								return o;
								
							}
					}
				}
			}
		}
		
		return null;
	}
}
