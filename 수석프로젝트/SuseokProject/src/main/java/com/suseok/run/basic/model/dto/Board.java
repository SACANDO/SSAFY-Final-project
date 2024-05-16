package com.suseok.run.basic.model.dto;

import java.sql.Timestamp;

public class Board {

	private int groupId;
	private int boardId;
	private int writerSeq;
	private String title;
	private String content;
	private String img;
	private Timestamp createdAt;
	private boolean notice;

	public Board() {
	}

	public Board(int groupId, int boardId, int writerSeq, String title, String content, String img, Timestamp createdAt,
			boolean notice) {
		this.groupId = groupId;
		this.boardId = boardId;
		this.writerSeq = writerSeq;
		this.title = title;
		this.content = content;
		this.img = img;
		this.createdAt = createdAt;
		this.notice = notice;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getWriterSeq() {
		return writerSeq;
	}

	public void setWriterSeq(int writerSeq) {
		this.writerSeq = writerSeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isNotice() {
		return notice;
	}

	public void setNotice(boolean notice) {
		this.notice = notice;
	}

}
