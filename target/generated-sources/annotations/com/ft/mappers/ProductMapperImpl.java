package com.ft.mappers;

import com.ft.dto.ActionDto;
import com.ft.dto.ProductDto;
import com.ft.entity.Action;
import com.ft.entity.Product;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T10:56:41+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private ActionMapper actionMapper;

    @Override
    public Product fromDto(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setName( dto.getName() );
        product.setDescription( dto.getDescription() );
        product.setActions( actionDtoSetToActionSet( dto.getActions() ) );

        return product;
    }

    @Override
    public ProductDto toDto(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( entity.getId() );
        productDto.setName( entity.getName() );
        productDto.setDescription( entity.getDescription() );
        productDto.setActions( actionSetToActionDtoSet( entity.getActions() ) );

        return productDto;
    }

    protected Set<Action> actionDtoSetToActionSet(Set<ActionDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Action> set1 = new LinkedHashSet<Action>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ActionDto actionDto : set ) {
            set1.add( actionMapper.fromDto( actionDto ) );
        }

        return set1;
    }

    protected Set<ActionDto> actionSetToActionDtoSet(Set<Action> set) {
        if ( set == null ) {
            return null;
        }

        Set<ActionDto> set1 = new LinkedHashSet<ActionDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Action action : set ) {
            set1.add( actionMapper.toDto( action ) );
        }

        return set1;
    }
}
