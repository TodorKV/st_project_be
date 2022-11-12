package com.ft.mappers;

import com.ft.dto.ActionDto;
import com.ft.dto.ActionStatusDto;
import com.ft.dto.OrderDto;
import com.ft.dto.PhotoDto;
import com.ft.dto.ProductDto;
import com.ft.dto.SimpleCommentDto;
import com.ft.dto.SimpleUserDto;
import com.ft.dto.TenantDto;
import com.ft.entity.Action;
import com.ft.entity.ActionStatus;
import com.ft.entity.Comment;
import com.ft.entity.Order;
import com.ft.entity.Photo;
import com.ft.entity.Product;
import com.ft.entity.Tenant;
import com.ft.entity.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T10:56:42+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public Order fromDto(OrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( dto.getId() );
        order.setPriority( dto.getPriority() );
        order.setOrderNumber( dto.getOrderNumber() );
        order.setWhenToBeDone( dto.getWhenToBeDone() );
        order.setDescription( dto.getDescription() );
        order.setCompleted( dto.isCompleted() );
        order.setProduct( productDtoToProduct( dto.getProduct() ) );
        order.setPhotos( photoDtoSetToPhotoSet( dto.getPhotos() ) );
        order.setActionStatuses( actionStatusDtoSetToActionStatusSet( dto.getActionStatuses() ) );

        return order;
    }

    @Override
    public OrderDto toDto(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( entity.getId() );
        orderDto.setDescription( entity.getDescription() );
        orderDto.setOrderNumber( entity.getOrderNumber() );
        orderDto.setWhenToBeDone( entity.getWhenToBeDone() );
        orderDto.setPhotos( photoSetToPhotoDtoSet( entity.getPhotos() ) );
        orderDto.setProduct( productToProductDto( entity.getProduct() ) );
        orderDto.setPriority( entity.getPriority() );
        orderDto.setActionStatuses( actionStatusSetToActionStatusDtoSet( entity.getActionStatuses() ) );
        orderDto.setCompleted( entity.isCompleted() );

        return orderDto;
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

    protected Set<Action> actionDtoSetToActionSet(Set<ActionDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Action> set1 = new LinkedHashSet<Action>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ActionDto actionDto : set ) {
            set1.add( actionDtoToAction( actionDto ) );
        }

        return set1;
    }

    protected Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setDescription( productDto.getDescription() );
        product.setActions( actionDtoSetToActionSet( productDto.getActions() ) );

        return product;
    }

    protected Set<Photo> photoDtoSetToPhotoSet(Set<PhotoDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Photo> set1 = new LinkedHashSet<Photo>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PhotoDto photoDto : set ) {
            set1.add( photoMapper.fromDto( photoDto ) );
        }

        return set1;
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

    protected Set<ActionStatus> actionStatusDtoSetToActionStatusSet(Set<ActionStatusDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ActionStatus> set1 = new LinkedHashSet<ActionStatus>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ActionStatusDto actionStatusDto : set ) {
            set1.add( actionStatusDtoToActionStatus( actionStatusDto ) );
        }

        return set1;
    }

    protected Set<PhotoDto> photoSetToPhotoDtoSet(Set<Photo> set) {
        if ( set == null ) {
            return null;
        }

        Set<PhotoDto> set1 = new LinkedHashSet<PhotoDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Photo photo : set ) {
            set1.add( photoMapper.toDto( photo ) );
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

    protected Set<ActionDto> actionSetToActionDtoSet(Set<Action> set) {
        if ( set == null ) {
            return null;
        }

        Set<ActionDto> set1 = new LinkedHashSet<ActionDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Action action : set ) {
            set1.add( actionToActionDto( action ) );
        }

        return set1;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setActions( actionSetToActionDtoSet( product.getActions() ) );

        return productDto;
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

    protected ActionStatusDto actionStatusToActionStatusDto(ActionStatus actionStatus) {
        if ( actionStatus == null ) {
            return null;
        }

        ActionStatusDto actionStatusDto = new ActionStatusDto();

        actionStatusDto.setId( actionStatus.getId() );
        actionStatusDto.setTimeTakenState( actionStatus.getTimeTakenState() );
        actionStatusDto.setProgress( actionStatus.getProgress() );
        actionStatusDto.setComments( commentSetToSimpleCommentDtoSet( actionStatus.getComments() ) );
        actionStatusDto.setTimeBegin( actionStatus.getTimeBegin() );
        actionStatusDto.setTimeEnd( actionStatus.getTimeEnd() );
        actionStatusDto.setTenants( tenantSetToTenantDtoSet( actionStatus.getTenants() ) );
        actionStatusDto.setAction( actionToActionDto( actionStatus.getAction() ) );

        return actionStatusDto;
    }

    protected Set<ActionStatusDto> actionStatusSetToActionStatusDtoSet(Set<ActionStatus> set) {
        if ( set == null ) {
            return null;
        }

        Set<ActionStatusDto> set1 = new LinkedHashSet<ActionStatusDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ActionStatus actionStatus : set ) {
            set1.add( actionStatusToActionStatusDto( actionStatus ) );
        }

        return set1;
    }
}
