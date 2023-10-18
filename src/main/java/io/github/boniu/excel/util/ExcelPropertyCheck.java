package io.github.boniu.excel.util;

import com.alibaba.excel.converters.AutoConverter;
import com.alibaba.excel.converters.Converter;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ExcelPropertyCheck {
    boolean required() default true; // ----是否为空，默认不为空。

    boolean checkFormat() default false; // ----是否进行格式检验，默认不进行。

    int type() default -1; // ----格式检验类型，int 已经支持的类型有 0->ip、1->端口、2->时间日期格式

    int length() default -1; // ----长度校验， int 字符串的长度，-1不进行校验

    String[] value() default {""}; // ----导出时对应字段的表头名称

    int index() default -1; // ----排列顺序，最好不要配默认按字段顺序。

    int order() default Integer.MAX_VALUE; // ----同上

    Class<? extends Converter<?>> converter() default AutoConverter.class; // ----转换器

    String format() default ""; // ----格式划输出

}