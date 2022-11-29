package com.zbz.boot.controller;

import com.zbz.boot.bean.User;
import com.zbz.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {
//    @GetMapping(value ={ "/","/login"})
//    public  String  login(){
//        return  "/login";
//    }
    @ResponseBody
    @PostMapping(value ={ "/","/login"})
    public String main(@RequestBody HashMap<String,String> map, HttpSession session, Model model) {
        //RedirectAttributes

       //if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassWord())) {
            //把登陆成功的用户保存起来
        String name=map.get("name");
        String passWord=map.get("passWord");
        if(StringUtils.hasLength(name)&&StringUtils.hasLength(passWord)){
           User  user= userService.getByName(name);
            if(user!=null&&user.getPassWord().equals(passWord)){
                session.setAttribute("loginUser", user);
                return "success";
            }
            model.addAttribute("msg", "账号密码错误");
            return "faile";
            //登录成功重定向到main.html;  重定向防止表单重复提交
            //return "redirect:/main.html";

        } else {
            model.addAttribute("msg", "请输入账号密码");
            //回到登录页面
           // return "login";
            return "error";
        }

    }
    @GetMapping("/main.html")
    public  String   mainPage(HttpSession session, Model model){
//        if(session.getAttribute("loginUser")!=null){
//            return "main";
//        }
//        model.addAttribute("msg","请重新登录");
//        return "login";
        return "main";
    }
    @Autowired
    UserService  userService;

    @ResponseBody
    @GetMapping("/getUser")
    public  User  getUser(@RequestParam("id") Integer id){
        return userService.getUser(id);
    }

}
