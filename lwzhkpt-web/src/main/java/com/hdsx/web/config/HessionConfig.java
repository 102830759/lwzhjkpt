package com.hdsx.web.config;

/**
 * Created by Kimbo on 2017/2/15.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:hession-service.xml"})
public class HessionConfig {

}
