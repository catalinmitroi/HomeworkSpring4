package com.electronicsStore.ElectronicsStore.service;

import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    //add product
    public Products addProducts(Products products){
      /*  Products p = new Products();
        p.setName(products.getName());
        p.setIdentityCod(products.getIdentityCod());
        p.setStock(products.getStock());
        return productsRepository.save(p);*/
        return productsRepository.save(products);
    }

    //soft delete
    public void softDelete(Integer id){
        Products p = productsRepository.findById(id).get();
        p.setDeleted(true);
        productsRepository.save(p);
        //productsRepository.softDeleteById(id);
    }

    // get all products without deleted products
    public List<Products> getAllNDeletedProducts(){
         return productsRepository.findAll().stream()
                 .filter(products -> products.isDeleted() == Boolean.FALSE)
                 .collect(Collectors.toList());
    }

    //get all products + products deleted
    public List<Products> getAllProducts(){
        return productsRepository.findAll();

    }

    //update stock
    public void updateStock(Integer productId){
        productsRepository.updateStock(productId);
    }

    //increment atomic
    public void incrementStock(Integer productId){
        productsRepository.incrementStock(productId);
    }

    //decrement atomic
    public void decrementStock(Integer productId){
        productsRepository.decrementStock(productId);
    }
}
