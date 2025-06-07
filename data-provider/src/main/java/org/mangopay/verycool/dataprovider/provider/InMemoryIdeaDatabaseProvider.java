package org.mangopay.verycool.dataprovider.provider;

import org.mangopay.verycool.core.domain.model.Idea;
import org.mangopay.verycool.core.domain.provider.IdeaProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryIdeaDatabaseProvider implements IdeaProvider {
    private final Map<Long, Idea> ideas = new HashMap<>();

    @Override
    public Idea saveIdea(Idea idea) {
        ideas.put(idea.getId(), idea);
        return idea;
    }

    @Override
    public List<Idea> getAllIdeas() {
        return ideas.values()
                .stream()
                .toList();
    }

    @Override
    public void deleteAll() {
        ideas.clear();
    }

    @Override
    public Optional<Idea> getIdea(Long ideaId) {
        return Optional.of(ideas.get(ideaId));
    }
}
