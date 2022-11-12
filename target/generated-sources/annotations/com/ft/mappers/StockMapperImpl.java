package com.ft.mappers;

import com.ft.dto.StockDto;
import com.ft.entity.Stock;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T11:30:09+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class StockMapperImpl implements StockMapper {

    @Override
    public Stock fromDto(StockDto dto) {
        if ( dto == null ) {
            return null;
        }

        Stock stock = new Stock();

        stock.setId( dto.getId() );
        stock.setName( dto.getName() );
        stock.setQuantity( dto.getQuantity() );
        stock.setCategory( dto.getCategory() );

        return stock;
    }

    @Override
    public StockDto toDto(Stock entity) {
        if ( entity == null ) {
            return null;
        }

        StockDto stockDto = new StockDto();

        stockDto.setId( entity.getId() );
        stockDto.setName( entity.getName() );
        stockDto.setQuantity( entity.getQuantity() );
        stockDto.setCategory( entity.getCategory() );

        return stockDto;
    }
}
