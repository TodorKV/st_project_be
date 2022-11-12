package com.ft.mappers;

import com.ft.dto.SimpleUserDto;
import com.ft.dto.TenantDto;
import com.ft.entity.Tenant;
import com.ft.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T11:30:09+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class TenantMapperImpl implements TenantMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Tenant fromDto(TenantDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tenant tenant = new Tenant();

        tenant.setId( dto.getId() );
        tenant.setTenantValue( dto.getTenantValue() );
        tenant.setUser( simpleUserDtoToUser( dto.getUser() ) );

        return tenant;
    }

    @Override
    public TenantDto toDto(Tenant entity) {
        if ( entity == null ) {
            return null;
        }

        TenantDto tenantDto = new TenantDto();

        tenantDto.setId( entity.getId() );
        tenantDto.setTenantValue( entity.getTenantValue() );
        tenantDto.setUser( userMapper.toSimpleDto( entity.getUser() ) );

        return tenantDto;
    }

    protected User simpleUserDtoToUser(SimpleUserDto simpleUserDto) {
        if ( simpleUserDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( simpleUserDto.getId() );
        user.setUsername( simpleUserDto.getUsername() );

        return user;
    }
}
