package com.example.SortingApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SortingApp.model.SortElement;


public interface SortElementRepository extends JpaRepository<SortElement, Long> {
	List<SortElement> findBySortResultIdOrderByIndex(int sortResultId);
}
