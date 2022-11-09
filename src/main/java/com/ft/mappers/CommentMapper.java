package com.ft.mappers;

import com.ft.dto.CommentDto;
import com.ft.dto.SimpleCommentDto;
import com.ft.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper extends BaseMapper<CommentDto, Comment> {
    Comment fromDto(CommentDto dto);

    @Mapping(target = "actionStatus", ignore = true )
    CommentDto toDto(Comment entity);

    SimpleCommentDto toSimpleDto(Comment entity);
}
