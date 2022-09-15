package wx.th.springboot.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String avatarPath;
    private Integer money;
    private String name;
    private String password;
    private String phone;

}
