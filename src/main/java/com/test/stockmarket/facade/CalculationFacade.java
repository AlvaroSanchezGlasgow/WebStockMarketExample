package com.test.stockmarket.facade;

import java.util.List;
import java.util.Map;

import com.test.stockmarket.beans.Stocks;
import com.test.stockmarket.beans.Trades;

public interface CalculationFacade {

	Trades recordTrade(String operationType, Map<String, Double> oMapAmmount, Map<String, Double> oMapPrices);

	Double CalculateVolumeWeighStock(Map<String, Double> oMapInputValues, List<Trades> listTradesRegistration);

	Double CalculateGbceIndex(Map<String, Double> oMapPrice);

		List<Stocks> calculateDividendYieldAndPeRatio(Map<String, Double> oMapInputValues,
			Map<String, Double> oMapPrices);

	

	
}
