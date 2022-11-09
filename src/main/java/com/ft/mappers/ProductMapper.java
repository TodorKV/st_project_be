package com.ft.mappers;

import com.ft.dto.ProductDto;
import com.ft.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ActionMapper.class)
public interface ProductMapper extends BaseMapper<ProductDto, Product>{
    Product fromDto(ProductDto dto);
    ProductDto toDto(Product entity);
}
