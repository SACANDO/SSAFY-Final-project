package com.suseok.record.model.dto;

public class UserRecord {
	private int userSeq;			// 유저 id
	private double frequency;		// 빈도
	private double totalDistance;	// 유저가 달린 누적 거리
	private double highestSpeed;	// 최고 속력
	
	public UserRecord() {}
	
	public UserRecord(int userSeq, double frequency, double totalDistance, double highestSpeed) {
		this.userSeq = userSeq;
		this.frequency = frequency;
		this.totalDistance = totalDistance;
		this.highestSpeed = highestSpeed;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
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
