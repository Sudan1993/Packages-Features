package com.sudaraje.features;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeaturesController {

	@Autowired
	private FeaturesService featuresService;
	
	@RequestMapping("/features/getAll")
	public List<Features> getAllFeatures() {
		return featuresService.getAllFeatures();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/features")
	@ResponseBody
	public ResponseEntity<Object> insertFeature(@RequestBody Features feature) {
		System.out.println(feature.toString());
		System.out.println(featuresService.findByFeatureName(feature.getFeatureName()).size());
		if(featuresService.findByFeatureName(feature.getFeatureName()).size()!=0){
			return new ResponseEntity<>("FeatureName already exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			featuresService.insertFeature(feature);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/features/{featureName}")
	@ResponseBody
	public ResponseEntity<Object> deleteFeature(@PathVariable String featureName) {
		if(featuresService.findByFeatureName(featureName).size()==0){
			return new ResponseEntity<>("FeatureName doesnt exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			featuresService.deleteFeature(featureName);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
	}
	
}