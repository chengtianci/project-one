package org.chengtc.TTJJcrawler.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FundBaseInfoDto {
    @ExcelProperty(value = "基金名称", index = 0)
    private String name;
    @ExcelProperty(value = "基金代码", index = 1)
    private String code;
    @ExcelProperty(value = "跟踪误差率（%）", index = 2)
    private String trackingError;
    @ExcelProperty(value = "规模（亿）", index = 3)
    private String scale;
    @ExcelProperty(value = "成立时间", index = 4)
    private String establishYear;
    @ExcelProperty(value = "成立年限（年）", index = 5)
    private String establishDuringYear;
    @ExcelProperty(value = "管理费用率（%）", index = 6)
    private String managementRate;
    @ExcelProperty(value = "托管费用率（%）", index = 7)
    private String custodyFeeRate;
    @ExcelProperty(value = "费率合计（%）", index = 8)
    private String totaRate;
    @ExcelProperty(value = "交易方式", index = 9)
    private String transactionMode;
}
