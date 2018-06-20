package com.xjtu.qa.service;

import java.util.List;


import com.xjtu.qa.pojo.Reply;

public interface ReplyService {

	void add(Reply a);    
    void delete(int id);
    void update(Reply a);
    Reply get(int id);
    
    List<Reply> listReply(int aid);
}
