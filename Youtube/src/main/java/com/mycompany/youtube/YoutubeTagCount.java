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


public class YoutubeTagCount {
     private static final String COMMA_DELIMITER = ",";
    

public void getTags(String path) throws IOException
{
    SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
    JavaSparkContext sparkContext = new JavaSparkContext (conf);
    JavaRDD<String> videos = sparkContext.textFile (path);
    JavaRDD<String> tag = videos.map (YoutubeTagCount::extractTags)
            .filter (StringUtils::isNotBlank);
            JavaRDD<String> tags = tag.flatMap (title -> Arrays.asList (title
                .toLowerCase ()
                .trim ()
               .split ("\\|")).iterator ());
    Map<String, Long> tagCounts = tags.countByValue ();
    List<Map.Entry> sorted_tags = tagCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
    for (Map.Entry<String, Long> entry : sorted_tags) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
}}

    public static String extractTags(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
        
    }}


       
