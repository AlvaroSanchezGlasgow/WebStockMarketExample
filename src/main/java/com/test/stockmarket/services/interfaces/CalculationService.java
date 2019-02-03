package com.test.stockmarket.services.interfaces;

import java.util.List;
import java.util.Map;

import com.test.stockmarket.beans.Stocks;
import com.test.stockmarket.beans.Trades;


public interface CalculationService {

	Trades recordTrade(String operationType, Map<String, Double> oMapInputValues, Map<String, Double> oMapPrices);

	
	Double calculateGbceIndex(Map<String, Double> oMapPrice);

	Double calculateVolumeWeighStock(Map<String, Double> oMapInputValues, List<Trades> listTradesRegistration);

	Stocks calculateDividendYieldAndPeRatio(String Product, double d, Map<String, Double> oMapPrices);

	

	
	

	
}
