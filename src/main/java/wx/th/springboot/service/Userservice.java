package wx.th.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wx.th.springboot.mapper.UserMapper;

@Service
public class Userservice {
    @Autowired
    UserMapper UserMapper;


}
