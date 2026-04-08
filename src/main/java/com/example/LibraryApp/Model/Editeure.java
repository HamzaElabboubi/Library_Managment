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
public class Editeure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long e_id;
    private String nom;
    private String adresse;

    @OneToMany(mappedBy = "editeure")
    private List<Livre> livres;

}
