/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

/**
 *
 * @author smc
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PyramidCSVDAO pDAO=new PyramidCSVDAO();
       List<Pyramid> pyramids=pDAO.readPyramidsFromCSV("D:\\pyramids.csv");
       int i=0;
       for(Pyramid p:pyramids){
       System.out.println("#"+(i++)+p);
               }
    
    pyramids.sort(Comparator.comparingDouble(Pyramid::getHeight));
    i=0;
    for(Pyramid p:pyramids){
       System.out.println("#"+(i++)+p);
               }
    Map < String,Integer > countBySite=new LinkedHashMap < >();
for (Pyramid p:pyramids) {
    String site =p.getSite();
    Integer count=countBySite.get(site);
    if(count==null){
        count=1;}
    else{
        count++;
    }
    countBySite.put(site,count);}
System.out.println(countBySite);

}   
     
    
    }  

