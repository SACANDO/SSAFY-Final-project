package com.suseok.run.model.dto;

public class StravaActivity {
	private long id;
	private String name;
	private double distance;
	private int movingTime;

	public StravaActivity() {
	}

	public StravaActivity(long id, String name, double distance, int movingTime) {
		this.id = id;
		this.name = name;
		this.distance = distance;
		this.movingTime = movingTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getMovingTime() {
		return movingTime;
	}

	public void setMovingTime(int movingTime) {
		this.movingTime = movingTime;
	}

}
