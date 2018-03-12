package com.uru.app.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Subhrajyoti.Moitra on 21-01-2015. Another way to init this is
 * using <servlet-mapping>
 * <servlet-name>javax.ws.rs.core.Application</servlet-name>
 * <url-pattern>/api/*</url-pattern> </servlet-mapping>
 */
@ApplicationPath("/api")
public class JaxRsActivator extends Application {
}
