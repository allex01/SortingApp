package com.example.SortingApp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.SortingApp.BubbleSort;
import com.example.SortingApp.service.SortService;

@RestController
public class SortController {
	
	@Autowired
	private SortService sortService;
	
	
	@PostMapping("/sort")
    public ResponseEntity<String> sortArray(@RequestBody String str_array) {
		
		try {
			String[] nums_array = str_array.split(",");
			List<Integer> array = Arrays.stream(nums_array).
					map(Integer::parseInt).
					collect(Collectors.toList());
			List<Integer> sortedArray = BubbleSort.bubbleSort(array);
			sortService.saveSortedArray(sortedArray);
			String sortedArrayStr=sortedArray.toString();
			
	        return new ResponseEntity<>(sortedArrayStr, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Ошибка: неправильно введён массив", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}
        
    }
	
	@GetMapping("/getSortedArray")
	public ResponseEntity<String> getSortedArray(@RequestParam("id") String sort_id){
		try {
			int id = Integer.parseInt(sort_id);
			List<Integer> sortedArray = sortService.getSortedArrayById(id);
			if(sortedArray.isEmpty()) {
				return new ResponseEntity<>("Ошибка: такого id сортировки не существует", HttpStatus.OK);
			}
			String sortedArrayStr=sortedArray.toString();
			return new ResponseEntity<>(sortedArrayStr, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Ошибка: такого id сортировки не существует", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}
	}
	
}
