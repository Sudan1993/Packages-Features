package com.sudaraje.features;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FeaturesRepository extends CrudRepository<Features, Long>{

	List<Features> findByFeatureName(String featureName);
}
