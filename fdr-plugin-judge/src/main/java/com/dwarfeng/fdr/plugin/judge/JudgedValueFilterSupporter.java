package com.dwarfeng.fdr.plugin.judge;

import com.dwarfeng.fdr.impl.handler.FilterSupporter;
import org.springframework.stereotype.Component;

/**
 * 判断结果过滤器支持器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class JudgedValueFilterSupporter implements FilterSupporter {

    public static final String SUPPORT_TYPE = "judged_value_filter";

    @Override
    public String provideType() {
        return SUPPORT_TYPE;
    }

    @Override
    public String provideLabel() {
        return "判断结果过滤器";
    }

    @Override
    public String provideDescription() {
        return "judge框架提供的过滤器，用于判断DataInfo对象是否能转换成JudgedValue，以及转化后是否合法。";
    }

    @Override
    public String provideExampleContent() {
        return "";
    }
}
