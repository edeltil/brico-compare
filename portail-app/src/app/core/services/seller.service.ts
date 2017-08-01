import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {JsonHttp} from "./";

const url = '/api/sellers';

@Injectable()
export class CategoryService {
  //http://localhost:8090/sellers

  constructor(private http: JsonHttp) {
  }

  get():Observable<Seller> {
    return this.http.get(`${url}`)
    .map(res => res.json());
  }

}
