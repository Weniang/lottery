package me.zohar.lottery.useraccount.param;

import lombok.Data;
import me.zohar.lottery.ValidationGrop;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 基本信息编辑参数
 */
@Data
public class UserAccountBasicInfoEditParam {

    /**
     * 主键id
     */
    @NotBlank
    private String userAccountId;

    /**
     * QQ号
     */
    @NotBlank(message = "QQ号不能为空",
            groups = ValidationGrop.UserGroup.UPDATE.QQNUMBER.NOTBLANK.class)
    @Length(min = 5, max = 11, message = "非法QQ号码,QQ号长度只能5~11位",
            groups = ValidationGrop.UserGroup.UPDATE.QQNUMBER.LENGTH.class)
    private String qqNumber;

    /**
     * 昵称
     */
    @Length(min = 6, max = 16, message = "非法昵称,用户名长度只能6~16位",
            groups = ValidationGrop.UserGroup.UPDATE.NICKNAME.LENGTH.class)
    @NotBlank(message = "昵称不能为空",
            groups = ValidationGrop.UserGroup.UPDATE.NICKNAME.NOTBLANK.class)
    private String nickName;

}
