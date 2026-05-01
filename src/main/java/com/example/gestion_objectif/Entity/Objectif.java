package com.example.gestion_objectif.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Objectif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String titre;

    private Double montantGlobal;

    private String frequence;

    private Double mensualite;

    private Integer mois;

    private Integer annee;

    private String commentaire;

    private String statut;

    private Long userId;

    @Column(name = "categorie_id")
    private Long categorieId;

    public Objectif() {
    }

    public Objectif(Long id, String titre, Double montantGlobal, String frequence,
                    Double mensualite, Integer mois, Integer annee, String commentaire,
                    String statut, Long userId, Long categorieId) {
        this.id = id;
        this.titre = titre;
        this.montantGlobal = montantGlobal;
        this.frequence = frequence;
        this.mensualite = mensualite;
        this.mois = mois;
        this.annee = annee;
        this.commentaire = commentaire;
        this.statut = statut;
        this.userId = userId;
        this.categorieId = categorieId;
    }

    public Long getId() { return id; }
    public String getTitre() { return titre; }
    public Double getMontantGlobal() { return montantGlobal; }
    public String getFrequence() { return frequence; }
    public Double getMensualite() { return mensualite; }
    public Integer getMois() { return mois; }
    public Integer getAnnee() { return annee; }
    public String getCommentaire() { return commentaire; }
    public String getStatut() { return statut; }
    public Long getUserId() { return userId; }
    public Long getCategorieId() { return categorieId; }

    public void setId(Long id) { this.id = id; }
    public void setTitre(String titre) { this.titre = titre; }
    public void setMontantGlobal(Double montantGlobal) { this.montantGlobal = montantGlobal; }
    public void setFrequence(String frequence) { this.frequence = frequence; }
    public void setMensualite(Double mensualite) { this.mensualite = mensualite; }
    public void setMois(Integer mois) { this.mois = mois; }
    public void setAnnee(Integer annee) { this.annee = annee; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setCategorieId(Long categorieId) { this.categorieId = categorieId; }
}