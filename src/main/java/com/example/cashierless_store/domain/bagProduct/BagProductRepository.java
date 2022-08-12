package com.example.cashierless_store.domain.bagProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BagProductRepository extends JpaRepository<BagProduct, Long> {

    // userId로 up찾기
    @Query("select up from BagProduct up where up.bag.id =:bagId")
    List<BagProduct> findByBagId(@Param("bagId") Long bagId);


}
