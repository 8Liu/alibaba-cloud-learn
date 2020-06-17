package com.liudehuang.boot.druid.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.alibaba.fastjson.JSONObject;
import com.liudehuang.boot.druid.entity.SysUser;
import com.liudehuang.boot.druid.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DruidController {
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/druidStat")
    public String druidStat(){
        List<Map<String, Object>> mapList = DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        String json = JSONObject.toJSONString(mapList);
        return json;
    }

    @GetMapping("/getUser")
    public SysUser getUser(@RequestParam("id") Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}
