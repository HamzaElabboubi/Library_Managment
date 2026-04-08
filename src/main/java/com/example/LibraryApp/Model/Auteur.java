package com.example.LibraryApp.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int a_id;
    private String nom;
    private  String prenom;
    @OneToMany(mappedBy="auteur")
    private List<Livre> livres;
}
