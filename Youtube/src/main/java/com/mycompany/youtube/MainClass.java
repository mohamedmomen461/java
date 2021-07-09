/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youtube;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        YoutubeTitleCount p1=new YoutubeTitleCount();
               p1.getTitle("src/main/java/com/mycompany/youtube/USvideos.csv");
//        YoutubeTagCount p2=new YoutubeTagCount();
//               p2.getTags("src/main/java/com/mycompany/youtube/USvideos.csv");
               
             

        
    }}
         