package com.ps.customermngsystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Actor {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ano;
		private String aname;
		private int age;

		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		   @JoinTable(
		           name = "bollywood",
		           joinColumns = @JoinColumn(name = "fano"),
		           inverseJoinColumns = @JoinColumn(name = "fmno")
		           )
		List<Movie> porfolio;
}
