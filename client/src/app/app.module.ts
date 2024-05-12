import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {MissingTranslationHandler, TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {ToastrModule} from "ngx-toastr";
import {MyMissingTranslationHandler} from "./config/language.service";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {InterceptorLanguage} from "./config/interceptor-language.service";

export function httpTranslateLoader(http: HttpClient): TranslateHttpLoader {
  return new TranslateHttpLoader(http, '/assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    //   Add
    BrowserAnimationsModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: httpTranslateLoader,
        deps: [HttpClient]
      },
      missingTranslationHandler: {
        provide: MissingTranslationHandler,
        useClass: MyMissingTranslationHandler
      }
    })
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: InterceptorLanguage, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

  // constructor(private translate: TranslateService) {
  //   this.translate.setDefaultLang('vi');
  // }

}
