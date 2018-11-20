package com.ldq.emu.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String loginName;

    private String loginPasswd;

    private String userSex;

    private String userTel;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPasswd() {
        return loginPasswd;
    }

    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd == null ? null : loginPasswd.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", loginName=" + loginName + ", loginPasswd="
				+ loginPasswd + ", userSex=" + userSex + ", userTel=" + userTel + "]";
	}
    
}