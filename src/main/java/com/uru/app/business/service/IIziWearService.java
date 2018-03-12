package com.uru.app.business.service;

import com.uru.app.model.IziWearDataModel;

/**
 * Created by rahul.dev on 7/6/2016.
 */
public interface IIziWearService {

    IziWearDataModel getIziWearDetails(long iziWearId) ;
    boolean saveIziWearData(IziWearDataModel iziWearData);
    IziWearDataModel updateIziWearData(IziWearDataModel iziWearData);
    boolean deleteIziWearData(long iziWearId);
}
