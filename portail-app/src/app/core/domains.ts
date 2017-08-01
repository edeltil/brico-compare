export interface Category {
  label:string;
}
export interface Seller{
label:string;
}
export interface Product{
id:string;
title:string;
description:string;
url:string;
price:number;
oldPrice:number;
image:string;
shortDescription:string;
unit:string;
seller:string;
categorieSeller:string;
rate:number;
}
export interface SimpleProduct{
id:string;
title:string;
price:number;
oldPrice:number;
image:string;
shortDescription:string;
seller:string;
rate:number;
}
