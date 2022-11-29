package com.zbz.boot.controller.message;

import com.alibaba.fastjson.JSON;
import com.zbz.boot.bean.Message;
import com.zbz.boot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MessageController {
    @Autowired
    MessageService  messageService;
    @ResponseBody
    @PostMapping("/insertMessages")
    public Integer insertMessages(@RequestBody Map map){
        Message message=new Message();
        message.setTitle((String) map.get("title"));
        message.setLink((String) map.get("link"));
        message.setType((String) map.get("type"));
      return  messageService.insertMessages(message);
    }

    @ResponseBody
    @GetMapping("/getMessages")
    public List<Message> getMessages(@RequestParam("type")String type){
        return  messageService.getMessages(type);

    }
    @ResponseBody
    @PostMapping("/updateMessages")
    public Integer  updateMessages(@RequestBody Message message){
        return messageService.updateMessages(message);
    }
    @GetMapping("/deleteMessages")
    @ResponseBody
    public Integer deleteMessages(@RequestParam Integer id){
        return messageService.deleteMessages(id);
    }


}
