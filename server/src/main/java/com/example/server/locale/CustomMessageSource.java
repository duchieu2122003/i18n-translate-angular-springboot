package com.example.server.locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author duchieu212
 */
@Component
public class CustomMessageSource implements MessageSource {

    private final MessageSource messageSource;

    @Autowired
    public CustomMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return messageSource.getMessage(code, args, locale);
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return messageSource.getMessage(resolvable, locale);
    }

    public String getMessage(String fileName, String key) {
        Locale locale = LocaleContextHolder.getLocale();
        String messageKey = fileName + "." + key;
        return messageSource.getMessage(messageKey, null, locale);
    }
//    public String getMessage(String key) {
//        Locale locale = LocaleContextHolder.getLocale();
//        return messageSource.getMessage(key, null, locale);
//    }
}
