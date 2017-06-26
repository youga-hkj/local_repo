package com.project.controller;

import com.project.po.GreenhouseSensordata;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Bright_ on 2017/6/26.
 */
@Controller
@RequestMapping(value = "/resp")
public class DataController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/data")
    public @ResponseBody HashMap<String,List<GreenhouseSensordata>> userData(@RequestParam(value = "id")long userid){
        HashMap<String,List<GreenhouseSensordata>> result = userService.getSensordataByUserId(userid);
        return result;
    }

}
