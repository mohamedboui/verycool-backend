package org.mangopay.verycool.dataprovider.mapper;

import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.dataprovider.model.TagEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagEntity toJpaEntity(Tag tag);

    Tag toDomain(TagEntity tagEntity);
}
