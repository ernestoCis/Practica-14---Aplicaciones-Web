package com.jesus.cisneros.pokemon.controller;

import com.jesus.cisneros.pokemon.model.Pokemon;
import com.jesus.cisneros.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> obtenerTodos() {
        return pokemonService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pokemon obtenerPorId(@PathVariable Long id) {
        return pokemonService.obtenerPorId(id).orElse(null);
    }

    @PostMapping
    public Pokemon crear(@RequestBody Pokemon pokemon) {
        return pokemonService.crear(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon actualizarCompleto(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarCompleto(id, pokemon);
    }

    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarParcial(id, pokemon);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pokemonService.eliminar(id);
    }
}
