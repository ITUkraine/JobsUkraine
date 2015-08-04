package ua.com.jobsukraine.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalErrorController {

	public static final String DEFAULT_ERROR_VIEW = "errors/default";

	@ExceptionHandler(Throwable.class)
	public ModelAndView exception(Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());

		return mav;
	}

}
