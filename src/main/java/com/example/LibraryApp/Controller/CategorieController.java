package com.example.LibraryApp.Controller;


import com.example.LibraryApp.DTO.CategorieDTO;
import com.example.LibraryApp.Model.Categorie;
import com.example.LibraryApp.Services.CategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorie")
public class CategorieController {

    @Autowired CategoriService categoriService;

    @PostMapping
    public CategorieDTO creatCategori(@RequestBody CategorieDTO dto){
        return  categoriService.creatCategorie(dto);
    }

    @GetMapping
    public List<CategorieDTO> getallCategorie(){
        return categoriService.getAllCategorie();
    }

    @GetMapping("/{id}")
    public CategorieDTO getCategorie(@PathVariable Long id){
        return categoriService.getCategorie(id);
    }

    @PutMapping("/{id}")
    public CategorieDTO updateCategorie(@PathVariable Long id ,
                                        @RequestBody CategorieDTO dto){
        return  categoriService.updateCategorie(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteCategorie(@PathVariable Long id){
        return  categoriService.deleteCategorie(id);
    }




}
