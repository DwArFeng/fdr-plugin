package com.dwarfeng.fdrmanager.stack.service;

import com.dwarfeng.fdr.stack.bean.entity.TriggerInfo;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 触发器信息响应服务。
 *
 * @author DwArFeng
 * @since alpha-0.0.1
 */
public interface TriggerInfoResponseService extends Service {

    /**
     * 获取服务中是否有指定的触发器信息。
     *
     * @param key 指定的触发器信息的键。
     * @return 服务中是否有指定的触发器信息。
     * @throws ServiceException 服务异常。
     */
    boolean exists(LongIdKey key) throws ServiceException;

    /**
     * 获取服务中指定的主键对应的触发器信息。
     *
     * @param key 指定的主键。
     * @return 指定的主键对应的触发器信息。
     * @throws ServiceException 服务异常。
     */
    TriggerInfo get(LongIdKey key) throws ServiceException;

    /**
     * 向服务中插入指定的触发器信息。
     *
     * @param triggerInfo 指定的触发器信息。
     * @return 插入后分配的新主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey insert(TriggerInfo triggerInfo) throws ServiceException;

    /**
     * 向服务中更新指定的触发器信息。
     *
     * @param triggerInfo 指定的触发器信息。
     * @throws ServiceException 服务异常。
     */
    void update(TriggerInfo triggerInfo) throws ServiceException;

    /**
     * 从服务中删除指定的主键对应的触发器信息。
     *
     * @param key 指定的主键。
     * @throws ServiceException 服务异常。
     */
    void delete(LongIdKey key) throws ServiceException;

    /**
     * 从服务中获取所有的触发器信息。
     *
     * @param pagingInfo 分页信息。
     * @return 指定的数据点对应的触发器信息。
     * @throws ServiceException 服务异常。
     */
    PagedData<TriggerInfo> all(PagingInfo pagingInfo) throws ServiceException;

    /**
     * 从服务中获取指定数据点对应的所有触发器信息。
     *
     * @param pointKey   指定的数据点对应的主键。
     * @param pagingInfo 分页信息。
     * @return 指定的数据点对应的触发器信息。
     * @throws ServiceException 服务异常。
     */
    PagedData<TriggerInfo> childForPoint(LongIdKey pointKey, PagingInfo pagingInfo) throws ServiceException;
}
