package com.example.controller;

import com.example.entite.Equipe;
import com.example.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @PostMapping
    public ResponseEntity<Equipe> create(@RequestBody Equipe equipe) {
        return ResponseEntity.ok(equipeService.createEquipe(equipe));
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> getAll() {
        return ResponseEntity.ok(equipeService.getAllEquipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(equipeService.getEquipeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> update(@PathVariable Long id, @RequestBody Equipe equipe) {
        return ResponseEntity.ok(equipeService.updateEquipe(id, equipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
        return ResponseEntity.noContent().build();
    }
}
