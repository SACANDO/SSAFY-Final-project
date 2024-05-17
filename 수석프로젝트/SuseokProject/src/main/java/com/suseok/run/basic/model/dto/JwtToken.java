package com.suseok.run.basic.model.dto;


public class JwtToken {
	private String userId;
	private String refreshToken;
	
	public JwtToken () {}
	

	public JwtToken(String userId, String refreshToken) {
		this.userId = userId;
		this.refreshToken = refreshToken;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	@Override
	public String toString() {
		return "JwtDto [userId=" + userId + ", refreshToken=" + refreshToken + "]";
	}
	
	
	
	

}
