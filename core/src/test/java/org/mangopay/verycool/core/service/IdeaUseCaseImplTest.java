package org.mangopay.verycool.core.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mangopay.verycool.core.domain.model.Idea;
import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.core.domain.provider.IdeaProvider;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IdeaUseCaseImplTest {

    @Mock
    private IdeaProvider ideaProvider;
    @Mock
    private TagUseCaseImpl tagService;
    @InjectMocks
    private IdeaUseCaseImpl ideaUseCase;


    @Test
    void shouldCreateIdea() {
        // Given
        Idea idea = new Idea("Title idea", "Description idea",
                Collections.emptyList());
        when(ideaProvider.saveIdea(any())).thenReturn(idea);
        // When
        idea = ideaUseCase.createIdea(idea);
        // Then
        ArgumentCaptor<Idea> captor = ArgumentCaptor.forClass(Idea.class);
        verify(ideaProvider).saveIdea(captor.capture());
        verifyNoInteractions(tagService);

        Idea capturedIdea = captor.getValue();
        verify(ideaProvider, times(1)).saveIdea(any());
        assertEquals(capturedIdea.getTitle(), idea.getTitle());
    }

    @Test
    void shouldRetrieveAllIdeas() {
        // Given
        List<Idea> listIdeas = List.of(new Idea("Title idea", "Description idea", Collections.emptyList()), new Idea("Title of the second idea", "Description of the second idea", Collections.emptyList()));
        when(ideaProvider.getAllIdeas()).thenReturn(listIdeas);
        // When
        List<Idea> ideas = ideaUseCase.getAllIdeas();
        // Then
        assertThat(ideas).hasSize(2);
    }

    @Test
    void shouldCreateNewTag() {
        // Given
        Idea idea = new Idea("Title idea", "Description idea", Stream.of("first-tag", "second-tag", "third-tag")
                .map(Tag::new)
                .toList());
        // When
        ideaUseCase.createIdea(idea);
        // Then
        verify(tagService, times(3)).createTag(any());
    }

}
