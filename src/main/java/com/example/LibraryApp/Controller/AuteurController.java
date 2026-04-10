package com.example.LibraryApp.Controller;

import com.example.LibraryApp.DTO.AuteurDTO;
import com.example.LibraryApp.Services.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuteurController {

    @Autowired private AuteurService auteurService;

    @GetMapping("api/allAuteur")
    public List<AuteurDTO> getallAuteur(){
        return auteurService.GetAllAuteur();
    }

    @PostMapping("api/addAuteur")
    public AuteurDTO addAuteur(@RequestBody AuteurDTO dto){
        return auteurService.CreatAuteur(dto);
    }

    @DeleteMapping("api/deleteAuteur/{id}")
    public String deleteAuteur(@PathVariable Long id){
        return auteurService.DeleteAuteur(id);
    }

    @PutMapping("api/updateAuteur/{id}")
    public AuteurDTO updateAuteur( @PathVariable Long id,
                                   @RequestBody AuteurDTO dto ){
        return   auteurService.UpdateAuteur(id,dto);

    }

    @GetMapping("api/getAuteur/{id}")
    public AuteurDTO getAuteur(@PathVariable Long id){
        return auteurService.GetAuteur(id);
    }
}
