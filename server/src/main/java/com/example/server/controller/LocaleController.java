package com.example.server.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

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
        LocaleContextHolder.setLocale(Locale.forLanguageTag(lang));
    }

}
