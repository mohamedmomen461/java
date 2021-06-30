/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldCountries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.reverseOrder;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author MA
 */
public class WorldDAO {
    
    public List<Country> readCountries (String fileName){
        
        List<Country> countries =  new ArrayList<>();
         
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");
                Country country = createCountry(attributes);
                countries.add(country);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorldDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorldDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countries;
    }
    
    public List<City> readCities (String fileName){
        
        List<City> cities =  new ArrayList<>();
         
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");
                City city = createCity(attributes);
                cities.add(city);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorldDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WorldDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }
    public City createCity(String[] metadata){
        
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        int population = Integer.parseInt(metadata[2]);
        String countryCode = metadata[3];
        
        City city = new City(id, name, population, countryCode);
        return city;

    }
    
    public Country createCountry(String[] metadata){
        
        String code = metadata[0];
        String name = metadata[1];
        String continent = metadata[2];
        double surfaceArea = Double.parseDouble(metadata[4]);
        int population = Integer.parseInt(metadata[3]);
        double gnp = Double.parseDouble(metadata[5]);
        int capital = Integer.parseInt(metadata[6]);
        
        Country country = new Country(code, name, continent, population, surfaceArea, gnp, capital);
        return country;

    }
    
    
    public Map<String,List<City>> mapCities(List<City> cities){
        Map <String, List<City>> cityMap = new HashMap<String, List<City>>();
        for (City city: cities){
            String countryCode = city.getCountryCode();
            if(!cityMap.containsKey(countryCode)){
                cityMap.put(countryCode, new ArrayList<City>());
                cityMap.get(countryCode).add(city);
            }
            else {
               cityMap.get(countryCode).add(city);
            }
            
        }
        return cityMap;
    }
    public List<City> sortCities (Map<String,List<City>> cityMap, String countryCode){
        List<City> cities = new ArrayList<>();
        cities = cityMap.get(countryCode);
        List<City> sortedCities = cities.stream().sorted(Comparator.comparingInt(City::getPopulation)).collect(toList());
        return sortedCities;
    }
    public List<Integer> getCountryPopulation (List<Country> countries){
        
        return countries.stream().map(Country::getPopulation).collect(toList());
    }
    
    public OptionalInt getMaximumPopulation(List<Country> countries){
        return countries.stream().mapToInt(Country::getPopulation).max();
    }
    public OptionalDouble getAveragePopulation(List<Country> countries){
        return countries.stream().mapToInt(Country::getPopulation).average();
    }
    public void highestPopulationCity(Map<String,List<City>> cityMap){
        for (String name:cityMap.keySet()){
            List<City> c1 = cityMap.get(name);
            List<Integer> pop = new ArrayList<Integer>();
            for(City c:c1){
                pop.add(c.getPopulation());
                Integer max = pop.stream().max(Integer::compare).get();
                if(c.getPopulation()==max){
                    System.out.println(name + " = " +c);
                }
            }
        }
    }
    public void highestPopulationCapital(List<City> cities, List<Country> countries){
        List<Integer> capitalsId = countries.stream().map(Country::getCapital).collect(Collectors.toList());
        List<City> capitals = new ArrayList<>();
        for (Integer id : capitalsId){
            List<City> filter = cities.stream().filter(b->b.getId()== id).collect(Collectors.toList());
            try{
                capitals.add(filter.get(0));
            }catch(Exception e){};
        }
        List<City> sorted= capitals.stream().sorted(Comparator.comparingInt(City::getPopulation)).collect(toList());
        System.out.println(sorted.get(sorted.size()-1));
    }
    
}
