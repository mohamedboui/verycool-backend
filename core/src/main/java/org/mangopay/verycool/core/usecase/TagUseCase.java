package org.mangopay.verycool.core.usecase;

import org.mangopay.verycool.core.domain.model.Tag;

import java.util.Optional;

public interface TagUseCase {
    Tag createTag(Tag tag);

    Optional<Tag> findByName(String tagLabel);
}
