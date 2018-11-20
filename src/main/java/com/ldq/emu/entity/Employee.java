package com.ldq.emu.entity;

import java.io.Serializable;

public class Employee implements Serializable {

	private Integer empId;

	private String empName;

	private String empSex;

	private String empAge;

	private String empTel;

	private String empAddr;

	private String empMail;

	private String filePath;

	private String isDelete;

	private String position;

	private Integer dno;

	private String creationTime;

	private static final long serialVersionUID = 1L;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName == null ? null : empName.trim();
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex == null ? null : empSex.trim();
	}

	public String getEmpAge() {
		return empAge;
	}

	public void setEmpAge(String empAge) {
		this.empAge = empAge == null ? null : empAge.trim();
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel == null ? null : empTel.trim();
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr == null ? null : empAddr.trim();
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail == null ? null : empMail.trim();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}
	
	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSex=" + empSex + ", empAge=" + empAge
				+ ", empTel=" + empTel + ", empAddr=" + empAddr + ", empMail=" + empMail + ", filePath=" + filePath
				+ ", isDelete=" + isDelete + ", position=" + position + ", dno=" + dno + ", creationTime="
				+ creationTime + "]";
	}
	
}