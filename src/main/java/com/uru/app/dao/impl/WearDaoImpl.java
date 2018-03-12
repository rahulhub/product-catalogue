package com.uru.app.dao.impl;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.IWearDao;
import com.uru.app.entity.EcomItem;
import com.uru.app.entity.EcomProduct;
import com.uru.app.entity.IziWearData;
import com.uru.app.model.IziWearDataModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Created by rahul.dev on 7/6/2016.
 */
public class WearDaoImpl implements IWearDao {

    @Inject
    @MySQLURUDatabase
    EntityManager em;
    
    @Inject
	EntityToModelUtil e2m;
    
    @Inject
	ModelToEntityUtil m2e;


    @Override
    public IziWearDataModel getIziWearDetails(long id) {
    	final Query query = this.em.createNamedQuery("IziWearData.findById", IziWearData.class);
		query.setParameter("iziWearId", id);
		CacheHelper.formQueryCache(query, UruAppConstants.IZI_WEAR_DATA_FINDBY_ID);
		final IziWearData wearData = (IziWearData)query.getSingleResult();
				
			return this.e2m.convertIziWareToModel(wearData);
    }

    @Override
    @Transactional
    public boolean saveIziWearData(IziWearDataModel iziWearData) {
    	if(iziWearData == null) {
			throw new UruApplicationException("Illegal IziWearData. IziWearData creation failed.");
		}
    	IziWearData entity = m2e.convertIziWearTypeModelToEntity(iziWearData);
		em.persist(entity);
		return true;
    }

    @Override
    @Transactional
    public IziWearDataModel updateIziWearData(IziWearDataModel iziWearData) {
    	if(iziWearData == null) {
			throw new UruApplicationException("Illegal IziWearData data. IziWearData updation failed.");
		}
    	IziWearData entity = m2e.convertIziWearTypeModelToEntity(iziWearData);
		em.merge(entity);
		return iziWearData;  
    }

    @Override
    @Transactional
    public boolean deleteIziWearData(long iziWearId) {
    	final Query query = this.em.createNamedQuery("IziWearData.findById", IziWearData.class);
		query.setParameter("iziWearId", iziWearId);
		CacheHelper.formQueryCache(query, UruAppConstants.IZI_WEAR_DATA_FINDBY_ID);
		final IziWearData wearData = (IziWearData)query.getSingleResult();
		em.remove(wearData);
		return true;
    }
}
