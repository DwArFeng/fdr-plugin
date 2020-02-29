package com.dwarfeng.fdrmanager.node.configuration;

import com.dwarfeng.fdr.sdk.bean.entity.FastJsonPoint;
import com.dwarfeng.fdr.stack.bean.entity.Point;
import com.dwarfeng.subgrade.impl.bean.DozerBeanTransformer;
import com.dwarfeng.subgrade.stack.bean.BeanTransformer;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DwArFeng
 * @since 0.0.1-alpha
 */
@Configuration
public class BeanTransformerConfiguration {

    @Autowired
    private Mapper mapper;

    @Bean
    public BeanTransformer<Point, FastJsonPoint> pointFastJsonPointBeanTransformer() {
        return new DozerBeanTransformer<>(Point.class, FastJsonPoint.class, mapper);
    }
}
