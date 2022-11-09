package com.ft.mappers;

import com.ft.dto.ActionDto;
import com.ft.entity.Action;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActionMapper extends BaseMapper<ActionDto, Action> {
    Action fromDto(ActionDto dto);

    ActionDto toDto(Action entity);
}
