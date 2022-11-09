package com.ft.dto;

import com.ft.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CommentDto extends BaseDto {
    private String timeSent;
    private String comment;
    private ActionStatusDto actionStatus;
    private TenantDto tenant;
}
