package com.archi.log.tparchi.controllers;

import com.archi.log.tparchi.entities.Produit;
import com.archi.log.tparchi.repos.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogueController {
    @Autowired
    private ProduitRepo produitRepo;
    @RequestMapping("/save")
    public Produit enrProduit(Produit produit){
        produitRepo.save(produit);
        return produit;
    }
    @RequestMapping("/all")
    public List<Produit> getProduit(){
       return produitRepo.findAll();

    }
    @RequestMapping("/produits")
    public Page<Produit> getProduits(int page){
        return produitRepo.findAll(PageRequest.of(page,5));
    }
   /* @RequestMapping("/produitsparMc")
    public Page<Produit> getProduitsparmc(String mc,int page){
        return produitRepo.produitparMC(mc,PageRequest.of(page,5));


    }*/
    @RequestMapping("/get")
    public Produit getProduit(Long id){
        return produitRepo.findById(id).orElse(null);
    }
    @RequestMapping("/delete")
    public void deleteProduit(@RequestBody Produit produit){
        produitRepo.delete(produit);
    }
    @RequestMapping("/update")
    public  void updateProduit(@RequestBody Produit produit){
        produitRepo.saveAndFlush(produit);
    }

}
