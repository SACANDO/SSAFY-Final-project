package com.suseok.record.model.dto;

public class UserRecord {
	private int userSeq;
	private double currency;
	private double totalDistance;
	private double highestSpeed;
	
	public UserRecord() {}
	
	public UserRecord(int userSeq, double currency, double totalDistance, double highestSpeed) {
		this.userSeq = userSeq;
		this.currency = currency;
		this.totalDistance = totalDistance;
		this.highestSpeed = highestSpeed;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	public double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public double getHighestSpeed() {
		return highestSpeed;
	}

	public void setHighestSpeed(double highestSpeed) {
		this.highestSpeed = highestSpeed;
	}
	
	
}
