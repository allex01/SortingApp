package com.example.SortingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SortingApp.model.SortResult;

public interface SortResultRepository extends JpaRepository<SortResult,Long> {

}
