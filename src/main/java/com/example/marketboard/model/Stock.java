package com.example.marketboard.model;

import lombok.Builder;

import javax.persistence.*;

@Builder
@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional=false)
	private Writing writing;
}
////Hello world