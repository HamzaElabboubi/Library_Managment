package com.example.LibraryApp.Repo;

import com.example.LibraryApp.Model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepo extends JpaRepository<Auteur,Long> {
}
