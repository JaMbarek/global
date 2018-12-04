package com.cloud.mvc.example.business.system;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bean {

    private BigDecimal entrustCount;
    private BigDecimal entrustPrice;
    private BigDecimal entrustAmount;

    private Integer entrustType;
    private Integer marketId;
    private Integer type;
    private String dealPassword;


}
