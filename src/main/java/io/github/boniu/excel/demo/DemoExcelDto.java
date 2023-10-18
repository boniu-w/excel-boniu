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

    @ExcelProperty(value = "序号", order = 4)
    private String xuHao;

    @ExcelProperty(value = "备注", order = 4)
    private String remark;

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
                ", remark='" + remark + '\'' +
                '}';
    }
}