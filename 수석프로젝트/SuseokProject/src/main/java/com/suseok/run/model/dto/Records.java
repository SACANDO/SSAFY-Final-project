package com.suseok.run.model.dto;

import java.sql.Timestamp;

public class Records {
	private int id;				// 기록 id
	private Timestamp date; 	// 기록 생성일
	private double distance;	// 거리
	private double runTime;		// 달린 시간
	private double pace;		// 페이스
	private int userSeq;		// 기록 소유자
	
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
