package org.mangopay.verycool.application.adapter;

import org.mangopay.verycool.application.dto.TagDTO;
import org.mangopay.verycool.application.mapper.TagDTOMapper;
import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.core.usecase.TagUseCase;
import org.springframework.stereotype.Component;

@Component
public class TagUseCaseAdapter {
    private final TagUseCase tagUseCase;
    private final TagDTOMapper tagDTOMapper;

    public TagUseCaseAdapter(TagUseCase tagUseCase, TagDTOMapper tagDTOMapper) {
        this.tagUseCase = tagUseCase;
        this.tagDTOMapper = tagDTOMapper;
    }

    public TagDTO createTag(TagDTO tagDTO) {
        Tag tag = tagUseCase.createTag(tagDTOMapper.toDomain(tagDTO));
        return tagDTOMapper.toDto(tag);
    }
}
