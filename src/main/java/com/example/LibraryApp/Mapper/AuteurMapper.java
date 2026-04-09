package com.example.LibraryApp.Mapper;

import com.example.LibraryApp.DTO.AuteurDTO;
import com.example.LibraryApp.Model.Auteur;
import com.example.LibraryApp.Model.Livre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuteurMapper {


    @Mapping(target = "titreLivre", source = "livres", qualifiedByName = "livresVersLivreTitres")
    AuteurDTO toDTO(Auteur auteur);

    @Mapping(target = "livres" ,ignore = true)
    Auteur toEntity(AuteurDTO dto);

    @Named("livresVersLivreTitres")
    default List<String> livresVersLivreTitres(List<Livre> livres){
        if(livres==null) return null;
        return livres.stream()
                .map(Livre::getTitre)
                .collect(Collectors.toList());
    }

}
