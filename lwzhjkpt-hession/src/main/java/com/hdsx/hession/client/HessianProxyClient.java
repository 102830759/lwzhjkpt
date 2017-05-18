package com.hdsx.hession.client;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.netflix.ribbon.eureka.RibbonEurekaAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 * Created by Kimbo on 2017/2/20.
 */
@Component
@AutoConfigureAfter(RibbonEurekaAutoConfiguration.class)
public class HessianProxyClient extends BaseHessinaProxyClient{
}
/**/