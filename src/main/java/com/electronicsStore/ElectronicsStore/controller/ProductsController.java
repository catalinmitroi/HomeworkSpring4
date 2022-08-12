package com.electronicsStore.ElectronicsStore.controller;

import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    //get all products with deleted products
    @GetMapping("products/all")
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    //get all products without deleted products
    @GetMapping("products/nonDeleted")
    public List<Products> getAllNonDeletedProducts() {
        return productsService.getAllNDeletedProducts();
    }

    //add products
    @PostMapping("products")
    public Products addProducts(@RequestBody Products products) {
        return productsService.addProducts(products);
    }

    //softDelete
    @PutMapping("products/delete/{id}")
    public void softDelete(@PathVariable("id") Integer id) {
        productsService.softDelete(id);
    }

    //update Stock
    @PutMapping("products/updateStock/{id}")
    public void updateStock(@PathVariable("id") Integer id) {
        productsService.updateStock(id);
    }

    //increment stock
    @PutMapping("products/increment/{id}")
    public void increment(@PathVariable("id") Integer id) {
        productsService.incrementStock(id);
    }

    //decrement stock
    @PutMapping("products/decrement/{id}")
    public void decrement(@PathVariable("id") Integer id) {
        productsService.decrementStock(id);
    }

    }
