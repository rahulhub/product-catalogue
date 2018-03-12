package com.uru.app.business.elasticsearch;


import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;


@Singleton
@ApplicationScoped
@Startup
public class ElasticSearchConfig {

    private TransportClient client;
 

    @PostConstruct
    public void postConstruct() {
//        final Settings settings = ImmutableSettings.settingsBuilder()
//				.put("transport.tcp.port", "9300-9400")
//				.put("discovery.zen.ping.multicast.enabled", "false")
//				.put("discovery.zen.ping.unicast.hosts", "localhost")
//                .build();
//    	final Node node =NodeBuilder.nodeBuilder().settings(settings).client(true).data(false).clusterName("elasticsearch").build().start();
//        client = node.client();
        
        
       try {
		client = TransportClient.builder().build()
		            .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    @Produces
    @ElasticSearchClient
    public Client getClient() {
        return client;
    }

    @PreDestroy
    public void preDestroy() {
        client.close();
    }
}