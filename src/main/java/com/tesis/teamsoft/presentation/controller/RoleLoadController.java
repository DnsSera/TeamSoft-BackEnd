package com.tesis.teamsoft.presentation.controller;

import com.tesis.teamsoft.presentation.dto.RoleLoadDTO;
import com.tesis.teamsoft.service.implementation.RoleLoadServiceImpl;
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
@Tag(name = "RoleLoad")
@RequestMapping("/roleLoad")
public class RoleLoadController {

    @Autowired
    private RoleLoadServiceImpl roleLoadService;

    @RequestMapping(value = "/create_roleLoad", method = RequestMethod.POST)
    public ResponseEntity<?> createRoleLoad(@Valid @RequestBody RoleLoadDTO.RoleLoadCreateDTO roleLoadDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(roleLoadService.saveRoleLoad(roleLoadDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update_roleLoad/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRoleLoad(@Valid @RequestBody RoleLoadDTO.RoleLoadCreateDTO roleLoadDTO,
                                            BindingResult bindingResult,
                                            @PathVariable Long id) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(roleLoadService.updateRoleLoad(roleLoadDTO, id), HttpStatus.OK);
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

    @RequestMapping(value = "/delete_roleLoad/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRoleLoad(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(roleLoadService.deleteRoleLoad(id), HttpStatus.OK);
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

    @RequestMapping(value = "/findAll_roleLoad", method = RequestMethod.GET)
    public ResponseEntity<?> findAllRoleLoad() {
        try {
            return new ResponseEntity<>(roleLoadService.findAllByOrderByIdAsc(), HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findByID_roleLoad/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findRoleLoadById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(roleLoadService.findRoleLoadById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}