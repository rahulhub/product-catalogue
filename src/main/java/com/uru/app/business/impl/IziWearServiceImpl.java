package com.uru.app.business.impl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.uru.app.business.service.IIziWearService;
import com.uru.app.dao.ICatalogDao;
import com.uru.app.dao.IWearDao;
import com.uru.app.model.IziWearDataModel;

/**
 * Created by rahul.dev on 7/6/2016.
 */
public class IziWearServiceImpl implements IIziWearService {
	
	@Inject
	IWearDao wearDao;

    @Override
    public IziWearDataModel getIziWearDetails(long iziWearId) {
        return wearDao.getIziWearDetails(iziWearId);
    }

    @Override
    @Transactional
    public boolean saveIziWearData(IziWearDataModel iziWearData) {
    	return wearDao.saveIziWearData(iziWearData);
    }

    @Override
    @Transactional
    public IziWearDataModel updateIziWearData(IziWearDataModel iziWearData) {
    	return wearDao.updateIziWearData(iziWearData);
    }

    @Override
    public boolean deleteIziWearData(long iziWearId) {
    	return wearDao.deleteIziWearData(iziWearId);
    }
}
