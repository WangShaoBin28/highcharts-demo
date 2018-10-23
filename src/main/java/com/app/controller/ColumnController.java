package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package com.app.controller
 * @ClassName ColumnController
 * @Author wangshaobin
 * @Date 2018/10/23 10:15
 * @Version 1.0
 * @Description:
 **/
@Controller
public class ColumnController {

    @RequestMapping("/column")
    public String column() {

        return "column";
    }
}
