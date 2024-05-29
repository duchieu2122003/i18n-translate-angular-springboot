package com.example.server.locale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author duchieu212
 */
@Configuration
@Slf4j
public class LocaleConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.forLanguageTag("vi"));
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    // Cách tải thủ công: dài dòng nhưng tối ưu hiệu xuất
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setUseCodeAsDefaultMessage(true);
//        messageSource.clearCache();
//        messageSource.setBasenames(
//                "classpath:messages/en/animal",
//                "classpath:messages/en/person",
//
//                "classpath:messages/ko/animal",
//                "classpath:messages/ko/person",
//
//                "classpath:messages/vi/animal",
//                "classpath:messages/vi/person"
//
//        );
//        messageSource.setFallbackToSystemLocale(false);// if key not found, system locale not allowed
//        System.err.println("Loaded: " + Arrays.toString(messageSource.getBasenameSet().toArray()));
//        messageSource.getMessage("anyKey", null, Locale.getDefault());
//        return messageSource;
//    }

    // Cách tải tự động: Tối ưu khi tạo hay xóa các file ngôn ngữ
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.clearCache();
        messageSource.setBasenames(loadProperties());
        // Refresh cache
        messageSource.getMessage("anyKey", null, Locale.getDefault());
        messageSource.setFallbackToSystemLocale(false);// if key not found, system locale not allowed
        System.err.println("Loaded: " + Arrays.toString(messageSource.getBasenameSet().toArray()));
        return messageSource;
    }

    private String[] loadProperties() {
        List<String> propertiesFiles = new ArrayList<>();
        File path = new File("src/main/resources/messages");
        if (!path.exists() || !path.isDirectory()) {
            return new String[0];
        }
        loadPropertiesFromDirectory(path, propertiesFiles);
        return propertiesFiles.toArray(new String[0]);
    }

    private void loadPropertiesFromDirectory(File path, List<String> propertiesFiles) {
        File[] files = path.listFiles();
        if (files == null) {
            return;
        }
        String languageCode = path.getName();
        for (File file : files) {
            if (file.isDirectory()) {
                loadPropertiesFromDirectory(file, propertiesFiles);
            } else if (file.isFile() && file.getName().endsWith(".properties")) {
                String fileName = file.getName();
                String fileNameReplace = fileName.substring(0, fileName.lastIndexOf('_'));
                propertiesFiles.add("classpath:/messages/" + languageCode + "/" + fileNameReplace);
            }
        }
    }

//     private void loadPropertiesFromDirectory(File path, List<String> propertiesFiles) {
//             File[] files = path.listFiles();
//             if (files == null) {
//                 return;
//             }
//             String languageCode = path.getName();
//             for (File file : files) {
//                 if (file.isDirectory()) {
//                     loadPropertiesFromDirectory(file, propertiesFiles);
//                 } else if (!path.equals(new File("src/main/resources/i18n")) && file.isFile() && file.getName().endsWith(".properties")) {
//                     String fileName = file.getName();
//                     int lastIndex = fileName.lastIndexOf('_');
//                     if (lastIndex != -1) {
//                         fileName = fileName.substring(0, lastIndex);
//                     }
//                     propertiesFiles.add("classpath:/i18n/" + languageCode + "/" + fileName);
//                 }
//             }
//         }
}
