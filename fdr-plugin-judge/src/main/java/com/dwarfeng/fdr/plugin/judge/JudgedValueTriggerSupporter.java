package com.dwarfeng.fdr.plugin.judge;

import com.alibaba.fastjson.JSON;
import com.dwarfeng.fdr.impl.handler.TriggerSupporter;
import org.springframework.stereotype.Component;

/**
 * 判断结果过滤器制造器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class JudgedValueTriggerSupporter implements TriggerSupporter {

    public static final String SUPPORT_TYPE = "judged_value_trigger";

    @Override
    public String provideType() {
        return SUPPORT_TYPE;
    }

    @Override
    public String provideLabel() {
        return "判断结果触发器";
    }

    @Override
    public String provideDescription() {
        return "judge框架提供的触发器，用于判断DataInfo对象转化为JudgedValue之后其" +
                "JudgementInfo.value是否满足定义的约束，若满足定义的约束则进行触发。";
    }

    @Override
    public String provideExampleContent() {
        JudgedValueTriggerMaker.Config config = new JudgedValueTriggerMaker.Config(0.5, "GE");
        return JSON.toJSONString(config, true) +
                '\n' +
                "# 以下的内容为注释，在实际配置时删除这些注释。\n" +
                "# 可用的constraint内容 (可忽略大小写): \n" +
                "#   LE: judgementInfo.value的值 等于 配置的 value\n" +
                "#   LE: judgementInfo.value的值 不等于 配置的 value\n" +
                "#   LE: judgementInfo.value的值 小于等于 配置的 value\n" +
                "#   LT: judgementInfo.value的值 小于 配置的 value\n" +
                "#   GE: judgementInfo.value的值 大于等于 配置的 value\n" +
                "#   GT: judgementInfo.value的值 大于 配置的 value";
    }
}
