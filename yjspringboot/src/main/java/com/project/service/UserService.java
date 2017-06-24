package com.project.service;

import com.project.po.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bright_ on 2017/6/24.
 */
@Service
public interface UserService {
    boolean checkUserInfo(String username,String password);
    List<Users> getAllUser();
    void deleteUserById(int id);
    void addUser(Users user);
}
