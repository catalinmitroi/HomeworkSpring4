package com.electronicsStore.ElectronicsStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<com.electronicsStore.ElectronicsStore.model.ShoppingCart, Integer> {
    Integer totalPrice();
}
