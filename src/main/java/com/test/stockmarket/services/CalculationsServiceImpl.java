package com.test.stockmarket.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.test.stockmarket.beans.Stocks;
import com.test.stockmarket.beans.Trades;
import com.test.stockmarket.constans.Constans;
import com.test.stockmarket.services.interfaces.CalculationService;

@Service
public class CalculationsServiceImpl implements CalculationService {
	Stocks stock;
	Trades trade;

	@Override
	public Stocks calculateDividendYieldAndPeRatio(String Product, double value, Map<String,Double> oMapPrices) {

		Stocks stock = new Stocks();

		stock.setStockSymbol(Product);

		if (Product.equals("GIN")) {
			try {
				stock.setType("PREFERRED");
				if (oMapPrices.get("GIN") == 0) {
					stock.setDividendYield(0);
				}
				else {
				stock.setDividendYield((double) (Constans.GIN_FIXEDDIV * Constans.GIN_PARVAL) / oMapPrices.get("GIN"));
				}

			} catch (Exception ex) {
				stock.setDividendYield(0);
			}
		}

		if (Product.equals("TEA")) {
			try {
				stock.setType("COMMON");
				if (oMapPrices.get("TEA") == 0) {
					stock.setDividendYield(0);
				}
				else {
				stock.setDividendYield((double) Constans.TEA_LASTDIV / oMapPrices.get("TEA"));
				}
			} catch (Exception ex) {
				stock.setDividendYield(0);
			}
		}

		if (Product.equals("POP")) {
			try {
				stock.setType("COMMON");
				if (oMapPrices.get("POP") == 0) {
					stock.setDividendYield(0);
				}
				else {
				stock.setDividendYield((double) Constans.POP_LASTDIV / oMapPrices.get("POP"));
				}
			} catch (Exception ex) {
				stock.setDividendYield(0);
			}
		}

		if (Product.equals("ALE")) {
			try {
				stock.setType("COMMON");
				if (oMapPrices.get("ALE") == 0) {
					stock.setDividendYield(0);
				}
				else {
				stock.setDividendYield((double) Constans.ALE_LASTDIV % oMapPrices.get("ALE"));
				}
			} catch (Exception ex) {
				stock.setDividendYield(0);
			}
		}

		if (Product.equals("JOE")) {
			try {
				stock.setType("COMMON");
				if (oMapPrices.get("JOE") == 0) {
					stock.setDividendYield(0);
				}
				else {
				stock.setDividendYield((double) Constans.JOE_LASTDIV / oMapPrices.get("JOE"));
				}
			} catch (Exception ex) {
				stock.setDividendYield(0);
			}
		}

		// Calculate PeRatio
		calculatePeRatio(Product, stock,oMapPrices);

		return stock;
	}

	public static Stocks calculatePeRatio(String stockSymbol, Stocks stock,Map<String,Double> oMapPrices) {

		if (stockSymbol.equals("GIN")) {
			if (Constans.GIN_LASTDIV == 0) {
				stock.setPeRatio(0);
			} else {

				stock.setPeRatio((double) oMapPrices.get("GIN") / Constans.GIN_LASTDIV);
			}

		}

		if (stockSymbol.equals("TEA")) {
			if (Constans.TEA_LASTDIV == 0) {
				stock.setPeRatio(0);
			} else {

				stock.setPeRatio((double) oMapPrices.get("TEA") / Constans.TEA_LASTDIV);
			}
		}

		if (stockSymbol.equals("POP")) {
			if (Constans.POP_LASTDIV == 0) {
				stock.setPeRatio(0);
			} else {
				stock.setPeRatio((double) oMapPrices.get("POP") / Constans.POP_LASTDIV);
			}
		}

		if (stockSymbol.equals("ALE")) {
			if (Constans.ALE_LASTDIV == 0) {
				stock.setPeRatio(0);
			} else {
				stock.setPeRatio((double) oMapPrices.get("ALE") / Constans.ALE_LASTDIV);
			}
		}

		if (stockSymbol.equals("JOE")) {
			if (Constans.JOE_LASTDIV == 0) {
				stock.setPeRatio(0);
			} else {
				stock.setPeRatio((double)oMapPrices.get("JOE") / Constans.JOE_LASTDIV);
			}
		}

		return stock;
	}

	@Override
	public Trades recordTrade(String operationType, Map<String, Double> oMapInputValues,Map<String, Double> oMapPrices) {

		trade = new Trades();
		trade.setOperationType(operationType);
		trade.setDateTradeTime(new Date());
		trade.setTradeTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(new Date()));
		trade.setAleCost(oMapInputValues.get("ALE") *oMapPrices.get("ALE"));
		trade.setTeaCost(oMapInputValues.get("TEA") * oMapPrices.get("TEA"));
		trade.setPopCost(oMapInputValues.get("POP") * oMapPrices.get("POP"));
		trade.setGinCost(oMapInputValues.get("GIN") * oMapPrices.get("GIN"));
		trade.setJoeCost(oMapInputValues.get("JOE") * oMapPrices.get("JOE"));
		trade.setTotalTradedPrice(oMapInputValues.get("ALE") * oMapPrices.get("ALE")
				+ oMapInputValues.get("TEA") * oMapPrices.get("TEA") + oMapInputValues.get("POP") * oMapPrices.get("POP")
				+ oMapInputValues.get("GIN") * oMapPrices.get("GIN") + oMapInputValues.get("JOE") * oMapPrices.get("JOE"));
		// logic
		return trade;
	}

	@Override
	public Double calculateGbceIndex(Map<String, Double> oMapPrice) {

		double multip = 1;

		for (Entry<String, Double> entry : oMapPrice.entrySet()) {
			if (entry.getValue() > 0) {
				
				multip = multip * entry.getValue();
			} else {
				multip = multip * 1;
			}
		}

		double result = (double) Math.pow(oMapPrice.size(), 1 / multip);

		return result;
	}

	public Double calculateVolumeWeighStock(Map<String, Double> oMapInputValues, List<Trades> listTradesRegistration) {

		double aux = 0.0;
		
		int diferen=0;
		double ammount=(oMapInputValues.get("ALE") + oMapInputValues.get("GIN") + oMapInputValues.get("POP")
		+ oMapInputValues.get("TEA") + oMapInputValues.get("JOE"));
		if (ammount==0) {
			ammount=1;
		}
		
		for (Trades p : listTradesRegistration) {
			
			diferen=(int)Math.floor(((new Date().getTime()-p.getDateTradeTime().getTime())/1000)/60);
			 
			if (diferen < 15) {

				
				aux = aux + ((p.getAleCost() * oMapInputValues.get("ALE"))
						+ (p.getGinCost() * oMapInputValues.get("GIN")) + (p.getPopCost() * oMapInputValues.get("POP"))
						+ (p.getTeaCost() * oMapInputValues.get("TEA")) + (p.getJoeCost() * oMapInputValues.get("JOE")))
						/ ammount;
			}

		}
		return aux;
	}
}
