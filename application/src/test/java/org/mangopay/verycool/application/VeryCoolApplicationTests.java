package org.mangopay.verycool.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mangopay.verycool.core.domain.provider.IdeaProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = AppTestConfiguration.class)
class VeryCoolApplicationTests {


    @Autowired
    private IdeaProvider ideaProvider;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(ideaProvider, "IdeaProvider should be injected");
    }

}
