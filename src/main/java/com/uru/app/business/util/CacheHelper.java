package com.uru.app.business.util;

import javax.persistence.Query;

import com.uru.app.constants.UruAppConstants;

public class CacheHelper {

	public static void formQueryCache(Query query, String cacheRegion) {
		query.setHint(UruAppConstants.ORG_HIBERNATE_CACHEABLE,
				UruAppConstants.TRUE);
		query.setHint(UruAppConstants.ORG_HIBERNATE_CACHE_REGION,
				cacheRegion);
		query.setHint(UruAppConstants.ORG_HIBERNATE_CACHEMODE, UruAppConstants.NORMAL);
	}
}
