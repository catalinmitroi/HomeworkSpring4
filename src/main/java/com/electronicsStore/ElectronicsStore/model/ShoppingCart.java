package com.electronicsStore.ElectronicsStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*- create a SHoppingCart class
- a shoppingCart can contain multiple products
- a user should be able to add a product to a shopping cart
- a user should be able to remove a product from a shopping cart
_ a user should see the total price of the shopping cart
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Products> productsList;

    public Integer totalPrice(){
        Integer sum=0;
        for(int i=0;i< this.productsList.size();i++){
            sum +=productsList.get(i).getPrice();
        }
        return sum;
    }

    public void addProduct(Products product){
        this.productsList.add(product);
    }

    public void removeProduct(Products product){
        this.productsList.remove(product);
    }
}
