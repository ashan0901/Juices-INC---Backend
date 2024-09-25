package com.example.juicesinc.services;

import com.example.juicesinc.models.CustomIngredient;
import com.example.juicesinc.models.CustomProductRequest;
import com.example.juicesinc.models.RawMaterial;
import com.example.juicesinc.repositories.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomProductService {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    public double calculateCustomProductPrice(CustomProductRequest request) {
        double totalPrice = 0.0;
        List<CustomIngredient> ingredients = request.getIngredients();

        for (CustomIngredient ingredient : ingredients) {
            RawMaterial rawMaterial = rawMaterialRepository.findById(ingredient.getId()).orElse(null);
            if (rawMaterial != null) {
                totalPrice += rawMaterial.getPricePerUnit() * ingredient.getQuantity();
            }
        }
        return totalPrice;
    }
}