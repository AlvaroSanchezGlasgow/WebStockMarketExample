package com.test.stockmarket.beans;

import java.io.Serializable;

public class Stocks implements Serializable {

	private String stockSymbol = "";
	private String type = "";
	private int quantity = 0;
	private int LastDividend = 0;
	private double fixedDividend = 0.0;
	private int parValue = 0;
	private double dividendYield = 0.0;
	private double peRatio = 0.0;

	/**
	 * super Constructor
	 */
	public Stocks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getters and Setters
	 */
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getParValue() {
		return parValue;
	}
	public void setParValue(int parValue) {
		this.parValue = parValue;
	}
	public int getLastDividend() {
		return LastDividend;
	}

	public void setLastDividend(int lastDividend) {
		LastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public double getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(double dividendYield) {
		this.dividendYield = dividendYield;
	}

	public double getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(double peRatio) {
		this.peRatio = peRatio;
	}

}
