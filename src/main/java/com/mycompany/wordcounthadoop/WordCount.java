/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordcounthadoop;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.util.GenericOptionsParser;

/**
 *
 * @author bouhmid
 */
public class WordCount {
    
    
    public static void main(String [] args) throws Exception

{
 
    //***OBJECT POUR LA CONFIGURATION **************//
  Configuration conf = new Configuration();
  
  //*****CRÉER UN JOB QUI VA /
    Job job = Job.getInstance(conf, "word count");
    
    //**********************************//
    job.setJarByClass(WordCount.class);
    //*************************************
    
    //l'implmentation du Mapper 
    job.setMapperClass(MapForWordCount.class);
    
    
    //l'implementation du classe responsable du combainision
    job.setCombinerClass(ReduceForWordCount.class);
  
    
  //l'implementation du classe Reducer  
    job.setReducerClass(ReduceForWordCount.class);
    //**********************************//
    
    
    job.setOutputKeyClass(Text.class);
    //*************************************//
    job.setOutputValueClass(IntWritable.class);
    //******************************************//
    System.out.println("path 0"+ args[0]);
    
    //System.out.println("jobbbd"+ new Path(args[0]));
    //** configuer le Fichier de Lin'put
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    
    
    
    //****
     //FileSystem.get(conf).delete(new Path(args[1]),true);
     
     
     
    //** configuer l'OUtput*******************//
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
    
    



    
}

    
    
    
    
}
