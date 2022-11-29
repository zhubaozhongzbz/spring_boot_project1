package com.zbz.boot.service;

import com.zbz.boot.bean.Message;
import com.zbz.boot.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageMapper  messageMapper;
    public List<Message> getMessages(String type){
        return messageMapper.getMessages(type);
    }
    public Integer insertMessages(Message message){
       return messageMapper.insertMessages(message);
    }

    public Integer updateMessages(Message message) {
        return messageMapper.updateMessages(message);
    }

    public Integer deleteMessages(Integer id) {
       return  messageMapper.deleteMessages(id);
    }
}
