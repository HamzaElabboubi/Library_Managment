package com.example.LibraryApp.Services;

import com.example.LibraryApp.DTO.CategorieDTO;
import com.example.LibraryApp.Mapper.CategorieMapper;
import com.example.LibraryApp.Model.Categorie;
import com.example.LibraryApp.Repo.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriService {



    @Autowired    CategorieMapper categorieMapper;
    @Autowired CategorieRepo categorieRepo;

    public CategorieDTO creatCategorie(CategorieDTO dto){
        Categorie categorie = categorieMapper.toEntity(dto);
        Categorie saved =  categorieRepo.save(categorie);

        return categorieMapper.toDTO(saved);
    }

    public CategorieDTO getCategorie(Long id){
        Categorie categorie= categorieRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Categorie non Trouver"));

        return categorieMapper.toDTO(categorie);
    }

    public List<CategorieDTO> getAllCategorie(){
        return categorieRepo.findAll()
                .stream().map(categorieMapper::toDTO)
                .toList();
    }

    public String deleteCategorie(Long id){
        Categorie categorie = categorieRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Categorie non trouver"));
        categorieRepo.deleteById(id);
        return "Categorie  avec ID " + id + " supprimé avec succès.";
    }

    public CategorieDTO updateCategorie(Long id ,CategorieDTO dto){
        Categorie categorie = categorieRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Categorie non trouver"));
        categorie.setName(dto.getName());
        Categorie saved = categorieRepo.save(categorie);
        return categorieMapper.toDTO(saved);
    }



}
