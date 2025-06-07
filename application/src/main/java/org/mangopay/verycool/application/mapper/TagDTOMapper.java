package org.mangopay.verycool.application.mapper;


import org.mangopay.verycool.application.dto.TagDTO;
import org.mangopay.verycool.core.domain.model.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagDTOMapper {
    Tag toDomain(TagDTO tagDto);
    TagDTO toDto(Tag tag);
}
