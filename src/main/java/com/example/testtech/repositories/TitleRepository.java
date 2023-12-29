package com.example.testtech.repositories;

import com.example.testtech.models.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title,Integer> {
}
