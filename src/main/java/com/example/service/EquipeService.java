package com.example.service;

import com.example.entite.Equipe;
import com.example.entite.MatchDto;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface EquipeService {

    Equipe createEquipe(Equipe equipe);

    List<Equipe> getAllEquipes();

    Equipe getEquipeById(Long id);

    Equipe updateEquipe(Long id, Equipe equipe);

    void deleteEquipe(Long id);

    void EquipeService(RestTemplate restTemplate);

    void MatchClientService(RestTemplate restTemplate);

    // Exemple : récupérer les matchs d'une équipe par son
    List<MatchDto> getMatchesByEquipeId(String equipeId);
}
