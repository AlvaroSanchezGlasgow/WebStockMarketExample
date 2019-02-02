package com.test.stockmarket.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.stockmarket.beans.Stocks;

/**
 * Controller used to redirect the http call to the initial index view
 * @author asanchga
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private static final String INDEX = "index";
	private static final String STOCKS_LIST = "stocks";
	
		
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() throws Exception {
		logger.debug("HomeController - ");
		
		List<Stocks> oListStocks = new ArrayList<Stocks>();
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject(STOCKS_LIST, oListStocks);
		return modelAndView;
	}
	
}
