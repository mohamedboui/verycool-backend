package org.mangopay.verycool.dataprovider.provider;

import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.core.domain.provider.TagProvider;
import org.mangopay.verycool.dataprovider.mapper.TagMapper;
import org.mangopay.verycool.dataprovider.model.TagEntity;
import org.mangopay.verycool.dataprovider.repository.TagRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class TagDatabaseProvider implements TagProvider {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    TagDatabaseProvider(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public Optional<Tag> findByName(String tagLabel) {
        return tagRepository.findByName(tagLabel)
                .map(tagMapper::toDomain);
    }

    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
       TagEntity tagEntity =  tagRepository.save(tagMapper.toJpaEntity(tag));
       return tagMapper.toDomain(tagEntity);
    }

    @Override
    public List<Tag> getAllTags() {
        return List.of();
    }

    @Override
    public List<Tag> getTagsByIds(List<Long> tagIds) {
        return tagRepository.findAllById(tagIds)
                .stream()
                .map(tagMapper::toDomain)
                .toList();
    }
}
