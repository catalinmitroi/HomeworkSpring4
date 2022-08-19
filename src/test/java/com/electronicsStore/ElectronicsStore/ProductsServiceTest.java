package com.electronicsStore.ElectronicsStore;

import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.repository.ProductsRepository;
import com.electronicsStore.ElectronicsStore.service.ProductsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.electronicsStore.ElectronicsStore.model.Type.ELB;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductsServiceTest {

    @Mock
    ProductsRepository productsRepository;

    @InjectMocks
    ProductsService productsService;

    @Test
    public void when_save_product_it_should_return_user() {
        Products products = new Products(null,ELB,"Frigider","F54",14,2);
        when(productsRepository.save(any(Products.class))).thenReturn(new Products());
        Products createdProducts = productsService.addProducts(products);
        assertThat(createdProducts.getName()).isSameAs(products.getName());
    }

}
