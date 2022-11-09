package com.ft.mappers;

import com.ft.dto.base.BaseDto;
import com.ft.entity.base.BaseEntity;

public interface BaseMapper <D extends BaseDto, E extends BaseEntity> {
    E fromDto(D dto);
    D toDto(E entity);
}
