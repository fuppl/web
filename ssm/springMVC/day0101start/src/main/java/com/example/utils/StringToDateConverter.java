package com.example.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器，把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     *
     * @param s 传入的字符串的值
     * @return
     */
    @Override
    public Date convert(String s) {
        // 判断
        if (s == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 把字符串转换成日期
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("转换出错");
        }
    }
}
