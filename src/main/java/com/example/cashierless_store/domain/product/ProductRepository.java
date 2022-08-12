package com.example.cashierless_store.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // 유저프로덕트-프로덕트 테이블 조인 후,
    // userId 조건으로 필터링
    @Query("select p from UserProduct up join up.product p " +
            "where up.user.id =:userId")
    List<Product> getProductListByUserId(@Param("userId") Long userId);
}
