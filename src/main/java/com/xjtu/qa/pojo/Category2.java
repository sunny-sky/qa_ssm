package com.xjtu.qa.pojo;

public class Category2 {
    private int id;

    private String name;

    private int c1id;
    
    private Category category;

    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public int getC1id() {
        return c1id;
    }

    public void setC1id(Integer c1id) {
        this.c1id = c1id;
    }
}