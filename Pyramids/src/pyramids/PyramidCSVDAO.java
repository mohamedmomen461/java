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


public class PyramidCSVDAO {
    public PyramidCSVDAO(){
    }
    
    public List<Pyramid> readPyramidsFromCSV(String filename){
    List<Pyramid> pyramids=new ArrayList<>() ;
    try(BufferedReader br=new BufferedReader(new FileReader(filename))){
        String line=br.readLine();
        if(line!=null){
            line=br.readLine();}
        while(line!=null){String[] attributes=line.split(",");
        Pyramid pr=createPyramid(attributes);
        pyramids.add(pr);
        line=br.readLine();
        }}
    catch(IOException e){
        e.printStackTrace();}
    
 
    return pyramids;
    }
public Pyramid createPyramid(String[] metadata){
String pharaoh =metadata[0];
String modern_name =metadata[2];
String site =metadata[4];
double height=0;
if(metadata[7]!=null&&metadata[7].length()>0){
height=Double.parseDouble(metadata[7]);
}return new Pyramid(pharaoh,modern_name,site,height);
}}

