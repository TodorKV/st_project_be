package com.ft.mappers;

import com.ft.dto.SimpleUserDto;
import com.ft.dto.UserDto;
import com.ft.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T10:56:41+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private TenantMapper tenantMapper;

    @Override
    public User fromDto(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setUsername( dto.getUsername() );
        user.setRealname( dto.getRealname() );
        user.setPassword( dto.getPassword() );
        user.setRole( dto.getRole() );
        user.setTenant( tenantMapper.fromDto( dto.getTenant() ) );

        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setRealname( entity.getRealname() );
        userDto.setUsername( entity.getUsername() );
        userDto.setPassword( entity.getPassword() );
        userDto.setRole( entity.getRole() );
        userDto.setTenant( tenantMapper.toDto( entity.getTenant() ) );

        return userDto;
    }

    @Override
    public SimpleUserDto toSimpleDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        SimpleUserDto simpleUserDto = new SimpleUserDto();

        simpleUserDto.setId( entity.getId() );
        simpleUserDto.setUsername( entity.getUsername() );

        return simpleUserDto;
    }
}
