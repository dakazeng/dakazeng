package com.ldq.emu.entity;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer depId;

    private String depName;

    private String depInfo;

    private String creationTime;
    
	private static final long serialVersionUID = 1L;

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
        this.depName = depName == null ? null : depName.trim();
    }

    public String getDepInfo() {
        return depInfo;
    }

    public void setDepInfo(String depInfo) {
        this.depInfo = depInfo == null ? null : depInfo.trim();
    }

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", depInfo=" + depInfo + ", creationTime="
				+ creationTime + "]";
	}
    
    
}