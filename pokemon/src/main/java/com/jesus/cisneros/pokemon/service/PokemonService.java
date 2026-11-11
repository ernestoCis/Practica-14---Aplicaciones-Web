package com.jesus.cisneros.pokemon.service;

import com.jesus.cisneros.pokemon.model.Pokemon;
import com.jesus.cisneros.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    public List<Pokemon> obtenerTodos(){
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> obtenerPorId(Long id){
        return pokemonRepository.findById(id);
    }

    public Pokemon crear(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon actualizarCompleto(Long id, Pokemon nuevo) {
        return pokemonRepository.findById(id).map(pokemon -> {
            pokemon.setNombre(nuevo.getNombre());
            pokemon.setTipo(nuevo.getTipo());
            pokemon.setNivel(nuevo.getNivel());
            pokemon.setAtaque(nuevo.getAtaque());
            pokemon.setDefensa(nuevo.getDefensa());
            pokemon.setDescripcion(nuevo.getDescripcion());
            pokemon.setImagenUrl(nuevo.getImagenUrl());
            return pokemonRepository.save(pokemon);
        }).orElse(null);
    }

    public Pokemon actualizarParcial(Long id, Pokemon parcial) {
        return pokemonRepository.findById(id).map(pokemon -> {
            if (parcial.getNombre() != null) pokemon.setNombre(parcial.getNombre());
            if (parcial.getTipo() != null) pokemon.setTipo(parcial.getTipo());
            if (parcial.getNivel() != null) pokemon.setNivel(parcial.getNivel());
            if (parcial.getAtaque() != null) pokemon.setAtaque(parcial.getAtaque());
            if (parcial.getDefensa() != null) pokemon.setDefensa(parcial.getDefensa());
            if (parcial.getDescripcion() != null) pokemon.setDescripcion(parcial.getDescripcion());
            if (parcial.getImagenUrl() != null) pokemon.setImagenUrl(parcial.getImagenUrl());
            return pokemonRepository.save(pokemon);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        pokemonRepository.deleteById(id);
    }

}
