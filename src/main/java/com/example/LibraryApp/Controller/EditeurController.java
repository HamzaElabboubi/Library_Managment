package com.example.LibraryApp.Controller;


import com.example.LibraryApp.DTO.EditeureDTO;
import com.example.LibraryApp.Repo.EditeurRepo;
import com.example.LibraryApp.Services.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/editeur")
public class EditeurController {

    @Autowired EditeurService editeurService;


    @PostMapping
    public EditeureDTO creatEditeur( @RequestBody EditeureDTO dto){
        return editeurService.createEditeur(dto);
    }

    @GetMapping
    public List<EditeureDTO> getAllEditeur(){
        return  editeurService.getAllEditeur();
    }

    @GetMapping("/{id}")
    public EditeureDTO getEditeur(@PathVariable Long id){
        return editeurService.getEditeur(id);
    }

    @PutMapping("/{id}")
    public EditeureDTO updateEditeur(@PathVariable Long id, @RequestBody EditeureDTO dto){
        return editeurService.updateEditeur(id,dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEditeur(@PathVariable Long id){
        return editeurService.deleteEditeur(id);
    }

}

