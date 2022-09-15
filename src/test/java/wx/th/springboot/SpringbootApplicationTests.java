package wx.th.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wx.th.springboot.mapper.UserMapper;
import wx.th.springboot.pojo.User;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.queryUserById(4);
        System.out.println(user);
    }

}
