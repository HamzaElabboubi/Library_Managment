package com.example.LibraryApp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LivreCreateDTO {

    private String titre;

    private int pages;
    private LocalDate datepub;

    // ✅ Le client envoie juste les IDs des relations
    @NotNull(message = "L'auteur est obligatoire")
    private Long auteurId;

    @NotNull(message = "La catégorie est obligatoire")
    private Long categorieId;

    @NotNull(message = "L'éditeur est obligatoire")
    private Long editeurId;
}