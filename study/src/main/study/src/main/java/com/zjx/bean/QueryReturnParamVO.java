package com.zjx.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/27 17:44
 */
public class QueryReturnParamVO {
    /**
     * 账户名
     */
    private String name;
    /**
     * 证件号码
     */
    private String cardNum;
    /**
     * 账户数
     */
    private Long count;

    private List<BankVO> bankInstitution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<BankVO> getBankInstitution() {
        if(Objects.isNull(bankInstitution)){
            return bankInstitution = new ArrayList<>();
        }
        return bankInstitution;
    }

    public void setBankInstitution(List<BankVO> bankInstitution) {
        this.bankInstitution = bankInstitution;
    }

    @Override
    public String toString() {
        return "QueryReturnParamVO{" +
                "name='" + name + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", count=" + count +
                ", bankInstitution=" + bankInstitution +
                '}';
    }
}
