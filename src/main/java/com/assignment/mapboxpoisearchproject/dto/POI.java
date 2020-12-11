package com.assignment.mapboxpoisearchproject.dto;
import java.util.List;

//This class represents the POI object
public class POI {
   private String name;
   private List<String> categories;
   private String region;
   
   public POI() {
	}
   
   public POI(String name, List<String> categories, String region) {
	super();
	this.name = name;
	this.categories = categories;
	this.region = region;
    }

  public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public List<String> getCategories() {
	return categories;
   }

   public void setCategories(List<String> categories) {
	this.categories = categories;
    }

    public String getRegion() {
	return region;
    }

    public void setRegion(String region) {
	this.region = region;
    }
}
