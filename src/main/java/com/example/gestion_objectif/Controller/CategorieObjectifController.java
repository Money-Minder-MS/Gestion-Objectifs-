package com.example.gestion_objectif.Controller;

import com.example.gestion_objectif.Entity.CategorieObjectif;
import com.example.gestion_objectif.Service.CategorieObjectifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieObjectifController {

    private final CategorieObjectifService categorieService;

    public CategorieObjectifController(CategorieObjectifService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping("/add")
    public CategorieObjectif ajouter(@RequestBody CategorieObjectif categorie) {
        return categorieService.ajouter(categorie);
    }

    @GetMapping("/getall")
    public List<CategorieObjectif> afficherTout() {
        return categorieService.afficherTout();
    }

    @GetMapping("/getbyid/{id}")
    public CategorieObjectif afficherParId(@PathVariable Long id) {
        return categorieService.afficherParId(id);
    }

    @PutMapping("/update")
    public CategorieObjectif modifier(@RequestBody CategorieObjectif categorie) {
        return categorieService.modifier(categorie);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        categorieService.supprimer(id);
    }
}