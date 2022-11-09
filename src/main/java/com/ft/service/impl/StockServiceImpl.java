package com.ft.service.impl;

import com.ft.dto.StockDto;
import com.ft.entity.Stock;
import com.ft.mappers.StockMapper;
import com.ft.repository.StockRepository;
import com.ft.service.base.StockService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl extends BaseServiceAbstrImpl<StockDto, Stock> implements StockService {
    private final StockRepository repository;
    private final StockMapper mapper;

    public StockServiceImpl(StockRepository repository,
                            StockMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        super.setMapper(mapper);
        super.setRepository(repository);
    }

    @Override
    public Page<StockDto> searchByNamePaginated(String name, Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }
}
