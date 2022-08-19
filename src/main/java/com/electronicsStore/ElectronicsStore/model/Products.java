package com.electronicsStore.ElectronicsStore.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SQLDelete(sql = "UPDATE Products SET softDeleted=true WHERE id=?")
//@Where(clause="softDeleted=false")

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Type type;
    private String name;
    private String identityCod;
    private Integer stock;
    private Boolean Deleted = Boolean.FALSE;

    private Integer price;

    public Products(Integer id, Type tip, String s, String s1, int i, int i1) {
        this.id=id;
        this.type = tip;
        this.name = s;
        this.identityCod = s1;
        this.stock = i;
        this.price = i1;
    }

    public boolean isDeleted() {
        return this.Deleted;
    }
}
