package com.example.cashierless_store.domain.bag;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
//@NoArgsConstructor
@Entity
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bag_id")
    private Long id;

//    @OneToMany(mappedBy = "user")
//    private List<UserProduct> userProductList = new ArrayList<UserProduct>();
    @Builder
    public Bag() {
    }

}
