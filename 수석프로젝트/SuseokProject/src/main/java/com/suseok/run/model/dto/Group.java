package com.suseok.run.model.dto;

public class Group {
	private int groupId;
	private String groupName;
	private int groupLeader;
	private Double goalPace;
	private Double goalFrequency;
	private Double goalTotalDistance;
	private Double conPace;
	private Double conFrequency;
	private Double conTotalDistance;

	public Group() {
	}

	public Group(int groupId, String groupName, int groupLeader, Double goalPace, Double goalFrequency,
			Double goalTotalDistance, Double conPace, Double conFrequency, Double conTotalDistance) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupLeader = groupLeader;
		this.goalPace = goalPace;
		this.goalFrequency = goalFrequency;
		this.goalTotalDistance = goalTotalDistance;
		this.conPace = conPace;
		this.conFrequency = conFrequency;
		this.conTotalDistance = conTotalDistance;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
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

	public Double getGoalFrequency() {
		return goalFrequency;
	}

	public void setGoalFrequency(Double goalFrequency) {
		this.goalFrequency = goalFrequency;
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

	public Double getConFrequency() {
		return conFrequency;
	}

	public void setConFrequency(Double conFrequency) {
		this.conFrequency = conFrequency;
	}

	public Double getConTotalDistance() {
		return conTotalDistance;
	}

	public void setConTotalDistance(Double conTotalDistance) {
		this.conTotalDistance = conTotalDistance;
	}

	

}
