package com.zjx.bean;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/28 9:18
 */
public class BankVO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankVO(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BankVO{" +
                "name='" + name + '\'' +
                '}';
    }
}
