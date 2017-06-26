package com.project.service;

import com.project.po.GreenhouseSensordata;
import com.project.po.GreenhouseUser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Bright_ on 2017/6/24.
 */
@Service
public interface UserService {
    boolean checkUserInfo(String username,String password);
    List<GreenhouseUser> getAllUser();
    void deleteUserById(long id);
    void addUser(GreenhouseUser user);
    HashMap<String ,List<GreenhouseSensordata>> getSensordataByUserId(long id);
    List<String> getGreenhouseIdByUserId(long userid);
}
