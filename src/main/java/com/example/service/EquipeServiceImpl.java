package com.example.service;

import com.example.entite.Equipe;
import com.example.entite.MatchDto;
import com.example.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;
    private  RestTemplate restTemplate;

    @Override
    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe not found"));
    }

    @Override
    public Equipe updateEquipe(Long id, Equipe equipe) {
        Equipe existing = getEquipeById(id);
        existing.setNom(equipe.getNom());
        existing.setVille(equipe.getVille());
        return equipeRepository.save(existing);
    }

    @Override
    public void deleteEquipe(Long id) {

    }

    @Override
    public void EquipeService(RestTemplate restTemplate) {

    }

    @Override
    public void MatchClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Exemple : récupérer les matchs d'une équipe par son
    @Override
    public List<MatchDto> getMatchesByEquipeId(String equipeId) {
        String url = "http://localhost:8082/matchs/equipe/" + equipeId;  // endpoint du microservice Match
        ResponseEntity<MatchDto[]> response = restTemplate.getForEntity(url, MatchDto[].class);
        return Arrays.asList(response.getBody());
    }

}
