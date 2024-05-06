package com.suseok.run.model.dto;

public class Group {
	private int id;
	private String groupName;
	private int groupLeader;
	
	public Group() {}
	
	public Group(int id, String groupName, int groupLeader) {
		this.id = id;
		this.groupName = groupName;
		this.groupLeader = groupLeader;
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
}
