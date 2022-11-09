package com.ft.service.base;

import com.ft.dto.ActionDto;
import com.ft.dto.ActionStatusDto;
import com.ft.dto.OrderDto;

public interface ActionStatusService extends BaseService<ActionStatusDto> {
    ActionStatusDto save(ActionStatusDto dto, ActionDto actionDto, OrderDto orderDto);

    ActionStatusDto edit(Integer targetId, ActionStatusDto sourceDto);

    ActionStatusDto findById(Integer targetId);

    void deleteById(Integer id);
}
