package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    // Método GET para obter todos os alimentos
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return repository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    // Método POST para criar um novo alimento
    @PostMapping
    public ResponseEntity<String> createFood(@RequestBody Food food) {
        repository.save(food);
        return ResponseEntity.ok("Alimento adicionado com sucesso!");
    }
}
