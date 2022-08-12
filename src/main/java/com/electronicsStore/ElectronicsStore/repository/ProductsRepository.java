package com.electronicsStore.ElectronicsStore.repository;

import com.electronicsStore.ElectronicsStore.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    /*@Modifying
    @Transactional
    @Query("UPDATE Products p SET Deleted=true WHERE p.id = :id")
    void softDeleteById(Integer id);*/
    @Modifying
    @Transactional
    @Query("UPDATE Products p set p.stock = p.stock - 2 WHERE p.id = :productId AND p.Deleted = false")
    void updateStock(Integer productId);
    @Modifying
    @Transactional
    @Query("UPDATE Products p set p.stock = p.stock - 1 WHERE p.id = :productId")
    void decrementStock(Integer productId);
    @Modifying
    @Transactional
    @Query("UPDATE Products p set p.stock = p.stock + 1 WHERE p.id = :productId")
    void incrementStock(Integer productId);
}
