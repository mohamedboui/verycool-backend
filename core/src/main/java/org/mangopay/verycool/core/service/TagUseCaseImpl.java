package org.mangopay.verycool.core.service;

import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.core.domain.provider.TagProvider;
import org.mangopay.verycool.core.exception.BusinessException;
import org.mangopay.verycool.core.usecase.TagUseCase;

import java.util.Optional;

public class TagUseCaseImpl implements TagUseCase {
    private final TagProvider tagProvider;

    public TagUseCaseImpl(TagProvider tagProvider) {
        this.tagProvider = tagProvider;
    }

    @Override
    public Tag createTag(Tag tag) {
        if (findByName(tag.getName()).isPresent()) {
            throw new BusinessException(String.format("tag with name %s is already exist", tag.getName()));
        }
        return saveTag(tag);
    }

    private Tag saveTag(Tag tag) {
        return tagProvider.saveTag(tag);
    }

    @Override
    public Optional<Tag> findByName(String tagLabel) {
        return tagProvider.findByName(tagLabel);
    }
}