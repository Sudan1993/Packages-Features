package com.sudaraje.tax;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudaraje.features.Features;


@RestController
public class TaxesController {

	@Autowired
	private TaxesService taxesService;
	
	@RequestMapping("/taxes/getAll")
	public List<Taxes> getAllTaxes() {
		return taxesService.getAllTaxes();
	}
	
	// receiving a single tax and inserting it
	@RequestMapping(method=RequestMethod.POST, value="/taxes")
	@ResponseBody
	public ResponseEntity<Object> insertTaxes(@RequestBody Taxes taxes) {
		System.out.println(taxes.toString());
		System.out.println(taxesService.findByTaxesName(taxes.getCountry()).size());
		if(taxesService.findByTaxesName(taxes.getCountry()).size()!=0){
			return new ResponseEntity<>("TaxesName already exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			taxesService.insertTaxes(taxes);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/taxes/{taxName}")
	@ResponseBody
	public ResponseEntity<Object> deleteTaxes(@PathVariable String taxName) {
		if(taxesService.findByTaxesName(taxName).size()==0){
			return new ResponseEntity<>("TaxesName doesnt exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			taxesService.delete(taxName);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
	}
	
}