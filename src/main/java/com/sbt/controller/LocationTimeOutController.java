package com.sbt.controller;

import java.security.Principal;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sbt.dao.LocationTimeOutDao;
import com.sbt.model.LocationTimeOutVO;
import com.sbt.properties.PortalProperties;

@Controller
public class LocationTimeOutController {
	
	Logger logger = LogManager.getLogger(LocationTimeOutController.class);
	
	@Autowired
	PortalProperties prop;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	LocationTimeOutDao locTimeDao;
	
	@RequestMapping("/secured/location")
	public ModelAndView getLocation(Principal principal) {
		logger.debug("Inside getLocation location");
		ModelAndView mv = new ModelAndView("location");
		mv.addObject("principal",principal);
		
		//using externalize properties
		mv.addObject("version",prop.getVersion());
		
		//using Lacale properties
		String[] params = new String[]{"Ikhiloya", "today"};
		mv.addObject("greet",getLocaleMessage(params));
		
		logger.debug("Principal Value is : " + principal);
		return mv;
	}

	private String getLocaleMessage(String[] params) {
		String message="";
		try {
			 message = messageSource.getMessage("good.morning.name",params,LocaleContextHolder.getLocale());
		} catch (NoSuchMessageException e) {
			message = messageSource.getMessage("good.morning.name",params,Locale.US);
		}
		
		return message;
	}
	
	@RequestMapping("/home")
	public String home() {			
		return "index";
	}
			
	@RequestMapping("/secured/add")
	public String SaveEntity(LocationTimeOutVO locVo) {			
		locTimeDao.save(locVo);
		return "index";
	}

}
