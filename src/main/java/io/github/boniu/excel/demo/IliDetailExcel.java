package io.github.boniu.excel.demo;

import io.github.boniu.excel.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基本数据-内检测明细表
 *
 * @author Seven ME info@7-me.net
 * @since v1.0.0 2021-11-08
 */
public class IliDetailExcel {
    @Excel(name = "内检测明细表ID")
    private String id;
    @Excel(name = "内检测历史表ID")
    private String iliHistoryId;
    @Excel(name = "里程 m")
    private BigDecimal kp;
    @Excel(name = "特征类型")
    private String feature;
    @Excel(name = "尺寸类型", replace = {"PINH_9898"})
    private String dimension;
    @Excel(name = "周向")
    private Date orientation;
    @Excel(name = "缺陷深度 %")
    private BigDecimal depth;
    @Excel(name = "缺陷长度 mm")
    private BigDecimal length;
    @Excel(name = "缺陷宽度 mm")
    private BigDecimal width;
    @Excel(name = "内外指示", replace = {"INT_1", "EXT_0"}, isImport = true)
    private String isInternal;
    @Excel(name = "ERF")
    private BigDecimal erf;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIliHistoryId() {
        return iliHistoryId;
    }

    public void setIliHistoryId(String iliHistoryId) {
        this.iliHistoryId = iliHistoryId;
    }

    public BigDecimal getKp() {
        return kp;
    }

    public void setKp(BigDecimal kp) {
        this.kp = kp;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Date getOrientation() {
        return orientation;
    }

    public void setOrientation(Date orientation) {
        this.orientation = orientation;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public String getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(String isInternal) {
        this.isInternal = isInternal;
    }

    public BigDecimal getErf() {
        return erf;
    }

    public void setErf(BigDecimal erf) {
        this.erf = erf;
    }

    @Override
    public String toString() {
        return "IliDetailExcel{" +
                "id='" + id + '\'' +
                ", iliHistoryId='" + iliHistoryId + '\'' +
                ", kp=" + kp +
                ", feature='" + feature + '\'' +
                ", dimension='" + dimension + '\'' +
                ", orientation=" + orientation +
                ", depth=" + depth +
                ", length=" + length +
                ", width=" + width +
                ", isInternal='" + isInternal + '\'' +
                ", erf=" + erf +
                '}';
    }
}