//package com.example.server.locale;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//
//import java.util.Locale;
//
//@Component
//@Slf4j
//public class LocaleInterceptor implements HandlerInterceptor {
//
//    private final SessionLocaleResolver localeResolver;
//
//    public LocaleInterceptor(SessionLocaleResolver localeResolver) {
//        this.localeResolver = localeResolver;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        if (session.getAttribute("lang") == null) {
////            Locale defaultLocale = Locale.getDefault();
////            localeResolver.setLocale(request, response, defaultLocale);
//            session.setAttribute("lang", "vi");
//            LocaleContextHolder.setLocale(new Locale("vi"));
//        }else{
//            LocaleContextHolder.setLocale(new Locale(session.getAttribute("lang").toString()));
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.error("22222Post-handle method of LocaleInterceptor is invoked");
//        LocaleContextHolder.resetLocaleContext();
//    }
//}
