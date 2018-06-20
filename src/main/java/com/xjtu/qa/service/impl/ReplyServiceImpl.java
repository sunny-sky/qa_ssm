package com.xjtu.qa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.ReplyMapper;
import com.xjtu.qa.pojo.Reply;
import com.xjtu.qa.pojo.ReplyExample;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.ReplyService;
import com.xjtu.qa.service.UserService;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyMapper replyMapper;
	@Autowired
	UserService userService;

	@Override
    public void add(Reply r) {
		replyMapper.insert(r);
    }
    
    @Override
    public void delete(int id) {
    	replyMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void update(Reply a) {
    	replyMapper.updateByPrimaryKeySelective(a);
    }
    
    @Override
    public Reply get(int id) {
        return replyMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<Reply> listReply(int aid){
    	ReplyExample example = new ReplyExample();
    	example.createCriteria().andAidEqualTo(aid);
    	example.setOrderByClause("id desc");
    	List<Reply> replys = replyMapper.selectByExample(example);
    	setUser(replys);
    	
    	return replys;
    	
    	
    	
    }

	private void setUser(List<Reply> replys) {
		// TODO Auto-generated method stub
		 for (Reply reply : replys) {
	            setUser(reply);
	        }
	}

	private void setUser(Reply reply) {
		// TODO Auto-generated method stub
		int uid = reply.getUserid();
        User user =userService.get(uid);
        reply.setUser(user);
	}
}
