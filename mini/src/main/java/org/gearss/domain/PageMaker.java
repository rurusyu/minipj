package org.gearss.domain;

public class PageMaker {

	private int start, end, total, current, size;
	private boolean prev, next;
	private Criteria cri;
	
	
	public PageMaker(Criteria cri, int total){
		this.cri = cri;
		this.total = total;
		this.current = cri.getPage();
		this.size = cri.getSize();
		calcPage();
		
	}


	private void calcPage() {
		int tempEnd = (int)(Math.ceil(current/10.0)*10);
		start = tempEnd -9 ;
		end = (tempEnd*size) > total ? (int)(total/(double)size) : tempEnd;
		
		prev = start ==1?false:true;
		next = total >end*size ? true:false;
		
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getCurrent() {
		return current;
	}


	public void setCurrent(int current) {
		this.current = current;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public Criteria getCri() {
		return cri;
	}


	public void setCri(Criteria cri) {
		this.cri = cri;
	}


	@Override
	public String toString() {
		return "PageMaker [start=" + start + ", end=" + end + ", total=" + total + ", current=" + current + ", size="
				+ size + ", prev=" + prev + ", next=" + next + ", cri=" + cri + "]";
	}
	
	
}
