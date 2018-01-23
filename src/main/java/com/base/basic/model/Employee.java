package com.base.basic.model;

import java.util.Date;

public class Employee {
    private Long id;

    private String name;

    private Integer sex;

    private Date createdTime;

    public Employee(Long id, String name, Integer sex, Date createdTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.createdTime = createdTime;
    }

    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}