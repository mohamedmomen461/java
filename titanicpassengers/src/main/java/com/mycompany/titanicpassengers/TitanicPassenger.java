/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanicpassengers;

import static com.fasterxml.jackson.annotation.OptBoolean.FALSE;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author smc
 */
public class TitanicPassenger {
    private String pclass;
    private String survived;
    private String name;
    private String sex;
    private float age;
    private String sibsp;
    private String parch;
    private String ticket;
    private float fare;
    private String cabin;
    private String embarked;
    private String boat;
    private String body;
    private String home_dist;

    public TitanicPassenger(String pclass, String survived, String name, String sex, float age, String sibsp, String parch, String ticket, float fare, String cabin, String embarked, String boat, String body, String home_dist) {
        this.pclass = pclass;
        this.survived = survived;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibsp = sibsp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
        this.boat = boat;
        this.body = body;
        this.home_dist = home_dist;
    }

    TitanicPassenger() {
        
    }

    public String getPclass() {
        return pclass;
    }

    public String getSurvived() {
        return survived;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public float getAge() {
        return age;
    }

    public String getSibsp() {
        return sibsp;
    }

    public String getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public float getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public String getBoat() {
        return boat;
    }

    public String getBody() {
        return body;
    }

    public String getHome_dist() {
        return home_dist;
    }

    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    public void setSurvived(String survived) {
        this.survived = survived;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public void setSibsp(String sibsp) {
        this.sibsp = sibsp;
    }

    public void setParch(String parch) {
        this.parch = parch;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHome_dist(String home_dist) {
        this.home_dist = home_dist;
    }
     public List<TitanicPassenger> getPassengersFromJsonFile() throws FileNotFoundException, IOException{
        List<TitanicPassenger> allPassengers=new ArrayList<TitanicPassenger>();
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        InputStream input=new FileInputStream("D:\\titanic_csv.json");
        allPassengers=objectMapper.readValue(input,new TypeReference<List<TitanicPassenger>>(){});
        return allPassengers;
        
        
        
        
    }
    public void graphPassengerAges(List<TitanicPassenger> passengerList) {

     List<Float> pAges = passengerList.stream ().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList ());
     List<String> pNames = passengerList.stream ().map (TitanicPassenger::getName).limit (8).collect (Collectors.toList ());
        
    CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Age Histogram").xAxisTitle ("Names").yAxisTitle
("Age").build ();
// 2.Customize Chart
chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
chart.getStyler ().setHasAnnotations (true);
chart.getStyler ().setStacked (true);
// 3.Series
chart.addSeries ("Passenger's Ages",pNames, pAges);
// 4.Show it
new SwingWrapper (chart).displayChart ();
}
    public void graphPassengerClass(List<TitanicPassenger> passengerList) {
     Map<String, Long> result =
     passengerList.stream ().collect (
     Collectors.groupingBy (TitanicPassenger::getPclass, Collectors.counting () ) );
     PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler ().setSeriesColors (sliceColors);
        // Series
        chart.addSeries ("First Class", result.get ("1"));
        chart.addSeries ("Second Class", result.get ("2"));
        chart.addSeries ("Third Class", result.get ("3"));
        // Show it
        new SwingWrapper (chart).displayChart ();
}
    public void graphPassengersurvived(List<TitanicPassenger> passengerList) {
    Map<String, Long> result =
     passengerList.stream ().collect (
     Collectors.groupingBy (TitanicPassenger::getSurvived, Collectors.counting () ) );
     PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
        chart.getStyler ().setSeriesColors (sliceColors);
        // Series
        chart.addSeries ("First Class", result.get("0"));
        chart.addSeries ("Second Class", result.get("1"));
        // Show it
        new SwingWrapper (chart).displayChart ();
}
    public void graphPassengerSurvivedGender(List<TitanicPassenger> passengerList) {
     Map<String, Long> result =
             passengerList.stream ().filter(p->p.getSurvived().equals("1")).collect (
     Collectors.groupingBy (TitanicPassenger::getSex, Collectors.counting() ) );
     PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler ().setSeriesColors (sliceColors);
        // Series
        chart.addSeries ("First Class", result.get ("female"));
        chart.addSeries ("Second Class", result.get ("male"));
        // Show it
        new SwingWrapper (chart).displayChart ();
        
}
     }
    
    
    

