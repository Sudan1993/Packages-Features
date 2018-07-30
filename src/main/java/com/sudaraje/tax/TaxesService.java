package com.sudaraje.tax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxesService {

	@Autowired
	private TaxesRepository taxRepository;

	public List<Taxes> getAllTaxes() {
		// TODO Auto-generated method stub
		List<Taxes> taxes = new ArrayList<>();
		taxRepository.findAll().forEach(taxes::add);
		System.out.println(taxes);
		return taxes;
	}

	public List<Taxes> findByTaxesName(String country) {
		// TODO Auto-generated method stub
		return taxRepository.findByCountry(country);
	}

	public void insertTaxes(Taxes taxes) {
		// TODO Auto-generated method stub
		System.out.println(taxes.toString());
		taxRepository.save(taxes);
		
	}

	public void delete(String taxName) {
		// TODO Auto-generated method stub
		if(taxRepository.findByCountry(taxName).size()!=0) {
			List<Taxes> taxList = taxRepository.findByCountry(taxName);
			taxList.forEach(x -> taxRepository.delete(x));
		}else {
			System.out.println("no tax found with the specified name");
		}
		
	}
	
}
