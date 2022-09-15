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
        User user1 = new User();
        user1.setPassword("123");
        User user = userMapper.queryUserById(user1);
        System.out.println(user);
    }

}
