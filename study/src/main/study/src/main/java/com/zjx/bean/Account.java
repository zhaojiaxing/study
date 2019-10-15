package com.zjx.bean;
import java.text.DateFormat;
import java.util.*;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/09/06 14:37
 */
public class Account {
    private Long userAccountId;
    private Long otherAccountId;
    private Date date;

    public Account() {
    }

    public Account(Long userAccountId, Long otherAccountId) {
        this.userAccountId = userAccountId;
        this.otherAccountId = otherAccountId;
    }

    public Account(Long userAccountId, Long otherAccountId, Date date) {
        this.userAccountId = userAccountId;
        this.otherAccountId = otherAccountId;
        this.date = date;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Long getOtherAccountId() {
        return otherAccountId;
    }

    public void setOtherAccountId(Long otherAccountId) {
        this.otherAccountId = otherAccountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userAccountId=" + userAccountId +
                ", otherAccountId=" + otherAccountId +
                ", date=" + format(date) +
                '}'+"\n";
    }

    private static String format(Date date){
        DateFormat df2 = DateFormat.getDateTimeInstance();
        return df2.format(date);
    }
}
