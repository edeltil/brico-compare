import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core/src/metadata/ng_module";
import {RouterModule, Routes} from "@angular/router";
import {SharedModule} from "../../shared";
import {ProductListComponent} from "./product-list.component";

const routes: Routes = [
  {path: '', component: ProductListComponent},
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    SharedModule,
  ],
  declarations: [
    ProductListComponent,
  ],
  exports: [
    ProductListComponent,
  ]
})
export class ProductListModule {
}
