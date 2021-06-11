package com.realcoderz.web.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String nextHandlingMethod2(SessionStatus status, HttpSession httpsession) {

		status.setComplete();
		httpsession.invalidate();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("failure3");
		return "redirect:/index.jsp";
	}

}
