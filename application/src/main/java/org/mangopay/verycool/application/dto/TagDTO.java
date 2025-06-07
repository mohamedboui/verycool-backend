package org.mangopay.verycool.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TagDTO {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

}
