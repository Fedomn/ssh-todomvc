package com.fedomn.service.impl;

import com.fedomn.dao.FjDao;
import com.fedomn.dao.GenericDao;
import com.fedomn.model.Fj;
import com.fedomn.service.FjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FjServiceImpl extends GenericServiceImpl<Fj, String> implements FjService {

    @Autowired
    private FjDao fjDao;

    @Override
    public GenericDao<Fj, String> getDao() {
        return fjDao;
    }
}
