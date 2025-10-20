package com.tesis.teamsoft.presentation.controller;

import com.tesis.teamsoft.presentation.dto.RaceDTO;
import com.tesis.teamsoft.service.implementation.RaceServiceImpl;
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
@Tag(name = "Race")
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceServiceImpl raceService;

    @RequestMapping(value = "/create_race", method = RequestMethod.POST)
    public ResponseEntity<?> createRace(@Valid @RequestBody RaceDTO.RaceCreateDTO raceDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(raceService.saveRace(raceDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update_race/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRace(@Valid @RequestBody RaceDTO.RaceCreateDTO raceDTO,
                                        BindingResult bindingResult,
                                        @PathVariable Long id) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(raceService.updateRace(raceDTO, id), HttpStatus.OK);
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

    @RequestMapping(value = "/delete_race/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRace(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(raceService.deleteRace(id), HttpStatus.OK);
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

    @RequestMapping(value = "/findAll_race", method = RequestMethod.GET)
    public ResponseEntity<?> findAllRace() {
        try {
            return new ResponseEntity<>(raceService.findAllByOrderByIdAsc(), HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findByID_race/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findRaceById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(raceService.findRaceById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}