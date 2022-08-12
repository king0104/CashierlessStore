package com.example.cashierless_store.domain.bagProduct;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.domain.bag.Bag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@NoArgsConstructor
@Entity
public class BagProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bag_product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public BagProduct(Bag bag, Product product) {
        this.bag = bag;
        this.product = product;
    }



}
