package com.ft.mappers;

import com.ft.dto.StockDto;
import com.ft.entity.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper extends BaseMapper<StockDto, Stock> {
    Stock fromDto(StockDto dto);

    StockDto toDto(Stock entity);
}

