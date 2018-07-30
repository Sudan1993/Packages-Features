package com.sudaraje.tax;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sudaraje.features.Features;

@Entity
@Table(name="Taxes")
public class Taxes {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "taxId", insertable=true, updatable=true, unique=true)
	private Long taxId ;
	
	private String country;
	private Long taxAmount;
	public Long getTaxId() {
		return taxId;
	}
	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Long taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Taxes(Long taxId, String country, Long taxAmount) {
		super();
		this.taxId = taxId;
		this.country = country;
		this.taxAmount = taxAmount;
	}
	public Taxes() {}
	
}