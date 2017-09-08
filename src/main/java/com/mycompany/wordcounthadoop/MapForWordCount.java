/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordcounthadoop;

import com.google.common.base.Strings;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author bouhmid
 */
class MapForWordCount   extends Mapper<Object, Text, Text, IntWritable>{

    //************************
    private final static IntWritable one = new IntWritable(1);
    //*********************************
    private Text word = new Text();

    //********la fonction map********************//
    
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
        
 /*
        
La classe StringTokenizer fait partie du package java.util. Elle permet de décomposer une chaîne de caractères en une suite de "mots" séparés par des "délimiteurs".
        */
      StringTokenizer itr = new StringTokenizer(value.toString());
      
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
}
