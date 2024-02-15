package com.delo.marketplace.model;

import com.delo.marketplace.enumuration.Measure;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "manufacture")
    private String manufacture;
    @Column(name = "model_product")
    private String modelProduct;
    @Column (name = "union_price")
    private int unionPrice;
    @Column(name = "measure")
    @Enumerated(EnumType.STRING)
    private Measure measure;
    @Column(name = "in_stoke")
    private Float inStoke;

    public Product(String manufacture, String modelProduct, int unionPrice, Measure measure, Float inStoke) {
        this.manufacture = manufacture;
        this.modelProduct = modelProduct;
        this.unionPrice = unionPrice;
        this.measure = measure;
        this.inStoke = inStoke;
    }
}
