/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldCountries;

import java.util.List;
import java.util.Map;

/**
 *
 * @author MA
 */
public class MainClass {
    public static void main(String[] args){
        WorldDAO wDAO = new WorldDAO();
        List<City> cities = wDAO.readCities("D:\\Cities.csv");
        List<Country> countries = wDAO.readCountries("D:\\Countries.csv");
        int i = 0;
        for (City city: cities){
            System.out.println("#"+(i++)+city);
        }
        i = 0;
        for (Country country: countries){
            System.out.println("#"+(i++)+country);
        }
        Map<String,List<City>> cityMap = wDAO.mapCities(cities);
        for(String name: cityMap.keySet()){
            List<City> cities1 = cityMap.get(name);
            System.out.println(name + " = " + cities1);
        }
        
        wDAO.highestPopulationCity(cityMap);
        System.out.println("Max population: "+wDAO.getMaximumPopulation(countries));
        System.out.println("Average Population: "+wDAO.getAveragePopulation(countries));
        wDAO.highestPopulationCapital(cities,countries);
    }
}
