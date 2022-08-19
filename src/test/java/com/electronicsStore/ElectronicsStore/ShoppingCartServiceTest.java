package com.electronicsStore.ElectronicsStore;

import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.model.ShoppingCart;
import com.electronicsStore.ElectronicsStore.repository.ShoppingCartRepository;
import com.electronicsStore.ElectronicsStore.service.ProductsService;
import com.electronicsStore.ElectronicsStore.service.ShoppingCartService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.electronicsStore.ElectronicsStore.model.Type.ELB;
import static com.electronicsStore.ElectronicsStore.model.Type.ELG;
import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void it_should_create_shoppingCart() throws Exception{
        Products prod1 = new Products(null,ELB,"Frigider","F54",14,2);
        Products prod2 = new Products(null,ELG,"Aragaz","A231",12,34);
        List<Products> myList = new ArrayList<Products>();
        myList.add(prod1);
        myList.add(prod2);
       ShoppingCart testShoppingCart = new ShoppingCart(null,myList);
        when(shoppingCartRepository.save(any(ShoppingCart.class))).thenReturn(new ShoppingCart());
        ShoppingCart created = shoppingCartService.createShoppingCart();
        assertEquals(created.getId(),testShoppingCart.getId());

    }
}
