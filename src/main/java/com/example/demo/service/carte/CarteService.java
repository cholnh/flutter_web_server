package com.example.demo.service.carte;

import com.example.demo.domain.carte.Carte;

import java.util.List;

public interface CarteService {
    List<Carte> getAll();
    Carte getToday();
}
