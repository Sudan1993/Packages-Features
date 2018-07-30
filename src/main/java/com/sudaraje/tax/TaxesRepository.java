package com.sudaraje.tax;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaxesRepository extends CrudRepository<Taxes, Long>{
	
	List<Taxes> findByCountry(String countryName);
}
