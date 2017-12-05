package com.cg.eztrack.web.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.eztrack.web.logger.LoggerManager;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(Exception exe) throws Exception {
		final String methodName = "defaultErrorHandler";
		final String ip = request.getRemoteAddr();

		// AnnotationUtils is a Spring Framework utility class.
		// if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) !=
		// null)
		// throw e;

		// HttpSession session = req.getSession();

		if (session == null) {
			System.out.println("Session is null");
		} else {
			System.out.println("Session is not null");
			/*
			 * String syso1 = (String) session.getAttribute("bass1"); String syso2 =
			 * (String) session.getAttribute("bass2"); String syso3 = (String)
			 * session.getAttribute("bass3");
			 */
			// System.out.println(syso1.concat(" GlobalDefaultExceptionHandler "));
			LoggerManager.writeExceptionLog(ip, GlobalDefaultExceptionHandler.class.getName(), methodName,
					"Caught into Global Exception", exe);
			// System.out.println(syso2.concat(" GlobalDefaultExceptionHandler "));
			// System.out.println(syso3.concat(" GlobalDefaultExceptionHandler "));
		}

		// Otherwise setup and send the user to a default error-view.
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exe);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ExceptionHandler(value = SQLException.class)
	public ModelAndView SQLErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		// AnnotationUtils is a Spring Framework utility class.
		// if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) !=
		// null)
		// throw e;

		// Otherwise setup and send the user to a default error-view.
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
}
