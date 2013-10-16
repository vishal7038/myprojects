package edu.pr.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * Shared WebBindingInitializer for webapp custom editors.
 *
 * <p>Alternatively, such init-binder code may be put into
 * {@link org.springframework.web.bind.annotation.InitBinder}
 * annotated methods on the controller classes themselves.
 *
 * 
 */

public class CustomWebBindingInitializer implements WebBindingInitializer 
{

	public void initBinder(WebDataBinder binder, WebRequest request) 
	{
		System.out.println("CustomWebBindingInitializer:: initBinder() called");
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		binder.registerCustomEditor(PetType.class, new PetTypeEditor(this.clinic));*/
	}

}
