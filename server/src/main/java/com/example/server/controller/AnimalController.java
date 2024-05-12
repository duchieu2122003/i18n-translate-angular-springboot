package com.example.server.controller;

import com.example.server.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duchieu212
 */
@RestController
@RequestMapping("/api/animal")
@CrossOrigin
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    private AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(animalService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/message")
    public ResponseEntity<?> getMessage() {
        return new ResponseEntity<>(animalService.sendMesCheck(""), HttpStatus.OK);
    }
}
