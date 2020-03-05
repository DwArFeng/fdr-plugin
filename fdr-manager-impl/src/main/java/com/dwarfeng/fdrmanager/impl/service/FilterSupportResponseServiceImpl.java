package com.dwarfeng.fdrmanager.impl.service;

import com.dwarfeng.fdr.stack.bean.entity.FilterSupport;
import com.dwarfeng.fdr.stack.service.FilterSupportMaintainService;
import com.dwarfeng.fdrmanager.stack.service.FilterSupportResponseService;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.dto.PagingInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class FilterSupportResponseServiceImpl implements FilterSupportResponseService {

    @Autowired
    @Qualifier("filterSupportMaintainService")
    private FilterSupportMaintainService service;

    @Override
    public boolean exists(StringIdKey key) throws ServiceException {
        return service.exists(key);
    }

    @Override
    public FilterSupport get(StringIdKey key) throws ServiceException {
        return service.get(key);
    }

    @Override
    public StringIdKey insert(FilterSupport filterSupport) throws ServiceException {
        return service.insertIfNotExists(filterSupport);
    }

    @Override
    public void update(FilterSupport filterSupport) throws ServiceException {
        service.update(filterSupport);
    }

    @Override
    public void delete(StringIdKey key) throws ServiceException {
        service.delete(key);
    }

    @Override
    public PagedData<FilterSupport> idLike(String pattern, PagingInfo pagingInfo) throws ServiceException {
        return service.lookup(FilterSupportMaintainService.ID_LIKE, new Object[]{pattern}, pagingInfo);
    }

    @Override
    public PagedData<FilterSupport> labelLike(String pattern, PagingInfo pagingInfo) throws ServiceException {
        return service.lookup(FilterSupportMaintainService.LABEL_LIKE, new Object[]{pattern}, pagingInfo);
    }
}
