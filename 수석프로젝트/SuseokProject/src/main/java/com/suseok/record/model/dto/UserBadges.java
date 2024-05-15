package com.suseok.record.model.dto;

public class UserBadges {
	private String badgeName;
	private String badgeType;
	private int userSeq;

	public UserBadges() {
	}

	public UserBadges(String badgeName, String badgeType, int userSeq) {
		this.badgeName = badgeName;
		this.badgeType = badgeType;
		this.userSeq = userSeq;
	}

	public String getBadgeName() {
		return badgeName;
	}

	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}

	public String getBadgeType() {
		return badgeType;
	}

	public void setBadgeType(String badgeType) {
		this.badgeType = badgeType;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

}
