package com.zbz.boot.controller.annout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test1 {

    final  private  String view="vue/html/view";
    @RequestMapping("view")//url   http://localhost:8080/view
    public String say(){
        return view;
    }
    @RequestMapping("/data")
    public ModelAndView sa1(){
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("view","hello!");
        return modelAndView;
    }






}
