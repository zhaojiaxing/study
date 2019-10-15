package com.zjx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/23 13:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyFileInput {
    /**
     * 申请人
     */
    private String applyName;
    /**
     * 申请组织
     */
    private String applyOrganization;
    /**
     * 申请组织代码
     */
    private String organizationCode;
    /**
     * 接收单位代码
     */
    private Integer receiveOrganizationCode;
    /**
     * 查询状态：0待接收 1待查询 2已查询 3 已退回
     */
    private Integer state;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 接收时间
     */
    private Date receiveTime;
    /**
     * 查询时间
     */
    private Date queryTime;
    /**
     * 退回时间
     */
    private Date returnTime;
    /**
     * 加急状态（例如：中纪委加急）
     */
    private String urgentState;
    /**
     * 退回理由
     */
    private String returnReason;
    /**
     * 申请人工号
     */
    private String jobNum;
    /**
     * 被协查人列表
     */
    private List<RespondentVO> respondentList;
    /**
     * 协查文件
     */
    private List<InvestigationVO> investigationList;
    /**
     * 申请人工作证
     */
    private List<InvestigationVO> employeeCard;

    /**
     * 请求id
     */
    private String requestId;
}
