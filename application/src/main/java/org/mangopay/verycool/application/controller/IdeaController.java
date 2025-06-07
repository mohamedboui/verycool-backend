package org.mangopay.verycool.application.controller;

import org.mangopay.verycool.application.adapter.IdeaUseCaseAdapter;
import org.mangopay.verycool.application.dto.IdeaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/ideas")
@RequestMapping(path = "/ideas")
public class IdeaController {
    private final IdeaUseCaseAdapter ideaUseCaseAdapter;

    public IdeaController(IdeaUseCaseAdapter ideaUseCaseAdapter) {
        this.ideaUseCaseAdapter = ideaUseCaseAdapter;
    }

    @PostMapping
    public ResponseEntity<IdeaDTO> createIdea(@RequestBody IdeaDTO ideaDTO) {
        IdeaDTO newIdeaDTO = ideaUseCaseAdapter.createIdea(ideaDTO);
        return new ResponseEntity<>(newIdeaDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IdeaDTO>> getAllIdeas() {
        return new ResponseEntity<>(ideaUseCaseAdapter.getAllIdeas(), HttpStatus.OK);
    }
}
