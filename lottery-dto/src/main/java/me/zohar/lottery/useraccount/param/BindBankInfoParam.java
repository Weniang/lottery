package me.zohar.lottery.useraccount.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * 绑定银行卡信息入参
 *
 * @author zohar
 * @date 2019年1月20日
 */
@Data
public class BindBankInfoParam {

    /**
     * 开户银行
     */
    @NotBlank(message = "开户银行不能为空")
    private String openAccountBank;

    /**
     * 开户人姓名
     */
    @NotBlank(message = "开户姓名不能为空")
    private String accountHolder;

    /**
     * 银行卡账号
     */
    @NotBlank(message = "银行卡号不能为空")
    private String bankCardAccount;

    /**
     * 用户账号id
     */
    @NotBlank(message = "userAccountId不能为空")
    private String userAccountId;

    /**
     * 开户银行支行
     */
    @NotBlank(message = "开户支行不能为空")
    private String openAccountBankBranch;

}
