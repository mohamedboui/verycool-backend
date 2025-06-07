package org.mangopay.verycool.application;

import org.mangopay.verycool.application.adapter.IdeaUseCaseAdapter;
import org.mangopay.verycool.application.adapter.TagUseCaseAdapter;
import org.mangopay.verycool.application.mapper.IdeaDTOMapper;
import org.mangopay.verycool.application.mapper.IdeaDTOMapperImpl;
import org.mangopay.verycool.application.mapper.TagDTOMapper;
import org.mangopay.verycool.application.mapper.TagDTOMapperImpl;
import org.mangopay.verycool.core.domain.provider.IdeaProvider;
import org.mangopay.verycool.core.domain.provider.TagProvider;
import org.mangopay.verycool.core.service.IdeaUseCaseImpl;
import org.mangopay.verycool.core.service.TagUseCaseImpl;
import org.mangopay.verycool.core.usecase.IdeaUseCase;
import org.mangopay.verycool.core.usecase.TagUseCase;
import org.mangopay.verycool.dataprovider.provider.InMemoryIdeaDatabaseProvider;
import org.mangopay.verycool.dataprovider.provider.InMemoryTagDatabaseProvider;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootConfiguration
public class AppTestConfiguration {
    @Bean
    IdeaProvider ideaProvider() {
        return new InMemoryIdeaDatabaseProvider();
    }

    @Bean
    TagProvider tagProvider() {
        return new InMemoryTagDatabaseProvider();
    }

    @Bean
    TagUseCase tagUseCaseImpl(final TagProvider tagProvider) {
        return new TagUseCaseImpl(tagProvider);
    }

    @Bean
    IdeaUseCase ideaUseCaseImpl(final IdeaProvider ideaProvider, TagUseCase tagUseCase) {
        return new IdeaUseCaseImpl(ideaProvider, tagUseCase);
    }

    @Bean
    IdeaDTOMapper ideaDTOMapper(){
        return new IdeaDTOMapperImpl();
    }

    @Bean
    IdeaUseCaseAdapter ideaUseCaseAdapter(final IdeaUseCase ideaUseCase, IdeaDTOMapper ideaDTOMapper) {
        return new IdeaUseCaseAdapter(ideaUseCase, ideaDTOMapper);
    }

    @Bean
    TagDTOMapper tagDTOMapper(){
        return new TagDTOMapperImpl();
    }

    @Bean
    TagUseCaseAdapter tagUseCaseAdapter(final TagUseCase ideaUseCase, TagDTOMapper tagDTOMapper) {
        return new TagUseCaseAdapter(ideaUseCase, tagDTOMapper);
    }

}