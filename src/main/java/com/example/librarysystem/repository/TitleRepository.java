package com.example.librarysystem.repository;

import com.example.librarysystem.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, String> {


}
