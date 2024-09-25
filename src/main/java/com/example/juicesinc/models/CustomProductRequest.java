package com.example.juicesinc.models;

import java.util.List;

public class CustomProductRequest {
    private List<CustomIngredient> ingredients;

    // Getters and Setters

    public List<CustomIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<CustomIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}