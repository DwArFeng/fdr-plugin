package com.dwarfeng.fdrmanager.stack.service;

import com.dwarfeng.fdr.stack.bean.entity.Point;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 数据点响应服务。
 *
 * @author DwArFeng
 * @since alpha-0.0.1
 */
public interface PointResponseService extends Service {

    /**
     * 获取服务中是否有指定的权限。
     *
     * @param key 指定的权限的键。
     * @return 服务中是否有指定的权限。
     * @throws ServiceException 服务异常。
     */
    boolean exists(LongIdKey key) throws ServiceException;

    /**
     * 向服务中插入指定的权限。
     *
     * @param point 指定的权限。
     * @return 插入后分配的新主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey insert(Point point) throws ServiceException;

    /**
     * 向服务中更新指定的权限。
     *
     * @param point 指定的权限。
     * @throws ServiceException 服务异常。
     */
    void update(Point point) throws ServiceException;

    /**
     * 从服务中删除指定的主键对应的权限。
     *
     * @param key 指定的主键。
     * @throws ServiceException 服务异常。
     */
    void delete(LongIdKey key) throws ServiceException;

    /**
     * 获取所有权限。
     *
     * @param pagingInfo 分页信息。
     * @return 所有权限构成的分页数据。
     * @throws ServiceException 服务异常。
     */
    PagedData<Point> all(PagingInfo pagingInfo) throws ServiceException;
}
