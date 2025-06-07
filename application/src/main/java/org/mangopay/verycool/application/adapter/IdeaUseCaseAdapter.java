package org.mangopay.verycool.application.adapter;

import org.mangopay.verycool.application.dto.IdeaDTO;
import org.mangopay.verycool.application.mapper.IdeaDTOMapper;
import org.mangopay.verycool.core.domain.model.Idea;
import org.mangopay.verycool.core.usecase.IdeaUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IdeaUseCaseAdapter {

    private final IdeaUseCase ideaUseCase;
    private final IdeaDTOMapper ideaDTOMapper;

    public IdeaUseCaseAdapter(IdeaUseCase ideaUseCase, IdeaDTOMapper ideaDTOMapper) {
        this.ideaUseCase = ideaUseCase;
        this.ideaDTOMapper = ideaDTOMapper;
    }
    public IdeaDTO createIdea(IdeaDTO ideaDTO) {
       Idea idea = ideaUseCase.createIdea(ideaDTOMapper.toDomain(ideaDTO));
       return ideaDTOMapper.toDto(idea);
    }

    public List<IdeaDTO> getAllIdeas() {
        return ideaUseCase.getAllIdeas().stream().map(ideaDTOMapper::toDto).toList();
    }
}
