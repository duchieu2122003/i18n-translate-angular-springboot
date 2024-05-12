package com.example.server.service;

import com.example.server.controller.MessageException;
import com.example.server.entity.Animal;
import com.example.server.locale.CustomMessageSource;
import com.example.server.repository.AnimalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duchieu212
 */
@Service
@RequiredArgsConstructor
public class AnimalService {

    private final CustomMessageSource customMessageSource;

    private final AnimalRepo animalRepo;

    public List<Animal> getAll() {
        return animalRepo.findAll();
    }

    public String sendMesCheck(String a) {
        if (a.isEmpty()) {
            throw new MessageException(customMessageSource.getMessage("animal", "error.name"), "animal");
        }
        return "ok";
    }

}
