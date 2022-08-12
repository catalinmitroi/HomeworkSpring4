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
    Integer id;
    @NotNull
    String name;
    @NotNull
    String identityCod;
    @NotNull
    Type type;
    @NotNull
    Integer stock;
    Boolean Deleted = Boolean.FALSE;

    public boolean isDeleted() {
        return this.Deleted;
    }
}
