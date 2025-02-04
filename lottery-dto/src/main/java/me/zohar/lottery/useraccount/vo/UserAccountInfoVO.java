package me.zohar.lottery.useraccount.vo;

import lombok.Data;

/**
 * 用户账号信息vo
 *
 * @author zohar
 * @date 2018年12月27日
 */
@Data
public class UserAccountInfoVO {

    /**
     * 主键id
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 账号类型
     */
    private String accountType;

    private String accountTypeName;

    /**
     * 返点
     */
    private Double rebate;

    /**
     * 赔率
     */
    private Double odds;

    /**
     * 余额
     */
    private Double balance;

    /**
     * QQ号
     */
    private String qqNumber;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 是否设置了支付密码
     */
    private boolean moneyPwd;

    /**
     * 状态
     */
    private String state;

}
