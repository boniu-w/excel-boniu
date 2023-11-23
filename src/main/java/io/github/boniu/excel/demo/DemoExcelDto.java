package io.github.boniu.excel.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.boniu.excel.util.ExcelPropertyCheck;
import io.github.boniu.excel.util.ExcelPropertyType;

import java.time.LocalDate;

@ExcelPropertyCheck
public class DemoExcelDto {
    @ExcelProperty("id")
    @ExcelPropertyCheck(required = false)
    private Long id;         //记录标识

    @ExcelProperty("导入时间")
    @ExcelPropertyCheck(required = true, checkFormat = true, type = ExcelPropertyType.LOCAL_DATE)
    private LocalDate importTime;

    @ExcelProperty(value = "序号")
    @ExcelPropertyCheck(required = true)
    private String xuHao;

    @ExcelProperty(value = "所属海外资产")
    private String assetName;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "本月事件发生数量")
    private Integer numberCurrentMonth;

    @ExcelProperty(value = "上月事件发生数量")
    private Integer numberLastMonth;

    public Integer getNumberLastMonth() {
        return numberLastMonth;
    }

    public void setNumberLastMonth(Integer numberLastMonth) {
        this.numberLastMonth = numberLastMonth;
    }

    public Integer getNumberCurrentMonth() {
        return numberCurrentMonth;
    }

    public void setNumberCurrentMonth(Integer numberCurrentMonth) {
        this.numberCurrentMonth = numberCurrentMonth;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getImportTime() {
        return importTime;
    }

    public void setImportTime(LocalDate importTime) {
        this.importTime = importTime;
    }

    public String getXuHao() {
        return xuHao;
    }

    public void setXuHao(String xuHao) {
        this.xuHao = xuHao;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "DemoExcelDto{" +
                "id=" + id +
                ", importTime=" + importTime +
                ", xuHao='" + xuHao + '\'' +
                ", assetName='" + assetName + '\'' +
                ", remark='" + remark + '\'' +
                ", numberCurrentMonth=" + numberCurrentMonth +
                ", numberLastMonth=" + numberLastMonth +
                '}';
    }
}