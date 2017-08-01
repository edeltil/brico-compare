import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {JsonHttp} from "./";

const url = '/api/categories';

@Injectable()
export class CategoryService {
  //http://localhost:8090/category?root=Chauffage
//http://localhost:8090/category?root=

  constructor(private http: JsonHttp) {
  }

  get(root: string):Observable<Category> {
    return this.http.get(`${url}?root=${root}`)
    .map(res => res.json());
  }

}
