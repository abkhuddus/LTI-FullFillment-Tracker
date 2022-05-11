package com.lti.model;

public class OpStatusDTO {
	
	
	private Integer open;
	
	private Integer all;
	private Integer closed;
	public Integer getOpen() {
		return open;
	}
	public void setOpen(Integer open) {
		this.open = open;
	}
	public Integer getAll() {
		return all;
	}
	public void setAll(Integer all) {
		this.all = all;
	}
	public Integer getClosed() {
		return closed;
	}
	public void setClosed(Integer closed) {
		this.closed = closed;
	}
	@Override
	public String toString() {
		return "OpStatusDTO [open=" + open + ", all=" + all + ", closed=" + closed + "]";
	}

	
}
