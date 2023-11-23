package io.github.boniu.excel.demo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.UUID;

/**
 * 设备总表
 *
 * @author Seven ME info@7-me.net
 * @since v1.0.0 2023-06-15
 */
public class EquipmentExcelWg {
    private String id;
    private String facilityId;

    private String xbdEquipmentType;

    @ExcelProperty(index = 1)
    private String equipmentCode;

    @ExcelProperty(index = 2)
    private String equipmentName;

    // private String xeqBusinessPhase;
    // private LocalDateTime productionDate;

    @ExcelProperty(index = 6)
    private String manufacturer;
    @ExcelProperty(index = 7)
    private String model;

    // private String skidManufacturer;
    // private String specification;
    // private LocalDateTime createTime;
    // private LocalDateTime updateTime;
    // private String createBy;
    // private String updateBy;
    // private Integer delFlag;


    @Override
    public String toString() {
        return "EquipmentExcel{" +
                "id='" + id + '\'' +
                ", facilityId='" + facilityId + '\'' +
                ", xbdEquipmentType='" + xbdEquipmentType + '\'' +
                ", equipmentCode='" + equipmentCode + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFacilityId() {
        return facilityId;
    }



    public String getXbdEquipmentType() {
        return xbdEquipmentType;
    }

    public void setXbdEquipmentType(String xbdEquipmentType) {
        this.xbdEquipmentType = xbdEquipmentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
