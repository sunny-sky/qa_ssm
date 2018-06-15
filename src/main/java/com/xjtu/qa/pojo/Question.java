package com.xjtu.qa.pojo;

import java.util.List;

public class Question {
    private Integer id;

    private String content;

    private String creationtime;

    private Integer userid;

    private Integer c1id;

    private Integer c2id;
    
    private Category category;
    
    private int answerNum;
    
    private int cltProblemNum;

    public int getCltProblemNum() {
		return cltProblemNum;
	}
    
    List<Answer> answers;

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setCltProblemNum(int cltProblemNum) {
		this.cltProblemNum = cltProblemNum;
	}

	public int getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime == null ? null : creationtime.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getC1id() {
        return c1id;
    }

    public void setC1id(Integer c1id) {
        this.c1id = c1id;
    }

    public Integer getC2id() {
        return c2id;
    }

    public void setC2id(Integer c2id) {
        this.c2id = c2id;
    }


}