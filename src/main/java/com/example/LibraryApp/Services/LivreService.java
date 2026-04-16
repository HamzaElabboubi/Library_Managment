package com.example.LibraryApp.Services;


import com.example.LibraryApp.DTO.LivreCreateDTO;
import com.example.LibraryApp.DTO.LivreDTO;
import com.example.LibraryApp.Mapper.LivreMapper;
import com.example.LibraryApp.Model.Auteur;
import com.example.LibraryApp.Model.Categorie;
import com.example.LibraryApp.Model.Editeure;
import com.example.LibraryApp.Model.Livre;
import com.example.LibraryApp.Repo.AuteurRepo;
import com.example.LibraryApp.Repo.CategorieRepo;
import com.example.LibraryApp.Repo.EditeurRepo;
import com.example.LibraryApp.Repo.LivreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreService {


    @Autowired private AuteurRepo auteurRepo;
    @Autowired private CategorieRepo categorieRepo;
    @Autowired private EditeurRepo editeurRepo;
    @Autowired private LivreRepo livreRepo;
    @Autowired private LivreMapper livreMapper;


    // ── Récupérer un livre ──────────────────────────────────
    public LivreDTO getLivreById(Long id){
        Livre livre = livreRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Livre non trouver"));
        return livreMapper.toDTO(livre);
    }

    // ── Créer un livre ──────────────────────────────────────
    public LivreDTO CreatLivre(LivreCreateDTO dto){
        Auteur auteur = auteurRepo.findById(dto.getAuteurId())
                .orElseThrow(()-> new RuntimeException("Auteure non trouver"));

        Categorie categorie = categorieRepo.findById(dto.getCategorieId())
                .orElseThrow(()->new RuntimeException("Categories non trouver"));

        Editeure editeure = editeurRepo.findById(dto.getEditeurId())
                .orElseThrow(()->new RuntimeException("Editeure non Trouver"));

        // 2. Construire l'entité Livre
        Livre livre = Livre.builder()
                .titre(dto.getTitre())
                .pages(dto.getPages())
                .datepub(dto.getDatepub())
                .auteur(auteur)
                .categorie(categorie)
                .editeure(editeure)
                .build();

        // 3. Sauvegarder et retourner le DTO
        return livreMapper.toDTO(livreRepo.save(livre));
    }

    // ── Récupérer tous les livres ───────────────────────────
    public List<LivreDTO> getAllLivres() {
        return livreRepo.findAll()
                .stream()
                .map(livreMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String deleteLivre(Long id){
        Livre livre = livreRepo.findById(id).orElseThrow(()-> new RuntimeException("Livre introuvable"));
        livreRepo.deleteById(id);
        return "Livre   " + livre.getTitre() + " supprimé avec succès.";
    }

    public LivreDTO updateLivre(LivreDTO dto,Long id){
        Livre livre = livreRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Livre non trouver"));
        livre.setTitre(dto.getTitre());
        Livre save = livreRepo.save(livre);
        return livreMapper.toDTO(save);

    }
}
