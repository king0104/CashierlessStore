package com.example.cashierless_store.domain.userProduct;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.domain.userProduct.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepository extends JpaRepository<UserProduct, Long> {

    // userId로 up찾기
    @Query("select up from UserProduct up where up.user.id =:userId")
    List<UserProduct> findByUserId(@Param("userId") Long userId);


}
