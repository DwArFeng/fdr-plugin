package com.dwarfeng.fdrmanager.impl.service;

import com.dwarfeng.fdr.stack.bean.entity.TriggerInfo;
import com.dwarfeng.fdr.stack.service.TriggerInfoMaintainService;
import com.dwarfeng.fdrmanager.stack.service.TriggerInfoResponseService;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class TriggerInfoResponseServiceImpl implements TriggerInfoResponseService {

    @Autowired
    @Qualifier("triggerInfoMaintainService")
    private TriggerInfoMaintainService service;

    @Override
    public boolean exists(LongIdKey key) throws ServiceException {
        return service.exists(key);
    }

    @Override
    public TriggerInfo get(LongIdKey key) throws ServiceException {
        return service.get(key);
    }

    @Override
    public LongIdKey insert(TriggerInfo triggerInfo) throws ServiceException {
        return service.insert(triggerInfo);
    }

    @Override
    public void update(TriggerInfo triggerInfo) throws ServiceException {
        service.update(triggerInfo);
    }

    @Override
    public void delete(LongIdKey key) throws ServiceException {
        service.delete(key);
    }

    @Override
    public PagedData<TriggerInfo> childForPoint(LongIdKey pointKey, PagingInfo pagingInfo) throws ServiceException {
        return service.lookup(TriggerInfoMaintainService.CHILD_FOR_POINT, new Object[]{pointKey}, pagingInfo);
    }
}
