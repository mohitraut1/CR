package com.CR.model;

public class CoinData {
    private long id;
    private String coinName;
    private double coinValue;
    
    public CoinData() {
		// TODO Auto-generated constructor stub
	}
	public CoinData(long id, String coinName, double coinValue) {
		super();
		this.id = id;
		this.coinName = coinName;
		this.coinValue = coinValue;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public double getCoinValue() {
		return coinValue;
	}
	public void setCoinValue(double coinValue) {
		this.coinValue = coinValue;
	}
	@Override
	public String toString() {
		return "CoinData [id=" + id + ", coinName=" + coinName + ", coinValue=" + coinValue + "]";
	}
    
}