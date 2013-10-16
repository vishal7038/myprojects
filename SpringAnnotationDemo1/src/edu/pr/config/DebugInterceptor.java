/**
 * 
 */
package edu.pr.config;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

/**
 * @author Administrator
 *
 */
public class DebugInterceptor implements MethodInterceptor 
{
	static final Logger logger = Logger.getLogger(DebugInterceptor.class);
	
	public Object invoke(MethodInvocation invocation) throws Throwable 
    {
    	logger.debug("DebugInterceptor Invoker["+invocation.hashCode() + "]: " + toString(invocation.getMethod(), invocation.getThis()));
    	
        Object rval = invocation.proceed();

        logger.debug("DebugInterceptor Return["+invocation.hashCode() + "]: " + toReturnString(invocation.getMethod(), rval));
        return rval;
    }
    
    public String toReturnString(Method method, Object rval)
    {
    	StringBuffer sb = new StringBuffer();
    	sb.append(method.getReturnType() + " ");
    	
    	if (rval == null) {
			sb.append("return is null");
		}
		else {
			sb.append("return is of class [").append(rval.getClass().getName()+"@"+rval.hashCode()).append(']');
		}
    	
    	return sb.toString();
    }
    
    public String toString(Method method, Object target) {
		// Don't do toString on target, it may be proxied.
		StringBuilder sb = new StringBuilder();
		sb.append(toString(method)).append("; ");
		if (target == null) {
			sb.append("target is null");
		}
		else {
			sb.append("target is of class [").append(target.getClass().getName()+"@"+target.hashCode()).append(']');
		}
		return sb.toString();
	}
    
    /**
     * Returns a string describing this <code>Method</code>.  The string is
     * formatted as the method access modifiers, if any, followed by
     * the method return type, followed by a space, followed by the
     * class declaring the method, followed by a period, followed by
     * the method name, followed by a parenthesized, comma-separated
     * list of the method's formal parameter types. If the method
     * throws checked exceptions, the parameter list is followed by a
     * space, followed by the word throws followed by a
     * comma-separated list of the thrown exception types.
     * For example:
     * <pre>
     *    public boolean java.lang.Object.equals(java.lang.Object)
     * </pre>
     *
     * <p>The access modifiers are placed in canonical order as
     * specified by "The Java Language Specification".  This is
     * <tt>public</tt>, <tt>protected</tt> or <tt>private</tt> first,
     * and then other modifiers in the following order:
     * <tt>abstract</tt>, <tt>static</tt>, <tt>final</tt>,
     * <tt>synchronized</tt>, <tt>native</tt>.
     */
    
    private static final int LANGUAGE_MODIFIERS = 
    	Modifier.PUBLIC		| Modifier.PROTECTED	| Modifier.PRIVATE | 
    	Modifier.ABSTRACT	| Modifier.STATIC	| Modifier.FINAL   |  
    	Modifier.SYNCHRONIZED	| Modifier.NATIVE;
    
    public String toString(Method method) {
	try {
	    StringBuffer sb = new StringBuffer();
	    int mod = method.getModifiers() & LANGUAGE_MODIFIERS;
	    if (mod != 0) {
		sb.append(Modifier.toString(mod) + " ");
	    }
	    sb.append(method.getReturnType() + " ");  		//sb.append(Field.getTypeName(method.getReturnType()) + " ");
	    sb.append(method.getDeclaringClass() + "."); 	//sb.append(Field.getTypeName(method.getDeclaringClass()) + ".");
	    sb.append(method.getName() + "(");
	    Class[] params = method.getParameterTypes(); // avoid clone
	    for (int j = 0; j < params.length; j++) {
	    sb.append(params[j]); 						  	//sb.append(Field.getTypeName(params[j]));
		if (j < (params.length - 1))
		    sb.append(",");
	    }
	    sb.append(")");
	    Class[] exceptions = method.getExceptionTypes(); // avoid clone
	    if (exceptions.length > 0) {
		sb.append(" throws ");
		for (int k = 0; k < exceptions.length; k++) {
		    sb.append(exceptions[k].getName());
		    if (k < (exceptions.length - 1))
			sb.append(",");
		}
	    }
	    return sb.toString();
	} catch (Exception e) {
	    return "<" + e + ">";
	}
    }
    
    
}
