package com.ft.mappers;

import com.ft.dto.TaskDto;
import com.ft.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper  extends BaseMapper<TaskDto, Task> {
    Task fromDto(TaskDto dto);

    TaskDto toDto(Task entity);
}
