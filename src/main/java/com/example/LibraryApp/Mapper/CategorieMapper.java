package com.example.LibraryApp.Mapper;


import com.example.LibraryApp.DTO.CategorieDTO;
import com.example.LibraryApp.Model.Categorie;
import com.example.LibraryApp.Model.Livre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.lang.classfile.Interfaces;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategorieMapper {

    @Mapping(target = "titreLivres",source = "livres",qualifiedByName = "Livre_Vers_Titre")
    CategorieDTO toDTO(Categorie categorie);

    @Mapping(target = "livres",ignore = true)
    Categorie toEntity(CategorieDTO dto);

    @Named("Livre_Vers_Titre")
    default List<String> Livre_Vers_Titre(List<Livre> livres){
        if(livres==null) return null;
        return livres.stream()
                .map(Livre::getTitre)
                .collect(Collectors.toList());
    }


}
