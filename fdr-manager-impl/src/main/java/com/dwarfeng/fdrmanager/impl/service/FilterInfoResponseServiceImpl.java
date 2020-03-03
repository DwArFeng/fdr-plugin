package com.dwarfeng.fdrmanager.impl.service;

import com.dwarfeng.fdr.stack.bean.entity.FilterInfo;
import com.dwarfeng.fdr.stack.service.FilterInfoMaintainService;
import com.dwarfeng.fdrmanager.stack.service.FilterInfoResponseService;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class FilterInfoResponseServiceImpl implements FilterInfoResponseService {

    @Autowired
    @Qualifier("filterInfoMaintainService")
    private FilterInfoMaintainService service;

    @Override
    public boolean exists(LongIdKey key) throws ServiceException {
        return service.exists(key);
    }

    @Override
    public FilterInfo get(LongIdKey key) throws ServiceException {
        return service.get(key);
    }

    @Override
    public LongIdKey insert(FilterInfo filterInfo) throws ServiceException {
        return service.insert(filterInfo);
    }

    @Override
    public void update(FilterInfo filterInfo) throws ServiceException {
        service.update(filterInfo);
    }

    @Override
    public void delete(LongIdKey key) throws ServiceException {
        service.delete(key);
    }

    @Override
    public PagedData<FilterInfo> childForPoint(LongIdKey pointKey, PagingInfo pagingInfo) throws ServiceException {
        return service.lookup(FilterInfoMaintainService.CHILD_FOR_POINT, new Object[]{pointKey}, pagingInfo);
    }
}
