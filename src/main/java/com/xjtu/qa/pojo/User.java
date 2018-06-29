package com.xjtu.qa.pojo;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String gender;

    private String birthday;

    private String email;

    private String signature;

    private String creationtime;

    private String address;

    private String authority;
    
    //非数据库
    private String status;

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime == null ? null : creationtime.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }
    
    public String getAnonymousName(){
        if(null==name)
            return null;
 
        if(name.length()<=1)
            return "*";
 
        if(name.length()==2)
            return name.substring(0,1) +"*";
 
        char[] cs =name.toCharArray();
        for (int i = 1; i < cs.length-1; i++) {
            cs[i]='*';
        }
        return new String(cs);
 
    }
}