package com.tkrs.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {

    /**
    * File->setting->Inspections->Serializationissues，
    * 展开后将serialzable class without "serialVersionUID"打上勾
    * 在实体类上按alt+enter即可生成序列化Id
    * */
    private static final long serialVersionUID = 1905245300659413552L;

    private Integer userid;

    private String username;

    private String password;

    private Integer age;

    private Integer sex;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private Integer deleteFlag;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}