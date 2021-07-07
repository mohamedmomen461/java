/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanic;

import java.io.IOException;
import java.util.List;
import joinery.DataFrame;
import static tech.tablesaw.api.QuerySupport.column;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;


public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Table titanicData;
        String dataPath="D:\\titanic.csv";
        titanicData=Table.read().csv("D:\\titanic.csv");
        List<Column<?>> dataStructure=titanicData.columns();
        System.out.println(dataStructure);
        System.out.println(titanicData.summary());
        DataFrame<Object> df =DataFrame.readCsv("D:\\titanic.csv");
        DataFrame<Object> df1=df.retain("age","fare").min();
        DataFrame<Object> df2=df.retain("age","fare").max();
        DataFrame<Object> df3=df.retain("age","fare").mean();
        DataFrame<Object> df4=df.retain("age","fare").stddev();              
        
        System.out.println(df1);
        System.out.println(df2);
        
        System.out.println(df3);
        System.out.println(df4);
        
   
    }
    
}
