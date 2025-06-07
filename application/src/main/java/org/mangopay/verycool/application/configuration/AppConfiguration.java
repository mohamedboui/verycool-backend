package org.mangopay.verycool.application.configuration;

import org.mangopay.verycool.core.domain.provider.IdeaProvider;
import org.mangopay.verycool.core.domain.provider.TagProvider;
import org.mangopay.verycool.core.service.IdeaUseCaseImpl;
import org.mangopay.verycool.core.service.TagUseCaseImpl;
import org.mangopay.verycool.core.usecase.IdeaUseCase;
import org.mangopay.verycool.core.usecase.TagUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    IdeaUseCase ideaUseCase(final IdeaProvider ideaProvider, final TagUseCase tagUseCase) {
        return new IdeaUseCaseImpl(ideaProvider, tagUseCase);
    }

    @Bean
    TagUseCase tagUseCase(TagProvider tagProvider) {
        return new TagUseCaseImpl(tagProvider);
    }
}
