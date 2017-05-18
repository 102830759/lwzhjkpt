package com.hdsx.web.rest;


import com.hdsx.api.sd.service.SDService;
import com.hdsx.api.sd.vo.Sd;
import com.hdsx.hession.client.HessianProxyClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhaod on 2017/5/10.
 */
@Api("隧道服务")
@RestController
@RequestMapping("sd")
public class SDRestService {

    @Resource
    private HessianProxyClient hessionClient;

    private static Logger logger = LoggerFactory.getLogger(SDRestService.class);

    @RequestMapping(value = "info/{sddm}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "根据唯一标识查询要素详情")
    public Sd getlxList(@PathVariable(value = "sddm") String sddm) {
        Sd sd = new Sd();
        SDService sdService;
        try {
            sdService = (SDService) hessionClient.create();
            sd = sdService.queryOne(sddm);

        } catch (Exception e) {
            logger.error("隧道服务:{}", e.getMessage(), e);
        }
        return sd;
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "qeury", method = RequestMethod.GET, produces = "application/json")
    public List<Sd> query() {
        SDService sdService;
        List<Sd> sds = null;
        try {
            sdService = (SDService) hessionClient.create();
            sds = sdService.queryList();
        } catch (Exception e) {
            logger.error("隧道服务:{}", e.getMessage(), e);
        }
        return sds;
    }
}
