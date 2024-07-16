package com.springbootacademy.batch7.pos.dto.request;

import com.springbootacademy.batch7.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemUpdateDTO {
        private int id;
        private String itemName;
        private double balanceQty;
        private double supplierPrice;
        private double sellingPrice;
}
