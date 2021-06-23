/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readconsole;
import java.io.*;

/**
 *
 * @author smc
 */
public class Readconsole {

    public static void main(String[] args) {
        try{
            InputStreamReader read=new InputStreamReader(System.in);
            BufferedReader br =new BufferedReader(read);
            Writer fw=new FileWriter("D:\\Task.txt");
            BufferedWriter buffer=new BufferedWriter(fw);
            String line="";
    
    while(!line.equals("stop")){
        try{
            System.out.println("enter data :  ");
            line=br.readLine();
            System.out.println("dsta is :"+line);
            
           
            if(!line.equals("stop")){
                 buffer.write(line+" ");
            }
            
                    
        }catch(IOException e){
           e.printStackTrace();
        }}
    
       br.close();
       read.close();
       buffer.close();
       }
       catch(IOException e){
               e.printStackTrace();
               
               }
    }}

