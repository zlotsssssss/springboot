package wx.th.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import wx.th.springboot.pojo.User;

@Mapper
@Repository
public interface UserMapper {
    User queryUserById(User user);

    int insert(User user);

    int update(User user);

    int delete(int id);
}
