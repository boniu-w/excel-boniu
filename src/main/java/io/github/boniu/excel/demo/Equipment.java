package io.github.boniu.excel.demo;

import com.alibaba.excel.annotation.ExcelProperty;

/************************************************************************
 * author: wg
 * description: Equipment 
 * createTime: 14:56 2023/11/23
 * updateTime: 14:56 2023/11/23
 ************************************************************************/
public class Equipment {

    @ExcelProperty(index = 1)
    private String equipmentCode;



    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentCode='" + equipmentCode + '\'' +
                '}';
    }
}
