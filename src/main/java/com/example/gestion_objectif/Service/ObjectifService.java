package com.example.gestion_objectif.Service;

import com.example.gestion_objectif.Entity.Objectif;
import com.example.gestion_objectif.Repository.ObjectifRepository;
import com.example.gestion_objectif.UserClient;
import com.example.gestion_objectif.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectifService {

    private final ObjectifRepository objectifRepository;
    private final UserClient userClient;

    public ObjectifService(ObjectifRepository objectifRepository, UserClient userClient) {
        this.objectifRepository = objectifRepository;
        this.userClient = userClient;
    }

    public Objectif ajouter(Objectif objectif) {
        // Vérifier que le userId existe dans le microservice User
        UserDTO user = userClient.getById(objectif.getUserId());
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable avec l'id : " + objectif.getUserId());
        }
        return objectifRepository.save(objectif);
    }

    public List<Objectif> afficherTout() {
        return objectifRepository.findAll();
    }

    public Objectif afficherParId(Long id) {
        return objectifRepository.findById(id).orElse(null);
    }

    // Récupérer tous les objectifs d'un user
    public List<Objectif> afficherParUserId(Long userId) {
        return objectifRepository.findByUserId(userId);
    }

    public Objectif modifier(Objectif objectif) {
        return objectifRepository.save(objectif);
    }

    public void supprimer(Long id) {
        objectifRepository.deleteById(id);
    }
}