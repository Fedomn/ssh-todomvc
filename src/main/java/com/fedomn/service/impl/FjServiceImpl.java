package com.fedomn.service.impl;

import com.fedomn.dao.FjDao;
import com.fedomn.model.Fj;
import com.fedomn.service.FjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FjServiceImpl extends GenericServiceImpl<Fj, String> implements FjService {

    private FjDao fjDao;

    @Autowired
    public void setFjDao(FjDao fjDao) {
        this.fjDao = fjDao;
        setGenericDao(fjDao);
    }

}
