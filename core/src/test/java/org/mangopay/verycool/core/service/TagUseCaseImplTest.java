package org.mangopay.verycool.core.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mangopay.verycool.core.domain.model.Tag;
import org.mangopay.verycool.core.domain.provider.TagProvider;
import org.mangopay.verycool.core.exception.BusinessException;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TagUseCaseImplTest {
    @Mock
    private TagProvider tagProvider;
    @InjectMocks
    private TagUseCaseImpl tagUseCase;


    @Test
    void shouldCreateTag() {
        // Given
        Tag tag = new Tag("birthday");
        Mockito.when(tagProvider.findByName(anyString())).thenReturn(Optional.empty());
        Mockito.when(tagProvider.saveTag(any())).thenReturn(tag);

        // When
        tagUseCase.createTag(tag);

        // Then
        ArgumentCaptor<Tag> captor = ArgumentCaptor.forClass(Tag.class);
        verify(tagProvider).saveTag(captor.capture());

        Tag capturedTag = captor.getValue();
        assertEquals(capturedTag.getName(), tag.getName());

        verify(tagProvider, times(1)).findByName(anyString());
        verify(tagProvider, times(1)).saveTag(any());
    }

    @Test
    void shouldNotCreateTagIfExist() {
        // Given
        Tag tag = new Tag("birthday");
        Mockito.when(tagProvider.findByName(any())).thenReturn(Optional.of(tag));
        // When
        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> tagUseCase.createTag(tag)
        );

        // Then
        assertEquals("tag with name birthday is already exist", exception.getMessage());
    }
}
