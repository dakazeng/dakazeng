package com.ldq.emu.entity;

public class OrdersCustom extends Orders {

	private static final long serialVersionUID = 1L;

	private Integer empId;
	private String empName;
	private Integer cusId;
	private String cusName;
	private String depName;
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
		this.empName = empName;
	}
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
		this.cusName = cusName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "OrdersCustom [empId=" + empId + ", empName=" + empName + ", cusId=" + cusId + ", cusName=" + cusName
				+ ", depName=" + depName + "]";
	}
	
}
