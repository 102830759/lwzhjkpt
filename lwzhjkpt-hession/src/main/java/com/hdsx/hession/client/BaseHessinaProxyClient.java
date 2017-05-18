package com.hdsx.hession.client;

import com.caucho.hessian.client.HessianProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Kimbo on 2017/2/21.
 */
public class BaseHessinaProxyClient{
    protected String contextPath = null;

    protected Class service;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public Object create() throws MalformedURLException, URISyntaxException {
        URI originalUri = null;
        try {
            originalUri = new URI(contextPath + "/" + service.getName());
        } catch (URISyntaxException e) {
            throw e;
        }
        String serviceId = originalUri.getHost();
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
        URI uri = loadBalancerClient.reconstructURI(serviceInstance, originalUri);
        String url = uri.toString();
        HessianProxyFactory factory = new HessianProxyFactory();
        return factory.create(service, url);
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public Class getService() {
        return service;
    }

    public void setService(Class service) {
        this.service = service;
    }
}
