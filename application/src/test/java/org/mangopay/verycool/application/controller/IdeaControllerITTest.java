package org.mangopay.verycool.application.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mangopay.verycool.application.AppTestConfiguration;
import org.mangopay.verycool.application.dto.IdeaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureRestDocs
@ContextConfiguration(classes = AppTestConfiguration.class)
@Import(IdeaController.class)
public class IdeaControllerITTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldCreateIdea() throws Exception {
        createIdea()
                .andExpect(status().isCreated())
                .andExpect(jsonPath("title", is("The title of the idea")))
                .andExpect(jsonPath("description", is("The description of the idea")))
                .andExpect(jsonPath("tags", hasSize(3)))
                .andExpect(jsonPath("tags[0].name", is("first-tag")))
                .andExpect(jsonPath("tags[1].name", is("second-tag")))
                .andExpect(jsonPath("tags[2].name", is("third-tag")));
    }

    private ResultActions createIdea() throws Exception {
        String payload = """
                {
                  "title": "The title of the idea",
                  "description": "The description of the idea",
                  "tags": [
                    {
                      "name": "first-tag"
                    },
                    {
                      "name": "second-tag"
                    },
                    {
                      "name": "third-tag"
                    }
                  ]
                }""";
        return this.mvc.perform(post("/api/ideas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        );
    }


    @Test
    void shouldFindAllIdeas() throws Exception {
        String ideaAsJson = createIdea().andReturn()
                .getResponse()
                .getContentAsString();
        IdeaDTO idea = objectMapper.readValue(ideaAsJson, IdeaDTO.class);
        this.mvc.perform(get("/api/ideas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("The title of the idea")))
                .andExpect(jsonPath("$[0].description", is("The description of the idea")))
                .andExpect(jsonPath("$[0].tags", isA(List.class)))
                .andExpect(jsonPath("$[0].tags[0].name", is("first-tag")))
                .andExpect(jsonPath("$[0].tags[0].id", is(idea
                        .getTags()
                        .stream().findFirst().get()
                        .getId())));
    }

}