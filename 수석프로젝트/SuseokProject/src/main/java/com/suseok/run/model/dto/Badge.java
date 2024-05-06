package com.suseok.run.model.dto;

import java.util.Date;

public class Badge {
	private String id;
	private String badgeName;
	private String badgeType;
	private Date obtainedAt;

	public String getId() {
		return id;
	}

	public Badge() {
	}

	public Badge(String id, String badgeName, String badgeType, Date obtainedAt) {

		this.id = id;
		this.badgeName = badgeName;
		this.badgeType = badgeType;
		this.obtainedAt = obtainedAt;
	}

	public void setId(String id) {
		this.id = id;
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
