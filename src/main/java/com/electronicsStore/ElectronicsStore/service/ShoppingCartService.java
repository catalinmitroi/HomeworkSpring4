package com.electronicsStore.ElectronicsStore.service;

import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.model.ShoppingCart;
import com.electronicsStore.ElectronicsStore.repository.ProductsRepository;
import com.electronicsStore.ElectronicsStore.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductsRepository productsRepository;

    //create empty cart
    public ShoppingCart createShoppingCart(){
        ShoppingCart sc = new ShoppingCart();
        shoppingCartRepository.save(sc);
        return sc;
    }

    //add
    public void addProduct(Integer productId, Integer shoppingCartId){
        Products product = productsRepository.findById(productId).get();
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        shoppingCart.addProduct(product);
    }

    //remove
    public void removeProduct(Integer productId, Integer shoppingCartId){
        Products product = productsRepository.findById(productId).get();
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        shoppingCart.removeProduct(product);
    }

    //show total price
    public Integer totalPrice(Integer shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();
        return shoppingCart.totalPrice();
    }
}


