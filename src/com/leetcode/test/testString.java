package com.leetcode.test;

import org.junit.Test;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/9/14 2:09 下午
 * @Version 1.0
 */
public class testString {
    public static void main(String[] args) {
        ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = load.iterator();
        while(iterator.hasNext()) {
            Driver next = iterator.next();
            System.out.println(next);
        }
    }
}
