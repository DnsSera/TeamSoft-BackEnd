package com.tesis.teamsoft.presentation.controller;

import com.tesis.teamsoft.presentation.dto.LevelsDTO;
import com.tesis.teamsoft.service.implementation.LevelsServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "Levels")
@RequestMapping("/levels")
public class LevelsController {

    @Autowired
    private LevelsServiceImpl levelsService;

    @RequestMapping(value = "/create_levels", method = RequestMethod.POST)
    public ResponseEntity<?> createLevels(@Valid @RequestBody LevelsDTO.LevelsCreateDTO levelsDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(levelsService.saveLevels(levelsDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update_levels/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateLevels(@Valid @RequestBody LevelsDTO.LevelsCreateDTO levelsDTO,
                                          BindingResult bindingResult,
                                          @PathVariable Long id) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(levelsService.updateLevels(levelsDTO, id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete_levels/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLevels(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(levelsService.deleteLevels(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/findAll_levels", method = RequestMethod.GET)
    public ResponseEntity<?> findAllLevels() {
        try {
            return new ResponseEntity<>(levelsService.findAllByOrderByIdAsc(), HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findByID_levels/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findLevelsById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(levelsService.findLevelsById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}