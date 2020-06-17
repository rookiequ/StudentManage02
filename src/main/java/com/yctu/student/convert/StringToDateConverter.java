package com.yctu.student.convert;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName StringToDateConverter
 * @Description 字符串类型转换为时间类型
 * @Author qlq
 * @Date 2020-06-17 15:32
 */
public class StringToDateConverter implements Converter<String, LocalDate> {

    /** 默认日期时间格式 */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 默认日期格式 */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    /** 默认时间格式 */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    @Override
    public LocalDate convert(String s) {
        if (s.isEmpty()){
            throw new NullPointerException("请输入日期");
        }

        return LocalDate.parse(s, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }
}
