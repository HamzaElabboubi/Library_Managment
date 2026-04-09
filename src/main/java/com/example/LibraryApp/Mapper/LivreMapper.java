package com.example.LibraryApp.Mapper;

import com.example.LibraryApp.DTO.LivreDTO;
import com.example.LibraryApp.Model.Livre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivreMapper {


    // Livre (Entity) → LivreDTO
    // On "aplatit" les objets imbriqués vers des champs simples
    @Mapping(target = "auteurnom" , source = "auteur.nom")
    @Mapping(target = "auteurprenom",source = "auteur.prenom")
    @Mapping(target = "categorieNom",source = "categorie.name")
    @Mapping(target = "editeurNom",source = "editeur.nom")
    LivreDTO toDTO(Livre livre);


    // LivreDTO → Livre (Entity)
    // On ignore les relations car le Service s'en charge via les IDs
    @Mapping(target = "auteur",    ignore = true)
    @Mapping(target = "categorie", ignore = true)
    @Mapping(target = "editeure",  ignore = true)
    Livre ToEntity(LivreDTO dto);

}
