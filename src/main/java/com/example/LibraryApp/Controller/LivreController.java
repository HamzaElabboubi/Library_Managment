package com.example.LibraryApp.Controller;


import com.example.LibraryApp.DTO.LivreCreateDTO;
import com.example.LibraryApp.DTO.LivreDTO;
import com.example.LibraryApp.Services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livre")
public class LivreController {

    @Autowired LivreService livreService;

    @PostMapping
    public LivreDTO creatLivre(@RequestBody LivreCreateDTO dto){
        return livreService.CreatLivre(dto);
    }

    @GetMapping
    public List<LivreDTO> getAllLivre(){
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public LivreDTO getLivre(@PathVariable Long id){
        return livreService.getLivreById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteLivre(@PathVariable Long id){
        return livreService.deleteLivre(id)
    }

    @PutMapping("/{id}")
    public LivreDTO updateLivre(@RequestBody LivreDTO dto, @PathVariable Long id){

    }




}
