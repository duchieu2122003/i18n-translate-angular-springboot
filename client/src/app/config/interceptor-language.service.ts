import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class InterceptorLanguage implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const lang = localStorage.getItem('lang');
    if (lang == null) {
      let langFavorite = navigator.languages[0];
      localStorage.setItem('lang', langFavorite);
    }
    const modifiedRequest = req.clone({
      url: `${req.url}?lang=` + localStorage.getItem('lang')
    });
    return next.handle(modifiedRequest);
  }


}
