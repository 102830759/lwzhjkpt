package com.hdsx.api.sd.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class Sd implements Serializable {
    private static final long serialVersionUID = 4018794664498110340L;
    /**
     * 唯一标识
     */
    @ApiModelProperty(value = "")
    private String id;
    /**
     * 隧道代码
     */
    @ApiModelProperty(value = "隧道代码")
    private String sddm;
    /**
     * 隧道名称
     */
    @ApiModelProperty(value = "隧道名称")
    private String sdmc;

    private String roadcode;
    private String roadname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSddm() {
        return sddm;
    }

    public void setSddm(String sddm) {
        this.sddm = sddm;
    }

    public String getSdmc() {
        return sdmc;
    }

    public void setSdmc(String sdmc) {
        this.sdmc = sdmc;
    }

    public String getRoadcode() {
        return roadcode;
    }

    public void setRoadcode(String roadcode) {
        this.roadcode = roadcode;
    }

    public String getRoadname() {
        return roadname;
    }

    public void setRoadname(String roadname) {
        this.roadname = roadname;
    }

    @Override
    public String toString() {
        return "Sd{" +
                "id='" + id + '\'' +
                ", sddm='" + sddm + '\'' +
                ", sdmc='" + sdmc + '\'' +
                ", roadcode='" + roadcode + '\'' +
                ", roadname='" + roadname + '\'' +
                '}';
    }
}

