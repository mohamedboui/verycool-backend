package org.mangopay.verycool.core.domain.provider;

import org.mangopay.verycool.core.domain.model.Idea;

import java.util.List;
import java.util.Optional;

public interface IdeaProvider {
    Optional<Idea> getIdea(Long ideaId);

    Idea saveIdea(Idea idea);

    List<Idea> getAllIdeas();

    void deleteAll();
}
