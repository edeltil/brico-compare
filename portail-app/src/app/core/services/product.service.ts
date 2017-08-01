import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {Response} from "@angular/http";
import {SimpleProduct} from "../domains";
import {objToSearchParams} from "./helpers";
import {PageRequest, Page, ProductParams} from "../dto";
import {JsonHttp} from "./";

const url = '/api/search';
const defaultPageRequest: PageRequest = {page: 1, size: 5};

@Injectable()
export class ProductService {

  constructor(private http: JsonHttp) {
  }

  list(pageRequest: PageRequest = defaultPageRequest): Observable<Page<SimpleProduct>> {
    return this.http.get(url, {search: objToSearchParams(pageRequest)})
      .map(res => res.json())
      ;
  }

  get(id: string|number): Observable<Product> {
    return this.http.get(`${url}/${id}`)
      .map(res => res.json())
      ;
  }

  create(params: ProductParams): Observable<Response> {
    return this.http.post(url, params);
  }

  updateMe(productParam: ProductParams): Observable<Response> {
    return this.http.patch(`${url}/me`, productParam);
  }

}
