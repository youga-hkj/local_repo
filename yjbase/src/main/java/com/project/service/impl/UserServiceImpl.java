package com.project.service.impl;

import com.project.mapper.UserMapper;
import com.project.po.User;
import com.project.po.UserExample;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Bright_ on 2017/6/7.
 */
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    /**
     * check user infomation
     * @param username
     * @param password
     * @return
     */
    public boolean checkUserInfo(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExample(example);
        if(result.size()>0){
            return true;
        }else{
            return false;
        }
    }
}
