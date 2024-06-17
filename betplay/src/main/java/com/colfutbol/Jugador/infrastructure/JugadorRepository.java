package com.colfutbol.Jugador.infrastructure;

import java.util.List;

import com.colfutbol.Jugador.domain.Jugador;

public interface JugadorRepository {

    Jugador findById(Integer id);

    List<Jugador> findAll();

    void save(Jugador jugador);

    void update(Jugador jugador);
}