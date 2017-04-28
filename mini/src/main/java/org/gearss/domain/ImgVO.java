package org.gearss.domain;

import java.sql.Timestamp;

public class ImgVO {
	
	private int ino;
	private String titleName,content,fileName;
	private Timestamp regdate;
	
	
	
	public int getIno() {
		return ino;
	}
	public int setIno(int ino) {
		return this.ino = ino;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return fileName;
	}
	public void setFilename(String filename) {
		this.fileName = filename;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ImgVO [ino=" + ino + ", titleName=" + titleName + ", content=" + content + ", filename=" + fileName
				+ ", regdate=" + regdate + "]";
	}
	
	

}
