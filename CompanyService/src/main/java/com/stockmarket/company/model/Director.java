package com.stockmarket.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "director_id")
	private Integer durectorId;
	@Column(name = "director_name")
	private String directorName;
	public Integer getDurectorId() {
		return durectorId;
	}
	public void setDurectorId(Integer durectorId) {
		this.durectorId = durectorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public Director(String directorName) {
		super();
		//this.durectorId = durectorId;
		this.directorName = directorName;
	}
	public Director() {
		super();
	}

}
