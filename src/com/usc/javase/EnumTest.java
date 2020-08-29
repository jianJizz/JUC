package com.usc.javase;

/**
 * @author jianjianduan
 * @date 2020/8/29 3:14 下午
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        Season season = Season.SPRING;
        switch (season){
            case SPRING:
                System.out.println("spring, code is: " + season.getCode());
                break;
            case SUMMER:
                System.out.println("summer, code is: " + season.getCode());
                break;
            default:
                System.out.println("No this Season");
                break;
        }

    }
}
