package mypack;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;  
 
@CrossOrigin("*")
@RestController 
public class CountryController {  
  
 CountryService countryService = new CountryService();  
  
 @GetMapping(value="/countries")
 public String getCountries() {  
  List<Country> listOfCountries = countryService.getAllCountries();  
  String json = new Gson().toJson(listOfCountries);
  return json;
 }  
  
 @GetMapping(value = "/countries/{id}")  
 public String getCountryById(@PathVariable int id) {  
  return new Gson().toJson(countryService.getCountry(id));  
 }  
  
 @PostMapping(value = "/countries")  
 public Country addCountry(@RequestBody Country country) {  
  return countryService.addCountry(country);  
 }  
  
 @PutMapping(value = "/countries")  
 public Country updateCountry(@RequestBody Country country) {  
  return countryService.updateCountry(country);  
  
 }  
  
 @DeleteMapping(value = "/country/{id}")  
 public void deleteCountry(@PathVariable("id") int id) {  
  countryService.deleteCountry(id);  
  
 }   
}  













