package com.example.LibraryApp.Services;

import com.example.LibraryApp.DTO.EditeureDTO;
import com.example.LibraryApp.Mapper.EditeurMapper;
import com.example.LibraryApp.Model.Editeure;
import com.example.LibraryApp.Repo.EditeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditeurService {

    @Autowired EditeurRepo editeurRepo;
    @Autowired EditeurMapper editeurMapper;

    public EditeureDTO createEditeur(EditeureDTO dto){
        Editeure editeure = editeurMapper.ToEntity(dto);
        Editeure saved = editeurRepo.save(editeure);

        return editeurMapper.toDTO(saved);
    }

    public List<EditeureDTO> getAllEditeur(){
        return editeurRepo.findAll()
                .stream().map(editeurMapper::toDTO)
                .toList();

    }

    public EditeureDTO getEditeur(Long id){
        Editeure editeure = editeurRepo.findById(id).orElseThrow(()->new RuntimeException("Editeure introuvable"));

        return editeurMapper.toDTO(editeure);
    }

    public  String deleteEditeur(Long id ){
        Editeure editeure = editeurRepo.findById(id).orElseThrow(()->new RuntimeException("Editeur introuvable"));

        editeurRepo.deleteById(id);

        return "Editeur   " + editeure.getNom() + " supprimé avec succès.";
    }

    public  EditeureDTO updateEditeur(Long id,EditeureDTO dto){
        Editeure editeure = editeurRepo.findById(id).orElseThrow(()-> new RuntimeException("Editeur introuvable"));

        editeure.setNom(dto.getNom());

        Editeure saved = editeurRepo.save(editeure);

        return editeurMapper.toDTO(saved);
    }


}
