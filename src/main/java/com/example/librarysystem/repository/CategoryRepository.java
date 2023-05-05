package com.example.librarysystem.repository;

import com.example.librarysystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {


}
