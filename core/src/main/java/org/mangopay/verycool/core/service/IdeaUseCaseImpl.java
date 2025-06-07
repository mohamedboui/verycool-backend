package org.mangopay.verycool.core.service;

import org.mangopay.verycool.core.domain.model.Idea;
import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.core.domain.provider.IdeaProvider;
import org.mangopay.verycool.core.usecase.IdeaUseCase;
import org.mangopay.verycool.core.usecase.TagUseCase;

import java.util.List;

public class IdeaUseCaseImpl implements IdeaUseCase {
    private final IdeaProvider ideaProvider;
    private final TagUseCase tagUseCase;

    public IdeaUseCaseImpl(IdeaProvider ideaProvider, TagUseCase tagUseCase) {
        this.ideaProvider = ideaProvider;
        this.tagUseCase = tagUseCase;
    }

    @Override
    public Idea createIdea(Idea idea) {
        List<Tag> savedTags = idea.getTags()
                .stream()
                .map(tagUseCase::createTag)
                .toList();
        Idea ideaToSave = new Idea(idea.getTitle(), idea.getDescription(), savedTags);
        return ideaProvider.saveIdea(ideaToSave);
    }

    @Override
    public List<Idea> getAllIdeas() {
        return ideaProvider.getAllIdeas();
    }
}
