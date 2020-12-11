package com.assignment.mapboxpoisearchproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.assignment.mapboxpoisearchproject.dto.POI;

//This class acts as a controller for the incoming requests
@RestController
@RequestMapping(value="/")
public class Controller {

	//inject a bean of restTemplate
	@Autowired
	public RestTemplate restTemplate;

	//This method handles the GET /itinerary request
	@RequestMapping(value = "/itinerary", method = RequestMethod.GET)
	public Object fetchListOfPOIs() {
		
		ArrayList<POI> listOfPOIs = new ArrayList<>();
		
		//response from mapBox.places API
		JsonNode responseNode = restTemplate.getForObject(
				"https://api.mapbox.com/geocoding/v5/mapbox.places/Istanbul.json&history.json?types=poi&limit=10&access_token=pk.eyJ1IjoicG9vamFyYWlpIiwiYSI6ImNraWhka3VnaDF3ZGgyeHBlbGNlbGVmaDMifQ.IWyL1NoCsYxJiNZ2uvQ4Hw",
				JsonNode.class);
		
		//fetching the features list from response
		ArrayNode featureNodeList = (ArrayNode) responseNode.get("features");
		Iterator<JsonNode> responseNodeItr = featureNodeList.elements();
		
		//traversing on the features list
		while (responseNodeItr.hasNext()) {
			
			//creating a POI object
			POI poi = new POI();
			JsonNode featureNode = responseNodeItr.next();
			
			//setting place name of POI
			poi.setName(featureNode.get("place_name").asText());
			
			//setting categories of POI
			String[] categoryNode = featureNode.get("properties").get("category").asText().split(",");
			poi.setCategories(Arrays.asList(categoryNode));
			
			//setting region of POI
			ArrayNode contextNodeList = (ArrayNode) featureNode.get("context");
			Iterator<JsonNode> contextNodeItr = contextNodeList.elements();
			while (contextNodeItr.hasNext()) {
				JsonNode contextNode = contextNodeItr.next();
				if (contextNode.get("id").asText().contains("region")) {
					poi.setRegion(contextNode.get("text").asText());
					break;
				}
			}
			
			//adding POI to the list of POIs
			listOfPOIs.add(poi);
		}
		return listOfPOIs;
	}
	
}
