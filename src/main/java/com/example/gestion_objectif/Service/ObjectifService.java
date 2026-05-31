package com.example.gestion_objectif.Service;

import com.example.gestion_objectif.Entity.Objectif;
import com.example.gestion_objectif.NotificationPublisher;
import com.example.gestion_objectif.RabbitMQConfig;
import com.example.gestion_objectif.Repository.ObjectifRepository;
import com.example.gestion_objectif.UserClient;
import com.example.gestion_objectif.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ObjectifService {
    @Autowired
    private NotificationPublisher notificationPublisher;
    private final ObjectifRepository objectifRepository;
    private final UserClient userClient;

    public ObjectifService(ObjectifRepository objectifRepository, UserClient userClient) {
        this.objectifRepository = objectifRepository;
        this.userClient = userClient;
    }

    public Objectif ajouter(Objectif objectif) {
        UserDTO user = userClient.getById(objectif.getUserId());
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable avec l'id : " + objectif.getUserId());
        }

        // ✅ Save first, keep reference
        Objectif saved = objectifRepository.save(objectif);

        Map<String, Object> data = new HashMap<>();
        data.put("titre",   saved.getTitre());
        data.put("montant", saved.getMontantGlobal());

        notificationPublisher.publier(
                RabbitMQConfig.KEY_OBJECTIF,
                saved.getUserId(),
                "Nouvel objectif créé : " + saved.getTitre(),
                data
        );

        // ✅ Return AFTER publishing
        return saved;
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