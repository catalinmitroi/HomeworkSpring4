package com.electronicsStore.ElectronicsStore.controller;

import com.electronicsStore.ElectronicsStore.model.ShoppingCart;
import com.electronicsStore.ElectronicsStore.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PutMapping("{productId}/{shoppingCartId}")
    public void addProduct(@PathVariable Integer productId, @PathVariable Integer shoppingCartId){
        shoppingCartService.addProduct(productId,shoppingCartId);
    }

    @DeleteMapping("{productId}/{shoppingCartId}")
    public void removeProduct(@PathVariable Integer productId, @PathVariable Integer shoppingCartId){
        shoppingCartService.removeProduct(productId,shoppingCartId);
    }

    @GetMapping("price/{shoppingCartId}")
    public Integer totalPrice(@PathVariable Integer shoppingCartId){
        return shoppingCartService.totalPrice(shoppingCartId);
    }

    @PostMapping("create")
    public ShoppingCart createShoppingCart(){
        return shoppingCartService.createShoppingCart();
    }

}
