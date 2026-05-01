package com.example.gestion_objectif.Repository;

import com.example.gestion_objectif.Entity.CategorieObjectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieObjectifRepository extends JpaRepository<CategorieObjectif, Long> {
}