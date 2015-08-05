package ua.com.jobsukraine.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalErrorController {

	public static final String DEFAULT_ERROR_VIEW = "errors/default";

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());

		return mav;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("name", "404");
		mav.addObject("message", "Page " + request.getRequestURL() + " not found");

		return mav;
	}
}
