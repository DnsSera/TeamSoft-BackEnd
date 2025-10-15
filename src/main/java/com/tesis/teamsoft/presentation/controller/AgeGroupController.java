package com.tesis.teamsoft.presentation.controller;

import com.tesis.teamsoft.persistence.entity.AgeGroupEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/age-groups")
public class AgeGroupController {

    @PostMapping
    public ResponseEntity<?> testAgeGroupValidation(@Valid @RequestBody AgeGroupEntity ageGroup,
                                                    BindingResult bindingResult) {

        // Verificar si hay errores de validación
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));

            // Agregar también los errores globales (como el @AssertTrue)
            bindingResult.getGlobalErrors().forEach(error ->
                    errors.put("globalError", error.getDefaultMessage()));

            return ResponseEntity.badRequest().body(errors);
        }

        // Si pasa la validación, simplemente devolvemos el objeto recibido
        Map<String, Object> response = new HashMap<>();
        response.put("message", "✅ Validación exitosa");

        return ResponseEntity.ok(response);
    }
}
