import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../common/product';
import { CartService } from '../../services/cart.service';
import { CartItem } from '../../common/cart-item';
import { ProductSize } from '../../common/product-size';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent implements OnInit{

  product!: Product;
  productSizes: ProductSize[] = [];
  selectedValue: string = '';

  constructor(private productService: ProductService,
              private cartService: CartService,
              private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleProductDetails();
    });
    this.loadProductSizes();
  }

  handleProductDetails() {
    
    // get the 'id' param
    const productId: number = +this.route.snapshot.paramMap.get('id')!;

    this.productService.getProduct(productId).subscribe(
      data => {
        this.product = data;
      }
    );
  }

  onSelectionChange(event: Event) {
    console.log('Selected value:', this.selectedValue);
    this.product.size = this.selectedValue;
  }

  addToCart(){
    console.log(`Adding to cart: ${this.product.name}, ${this.product.unitPrice}`);
    const cartItem = new CartItem(this.product);
    this.cartService.addToCart(cartItem);
  }

  loadProductSizes(): void {
    const productId = +this.route.snapshot.paramMap.get('id');
    this.productService.getProductSizesByProductId(productId).subscribe(
      (productSizes: ProductSize[]) => {
        this.productSizes = productSizes;
      }
    );
  }
}
