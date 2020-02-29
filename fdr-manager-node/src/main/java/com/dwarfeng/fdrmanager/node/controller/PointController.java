package com.dwarfeng.fdrmanager.node.controller;

import com.dwarfeng.fdr.sdk.bean.entity.JSFixedFastJsonPoint;
import com.dwarfeng.fdr.sdk.bean.entity.WebInputPoint;
import com.dwarfeng.fdr.stack.bean.entity.Point;
import com.dwarfeng.fdrmanager.stack.service.PointResponseService;
import com.dwarfeng.subgrade.sdk.bean.dto.FastJsonResponseData;
import com.dwarfeng.subgrade.sdk.bean.dto.JSFixedFastJsonPagedData;
import com.dwarfeng.subgrade.sdk.bean.dto.PagingUtil;
import com.dwarfeng.subgrade.sdk.bean.dto.ResponseDataUtil;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.BehaviorAnalyse;
import com.dwarfeng.subgrade.sdk.interceptor.http.BindingCheck;
import com.dwarfeng.subgrade.stack.bean.BeanTransformer;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * 账户控制器。
 *
 * @author DwArFeng
 * @since alpha-0.0.1
 */
@RestController
@RequestMapping("/api/v1/point")
public class PointController {

    @Autowired
    private PointResponseService service;
    @Autowired
    private ServiceExceptionMapper sem;

    @Autowired
    private BeanTransformer<Point, JSFixedFastJsonPoint> beanTransformer;

    @GetMapping("/exists")
    @BehaviorAnalyse
    public FastJsonResponseData<Boolean> exists(HttpServletRequest request, @RequestParam("key") @NotNull long key) {
        try {
            boolean exists = service.exists(new LongIdKey(key));
            return FastJsonResponseData.of(ResponseDataUtil.good(exists));
        } catch (Exception e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(Boolean.class, e, sem));
        }
    }

    @PostMapping("")
    @BehaviorAnalyse
    @BindingCheck
    public FastJsonResponseData<FastJsonLongIdKey> insert(
            HttpServletRequest request,
            @RequestBody @Validated WebInputPoint point, BindingResult bindingResult) {
        try {
            LongIdKey insert = service.insert(point.toStackBean());
            return FastJsonResponseData.of(ResponseDataUtil.good(FastJsonLongIdKey.of(insert)));
        } catch (Exception e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(FastJsonLongIdKey.class, e, sem));
        }
    }

    @PatchMapping("")
    @BehaviorAnalyse
    @BindingCheck
    public FastJsonResponseData<Object> update(
            HttpServletRequest request,
            @RequestBody @Validated WebInputPoint point, BindingResult bindingResult) {
        try {
            service.update(point.toStackBean());
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (Exception e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(Object.class, e, sem));
        }
    }

    @DeleteMapping("")
    @BehaviorAnalyse
    public FastJsonResponseData<Object> delete(HttpServletRequest request, @RequestParam("key") long key) {
        try {
            service.delete(new LongIdKey(key));
            return FastJsonResponseData.of(ResponseDataUtil.good(null));
        } catch (Exception e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(Object.class, e, sem));
        }
    }

    @GetMapping("/all")
    @BehaviorAnalyse
    public FastJsonResponseData<JSFixedFastJsonPagedData<JSFixedFastJsonPoint>> all(
            HttpServletRequest request, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        try {
            PagedData<Point> all = service.all(new PagingInfo(page, rows));
            PagedData<JSFixedFastJsonPoint> transform = PagingUtil.transform(all, beanTransformer);
            return FastJsonResponseData.of(ResponseDataUtil.good(JSFixedFastJsonPagedData.of(transform)));
        } catch (Exception e) {
            return FastJsonResponseData.of(ResponseDataUtil.bad(JSFixedFastJsonPagedData.class, e, sem));
        }
    }
}
