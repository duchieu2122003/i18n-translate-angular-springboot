import {Injectable} from "@angular/core";
import {ToastrService} from "ngx-toastr";
import {MissingTranslationHandler, MissingTranslationHandlerParams, TranslateService} from "@ngx-translate/core";
import {registerLocaleData} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  constructor(private toast: ToastrService, private translate: TranslateService) {
  }

  switchLanguage(language: string) {
    let lag = localStorage.getItem('lang') || 'vi';
    let langStorage: string = language.substring(0, language.indexOf("/"));
    this.translate.use(language);
    localStorage.setItem('lang', langStorage)
      registerLocaleData(langStorage);
  }

  langStorage() {
    let lag: string | null = localStorage.getItem('lang');
    if (lag == null) {
      localStorage.setItem('lang', 'vi');
    }
    return localStorage.getItem('lang');
  }
}

@Injectable({
  providedIn:'root'
})
export class MyMissingTranslationHandler implements MissingTranslationHandler {
  handle(params: MissingTranslationHandlerParams) {
    console.log(`Missing translation for key: ${params.key}`);
    return params.key;
  }
}
