package com.test.stockmarket.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.stockmarket.beans.Stocks;
import com.test.stockmarket.beans.Trades;
import com.test.stockmarket.facade.CalculationFacade;
import com.test.stockmarket.services.interfaces.CalculationService;

@Component
public class CalculationFacadeImpl implements CalculationFacade{

	@Autowired
	CalculationService calculationService;
	
	List<Stocks> oListStocks;

	@Override
	public List<Stocks> calculateDividendYieldAndPeRatio(Map<String,Double> oMapInputValues,Map<String,Double> oMapPrices){
		
		oListStocks = new ArrayList<Stocks>();
		oMapInputValues.forEach((k, v) -> oListStocks.add(calculationService.calculateDividendYieldAndPeRatio(k.toString(), Double.parseDouble(v.toString()),oMapPrices)));
  		return oListStocks;
		
	}


	@Override
	public Trades recordTrade(String operationType, Map<String, Double> oMapInputValues,Map<String, Double> oMapPrices) {
		
		Trades trade = new Trades();
		trade = calculationService.recordTrade(operationType,oMapInputValues,oMapPrices);
		 	
		return trade;
		
	}

	@Override
	public Double CalculateVolumeWeighStock(Map<String, Double> oMapInputValues, List<Trades> listTradesRegistration) {
		
		Double volumeWeighIndex = 0.0;
		volumeWeighIndex = calculationService.calculateVolumeWeighStock(oMapInputValues, listTradesRegistration);
		return volumeWeighIndex ;
	
			
	}

	@Override
	public Double CalculateGbceIndex(Map<String, Double> oMapPrice) {
		Double gbceIndex = 0.0;
		gbceIndex = calculationService.calculateGbceIndex(oMapPrice);
		return gbceIndex ;
	}

	
	
}
