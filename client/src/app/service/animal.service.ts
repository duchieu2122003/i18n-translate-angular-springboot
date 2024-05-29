import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  private api = 'http://localhost:8081/api/animal';

  constructor(private http: HttpClient) {
  }

  getMessageName(): Observable<any> {
    return this.http.get(this.api + '/message-name')
  }

  getMessageAge(): Observable<any> {
    return this.http.get(this.api + '/message-age')
  }
}
