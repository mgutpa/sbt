package com.sbt.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sbt.dao.LocationTimeOutDao;
import com.sbt.model.LocationTimeOutVO;
import com.sbt.properties.PortalProperties;
import com.sbt.util.Utility;

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
		
		//using Locale properties
		String[] params = new String[]{"Ikhiloya", "today"};
		mv.addObject("greet",Utility.getLocaleMessage("good.morning.name",params,LocaleContextHolder.getLocale(),messageSource));
		
		logger.debug("Principal Value is : " + principal);
		return mv;
	}
	
	@RequestMapping("/login")
	public String home() {			
		return "signup";
	}
			
	@RequestMapping("/secured/add")
	public String SaveEntity(LocationTimeOutVO locVo) {			
		locTimeDao.save(locVo);
		return "index";
	}	
	
	@RequestMapping(value="/fetchTimeoutDetails",method=RequestMethod.POST,produces={ "application/json", "application/xml" })
	@ResponseBody
	public List<LocationTimeOutVO> fetchLocationTimeOutDetails() {
		List<LocationTimeOutVO> locationDetails = new ArrayList<LocationTimeOutVO>(); 
		locationDetails.add(new LocationTimeOutVO("OYO",14324L, 454L));
		locationDetails.add(new LocationTimeOutVO("OYO-Delhi",14356L, 600L));
		locationDetails.add(new LocationTimeOutVO("OYO-Kolkata",14376L, 500L));
		locationDetails.add(new LocationTimeOutVO("OYO-Jharkhand",14763L, 4800L));

		return locationDetails;
		
	}
	

}
