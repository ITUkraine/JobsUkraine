package ua.com.jobsukraine.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import ua.com.jobsukraine.exceptions.CustomMessageException;

@ControllerAdvice
@Controller
public class GlobalErrorController {

	private static final String DEFAULT_ERROR_VIEW = "errors/default";
	private static final Logger LOGGER = Logger.getLogger(GlobalErrorController.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {
		LOGGER.error(e);
		ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);
		modelAndView.addObject("name", e.getClass().getSimpleName());
		modelAndView.addObject("message", e.getMessage());

		return modelAndView;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		LOGGER.error("Throw if such page or mapping doesnt't exist", e);
		ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);
		modelAndView.addObject("name", "404");
		modelAndView.addObject("message", "Page " + request.getRequestURL() + " not found");

		return modelAndView;
	}

	@RequestMapping(value = "/accessDenied")
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOGGER.error("Throw if you try access denied page", e);
		ModelAndView modelAndView = new ModelAndView("errors/default");
		modelAndView.addObject("name", response.getStatus());
		modelAndView.addObject("message",
				"Access denied to " + request.getAttribute("javax.servlet.forward.request_uri"));

		return modelAndView;
	}

	@ExceptionHandler(CustomMessageException.class)
	public ModelAndView handleCustomException(Exception e) {
		LOGGER.error("Throw if vacancy doesn't exist", e);
		ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);
		modelAndView.addObject("message", e.getMessage());
		return modelAndView;
	}

}
