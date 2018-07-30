package com.sudaraje.packages;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PackagesRepository extends CrudRepository<Packages, Long>{

	List<Packages> findByPackageName(String packageName);
}
