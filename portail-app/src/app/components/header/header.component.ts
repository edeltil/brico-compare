import {Component, OnInit, HostListener} from "@angular/core";
import {Router} from "@angular/router";
import {CategoryService} from "../../core/services/category.service";
import {SellerService} from "../../core/services/seller.service";
import {styles} from "./header.component.styles";

@Component({
  selector: 'mpt-header',
  templateUrl: 'header.component.html',
})
export class HeaderComponent implements OnInit {

  styles: any = styles;
  isSignedIn: boolean;
  isMenuHidden: boolean = true;
  sellers: Seller[] = [];
  category1: Category[] = [];
  category2: Category[] = [];

  constructor(private router: Router,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.sellers = this.sellerService.get();
    this.category1 = this.categoryService.get("");
    this.category2 = this.categoryService.get("");
  }

  onChangeSeller(newValue) {
    console.log(newValue);
    this.selectedCategory1 = newValue;
  }
  onChangeCategory1(newValue) {
    console.log(newValue);
    this.selectedCategory1 = newValue;
    this.category2 = this.categoryService.get(this.selectedCategory1.label);
  }
  onChangeCategory2(newValue) {
    console.log(newValue);
    this.selectedCategory2 = newValue;
  }

  logout() {
    this.router.navigate(['/login']);
  }

  toggleMenu(e: Event) {
    this.isMenuHidden = !this.isMenuHidden;
    e.stopPropagation();
  }

  @HostListener('document:click') hideMenu() {
    this.isMenuHidden = true;
  }

}
