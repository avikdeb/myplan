package com.avik.myplan.beans;

public class Plan {
	
	private int idplan;
	private String name;
	private String desc;
	private String organizer;
	private String vendor;
	private String plannedMonth;
	private int createdBy;
	

	public int getIdplan() {
		return idplan;
	}
	
	public void setIdplan(int idplan) {
		this.idplan = idplan;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getOrganizer() {
		return organizer;
	}
	
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public String getPlannedMonth() {
		return plannedMonth;
	}
	
	public void setPlannedMonth(String plannedMonth) {
		this.plannedMonth = plannedMonth;
	}
	
	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

}
