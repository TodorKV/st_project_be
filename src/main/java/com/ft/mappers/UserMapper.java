package com.ft.mappers;

import com.ft.dto.SimpleUserDto;
import com.ft.dto.UserDto;
import com.ft.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TenantMapper.class)
public interface UserMapper {
    User fromDto(UserDto dto);
    UserDto toDto(User entity);
    SimpleUserDto toSimpleDto(User entity);
}
