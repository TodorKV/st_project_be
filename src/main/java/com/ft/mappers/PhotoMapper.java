package com.ft.mappers;

import com.ft.dto.PhotoDto;
import com.ft.entity.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhotoMapper extends BaseMapper<PhotoDto, Photo> {
    Photo fromDto(PhotoDto dto);

    PhotoDto toDto(Photo entity);
}
