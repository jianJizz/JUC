package com.usc.javase;

/**
 * @author jianjianduan
 * @date 2020/8/29 3:14 下午
 */
public enum Season {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);

    private int code;
    private Season(int code){
        this.code = code;
    }


    public int getCode(){
        return this.code;
    }
}
