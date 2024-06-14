package com.example.SortingApp.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="sortResults")
public class SortResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="sortResult",
			cascade=CascadeType.ALL)
    private List<SortElement> elements = new ArrayList<>();
}
