package com.example.juicesinc.controllers;

import com.example.juicesinc.models.CustomIngredient;
import com.example.juicesinc.models.CustomProductRequest;
import com.example.juicesinc.models.RawMaterial;
import com.example.juicesinc.repositories.RawMaterialRepository;
import com.example.juicesinc.services.CustomProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/custom-products")
public class CustomProductController {
    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createCustomProduct(@RequestBody CustomProductRequest request) {
        double totalPrice = 0;
        for (CustomIngredient ingredient : request.getIngredients()) {
            //have a method to fetch the price by ingredient ID
            double price = getPriceById(ingredient.getId());
            totalPrice += price * ingredient.getQuantity();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return ResponseEntity.ok(response);
    }

    private double getPriceById(String id) {
        // Fetch the raw material by ID
        RawMaterial rawMaterial = rawMaterialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found with id: " + id));

        // Return the price of the raw material
        return rawMaterial.getPricePerUnit();
    }
}
