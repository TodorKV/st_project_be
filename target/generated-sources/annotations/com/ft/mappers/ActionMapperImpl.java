package com.ft.mappers;

import com.ft.dto.ActionDto;
import com.ft.entity.Action;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T10:56:42+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class ActionMapperImpl implements ActionMapper {

    @Override
    public Action fromDto(ActionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Action action = new Action();

        action.setId( dto.getId() );
        action.setName( dto.getName() );
        action.setExpectedMinutes( dto.getExpectedMinutes() );
        action.setStep( dto.getStep() );

        return action;
    }

    @Override
    public ActionDto toDto(Action entity) {
        if ( entity == null ) {
            return null;
        }

        ActionDto actionDto = new ActionDto();

        actionDto.setId( entity.getId() );
        actionDto.setName( entity.getName() );
        actionDto.setExpectedMinutes( entity.getExpectedMinutes() );
        actionDto.setStep( entity.getStep() );

        return actionDto;
    }
}
