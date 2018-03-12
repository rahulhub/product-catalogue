package com.uru.app.rest;

import com.uru.app.business.service.IIziWearService;
import com.uru.app.model.IziWearDataModel;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by rahul.dev on 7/5/2016.
 */

@Path("/iziwearservice")
@Api(value = "/iziwearservice")
@Produces(MediaType.APPLICATION_JSON)
public class IziWearRestService {

    @Inject
    IIziWearService iziWearService;

    @GET
    @Path("/getIziWearData")
    @Produces(MediaType.APPLICATION_JSON)
    public IziWearDataModel getIziWearDetails(@QueryParam("iziWearId") long iziWearId) {
        return  iziWearService.getIziWearDetails(iziWearId);
    }

    @POST
    @Path("/saveIziWearData")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean saveIziWearData(IziWearDataModel iziWearData){
        return iziWearService.saveIziWearData(iziWearData);
    }

    @POST
    @Path("/updateIziWearData")
    @Consumes(MediaType.APPLICATION_JSON)
    public IziWearDataModel updateIziWearData(IziWearDataModel iziWearData){
        return iziWearService.updateIziWearData(iziWearData);
    }

    @POST
    @Path("/deleteIziWearData")
    //@Consumes(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteIziWearData(@QueryParam("iziWearId") long iziWearId){
        return iziWearService.deleteIziWearData(iziWearId);
    }

}
