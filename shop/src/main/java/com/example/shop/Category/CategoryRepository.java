package com.example.shop.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//JPA repository
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
