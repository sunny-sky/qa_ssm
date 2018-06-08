package com.xjtu.qa.pojo;

public class Category2 {
    private Integer id;

    private String name;

    private Integer c1id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getC1id() {
        return c1id;
    }

    public void setC1id(Integer c1id) {
        this.c1id = c1id;
    }
}