package com.uru.app.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;

import javax.inject.Named;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

@Named
@Provider
public class IziJacksonJsonProvider extends JacksonJsonProvider {

	public void writeTo(Object value, Class<?> type, java.lang.reflect.Type genericType, Annotation[] annotations, 
            MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) 
            throws IOException 
    {
        ObjectMapper mapper = locateMapper(type, mediaType);

        mapper.disable(Feature.FAIL_ON_EMPTY_BEANS);

        super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
    }
}
