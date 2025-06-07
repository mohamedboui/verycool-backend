package org.mangopay.verycool.core.domain.provider;

import org.mangopay.verycool.core.domain.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagProvider {
    Optional<Tag> findByName(String tagLabel);

    Tag saveTag(Tag tag);

    List<Tag> getAllTags();

    List<Tag> getTagsByIds(List<Long> tags);
}
