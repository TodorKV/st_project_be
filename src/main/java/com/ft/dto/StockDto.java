package com.ft.dto;

import com.ft.dto.base.BaseDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class StockDto extends BaseDto {
    private String name;
    private int quantity;
    private String category;
}
