package com.suseok.run.model.dto;

public class Condition {
	
	// domain : 그룹 / 유저
	// 그룹 : 그룸 네임 필드 필요
	// 유저 : 내 라이벌인지 일반 유저인지 필요
	
	// orderBy는 랭킹매길때 사용 (domain은 유저인지 그룹인지)
	private String domain;
	private String key;
	private String word;
	private String orderBy;

	public Condition() {
	}

	public Condition(String domain, String key, String word) {
		this.domain = domain;
		this.key = key;
		this.word = word;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
