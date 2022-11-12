package com.ft.mappers;

import com.ft.dto.SimpleUserDto;
import com.ft.dto.TaskDto;
import com.ft.dto.TenantDto;
import com.ft.entity.Task;
import com.ft.entity.Tenant;
import com.ft.entity.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T11:30:09+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( dto.getId() );
        task.setWhenToBeDone( dto.getWhenToBeDone() );
        task.setDescription( dto.getDescription() );
        task.setCompleted( dto.isCompleted() );
        task.setTenants( tenantDtoSetToTenantSet( dto.getTenants() ) );

        return task;
    }

    @Override
    public TaskDto toDto(Task entity) {
        if ( entity == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setId( entity.getId() );
        taskDto.setDescription( entity.getDescription() );
        taskDto.setWhenToBeDone( entity.getWhenToBeDone() );
        taskDto.setCompleted( entity.isCompleted() );
        taskDto.setTenants( tenantSetToTenantDtoSet( entity.getTenants() ) );

        return taskDto;
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

    protected Tenant tenantDtoToTenant(TenantDto tenantDto) {
        if ( tenantDto == null ) {
            return null;
        }

        Tenant tenant = new Tenant();

        tenant.setId( tenantDto.getId() );
        tenant.setTenantValue( tenantDto.getTenantValue() );
        tenant.setUser( simpleUserDtoToUser( tenantDto.getUser() ) );

        return tenant;
    }

    protected Set<Tenant> tenantDtoSetToTenantSet(Set<TenantDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Tenant> set1 = new LinkedHashSet<Tenant>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TenantDto tenantDto : set ) {
            set1.add( tenantDtoToTenant( tenantDto ) );
        }

        return set1;
    }

    protected SimpleUserDto userToSimpleUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        SimpleUserDto simpleUserDto = new SimpleUserDto();

        simpleUserDto.setId( user.getId() );
        simpleUserDto.setUsername( user.getUsername() );

        return simpleUserDto;
    }

    protected TenantDto tenantToTenantDto(Tenant tenant) {
        if ( tenant == null ) {
            return null;
        }

        TenantDto tenantDto = new TenantDto();

        tenantDto.setId( tenant.getId() );
        tenantDto.setTenantValue( tenant.getTenantValue() );
        tenantDto.setUser( userToSimpleUserDto( tenant.getUser() ) );

        return tenantDto;
    }

    protected Set<TenantDto> tenantSetToTenantDtoSet(Set<Tenant> set) {
        if ( set == null ) {
            return null;
        }

        Set<TenantDto> set1 = new LinkedHashSet<TenantDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Tenant tenant : set ) {
            set1.add( tenantToTenantDto( tenant ) );
        }

        return set1;
    }
}
