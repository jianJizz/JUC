package com.usc.basic.bit;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author jianjianDuan
 * @date 2022/5/23 1:47 PM
 */
public class GoogleBoomFilter {

    public static void main(String[] args) {
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }
}
