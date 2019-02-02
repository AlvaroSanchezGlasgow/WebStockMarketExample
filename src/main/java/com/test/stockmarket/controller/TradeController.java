package com.test.stockmarket.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.stockmarket.beans.Stocks;
import com.test.stockmarket.beans.Trades;
import com.test.stockmarket.constans.Constans;
import com.test.stockmarket.facade.CalculationFacade;
import com.test.stockmarket.services.interfaces.CalculationService;
import com.test.stockmarket.utils.Utils;

/**
 * Controller used to redirect the http call to the initial index view
 * @author asanchga
 *
 */
@Controller
public class TradeController {

	List<Trades> listTradesRegistration = new ArrayList<Trades>();
	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

	private static final String INDEX = "index";
	private static final String STOCKS_LIST = "stocks";
	
	@Autowired
	private CalculationFacade calculationFacade;
			
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value = "/createTrade", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String newTrade(@RequestParam(value="TeaAmmount") String sTeaAmmount, @RequestParam(value="PopAmmount") String sPopAmmount, 
			@RequestParam(value="AleAmmount") String sAleAmmount, @RequestParam(value="GinAmmount") String sGinAmmount,
			@RequestParam(value="JoeAmmount") String sJoeAmmount, @RequestParam(value="operationType") String operationType,
			@RequestParam(value="JoePrice") String sJoePrice,@RequestParam(value="PopPrice") String sPopPrice,@RequestParam(value="AlePrice") String sAlePrice,
			@RequestParam(value="GinPrice") String sGinPrice,@RequestParam(value="TeaPrice") String sTeaPrice) throws Exception {
		
		int teaAmmount=Utils.convertStringToNumber(sTeaAmmount);
		int popAmmount=Utils.convertStringToNumber(sPopAmmount);
		int aleAmmount=Utils.convertStringToNumber(sAleAmmount);
		int ginAmmount=Utils.convertStringToNumber(sGinAmmount);
		int joeAmmount=Utils.convertStringToNumber(sJoeAmmount);
		
		double TeaPrice=Utils.convertStringToDouble(sTeaPrice);
		double popPrice=Utils.convertStringToDouble(sPopPrice);
		double alePrice=Utils.convertStringToDouble(sAlePrice);
		double ginPrice=Utils.convertStringToDouble(sGinPrice);
		double joePrice=Utils.convertStringToDouble(sJoePrice);
		
		Map<String,Integer> oMapInputValues = new HashMap<String,Integer>();
		oMapInputValues.put("TEA", teaAmmount);
		oMapInputValues.put("POP", popAmmount);
		oMapInputValues.put("ALE", aleAmmount);
		oMapInputValues.put("GIN", ginAmmount);
		oMapInputValues.put("JOE", joeAmmount);
		
		
		
		Map<String,Double> oMapPrices = new HashMap<String,Double>();
		oMapPrices.put("TEA", TeaPrice);
		oMapPrices.put("POP", popPrice);
		oMapPrices.put("ALE", alePrice);
		oMapPrices.put("GIN", ginPrice);
		oMapPrices.put("JOE", joePrice);
		
		
		String sJSONResponse = "";
		List<Stocks> oListStocks = new ArrayList<Stocks>();
		Map<String, Object> oMapResult = new HashMap<String, Object>();
		
		Trades trade = new Trades();
		
		Double volumeWeighStockPrice = 0.0;
		Double gbceIndex = 0.0;
		
		//Dividend Yield and PE Ratio Calculation
		try {
		oListStocks = calculationFacade.calculateDividendYieldAndPeRatio(oMapInputValues,oMapPrices);
		}catch(Exception error) {
			logger.error("Error: "+error.getMessage());
			throw new Exception("Error Calculating Dividend Yield and PeRatio: "+error.getMessage());
		}
		
		
		//Record Trade
				try {
					trade = calculationFacade.recordTrade(operationType,oMapInputValues,oMapPrices);
					listTradesRegistration.add(trade);
					}catch(Exception error) {
						logger.error("Error: "+error.getMessage());
						throw new Exception("Error Recording the Trade: "+error.getMessage());
					}
				
				//Calculate Volume Weighted Stock Price based on trades in past 15 minutes
				try {
					volumeWeighStockPrice = calculationFacade.CalculateVolumeWeighStock(oMapInputValues,listTradesRegistration);
					
					}catch(Exception error) {
						logger.error("Error: "+error.getMessage());
						throw new Exception("Error Calculating Volume Weighted Stock Price: "+error.getMessage());
					}
				
				//Calculate the GBCE All Share Index
				
				try {
					gbceIndex = calculationFacade.CalculateGbceIndex(oMapPrices);
				
					}catch(Exception error) {
						logger.error("Error: "+error.getMessage());
						throw new Exception("Error Calculating Volume Weighted Stock Price: "+error.getMessage());
					}
		
				oMapResult.put("stocksList",oListStocks);
				oMapResult.put("trade",trade);
				oMapResult.put("volumeWeighStockPrice",String.format("%.4f", volumeWeighStockPrice));
				oMapResult.put("gbceIndex",String.format("%.4f", gbceIndex));
				
		ObjectMapper mapper = new ObjectMapper();
		sJSONResponse= mapper.writeValueAsString(oMapResult);
		
		System.out.println("JSONResponse-->"+sJSONResponse);
		return sJSONResponse;
	}
	
}
