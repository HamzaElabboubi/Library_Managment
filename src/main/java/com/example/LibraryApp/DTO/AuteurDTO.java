package com.example.LibraryApp.DTO;


import com.example.LibraryApp.Model.Livre;
import lombok.Data;

import java.util.List;


@Data
public class AuteurDTO {
        private Long a_id;
        private String nom;
        private String prenom;
        private List<String> titreLivre;

    }
