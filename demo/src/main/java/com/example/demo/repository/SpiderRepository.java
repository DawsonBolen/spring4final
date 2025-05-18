package com.example.demo.repository;

import com.example.demo.model.Spider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpiderRepository extends JpaRepository<Spider, Long> {

}
