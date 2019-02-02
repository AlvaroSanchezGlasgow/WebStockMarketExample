package com.test.stockmarket.facade;

import java.util.List;
import java.util.Map;

import com.test.stockmarket.beans.Stocks;
import com.test.stockmarket.beans.Trades;

public interface CalculationFacade {

	Trades recordTrade(String operationType, Map<String, Integer> oMapPrices, Map<String, Double> oMapPrices2);

	Double CalculateVolumeWeighStock(Map<String, Integer> oMapInputValues, List<Trades> listTradesRegistration);

	Double CalculateGbceIndex(Map<String, Double> oMapPrice);

		List<Stocks> calculateDividendYieldAndPeRatio(Map<String, Integer> oMapInputValues,
			Map<String, Double> oMapPrices);

	

	
}
