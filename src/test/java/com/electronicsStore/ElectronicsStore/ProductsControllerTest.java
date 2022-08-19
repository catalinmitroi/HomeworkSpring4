package com.electronicsStore.ElectronicsStore;

import com.electronicsStore.ElectronicsStore.controller.ProductsController;
import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.model.Type;
import com.electronicsStore.ElectronicsStore.service.ProductsService;
import com.sun.istack.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductsController.class)
public class ProductsControllerTest {

    @MockBean
    ProductsService productsService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void it_should_get_all_products() throws Exception{
        Products testProducts = new Products(null, Type.ELB, "Aragaz","F2123",23,2);
        mockMvc.perform(get("product/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void it_should_add_stock() throws Exception {
        Products testProducts = new Products(null, Type.ELB, "Aragaz","d4523",3,false,32);
        mockMvc.perform(post("product/updateStock/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
