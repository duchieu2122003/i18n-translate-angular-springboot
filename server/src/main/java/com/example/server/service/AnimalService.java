package com.example.server.service;

import com.example.server.controller.MessageException;
import com.example.server.locale.CustomMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duchieu212
 */
@Service
@RequiredArgsConstructor
public class AnimalService {

    private final CustomMessageSource customMessageSource;

    public String sendMessageName(String a) {
        if (a.isEmpty()) {
            throw new MessageException(customMessageSource.getMessage("animal", "error.name"), "animal");
        }
        return "ok";
    }

    public String sendMessageAge(String a) {
        if (a.isEmpty()) {
            throw new MessageException(customMessageSource.getMessage("person", "error.age"), "person");
        }
        return "ok";
    }
}
