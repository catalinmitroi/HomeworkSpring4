package com.electronicsStore.ElectronicsStore.controller;

import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductsController {
    private final ProductsService productsService;

    //get all products with deleted products
    @GetMapping("all")
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    //get all products without deleted products
    @GetMapping("nonDeleted")
    public List<Products> getAllNonDeletedProducts() {
        return productsService.getAllNDeletedProducts();
    }

    //add products
    @PostMapping
    public Products addProducts(@RequestBody Products products) {
        return productsService.addProducts(products);
    }

    //softDelete
    @PutMapping("delete/{id}")
    public void softDelete(@PathVariable("id") Integer id) {
        productsService.softDelete(id);
    }

    //update Stock
    @PutMapping("updateStock/{id}")
    public void updateStock(@PathVariable("id") Integer id) {
        productsService.updateStock(id);
    }

    //increment stock
    @PutMapping("increment/{id}")
    public void increment(@PathVariable("id") Integer id) {
        productsService.incrementStock(id);
    }

    //decrement stock
    @PutMapping("decrement/{id}")
    public void decrement(@PathVariable("id") Integer id) {
        productsService.decrementStock(id);
    }

    }
