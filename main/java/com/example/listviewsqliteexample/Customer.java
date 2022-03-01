package com.example.listviewsqliteexample;

public class Customer
{
    String name;
    String userName;
    String password;
    String email;
    String MobileNo;
    String address;
    String Status;


    public Customer()
    {
    }

    public Customer(String name, String userName, String password, String email, String mobileNo, String address, String status)
    {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        MobileNo = mobileNo;
        this.address = address;
        Status = status;

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


}
