package com.project.service.impl;

import com.project.mapper.UsersMapper;
import com.project.po.Users;
import com.project.po.UsersExample;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bright_ on 2017/6/24.
 */


public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper userdao;

    public boolean checkUserInfo(String username, String password) {
        UsersExample example = new UsersExample();
        example.createCriteria().andNameEqualTo(username).andPasswordEqualTo(password);
        List<Users> list = userdao.selectByExample(example);
        if (list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    public List<Users> getAllUser() {
        UsersExample example = new UsersExample();
        example.createCriteria().andIdIsNotNull();
        return userdao.selectByExample(example);
    }

    public void deleteUserById(int id) {
        userdao.deleteByPrimaryKey(id);
    }

    public void addUser(Users user) {
     userdao.insert(user);
    }
}
