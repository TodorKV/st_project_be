package com.ft.mappers;

import com.ft.dto.ActionDto;
import com.ft.dto.ActionStatusDto;
import com.ft.dto.SimpleCommentDto;
import com.ft.dto.SimpleUserDto;
import com.ft.dto.TenantDto;
import com.ft.entity.Action;
import com.ft.entity.ActionStatus;
import com.ft.entity.Comment;
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
public class ActionStatusMapperImpl implements ActionStatusMapper {

    @Override
    public ActionStatus fromDto(ActionStatusDto dto) {
        if ( dto == null ) {
            return null;
        }

        ActionStatus actionStatus = new ActionStatus();

        actionStatus.setId( dto.getId() );
        actionStatus.setTimeBegin( dto.getTimeBegin() );
        actionStatus.setTimeEnd( dto.getTimeEnd() );
        actionStatus.setTimeTakenState( dto.getTimeTakenState() );
        actionStatus.setProgress( dto.getProgress() );
        actionStatus.setComments( simpleCommentDtoSetToCommentSet( dto.getComments() ) );
        actionStatus.setAction( actionDtoToAction( dto.getAction() ) );
        actionStatus.setTenants( tenantDtoSetToTenantSet( dto.getTenants() ) );

        return actionStatus;
    }

    @Override
    public ActionStatusDto toDto(ActionStatus entity) {
        if ( entity == null ) {
            return null;
        }

        ActionStatusDto actionStatusDto = new ActionStatusDto();

        actionStatusDto.setId( entity.getId() );
        actionStatusDto.setTimeTakenState( entity.getTimeTakenState() );
        actionStatusDto.setProgress( entity.getProgress() );
        actionStatusDto.setComments( commentSetToSimpleCommentDtoSet( entity.getComments() ) );
        actionStatusDto.setTimeBegin( entity.getTimeBegin() );
        actionStatusDto.setTimeEnd( entity.getTimeEnd() );
        actionStatusDto.setTenants( tenantSetToTenantDtoSet( entity.getTenants() ) );
        actionStatusDto.setAction( actionToActionDto( entity.getAction() ) );

        return actionStatusDto;
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

    protected Comment simpleCommentDtoToComment(SimpleCommentDto simpleCommentDto) {
        if ( simpleCommentDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( simpleCommentDto.getId() );
        comment.setTimeSent( simpleCommentDto.getTimeSent() );
        comment.setComment( simpleCommentDto.getComment() );
        comment.setTenant( tenantDtoToTenant( simpleCommentDto.getTenant() ) );

        return comment;
    }

    protected Set<Comment> simpleCommentDtoSetToCommentSet(Set<SimpleCommentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Comment> set1 = new LinkedHashSet<Comment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( SimpleCommentDto simpleCommentDto : set ) {
            set1.add( simpleCommentDtoToComment( simpleCommentDto ) );
        }

        return set1;
    }

    protected Action actionDtoToAction(ActionDto actionDto) {
        if ( actionDto == null ) {
            return null;
        }

        Action action = new Action();

        action.setId( actionDto.getId() );
        action.setName( actionDto.getName() );
        action.setExpectedMinutes( actionDto.getExpectedMinutes() );
        action.setStep( actionDto.getStep() );

        return action;
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

    protected SimpleCommentDto commentToSimpleCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        SimpleCommentDto simpleCommentDto = new SimpleCommentDto();

        simpleCommentDto.setId( comment.getId() );
        simpleCommentDto.setTimeSent( comment.getTimeSent() );
        simpleCommentDto.setComment( comment.getComment() );
        simpleCommentDto.setTenant( tenantToTenantDto( comment.getTenant() ) );

        return simpleCommentDto;
    }

    protected Set<SimpleCommentDto> commentSetToSimpleCommentDtoSet(Set<Comment> set) {
        if ( set == null ) {
            return null;
        }

        Set<SimpleCommentDto> set1 = new LinkedHashSet<SimpleCommentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Comment comment : set ) {
            set1.add( commentToSimpleCommentDto( comment ) );
        }

        return set1;
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

    protected ActionDto actionToActionDto(Action action) {
        if ( action == null ) {
            return null;
        }

        ActionDto actionDto = new ActionDto();

        actionDto.setId( action.getId() );
        actionDto.setName( action.getName() );
        actionDto.setExpectedMinutes( action.getExpectedMinutes() );
        actionDto.setStep( action.getStep() );

        return actionDto;
    }
}
