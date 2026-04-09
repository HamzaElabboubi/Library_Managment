package com.example.LibraryApp.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LivreDTO {

    private Long l_id;
    private String titre;
    private int pages;
    private LocalDate datepub;

    //on affiche seulement le nom et le prenom d'auteure pas tous l'objet
    private String auteurnom;
    private String auteurprenom;

    // ✅ On affiche juste le nom de la catégorie
    private String categorieNom;

    // ✅ On affiche juste le nom de l'éditeur
    private String editeurNom;
}
