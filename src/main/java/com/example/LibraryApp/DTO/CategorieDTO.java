package com.example.LibraryApp.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CategorieDTO {

    private Long c_id;
    private String name;
    private List<String> titreLivres;
}
