package com.ldq.emu.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer cusId;

    private String cusName;

    private String cusSex;

    private String cusAddr;

    private String cusTel;

    private String linkman;

    private String cusMail;

    private String creationTime;
    
    private String creatDateStart;
	
	private String creatDateEnd;

    private static final long serialVersionUID = 1L;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getCusSex() {
        return cusSex;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex == null ? null : cusSex.trim();
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr == null ? null : cusAddr.trim();
    }

    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel == null ? null : cusTel.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getCusMail() {
        return cusMail;
    }

    public void setCusMail(String cusMail) {
        this.cusMail = cusMail == null ? null : cusMail.trim();
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime == null ? null : creationTime.trim();
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
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusSex=" + cusSex + ", cusAddr=" + cusAddr
				+ ", cusTel=" + cusTel + ", linkman=" + linkman + ", cusMail=" + cusMail + ", creationTime="
				+ creationTime + ", creatDateStart=" + creatDateStart + ", creatDateEnd=" + creatDateEnd + "]";
	}

	
    
}