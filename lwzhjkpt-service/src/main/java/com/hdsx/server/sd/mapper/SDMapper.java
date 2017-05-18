package com.hdsx.server.sd.mapper;


import com.hdsx.api.sd.vo.Sd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhaod on 2017/4/14.
 */

public interface SDMapper {
    Sd queryOne(@Param("sddm") String sddm);
    List<Sd> queryList();
}
