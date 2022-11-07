import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>("http://localhost:8080/api/v1/products");
  }

  public addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>("http://localhost:8080/api/v1/create/product/", product);
  }

  public updateProduct(product: Product): Observable<Product> {
    return this.http.put<Product>("http://localhost:8080/api/v1/update", product);
  }

  public deleteProduct(productId: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/api/v1/product/${productId}`);
  }
}
