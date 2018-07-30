package com.sudaraje.packages;

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
public class PackagesController {

	@Autowired
	private PackagesService packagesService;
	
	@RequestMapping("/packages/getAll")
	public List<Packages> getAllPackages() {
		return packagesService.getAllPackages();
	}
	
	// receiving a single package and inserting it
	@RequestMapping(method=RequestMethod.POST, value="/packages")
	@ResponseBody
	public ResponseEntity<Object> insertPackage(@RequestBody Packages packages) {
		System.out.println(packages.toString());
		System.out.println(packagesService.findByPackageName(packages.getPackageName()).size());
		if(packagesService.findByPackageName(packages.getPackageName()).size()!=0){
			return new ResponseEntity<>("PackageName already exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			Set<Features> features = packages.getFeatures();
			packages.setFeatures(features);
			//features.forEach(System.out::println);			
			Iterator<Features> iter = features.iterator();
			while(iter.hasNext()) {
				Features feature = iter.next();
				packages.getFeatures().add(new Features(feature.getFeatureName(),feature.getFeatureDescription()));
			}
			packagesService.insertPackage(packages);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/packages/{packageName}")
	@ResponseBody
	public ResponseEntity<Object> deletePackage(@PathVariable String packageName) {
		if(packagesService.findByPackageName(packageName).size()==0){
			return new ResponseEntity<>("PackageName doesnt exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			packagesService.deletePackage(packageName);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
	}
	
}