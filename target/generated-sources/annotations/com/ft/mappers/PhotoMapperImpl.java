package com.ft.mappers;

import com.ft.dto.PhotoDto;
import com.ft.entity.Photo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-12T10:56:40+0200",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
@Component
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public Photo fromDto(PhotoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Photo photo = new Photo();

        photo.setId( dto.getId() );
        photo.setPublicId( dto.getPublicId() );
        photo.setSecureUrl( dto.getSecureUrl() );
        photo.setCreatedAt( dto.getCreatedAt() );
        photo.setForCompletedProduct( dto.isForCompletedProduct() );

        return photo;
    }

    @Override
    public PhotoDto toDto(Photo entity) {
        if ( entity == null ) {
            return null;
        }

        PhotoDto photoDto = new PhotoDto();

        photoDto.setId( entity.getId() );
        photoDto.setPublicId( entity.getPublicId() );
        photoDto.setSecureUrl( entity.getSecureUrl() );
        photoDto.setCreatedAt( entity.getCreatedAt() );
        photoDto.setForCompletedProduct( entity.isForCompletedProduct() );

        return photoDto;
    }
}
