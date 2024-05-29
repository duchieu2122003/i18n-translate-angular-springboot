package com.example.server.controller;

import com.example.server.locale.CustomMessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author duchieu212
 */
@RestController
@RequestMapping("/api/locale")
@CrossOrigin
public class LocaleController {

    @GetMapping("/{lang}")
    public void setLocale(@PathVariable("lang") String lang) {
        System.err.println("+++++++++++++++");
        LocaleContextHolder.setLocale(Locale.forLanguageTag(lang));
    }

}
