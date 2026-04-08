package com.example.LibraryApp.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long l_id;
    private String titre;
    private int pages;
    private LocalDate datepub;

    @ManyToOne
    private Auteur auteur;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
   private Editeure editeure;

}
