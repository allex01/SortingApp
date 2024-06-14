package com.example.SortingApp.service;

import com.example.SortingApp.model.*;
import com.example.SortingApp.repository.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class SortService {
	
	@Autowired
	private SortResultRepository sortResultRepository;
	@Autowired
	private SortElementRepository sortElementRepository;
	
	@Transactional
	public SortResult saveSortedArray(List<Integer> array) {
		SortResult sortResult = new SortResult();
		sortResultRepository.save(sortResult);
		
		List<SortElement> elements = IntStream.range(0, array.size())
				.mapToObj(i->new SortElement(sortResult,array.get(i),i))
				.collect(Collectors.toList()); 
		
		sortElementRepository.saveAll(elements);
		return sortResult;
	}
	
	public List<Integer> getSortedArrayById(int id) {
		return sortElementRepository.findBySortResultIdOrderByIndex(id).stream()
				.map(SortElement::getValue)
				.collect(Collectors.toList());
	}
}
