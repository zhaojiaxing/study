package com.zjx.bean;

import lombok.Data;

/**
 * 被协查人vo
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/23 13:47
 */
@Data
public class RespondentVO {
    /**主键*/
    private Integer id;
    /**
     * 申请文件表id
     */
    private Integer applyFileId;
    /**
     * 被查询人类型 1单位存款人 2个人存款人
     */
    private Integer type;
    /**
     * 查询方式（1为按存款人或企业名称名称查询；2为按身份证件信息查询）
     */
    private Integer queryWay;
    /**
     * 存款人名称（单位或者个人名称）
     */
    private String respondentName;
    /**
     * 注册地区代码
     */
    private String regionCode;
    /**
     * 证件种类（1身份证 2军官证 3文职干部证 4警官证 5士兵证 6.护照 7港澳台居民通行证 8户口簿 9其他）
     */
    private Integer cardType;
    /**
     * 证件号码
     */
    private String cardNum;
}
