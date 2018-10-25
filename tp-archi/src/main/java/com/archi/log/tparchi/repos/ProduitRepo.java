package com.archi.log.tparchi.repos;

import com.archi.log.tparchi.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepo extends JpaRepository<Produit,Long> {
   // @Query("select p from produit p where p.designation like :x")
    //public Page<Produit> produitparMC(@Param("x") String mc, Pageable pageable);
    public List<Produit> findByDesignation(String des);
    public Page<Produit> findByDesignation(String des, Pageable pageable);


}
