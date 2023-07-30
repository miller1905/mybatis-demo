package com.example.mybatis.model;

import java.util.Objects;

/**
 * @author Yazha
 */
public class SysUser {

    private String username;
    private String password;
    private String fullName;
    private String address;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysUser sysUser = (SysUser) o;
        return age == sysUser.age && Objects.equals(username, sysUser.username) && Objects.equals(password, sysUser.password) && Objects.equals(fullName, sysUser.fullName) && Objects.equals(address, sysUser.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, fullName, address, age);
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
