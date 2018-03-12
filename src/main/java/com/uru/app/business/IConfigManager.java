package com.uru.app.business;

import java.util.List;
import java.util.Map;

import com.uru.app.business.util.CalcTemplate;

/**
 * Created by Rahul Dev.
 */
public interface IConfigManager {

	public void loadConfig();

	public List<CalcTemplate> getTemplates();
	
	public CalcTemplate getTemplateByName(String templateName);

	

}
