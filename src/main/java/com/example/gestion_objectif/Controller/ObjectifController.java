package com.example.gestion_objectif.Controller;

import com.example.gestion_objectif.Entity.Objectif;
import com.example.gestion_objectif.Service.ObjectifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objectifs")
public class ObjectifController {

    private final ObjectifService objectifService;

    public ObjectifController(ObjectifService objectifService) {
        this.objectifService = objectifService;
    }

    @PostMapping("/add")
    public Objectif ajouter(@RequestBody Objectif objectif) {
        return objectifService.ajouter(objectif);
    }

    @GetMapping("/getall")
    public List<Objectif> afficherTout() {
        return objectifService.afficherTout();
    }

    @GetMapping("/getbyid/{id}")
    public Objectif afficherParId(@PathVariable Long id) {
        return objectifService.afficherParId(id);
    }

    @PutMapping("/update")
    public Objectif modifier(@RequestBody Objectif objectif) {
        return objectifService.modifier(objectif);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        objectifService.supprimer(id);
    }
}