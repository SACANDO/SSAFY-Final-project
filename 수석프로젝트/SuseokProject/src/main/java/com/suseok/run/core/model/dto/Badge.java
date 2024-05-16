package com.suseok.run.core.model.dto;

import java.util.Date;

public class Badge {
	private String badgeName;
	private String badgeType;
	private Date obtainedAt;

	public Badge() {
	}

	public Badge(String badgeName, String badgeType, Date obtainedAt) {
		this.badgeName = badgeName;
		this.badgeType = badgeType;
		this.obtainedAt = obtainedAt;
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

	public Date getObtainedAt() {
		return obtainedAt;
	}

	public void setObtainedAt(Date obtainedAt) {
		this.obtainedAt = obtainedAt;
	}

}
