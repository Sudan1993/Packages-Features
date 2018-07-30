package com.sudaraje.features;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeaturesService {

	@Autowired
	private FeaturesRepository featureRepository;
	
	public List<Features> getAllFeatures() {
		// TODO Auto-generated method stub
		List<Features> features = new ArrayList<>();
		featureRepository.findAll().forEach(features::add);
		System.out.println(features);
		return features;
	}

	public List<Features> findByFeatureName(String featureName) {
		// TODO Auto-generated method stub
		return featureRepository.findByFeatureName(featureName);
	}

	public void insertFeature(Features feature) {
		// TODO Auto-generated method stub
		System.out.println(feature.toString());
		featureRepository.save(feature);
	}

	public void deleteFeature(String featureName) {
		// TODO Auto-generated method stub
		if(featureRepository.findByFeatureName(featureName).size()!=0) {
			//remove the list of users with the specified username
			List<Features> userList = featureRepository.findByFeatureName(featureName);
			userList.forEach(x -> featureRepository.delete(x));
		}else {
			System.out.println("no user found with the specified name");
		}
	}
	
}
