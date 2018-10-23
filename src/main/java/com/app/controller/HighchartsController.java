package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.entity.Demo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package com.app.controller
 * @ClassName HighchartsController
 * @Author wangshaobin
 * @Date 2018/10/22 10:29
 * @Version 1.0
 * @Description:
 **/
@Controller
public class HighchartsController {


    private static List<Demo> demos;

    static {
        //封装数据
        demos = new ArrayList<>();

        Demo demo = new Demo("IT类", 20);
        Demo demo2 = new Demo("运营类", 40);
        Demo demo3 = new Demo("开发类", 50);

        demos.add(demo);
        demos.add(demo2);
        demos.add(demo3);
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/demo";
    }


    @RequestMapping("/demo")
    public String demo(ModelMap modelMap) {

        return "demo";
    }

    @RequestMapping("/showJson")
    @ResponseBody
    public List<Map<String, Object>> showJson() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < demos.size(); i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", demos.get(i).getName());
            map.put("y", demos.get(i).getY());
            list.add(map);
        }
        return list;
    }

}
