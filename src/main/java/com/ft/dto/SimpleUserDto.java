package com.ft.dto;

import com.ft.dto.base.BaseDto;
import lombok.*;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SimpleUserDto extends BaseDto {

    private String username;
}
