package com.ldq.emu.entity;

import java.io.Serializable;

public class Orders implements Serializable {
    private Integer orderId;

    private String orderName;

    private String orderNumber;

    private String endEditTime;

    private String orderPrice;

    private String orderInfo;

    private String payMethod;

    private String company;

    private String isPay;

    private String payTime;

    private String creationTime;

    private Integer cno;

    private Integer eno;

    private Integer dno;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getEndEditTime() {
        return endEditTime;
    }

    public void setEndEditTime(String endEditTime) {
        this.endEditTime = endEditTime == null ? null : endEditTime.trim();
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice == null ? null : orderPrice.trim();
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo == null ? null : orderInfo.trim();
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay == null ? null : isPay.trim();
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime == null ? null : creationTime.trim();
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderName=" + orderName + ", orderNumber=" + orderNumber
				+ ", endEditTime=" + endEditTime + ", orderPrice=" + orderPrice + ", orderInfo=" + orderInfo
				+ ", payMethod=" + payMethod + ", company=" + company + ", isPay=" + isPay + ", payTime=" + payTime
				+ ", creationTime=" + creationTime + ", cno=" + cno + ", eno=" + eno + ", dno=" + dno + "]";
	}
    
}