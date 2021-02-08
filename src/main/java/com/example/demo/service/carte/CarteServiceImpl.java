package com.example.demo.service.carte;

import com.example.demo.domain.carte.Carte;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarteServiceImpl implements CarteService {

    OAuth2RestOperations restTemplate;

    public List<Carte> getAll() {
        try {
            ResponseEntity<List<Carte>> response = restTemplate.exchange("/cartes/index", HttpMethod.GET,
                    null, new ParameterizedTypeReference<List<Carte>>() {});
            return response.getBody();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Carte getToday() {
        try {
            ResponseEntity<Carte> response = restTemplate.exchange("/cartes/today", HttpMethod.GET,
                    null, new ParameterizedTypeReference<Carte>() {});
            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }
}
