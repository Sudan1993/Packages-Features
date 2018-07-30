package com.sudaraje.packages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagesService {

	@Autowired
	private PackagesRepository packageRepository;

	public List<Packages> getAllPackages() {
		// TODO Auto-generated method stub
		List<Packages> packages = new ArrayList<>();
		packageRepository.findAll().forEach(packages::add);
		System.out.println(packages);
		return packages;
	}

	public List<Packages> findByPackageName(String packageName) {
		// TODO Auto-generated method stub
		return packageRepository.findByPackageName(packageName);
	}

	public void deletePackage(String packageName) {
		// TODO Auto-generated method stub
		if(packageRepository.findByPackageName(packageName).size()!=0) {
			List<Packages> packageList = packageRepository.findByPackageName(packageName);
			packageList.forEach(x -> packageRepository.delete(x));
		}else {
			System.out.println("no package found with the specified name");
		}
	}

	public void insertPackage(Packages packages) {
		// TODO Auto-generated method stub
		System.out.println(packages.toString());
		packageRepository.save(packages);
		
	}
	
}
