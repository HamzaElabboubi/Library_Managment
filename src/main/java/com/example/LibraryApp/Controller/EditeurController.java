package com.example.LibraryApp.Controller;


import com.example.LibraryApp.DTO.EditeureDTO;
import com.example.LibraryApp.Repo.EditeurRepo;
import com.example.LibraryApp.Services.EditeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EditeurController {

    @Autowired EditeurService editeurService;


    @PostMapping("api/creatEditeur")
    public EditeureDTO creatEditeur( @RequestBody EditeureDTO dto){
        return editeurService.createEditeur(dto);
    }

    @GetMapping("api/allEditeur")
    public List<EditeureDTO> getAllEditeur(){
        return  editeurService.getAllEditeur();
    }

    @GetMapping("api/getEditeur/{id}")
    public EditeureDTO getEditeur(@PathVariable Long id){
        return editeurService.getEditeur(id);
    }

    @PutMapping("api/updateEditeur/{id}")
    public EditeureDTO updateEditeur(@PathVariable Long id, @RequestBody EditeureDTO dto){
        return editeurService.updateEditeur(id,dto);
    }

    @DeleteMapping("api/deleteEditeur/{id}")
    public String deleteEditeur(@PathVariable Long id){
        return editeurService.deleteEditeur(id);
    }

}

