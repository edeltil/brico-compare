import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {SimpleProduct} from "../../core/domains";
import {ProductService} from "../../core/services/product.service";
import {HttpErrorHandler} from "../../core/services/http-error-handler";
import {styles} from './user-list.component.styles';

@Component({
  selector: 'mpt-product-list',
  templateUrl: 'product-list.component.html',
})
export class ProductListComponent implements OnInit {

  styles: any = styles;
  products: Product[];
  totalPages: number;
  page: number;

  constructor(private productService: ProductService,
              private errorHandler: HttpErrorHandler,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.page = +(params['page'] || 1);
      this.list(this.page);
    });
  }

  onPageChanged(page: number) {
    this.router.navigate(['/products', {page: page}]);
  }

  private list(page: number) {
    this.productService.list({page: page, size: 5})
      .subscribe(productsPage => {
        this.products = productsPage.content;
        this.totalPages = productsPage.totalPages;
      }, e => this.errorHandler.handle(e))
    ;
  }

}
