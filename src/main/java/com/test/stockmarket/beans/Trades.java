package com.test.stockmarket.beans;

import java.io.Serializable;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Trades implements Serializable {

	Date dateTradeTime;
	public Date getDateTradeTime() {
		return dateTradeTime;
	}

	public void setDateTradeTime(Date dateTradeTime) {
		this.dateTradeTime = dateTradeTime;
	}

	String tradeTime = "";
	String operationType = "";

	double teaCost = 0;
	double popCost = 0;
	double aleCost = 0;
	double ginCost = 0;
	double joeCost = 0;

	double totalTradedPrice = 0;

	/**
	 * super Constructor
	 */
	public Trades() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters and Setters
	 */

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public double getTeaCost() {
		return teaCost;
	}

	public void setTeaCost(double d) {
		this.teaCost = d;
	}

	public double getPopCost() {
		return popCost;
	}

	public void setPopCost(double d) {
		this.popCost = d;
	}

	public double getAleCost() {
		return aleCost;
	}

	public void setAleCost(double d) {
		this.aleCost = d;
	}

	public double getGinCost() {
		return ginCost;
	}

	public void setGinCost(double d) {
		this.ginCost = d;
	}

	public double getJoeCost() {
		return joeCost;
	}

	public void setJoeCost(double d) {
		this.joeCost = d;
	}

	public double getTotalTradedPrice() {
		return totalTradedPrice;
	}

	public void setTotalTradedPrice(double d) {
		this.totalTradedPrice = d;
	}

}
