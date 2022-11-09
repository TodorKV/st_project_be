package com.ft.mappers;

import com.ft.dto.OrderDto;
import com.ft.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PhotoMapper.class)
public interface OrderMapper extends BaseMapper<OrderDto, Order> {
    Order fromDto(OrderDto dto);

    OrderDto toDto(Order entity);
}
