package com.example.produs.controller;

import com.example.produs.model.Produs;
import com.example.produs.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusRepository produsRepository;

    @GetMapping
    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }

    @PostMapping
    public Produs createProdus(@RequestBody Produs produs) {
        return produsRepository.save(produs);
    }

    @GetMapping("/{id}")
    public Produs getProdusById(@PathVariable Long id) {
        return produsRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Produs updateProdus(@PathVariable Long id, @RequestBody Produs produsDetails) {
        Produs produs = produsRepository.findById(id).orElseThrow();
        produs.setNume(produsDetails.getNume());
        produs.setPret(produsDetails.getPret());
        produs.setDescriere(produsDetails.getDescriere());
        return produsRepository.save(produs);
    }

    @DeleteMapping("/{id}")
    public void deleteProdus(@PathVariable Long id) {
        produsRepository.deleteById(id);
    }
}
