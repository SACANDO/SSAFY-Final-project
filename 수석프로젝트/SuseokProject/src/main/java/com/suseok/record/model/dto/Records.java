package com.suseok.record.model.dto;

import java.sql.Timestamp;

public class Records {
	private int id;
	private Timestamp date; //timestamp? localdatetime?
	private double distance;
	private double runTime;
	private double pace;
	private int userSeq;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getRunTime() {
		return runTime;
	}
	public void setRunTime(double runTime) {
		this.runTime = runTime;
	}
	public double getPace() {
		return pace;
	}
	public void setPace(double pace) {
		this.pace = pace;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	
	public Records() {}
	public Records(int id, Timestamp date, double distance, double runTime, double pace, int userSeq) {

		this.id = id;
		this.date = date;
		this.distance = distance;
		this.runTime = runTime;
		this.pace = pace;
		this.userSeq = userSeq;
	}
	
	
}
