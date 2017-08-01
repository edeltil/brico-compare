import {inject, TestBed} from "@angular/core/testing";
import {
  ResponseOptions,
  Response,
  BaseResponseOptions,
  RequestMethod,
  HttpModule
} from "@angular/http";
import {MockBackend} from "@angular/http/testing";
import {CategoryService} from "./category.service";
import {CategoryParams} from "../dto";
import {APP_TEST_HTTP_PROVIDERS} from "../../../testing";

const dummyGetJson = ["Chauffage au bois","Chauffage d'appoint","Livre","Thermostat et programmateur de chauffage","Climatiseur","Pompe à chaleur","Raccordement au gaz","Radiateur électrique","Radiateur à eau chaude","Radiateur chauffage centrale","Plancher chauffant","Combustible et allumage","Production d'énergie et de chauffage renouvelable","Aérateur"];

describe('CategoryService', () => {

  let categoryService: CategoryService;
  let backend: MockBackend;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpModule,
      ],
      providers: [
        APP_TEST_HTTP_PROVIDERS,
        CategoryService,
      ],
    });
  });
  beforeEach(inject([CategoryService, MockBackend], (..._) => {
    [categoryService, backend] = _;
  }));

  describe('.get', () => {
    it("get category", (done) => {
      backend.connections.subscribe(conn => {
        conn.mockRespond(new Response(new ResponseOptions({
          body: JSON.stringify(dummyGetJson),
        })));
        expect(conn.request.method).toEqual(RequestMethod.Get);
        expect(conn.request.url).toEqual('/category?root=chauffage');
      });
      categoryService.get(chauffage).subscribe(res => {
        expect(res).toEqual(dummyGetJson);
        done();
      });
    });
  }); // .get

});
