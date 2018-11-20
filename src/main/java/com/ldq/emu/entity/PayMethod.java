package com.ldq.emu.entity;

import java.io.Serializable;

public class PayMethod implements Serializable {
    private Integer id;

    private String payMethod;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }
}