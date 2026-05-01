package com.example.gestion_objectif.Repository;

import com.example.gestion_objectif.Entity.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {

    // Méthode personnalisée : trouver les objectifs par statut
    List<Objectif> findByStatut(String statut);

    // Trouver les objectifs d'une catégorie
    List<Objectif> findByCategorieId(Long categorieId);
}