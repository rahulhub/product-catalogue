package com.uru.app.entity;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.io.Serializable;

/**
 * Created by rahul.dev on 7/3/2016.
 */

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="IziwearData")
@Table(name="izi_wear_data")
@NamedQuery(name="IziWearData.findById", query="Select izi from IziWearData izi where izi.iziWearId= :iziWearId", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})

public class IziWearData implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="IZI_WEAR_ID")
    private Long iziWearId ;

    @Column(name="IZIWEAR_LOGO_POSITIONS")
    private String iziWearLogoDetails;

    @Column(name="IZIWEAR_WASH_INSTRUCTIONS",length=1000)
    private String iziWearWashInstruction ;

    @Column(name="IZIWEAR_SIZE_CHART")
    private String iziWearSizeChartTemplate ;

    @Column(name="IZIWEAR_PRICE_MATRIX")
    private String iziWearPriceMatrixDetails ;
    
    @Column(name="IZIWEAR_LOGOTYPE")
    private String iziWearLogoType;
    
    @Column(name="IZIWEAR_TEXT",length=800)
    private String iziWearText;
    
    @Column(name="IZIWEAR_LOGO_IMAGE")
    private String iziWear_LogoImage;
    
    @Column(name="IZIWEAR_CustImage")
    private String iziWearCustImage;
    
    @Column(name="json_data",length=4000)
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
