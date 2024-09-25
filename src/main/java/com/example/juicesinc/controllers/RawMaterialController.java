package com.example.juicesinc.controllers;

import com.example.juicesinc.models.RawMaterial;
import com.example.juicesinc.repositories.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/raw-materials")
public class RawMaterialController {
    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @GetMapping
    public List<RawMaterial> getAllRawMaterials() {
        return rawMaterialRepository.findAll();
    }

    @PostMapping
    public RawMaterial createRaw(@RequestBody RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }
}
