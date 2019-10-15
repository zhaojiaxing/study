package com.zjx.bean;

import lombok.Data;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/23 13:49
 */
@Data
public class InvestigationVO {
    /**主键*/
    private Integer id;
    /**
     * 查询文件id
     */
    private Integer applyFileId;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 协查编号
     */
    private String investigationNum;
    /**
     * 文件内容
     */
    private String content;
    /**
     * 文件后缀名
     */
    private String prefix;
    /**
     * 文件类型 1.协查文件 2.工作证
     */
    private Integer type;
}
