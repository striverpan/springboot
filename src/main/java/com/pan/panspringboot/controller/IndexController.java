package com.pan.panspringboot.controller;


import com.pan.panspringboot.common.aspect.SystemControllerLog;
import com.pan.panspringboot.common.result.ResultBean;
import com.pan.panspringboot.common.result.ResultUtil;
import com.pan.panspringboot.domain.DiUser;
import com.pan.panspringboot.service.UserService;
import com.pan.panspringboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private UserService userService;

    @SystemControllerLog(description="首页测试")
    @RequestMapping(value = "/test")
    public ResultBean test() {

        DiUser diUser = new DiUser();
        diUser.setName("pan");
        diUser.setPassword("password");
        userService.add(diUser);

        return ResultUtil.success();
    }


}
