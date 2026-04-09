package com.example.LibraryApp.Repo;

import com.example.LibraryApp.Model.Auteur;
import com.example.LibraryApp.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Long> {
}
