package com.example.cashierless_store.domain.userProduct;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@NoArgsConstructor
@Entity
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public UserProduct(User user, Product product) {
        this.user = user;
        this.product = product;
    }



}
