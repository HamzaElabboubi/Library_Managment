package com.example.LibraryApp.Repo;

import com.example.LibraryApp.Model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepo extends JpaRepository<Livre,Long> {
}
