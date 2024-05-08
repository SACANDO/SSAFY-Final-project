package com.suseok.run.model.dto;

public class Group {
	private int id;
	private String groupName;
	private int groupLeader;
	private Double goalPace;
	private Double goalCurrency;
	private Double goalTotalDistance;
	private Double conPace;
	private Double conCurrency;
	private Double conTotalDistance;

	public Group() {
	}

	public Group(int id, String groupName, int groupLeader, Double goalPace, Double goalCurrency,
			Double goalTotalDistance, Double conPace, Double conCurrency, Double conTotalDistance) {
		this.id = id;
		this.groupName = groupName;
		this.groupLeader = groupLeader;
		this.goalPace = goalPace;
		this.goalCurrency = goalCurrency;
		this.goalTotalDistance = goalTotalDistance;
		this.conPace = conPace;
		this.conCurrency = conCurrency;
		this.conTotalDistance = conTotalDistance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupLeader() {
		return groupLeader;
	}

	public void setGroupLeader(int groupLeader) {
		this.groupLeader = groupLeader;
	}

	public Double getGoalPace() {
		return goalPace;
	}

	public void setGoalPace(Double goalPace) {
		this.goalPace = goalPace;
	}

	public Double getGoalCurrency() {
		return goalCurrency;
	}

	public void setGoalCurrency(Double goalCurrency) {
		this.goalCurrency = goalCurrency;
	}

	public Double getGoalTotalDistance() {
		return goalTotalDistance;
	}

	public void setGoalTotalDistance(Double goalTotalDistance) {
		this.goalTotalDistance = goalTotalDistance;
	}

	public Double getConPace() {
		return conPace;
	}

	public void setConPace(Double conPace) {
		this.conPace = conPace;
	}

	public Double getConCurrency() {
		return conCurrency;
	}

	public void setConCurrency(Double conCurrency) {
		this.conCurrency = conCurrency;
	}

	public Double getConTotalDistance() {
		return conTotalDistance;
	}

	public void setConTotalDistance(Double conTotalDistance) {
		this.conTotalDistance = conTotalDistance;
	}

}
