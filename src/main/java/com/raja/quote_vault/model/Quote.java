package com.raja.quote_vault.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "quotes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    @Id
    @Schema(hidden = true)
    private String id;

    @NotBlank
    private String content;

    @NotBlank
    private String author;

    @NotBlank
    private String category;

    @Schema(hidden = true)
    private LocalDateTime postingDateTime;
}
