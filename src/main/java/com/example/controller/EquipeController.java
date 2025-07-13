package com.example.controller;

import com.example.Mappers.EquipeMapper;
import com.example.entite.Equipe;
import com.example.entite.EquipeDto;
import com.example.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @Autowired
    private EquipeMapper equipeMapper;

    @PostMapping
    public ResponseEntity<EquipeDto> create(@RequestBody EquipeDto dto) {
        Equipe created = equipeService.createEquipe(equipeMapper.toEntity(dto));
        return ResponseEntity.ok(equipeMapper.toDto(created));
    }

    @GetMapping
    public ResponseEntity<List<EquipeDto>> getAll() {
        List<Equipe> equipes = equipeService.getAllEquipes();
        return ResponseEntity.ok(
                equipes.stream().map(equipeMapper::toDto).collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeDto> getOne(@PathVariable Long id) {
        Equipe equipe = equipeService.getEquipeById(id);
        return ResponseEntity.ok(equipeMapper.toDto(equipe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipeDto> update(@PathVariable Long id, @RequestBody EquipeDto dto) {
        Equipe updated = equipeService.updateEquipe(id, equipeMapper.toEntity(dto));
        return ResponseEntity.ok(equipeMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
        return ResponseEntity.noContent().build();
    }
}