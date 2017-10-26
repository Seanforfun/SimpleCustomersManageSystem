package com.sean.vo;

import java.util.List;

public class PageBean {
	private int pageNum;
	private int numPerPage;
	private int totalPage;
	private List<Customers> cs;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Customers> getCs() {
		return cs;
	}
	public void setCs(List<Customers> cs) {
		this.cs = cs;
	}
}
