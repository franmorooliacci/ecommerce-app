import { Product } from "./product";

export class CartItem {
    id: number;
    name: string;
    imageUrl: string;
    unitPrice: number;
    size: string;
    quantity: number;

    constructor(product: Product){
        this.id = product.id;
        this.name = product.name;
        this.imageUrl = product.imageUrl;
        this.unitPrice = product.unitPrice;
        if(product.size == null || product.size == undefined){
            this.size = 'L';
        } else {
            this.size = product.size;
        }
        this.quantity = 1;
    }
}
