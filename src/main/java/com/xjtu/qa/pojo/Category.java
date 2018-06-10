package com.xjtu.qa.pojo;

import java.util.List;

public class Category {
    private Integer id;

    private String name;
    
    List<Category2> category2s;
    
    List<List<Category2>> category2sByRow;   
    
    public List<Category2> getCategory2s() {
		return category2s;
	}

	public void setCategory2s(List<Category2> category2s) {
		this.category2s = category2s;
	}




	public List<List<Category2>> getCategory2sByRow() {
		return category2sByRow;
	}

	public void setCategory2sByRow(List<List<Category2>> category2sByRow) {
		this.category2sByRow = category2sByRow;
	}

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
}