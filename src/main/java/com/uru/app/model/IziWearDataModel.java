package com.uru.app.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by rahul.dev on 7/5/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IziWearDataModel {


    private Long iziWearId ;

    //private Long iziWearProductId ;

    private String iziWearLogoDetails;

    private String iziWearWashInstruction ;

    private String iziWearSizeChartTemplate ;

    private String iziWearPriceMatrixDetails ;
    
    private String iziWearLogoType;
    
    private String iziWearText;
    
    private String iziWear_LogoImage;
    
    private String iziWearCustImage;
    
    private String json_Data;

	public Long getIziWearId() {
		return iziWearId;
	}

	public void setIziWearId(Long iziWearId) {
		this.iziWearId = iziWearId;
	}

	public String getIziWearLogoDetails() {
		return iziWearLogoDetails;
	}

	public void setIziWearLogoDetails(String iziWearLogoDetails) {
		this.iziWearLogoDetails = iziWearLogoDetails;
	}

	public String getIziWearWashInstruction() {
		return iziWearWashInstruction;
	}

	public void setIziWearWashInstruction(String iziWearWashInstruction) {
		this.iziWearWashInstruction = iziWearWashInstruction;
	}

	public String getIziWearSizeChartTemplate() {
		return iziWearSizeChartTemplate;
	}

	public void setIziWearSizeChartTemplate(String iziWearSizeChartTemplate) {
		this.iziWearSizeChartTemplate = iziWearSizeChartTemplate;
	}

	public String getIziWearPriceMatrixDetails() {
		return iziWearPriceMatrixDetails;
	}

	public void setIziWearPriceMatrixDetails(String iziWearPriceMatrixDetails) {
		this.iziWearPriceMatrixDetails = iziWearPriceMatrixDetails;
	}

	public String getIziWearLogoType() {
		return iziWearLogoType;
	}

	public void setIziWearLogoType(String iziWearLogoType) {
		this.iziWearLogoType = iziWearLogoType;
	}

	public String getIziWearText() {
		return iziWearText;
	}

	public void setIziWearText(String iziWearText) {
		this.iziWearText = iziWearText;
	}

	public String getIziWear_LogoImage() {
		return iziWear_LogoImage;
	}

	public void setIziWear_LogoImage(String iziWear_LogoImage) {
		this.iziWear_LogoImage = iziWear_LogoImage;
	}

	public String getIziWearCustImage() {
		return iziWearCustImage;
	}

	public void setIziWearCustImage(String iziWearCustImage) {
		this.iziWearCustImage = iziWearCustImage;
	}

	public String getJson_Data() {
		return json_Data;
	}

	public void setJson_Data(String json_Data) {
		this.json_Data = json_Data;
	}
    
}
