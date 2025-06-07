package org.mangopay.verycool.dataprovider.provider;

import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.core.domain.provider.TagProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryTagDatabaseProvider implements TagProvider {
    Map<Long, Tag> tags = new HashMap<>();

    @Override
    public Optional<Tag> findByName(String tagLabel) {
        return tags.values()
                .stream()
                .filter(tag -> tag.getName().equals(tagLabel))
                .findFirst();
    }

    @Override
    public Tag saveTag(Tag tag) {
        tags.put(tag.getId(), tag);
        return tag;
    }

    @Override
    public List<Tag> getAllTags() {
        return tags.values()
                .stream()
                .toList();
    }

    @Override
    public List<Tag> getTagsByIds(List<Long> tags) {
        return this.tags.entrySet()
                .stream()
                .filter(entry -> tags.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }


}
