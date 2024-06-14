package com.example.SortingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="sortElements")
public class SortElement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="sort_id", nullable=false)
	@JsonIgnore
	private SortResult sortResult;
	@Column(name="value")
	private int value;
	@Column(name="index")
	private int index;
	

    public SortElement() {
    }

    public SortElement(SortResult sortResult, Integer value, int index) {
        this.sortResult = sortResult;
        this.value = value;
        this.index = index;
    }

	public int getValue() {
		return value;
	}
	
}
