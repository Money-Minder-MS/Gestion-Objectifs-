package com.example.gestion_objectif.Service;

import com.example.gestion_objectif.Entity.CategorieObjectif;
import com.example.gestion_objectif.Repository.CategorieObjectifRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieObjectifService {

    private final CategorieObjectifRepository categorieRepository;

    // Constructeur pour l'injection de dépendance
    public CategorieObjectifService(CategorieObjectifRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public CategorieObjectif ajouter(CategorieObjectif categorie) {
        return categorieRepository.save(categorie);
    }

    public List<CategorieObjectif> afficherTout() {
        return categorieRepository.findAll();
    }

    public CategorieObjectif afficherParId(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public CategorieObjectif modifier(CategorieObjectif categorie) {
        return categorieRepository.save(categorie);
    }

    public void supprimer(Long id) {
        categorieRepository.deleteById(id);
    }
}