package me.zohar.lottery.useraccount.param;

import lombok.Data;
import me.zohar.lottery.ValidationGrop;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UserAccountAppRegisterParam {

    /**
     * 用户名
     */
//    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9]$", message = "用户名只能使用字母或数字",
//            groups = ValidationGrop.UserGroup.ADD.USERNAME.PATTERN.class)
    @Length(min = 6, max = 16, message = "非法用户名,用户名长度只能6~16位",
            groups = ValidationGrop.UserGroup.ADD.USERNAME.LENGTH.class)
    @NotBlank(message = "用户名不能为空",
            groups = ValidationGrop.UserGroup.ADD.USERNAME.NOTBLANK.class)
    private String userName;

    /**
     * 登录密码
     */
    @NotBlank(message = "密码不能为空",
            groups = ValidationGrop.UserGroup.ADD.LOGINPWD.NOTBLANK.class)
    @Length(min = 6, max = 16, message = "非法密码,密码长度只能6~16位",
            groups = ValidationGrop.UserGroup.ADD.LOGINPWD.LENGTH.class)
//    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9]$", message = "密码只能使用字母或数字",
//            groups = ValidationGrop.UserGroup.ADD.LOGINPWD.PATTERN.class)
    private String loginPwd;


    /**
     * QQ号
     */
    @NotBlank(message = "QQ号不能为空",
            groups = ValidationGrop.UserGroup.ADD.QQNUMBER.NOTBLANK.class)
    @Length(min = 5, max = 11, message = "非法QQ号码,QQ号长度只能5~11位",
            groups = ValidationGrop.UserGroup.ADD.QQNUMBER.LENGTH.class)
    private String qqNumber;
}
