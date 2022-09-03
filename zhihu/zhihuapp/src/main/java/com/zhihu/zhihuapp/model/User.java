package com.zhihu.zhihuapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "昵称不能为空")
    @Length(max = 12,message = "昵称最大长度12")
    private String user_name;

    @NotEmpty(message = "密码不能为空")
    @Length(max = 30,message = "昵称最大长度30")
    private String email;

    @NotEmpty(message = "密码不能为空")
    @Length(max = 20,message = "密码最大长度20")
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
