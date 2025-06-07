package org.mangopay.verycool.dataprovider.provider;

import org.mangopay.verycool.core.domain.model.Idea;
import org.mangopay.verycool.core.domain.provider.IdeaProvider;
import org.mangopay.verycool.core.domain.provider.TagProvider;
import org.mangopay.verycool.dataprovider.mapper.IdeaMapper;
import org.mangopay.verycool.dataprovider.model.IdeaEntity;
import org.mangopay.verycool.dataprovider.repository.IdeaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class IdeaDatabaseProvider implements IdeaProvider {
    private final IdeaRepository ideaRepository;
    private final IdeaMapper ideaMapper;

    IdeaDatabaseProvider(IdeaRepository ideaRepository, TagProvider tagProvider, IdeaMapper ideaMapper) {
        this.ideaRepository = ideaRepository;
        this.ideaMapper = ideaMapper;
    }

    @Override
    public Optional<Idea> getIdea(Long ideaId) {
        return ideaRepository.findById(ideaId)
                .map(ideaMapper::toDomain);
    }

    @Override
    @Transactional
    public Idea saveIdea(Idea idea) {
        IdeaEntity ideaEntity = ideaRepository.save(ideaMapper.toJpaEntity(idea));
        return ideaMapper.toDomain(ideaEntity);
    }

    @Override
    public List<Idea> getAllIdeas() {
        List<IdeaEntity> allIdeas = ideaRepository.getAllIdeasWithTags();
        return allIdeas.stream()
                .map(ideaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteAll() {
        ideaRepository.deleteAll();
    }
}
