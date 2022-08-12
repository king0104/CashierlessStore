package com.example.cashierless_store.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

//    @OneToMany(mappedBy = "user")
//    private List<UserProduct> userProductList = new ArrayList<UserProduct>();
    @Builder
    public User() {
    }

}
