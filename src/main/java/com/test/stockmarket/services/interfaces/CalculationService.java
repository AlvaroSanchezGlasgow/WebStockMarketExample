package com.test.stockmarket.services.interfaces;

import java.util.List;
import java.util.Map;

import com.test.stockmarket.beans.Stocks;
import com.test.stockmarket.beans.Trades;


public interface CalculationService {

	Trades recordTrade(String operationType, Map<String, Integer> oMapInputValues, Map<String, Double> oMapPrices);

	
	Double calculateGbceIndex(Map<String, Double> oMapPrice);

	Double calculateVolumeWeighStock(Map<String, Integer> oMapInputValues, List<Trades> listTradesRegistration);

	Stocks calculateDividendYieldAndPeRatio(String Product, int value, Map<String, Double> oMapPrices);

	

	
	

	
}
