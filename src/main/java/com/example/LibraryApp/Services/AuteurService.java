package com.example.LibraryApp.Services;

import com.example.LibraryApp.DTO.AuteurDTO;
import com.example.LibraryApp.DTO.LivreDTO;
import com.example.LibraryApp.Mapper.AuteurMapper;
import com.example.LibraryApp.Model.Auteur;
import com.example.LibraryApp.Repo.AuteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {

    @Autowired private AuteurRepo auteurRepo;
    //@Autowired private AuteurDTO dto;
    @Autowired private AuteurMapper auteurMapper;


    //recuperation de tous les Auteures
    public List<AuteurDTO> GetAllAuteur(){
       return auteurRepo.findAll()
               .stream()
               .map(auteurMapper::toDTO)
               .toList();
    }

    public AuteurDTO CreatAuteur(AuteurDTO dto1){
        Auteur auteur = auteurMapper.toEntity(dto1);
        Auteur saved = auteurRepo.save(auteur);
        return auteurMapper.toDTO(saved);
    }

    public String DeleteAuteur(Long id){
        Auteur auteur = auteurRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Auteure non trouver"));
        auteurRepo.deleteById(id);
        return "Auteur avec ID " + id + " supprimé avec succès.";
    }


    // update Auteur
    public AuteurDTO UpdateAuteur(Long id,AuteurDTO dto){
        Auteur auteur = auteurRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Auteure non trouver"));

        auteur.setNom(dto.getNom());

        Auteur updated = auteurRepo.save(auteur);
        return auteurMapper.toDTO(updated);

    }

    //Select one Auteur
    public AuteurDTO GetAuteur(Long id){
        Auteur auteur = auteurRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Auteure non Trouver"));
        System.out.println(auteur);
        return auteurMapper.toDTO(auteur);

    }
}
