package org.mangopay.verycool.application.controller;


import org.junit.jupiter.api.Test;
import org.mangopay.verycool.application.AppTestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureRestDocs
@ContextConfiguration(classes = AppTestConfiguration.class)
@Import(TagController.class)
public class TagControllerITTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldCreateTag() throws Exception {
        createTag()
                .andExpect(status().isCreated())
                .andExpect(jsonPath("name", is("The name of the tag")));
    }

    private ResultActions createTag() throws Exception {
        String payload = """
                {
                  "name": "The name of the tag"
                }
                """;
        return this.mvc.perform(post("/tags")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        );
    }


}