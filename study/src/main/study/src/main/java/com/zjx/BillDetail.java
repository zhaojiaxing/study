/**
 * @(#) BillDetail.java 1.0 2018/11/15 hunter
 * 
 *      Copyright (c) 2018 keyway. All Rights Reserved.
 */
package com.zjx;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 账单流水
 * 
 * @author hunter
 * @since 2018/11/15 下午13:35:41
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class BillDetail {

    /** 交易金额 */
    private BigDecimal dealMoney;

    /** 收付标志 */
    private String dealSign;


}