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
    this.translate.use(language);
    localStorage.setItem('lang', language)
    registerLocaleData(language);
    this.toast.success(this.translate.instant('success.language'));
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
  providedIn: 'root'
})
export class MyMissingTranslationHandler implements MissingTranslationHandler {
  handle(params: MissingTranslationHandlerParams): string {
    return `${translationNotFound}[${params.key}]`;
  }
}

export const translationNotFound = 'not-found-key';
