package com.example.LibraryApp.DTO;

import lombok.Data;

import java.util.List;


@Data
public class EditeureDTO {

    private Long e_id;
    private String nom;
    private String adresse;
    private List<String> titreLivre;
}
