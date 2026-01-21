package io.github.boniu.excel.demo;


import cn.hutool.core.annotation.Alias;
import lombok.Data;

import java.io.Serializable;

/************************************************************************
 * author: wg
 * description: Haiyouguoji 
 * createTime: 16:30 2023/5/10
 * updateTime: 16:30 2023/5/10
 ************************************************************************/
@Data
public class HaiyouguojiExcel implements Serializable {
    
    @Alias(value = "所属页面")
    private String pageName;
    
    @Alias(value = "字段中文")
    private String field;
    
    @Alias(value = "字段英文")
    private String fieldEn;
    
    @Alias(value = "数据类型")
    private String fieldType;
    
    @Alias(value = "长度")
    private String length;
    
    @Alias(value = "数据表")
    private String dataTable;
    
    @Alias(value = "位数")
    private String bitLength;
    
    @Alias(value = "单位")
    private String unit;
    
    @Alias(value = "关系")
    private String relationShip;
    
    @Alias(value = "来源数据")
    private String source;
    //
    // private String dataIndex;
}
