package com.ldq.emu.entity;

public class EmployeeCustom extends Employee {

	private static final long serialVersionUID = 1L;

	private Integer depId;

	private String depName;

	private String depInfo;

	private String creationTime;
	
	private String creatDateStart;
	
	private String creatDateEnd;

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepInfo() {
		return depInfo;
	}

	public void setDepInfo(String depInfo) {
		this.depInfo = depInfo;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreatDateStart() {
		return creatDateStart;
	}

	public void setCreatDateStart(String creatDateStart) {
		this.creatDateStart = creatDateStart;
	}

	public String getCreatDateEnd() {
		return creatDateEnd;
	}

	public void setCreatDateEnd(String creatDateEnd) {
		this.creatDateEnd = creatDateEnd;
	}

	@Override
	public String toString() {
		return "EmployeeCustom [depId=" + depId + ", depName=" + depName + ", depInfo=" + depInfo + ", creationTime="
				+ creationTime + ", creatDateStart=" + creatDateStart + ", creatDateEnd=" + creatDateEnd + "]";
	}
	
	
}
