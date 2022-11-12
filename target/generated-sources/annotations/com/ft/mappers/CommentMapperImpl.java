package com.ft.mappers;

import com.ft.dto.ActionDto;
import com.ft.dto.ActionStatusDto;
import com.ft.dto.CommentDto;
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
    date = "2022-11-12T10:56:41+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment fromDto(CommentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( dto.getId() );
        comment.setTimeSent( dto.getTimeSent() );
        comment.setComment( dto.getComment() );
        comment.setActionStatus( actionStatusDtoToActionStatus( dto.getActionStatus() ) );
        comment.setTenant( tenantDtoToTenant( dto.getTenant() ) );

        return comment;
    }

    @Override
    public CommentDto toDto(Comment entity) {
        if ( entity == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId( entity.getId() );
        commentDto.setTimeSent( entity.getTimeSent() );
        commentDto.setComment( entity.getComment() );
        commentDto.setTenant( tenantToTenantDto( entity.getTenant() ) );

        return commentDto;
    }

    @Override
    public SimpleCommentDto toSimpleDto(Comment entity) {
        if ( entity == null ) {
            return null;
        }

        SimpleCommentDto simpleCommentDto = new SimpleCommentDto();

        simpleCommentDto.setId( entity.getId() );
        simpleCommentDto.setTimeSent( entity.getTimeSent() );
        simpleCommentDto.setComment( entity.getComment() );
        simpleCommentDto.setTenant( tenantToTenantDto( entity.getTenant() ) );

        return simpleCommentDto;
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

    protected ActionStatus actionStatusDtoToActionStatus(ActionStatusDto actionStatusDto) {
        if ( actionStatusDto == null ) {
            return null;
        }

        ActionStatus actionStatus = new ActionStatus();

        actionStatus.setId( actionStatusDto.getId() );
        actionStatus.setTimeBegin( actionStatusDto.getTimeBegin() );
        actionStatus.setTimeEnd( actionStatusDto.getTimeEnd() );
        actionStatus.setTimeTakenState( actionStatusDto.getTimeTakenState() );
        actionStatus.setProgress( actionStatusDto.getProgress() );
        actionStatus.setComments( simpleCommentDtoSetToCommentSet( actionStatusDto.getComments() ) );
        actionStatus.setAction( actionDtoToAction( actionStatusDto.getAction() ) );
        actionStatus.setTenants( tenantDtoSetToTenantSet( actionStatusDto.getTenants() ) );

        return actionStatus;
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
}
