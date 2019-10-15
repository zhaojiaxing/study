package com.zjx;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/09/25 15:04
 */
public enum TypeEnum {
    TICKET_FIELD(0,"ticket_field"),
    BILL_FIELD(1,"bill_field"),
    DRUG_FIELD(2,"drug_field");

    private Integer type;

    private String field;

    TypeEnum(Integer type,String field){
        this.type = type;
        this.field = field;
    }
    public Integer getType(){
        return this.type;
    }

    public String getField(){
        return this.field;
    }

    public static String getFieldByType(Integer type) {
        for (TypeEnum typeEnum : TypeEnum.values()) {
            if (typeEnum.getType()== type) {
                return typeEnum.getField();
            }
        }
        return null;
    }
}
