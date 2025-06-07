package org.mangopay.verycool.dataprovider.mapper;

import org.mangopay.verycool.core.domain.model.Idea;
import org.mangopay.verycool.dataprovider.model.IdeaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TagMapper.class})
public interface IdeaMapper {
    @Mapping(target = "tags", source = "tags")
    IdeaEntity toJpaEntity(Idea idea);

    @Mapping(target = "tags", source = "tags")
    Idea toDomain(IdeaEntity ideaEntity);
}
