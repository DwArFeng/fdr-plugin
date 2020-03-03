package com.dwarfeng.fdrmanager.stack.service;

import com.dwarfeng.fdr.stack.bean.entity.FilterInfo;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 过滤器信息响应服务。
 *
 * @author DwArFeng
 * @since alpha-0.0.1
 */
public interface FilterInfoResponseService extends Service {

    /**
     * 获取服务中是否有指定的过滤器信息。
     *
     * @param key 指定的过滤器信息的键。
     * @return 服务中是否有指定的过滤器信息。
     * @throws ServiceException 服务异常。
     */
    boolean exists(LongIdKey key) throws ServiceException;

    /**
     * 获取服务中指定的主键对应的过滤器信息。
     *
     * @param key 指定的主键。
     * @return 指定的主键对应的过滤器信息。
     * @throws ServiceException 服务异常。
     */
    FilterInfo get(LongIdKey key) throws ServiceException;

    /**
     * 向服务中插入指定的过滤器信息。
     *
     * @param filterInfo 指定的过滤器信息。
     * @return 插入后分配的新主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey insert(FilterInfo filterInfo) throws ServiceException;

    /**
     * 向服务中更新指定的过滤器信息。
     *
     * @param filterInfo 指定的过滤器信息。
     * @throws ServiceException 服务异常。
     */
    void update(FilterInfo filterInfo) throws ServiceException;

    /**
     * 从服务中删除指定的主键对应的过滤器信息。
     *
     * @param key 指定的主键。
     * @throws ServiceException 服务异常。
     */
    void delete(LongIdKey key) throws ServiceException;

    /**
     * 从服务中获取指定数据点对应的所有过滤器信息。
     *
     * @param pointKey   指定的数据点对应的主键。
     * @param pagingInfo 分页信息。
     * @return 指定的数据点对应的过滤器信息。
     * @throws ServiceException 服务异常。
     */
    PagedData<FilterInfo> childForPoint(LongIdKey pointKey, PagingInfo pagingInfo) throws ServiceException;
}
