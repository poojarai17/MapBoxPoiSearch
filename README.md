MapBoxPoiSearchProject is a Spring Boot Application built using Maven. It provides an API for rendering list of POIs(point of Interests) in JSON.

API request endpoint- GET http://localhost:8080/itinerary
Sample API Response-
[
{
"name": "Topkapi Palace",
"categories": ["tourism", "museum"],
"region": "Fatih"
}
]

To run the application, either clone the project or download it. Build a jar file(by running as Maven build with Goal package) and then run it.
<img width="446" alt="snapshot" src="https://user-images.githubusercontent.com/24866461/101906664-55e8d480-3bdf-11eb-8bb7-a184497fbc7d.PNG">
