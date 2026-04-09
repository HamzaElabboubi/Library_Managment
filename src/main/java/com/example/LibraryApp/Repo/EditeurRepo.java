package com.example.LibraryApp.Repo;

import com.example.LibraryApp.Model.Auteur;
import com.example.LibraryApp.Model.Editeure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurRepo extends JpaRepository<Editeure,Long> {
}
