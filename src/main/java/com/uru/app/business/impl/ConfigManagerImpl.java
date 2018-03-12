package com.uru.app.business.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.uru.app.business.IConfigManager;
import com.uru.app.business.util.CalcTemplate;

/**
 * Created by Rahul Dev.
 */
@Singleton
public class ConfigManagerImpl implements IConfigManager {


	private List<CalcTemplate> calcTemplates = new ArrayList<CalcTemplate>();
	private Map<String,CalcTemplate> calcTemplatesMap = new HashMap<String,CalcTemplate>();

	@Override
	@PostConstruct
	public void loadConfig() {
		if (calcTemplates.isEmpty()) {

			String strJson = null;
			try (InputStream ins = ConfigManagerImpl.class.getClassLoader()
					.getResourceAsStream("CalcTemplateConfig.json")) {
				strJson = IOUtils.toString(ins);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Gson gson = new Gson();

			JsonParser parser = new JsonParser();
			JsonArray jArray = parser.parse(strJson).getAsJsonArray();

			for (JsonElement obj : jArray) {
				CalcTemplate calcTemp = gson.fromJson(obj, CalcTemplate.class);
				if (null != calcTemp){
					calcTemplates.add(calcTemp);
					calcTemplatesMap.put(calcTemp.getTemplateName(), calcTemp);
				}
					
			}
		}

	}

	@Override
	public List<CalcTemplate> getTemplates() {
		return this.calcTemplates;
	}

	@Override
	public CalcTemplate getTemplateByName(String templateName) {
		return calcTemplatesMap.get(templateName);
	}


}
