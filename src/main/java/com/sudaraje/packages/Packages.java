package com.sudaraje.packages;

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
@Table(name="Packages")
public class Packages {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "packageId", insertable=true, updatable=true, unique=true)
	private Long packageId ;
	
	private String packageName;
	private String packageDescription;
	private Long minUsersAllowed;
	private Long priceUserMonth;
	private Long priceUserYear;
	private Long trialPeriodDays;
	
	@ManyToMany(targetEntity=Features.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name = "packages_features",joinColumns = {@JoinColumn(referencedColumnName="packageId")},
			inverseJoinColumns = {@JoinColumn(referencedColumnName="featureId")})
	private Set<Features> features = new HashSet<>();
	
	
	public Set<Features> getFeatures() {
		return features;
	}
	public void setFeatures(Set<Features> features) {
		this.features = features;
	}
	public Long getPackageId() {
		return packageId;
	}
	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDescription() {
		return packageDescription;
	}
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}
	public Long getMinUsersAllowed() {
		return minUsersAllowed;
	}
	public void setMinUsersAllowed(Long minUsersAllowed) {
		this.minUsersAllowed = minUsersAllowed;
	}
	public Long getPriceUserMonth() {
		return priceUserMonth;
	}
	public void setPriceUserMonth(Long priceUserMonth) {
		this.priceUserMonth = priceUserMonth;
	}
	public Long getPriceUserYear() {
		return priceUserYear;
	}
	public void setPriceUserYear(Long priceUserYear) {
		this.priceUserYear = priceUserYear;
	}
	public Long getTrialPeriodDays() {
		return trialPeriodDays;
	}
	public void setTrialPeriodDays(Long trialPeriodDays) {
		this.trialPeriodDays = trialPeriodDays;
	}
	
	public void addFeature(Features feature) {
		features.add(feature);
		feature.getPackages().add(this);
    }
 
    public void removeFeature(Features feature) {
    	features.remove(feature);
		feature.getPackages().remove(this);
    }
	
	public Packages(/*Long packageId, */String packageName, String packageDescription, Long minUsersAllowed,
			Long priceUserMonth, Long priceUserYear, Long trialPeriodDays/*, Set<Features> features*/) {
		super();
		//this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.minUsersAllowed = minUsersAllowed;
		this.priceUserMonth = priceUserMonth;
		this.priceUserYear = priceUserYear;
		this.trialPeriodDays = trialPeriodDays;
		//this.features = features;
	}
	public Packages() {
		
	}
	@Override
	public String toString() {
		return "Packages [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", minUsersAllowed=" + minUsersAllowed + ", priceUserMonth=" + priceUserMonth
				+ ", priceUserYear=" + priceUserYear + ", trialPeriodDays=" + trialPeriodDays + ", features=" + features
				+ "]";
	}
	
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Packages)) return false;
//        return packageId != null && packageId.equals(((Packages) o).packageId);
//    }
// 
//    @Override
//    public int hashCode() {
//        return 31;
//    }
	

}