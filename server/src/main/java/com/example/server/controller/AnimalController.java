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

    private final AnimalService animalService;

    @Autowired
    private AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/message-name")
    public ResponseEntity<?> getMessageName() {
        return new ResponseEntity<>(animalService.sendMessageName(""), HttpStatus.OK);
    }

    @GetMapping("/message-age")
    public ResponseEntity<?> getMessageAge() {
        return new ResponseEntity<>(animalService.sendMessageAge(""), HttpStatus.OK);
    }
}
