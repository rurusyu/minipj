package org.gearss.domain;

import java.sql.Timestamp;

public class ReplyVO {

	private int rno;
	private String writer, content;
	private Timestamp regdate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", writer=" + writer + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
	
	
}
