package org.mangopay.verycool.core.usecase;

import org.mangopay.verycool.core.domain.model.Idea;

import java.util.List;

public interface IdeaUseCase {
    Idea createIdea(Idea idea);

    List<Idea> getAllIdeas();
}
