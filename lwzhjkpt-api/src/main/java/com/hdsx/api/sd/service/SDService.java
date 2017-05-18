package com.hdsx.api.sd.service;



import com.hdsx.api.sd.vo.Sd;

import java.util.List;

/**
 * Created by zhaod on 2017/5/10.
 */
public interface SDService {

    Sd queryOne(String sddm);

    List<Sd> queryList();
}
