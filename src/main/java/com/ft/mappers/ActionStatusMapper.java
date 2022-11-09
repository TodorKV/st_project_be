package com.ft.mappers;

import com.ft.dto.ActionStatusDto;
import com.ft.entity.ActionStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActionStatusMapper extends BaseMapper<ActionStatusDto, ActionStatus> {
    ActionStatus fromDto(ActionStatusDto dto);

    ActionStatusDto toDto(ActionStatus entity);
}
