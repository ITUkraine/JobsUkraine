package ua.com.jobsukraine.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Controller
public class GlobalErrorController {

	private static final String DEFAULT_ERROR_VIEW = "errors/default";

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

	@RequestMapping(value = "/accessDenied")
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView("errors/default");
		mav.addObject("name", response.getStatus());
		mav.addObject("message", "Access denied to " + request.getRequestURL());

		return mav;
	}
	
}
