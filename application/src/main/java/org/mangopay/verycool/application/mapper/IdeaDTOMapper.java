package org.mangopay.verycool.application.mapper;

import org.mangopay.verycool.core.domain.model.Idea;
import org.mapstruct.Mapper;
import org.mangopay.verycool.application.dto.IdeaDTO;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TagDTOMapper.class})
public interface IdeaDTOMapper {
    @Mapping(target = "tags", source = "tags")
    Idea toDomain(IdeaDTO ideaDto);

    @Mapping(target = "tags", source = "tags")
    IdeaDTO toDto(Idea idea);
}
