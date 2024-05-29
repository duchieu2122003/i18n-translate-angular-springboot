import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LocaleService {
  private api = 'http://localhost:8080/api/locale';

  constructor(private http: HttpClient) {
  }
  changeLangServe(lang: string): Observable<any> {
    return this.http.get(this.api + '/' + lang)
  }
}
