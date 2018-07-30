package com.sudaraje.features;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sudaraje.packages.Packages;

@Entity
@Table(name="Features")
public class Features {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "featureId", insertable=true, updatable=true, unique=true, nullable=false)
	private Long featureId ;
	
	private String featureName;
	private String featureDescription;
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                },mappedBy="features")
	private Set<Packages> packages = new HashSet<>();
	
	@JsonIgnore
	public Set<Packages> getPackages() {
		return packages;
	}
	public void setPackages(Set<Packages> packages) {
		this.packages = packages;
	}
	public Long getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getFeatureDescription() {
		return featureDescription;
	}
	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}
	@Override
	public String toString() {
		return "Features [featureId=" + featureId + ", featureName=" + featureName + ", featureDescription="
				+ featureDescription + "]";
	}
	
	public Features(/*Long featureId,*/String featureName, String featureDescription/*,Set<Packages> packages*/) {
		super();
		//this.featureId = featureId;
		this.featureName = featureName;
		this.featureDescription = featureDescription;
		//this.packages = packages;
	}
	public Features() {
		
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Features feature = (Features) o;
        return Objects.equals(featureName, feature.featureName);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(featureName);
    }
	
	
}