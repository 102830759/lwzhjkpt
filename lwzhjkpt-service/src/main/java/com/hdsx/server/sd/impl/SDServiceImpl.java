package com.hdsx.server.sd.impl;

import com.hdsx.api.sd.service.SDService;
import com.hdsx.api.sd.vo.Sd;
import com.hdsx.server.sd.mapper.SDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by zhaod on 2017/4/14.
 */
@Service
@Transactional
public class SDServiceImpl implements SDService {
    @Autowired
    private SDMapper sdmapper;

    @Override
    public Sd queryOne(String sddm) {
        return sdmapper.queryOne(sddm);
    }

    @Override
    public List<Sd> queryList() {
        return sdmapper.queryList();
    }
}
