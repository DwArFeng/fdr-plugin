package com.dwarfeng.fdrmanager.impl.service;

import com.dwarfeng.fdr.stack.bean.entity.TriggerSupport;
import com.dwarfeng.fdr.stack.service.TriggerSupportMaintainService;
import com.dwarfeng.fdrmanager.stack.service.TriggerSupportResponseService;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class TriggerSupportResponseServiceImpl implements TriggerSupportResponseService {

    @Autowired
    @Qualifier("triggerSupportMaintainService")
    private TriggerSupportMaintainService service;

    @Override
    public boolean exists(StringIdKey key) throws ServiceException {
        return service.exists(key);
    }

    @Override
    public TriggerSupport get(StringIdKey key) throws ServiceException {
        return service.get(key);
    }

    @Override
    public StringIdKey insert(TriggerSupport triggerSupport) throws ServiceException {
        return service.insertIfNotExists(triggerSupport);
    }

    @Override
    public void update(TriggerSupport triggerSupport) throws ServiceException {
        service.update(triggerSupport);
    }

    @Override
    public void delete(StringIdKey key) throws ServiceException {
        service.delete(key);
    }

    @Override
    public PagedData<TriggerSupport> all(PagingInfo pagingInfo) throws ServiceException {
        return service.lookup(pagingInfo);
    }

    @Override
    public PagedData<TriggerSupport> idLike(String pattern, PagingInfo pagingInfo) throws ServiceException {
        return service.lookup(TriggerSupportMaintainService.ID_LIKE, new Object[]{pattern}, pagingInfo);
    }

    @Override
    public PagedData<TriggerSupport> labelLike(String pattern, PagingInfo pagingInfo) throws ServiceException {
        return service.lookup(TriggerSupportMaintainService.LABEL_LIKE, new Object[]{pattern}, pagingInfo);
    }
}
