package com.ft.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ft.dto.base.BaseDto;
import lombok.*;

import java.util.Date;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto extends BaseDto {

    private String publicId;
    private String secureUrl;
    private Date createdAt;
    private boolean isForCompletedProduct;
}
