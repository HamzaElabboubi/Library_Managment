package com.example.LibraryApp.Mapper;

import com.example.LibraryApp.DTO.EditeureDTO;
import com.example.LibraryApp.Model.Editeure;
import com.example.LibraryApp.Model.Livre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EditeurMapper {

    @Mapping(target = "titreLivre",source = "livres",qualifiedByName = "LivreToTitre")
    EditeureDTO toDTO(Editeure editeure);

    @Mapping(target = "livres",ignore = true)
    Editeure ToEntity(EditeureDTO dto);

    @Named("LivreToTitre")
    default List<String> LivreToTitre(List<Livre> livres){
        if(livres==null) return null;
        return livres.stream()
                .map(Livre::getTitre)
                .collect(Collectors.toList());
    }
}
