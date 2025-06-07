package org.mangopay.verycool.application.controller;

import org.mangopay.verycool.application.adapter.TagUseCaseAdapter;
import org.mangopay.verycool.application.dto.TagDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tags")
public class TagController {
    private final TagUseCaseAdapter tagUseCaseAdapter;

    public TagController(TagUseCaseAdapter tagUseCaseAdapter) {
        this.tagUseCaseAdapter = tagUseCaseAdapter;
    }

    @PostMapping
    public ResponseEntity<TagDTO> createTag(@RequestBody TagDTO tagDTO) {
        TagDTO newTagDTO = tagUseCaseAdapter.createTag(tagDTO);
        return new ResponseEntity<>(newTagDTO, HttpStatus.CREATED);
    }

}
