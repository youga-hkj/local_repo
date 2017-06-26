package com.project.service.impl;

import com.project.mapper.GreenhouseSensordataMapper;
import com.project.mapper.GreenhouseUserGreenhouseMapper;
import com.project.mapper.GreenhouseUserMapper;

import com.project.po.*;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bright_ on 2017/6/24.
 */


public class UserServiceImpl implements UserService {
    @Autowired
    private GreenhouseUserMapper userdao;
    @Autowired
    private GreenhouseUserGreenhouseMapper greenhouseUserGreenhouseDao;
    @Autowired
    private GreenhouseSensordataMapper greenhouseSensordataDao;
    public boolean checkUserInfo(String username, String password) {
        GreenhouseUserExample example = new GreenhouseUserExample();
        example.createCriteria().andLoginnameEqualTo(username).andPasswordEqualTo(password);
        List<GreenhouseUser> userList = userdao.selectByExample(example);
        if(userList.size()>0){
            return true;
        }else{
            return false;
        }
    }

    public List<GreenhouseUser> getAllUser() {
        GreenhouseUserExample example = new GreenhouseUserExample();
        example.createCriteria().andIdIsNotNull();
        return userdao.selectByExample(example);
    }

    public void deleteUserById(long id) {
        userdao.deleteByPrimaryKey(id);
    }

    public void addUser(GreenhouseUser user) {
        userdao.insert(user);
    }

    public HashMap<String,List<GreenhouseSensordata>> getSensordataByUserId(long id) {
        GreenhouseUserGreenhouseExample greenhouseUserGreenhouseExample = new GreenhouseUserGreenhouseExample();
        GreenhouseSensordataExample greenhouseSensordataExample = new GreenhouseSensordataExample();
        HashMap<String,List<GreenhouseSensordata>> result = new HashMap<String, List<GreenhouseSensordata>>();
        List<GreenhouseUserGreenhouseKey> userlist = greenhouseUserGreenhouseDao.selectByExample(greenhouseUserGreenhouseExample);
        for (GreenhouseUserGreenhouseKey userkey:userlist) {

            long greenhouseId = userkey.getGreenhouseid();
            greenhouseSensordataExample.createCriteria().andEquipmentidEqualTo(greenhouseId);
            List<GreenhouseSensordata> userdata = greenhouseSensordataDao.selectByExample(greenhouseSensordataExample);
            result.put(Long.toString(greenhouseId),userdata);
        }
        return result;
    }

    public List<String> getGreenhouseIdByUserId(long userid) {
        List<String> result = new ArrayList<String>();
        GreenhouseUserGreenhouseExample greenhouseUserGreenhouseExample = new GreenhouseUserGreenhouseExample();
        List<GreenhouseUserGreenhouseKey> equpmentList= greenhouseUserGreenhouseDao.selectByExample(greenhouseUserGreenhouseExample);
        for (GreenhouseUserGreenhouseKey equpment : equpmentList) {
           result.add(Long.toString(equpment.getGreenhouseid()));
        }
        return result;
    }
}
