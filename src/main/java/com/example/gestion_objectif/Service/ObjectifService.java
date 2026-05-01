package com.example.gestion_objectif.Service;

import com.example.gestion_objectif.Entity.Objectif;
import com.example.gestion_objectif.Repository.ObjectifRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectifService {

    private final ObjectifRepository objectifRepository;

    public ObjectifService(ObjectifRepository objectifRepository) {
        this.objectifRepository = objectifRepository;
    }

    public Objectif ajouter(Objectif objectif) {
        return objectifRepository.save(objectif);
    }

    public List<Objectif> afficherTout() {
        return objectifRepository.findAll();
    }

    public Objectif afficherParId(Long id) {
        return objectifRepository.findById(id).orElse(null);
    }

    public Objectif modifier(Objectif objectif) {
        return objectifRepository.save(objectif);
    }

    public void supprimer(Long id) {
        objectifRepository.deleteById(id);
    }
}