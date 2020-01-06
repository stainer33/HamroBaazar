package com.e.hamrobaazar.models;

public class User {
    private String email;
    private String fullName;
    private String password;
    private String mobileNo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String email, String fullName, String password, String mobileNo, String address) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    private String address;
}
