package com.company;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args){


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("movie.arff"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArffLoader.ArffReader arff = null;
        try {
            arff = new ArffLoader.ArffReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Instances data = arff.getData();

        System.out.println(data.toString());
        data.setClassIndex(data.numAttributes() - 1);


        HashSet<String> gen= new HashSet<String>();
        for(int i=0;i<914;i++)
        {
            String[] s=data.attribute(9).value(i).split("\\|");
            Collections.addAll(gen, s);
        }

        HashSet<String> plot= new HashSet<String>();
        for(int i=0;i<4760;i++)
        {
            String[] s=data.attribute(16).value(i).split("\\|");
            plot.addAll(Arrays.asList(s));
        }



        HashMap<String, Integer> actor1= new HashMap<>();
        HashMap<String, Integer> director=new HashMap<>();
        HashMap<String, Integer> actor2=new HashMap<>();
        HashMap<String, Integer> country=new HashMap<>();
        HashMap<String, Integer> language=new HashMap<>();
        HashMap<String, Integer> contentRating=new HashMap<>();
        HashMap<String, Integer> genres=new HashMap<>();
        HashMap<String, Integer> plotkey=new HashMap<>();


        for(int i=0;i<=2397;i++)
        {
            director.put(data.attribute(1).value(i),i);
        }
        for(int i=0;i<2097;i++)
        {
            actor1.put(data.attribute(10).value(i),i);
        }
        for(int i=0;i<3032;i++)
        {
            actor2.put(data.attribute(6).value(i),i);
        }
        for(int i=0;i<65;i++)
        {
            country.put(data.attribute(20).value(i),i);
        }
        for(int i=0;i<47;i++)
        {
            language.put(data.attribute(19).value(i),i);
        }
        for(int i=0;i<18;i++)
        {
            contentRating.put(data.attribute(21).value(i),i);
        }
        int i=0;
        for (String s : gen) {
            genres.put(s,i++);
        }

        i=0;
        for (String s : plot) {
            plotkey.put(s,i++);
        }









//        int a = Integer.parseInt(data.attribute(2).value(1));
//        System.out.println(data.attribute(2).value(1).getClass().getName());

        System.out.println("hi");
//        if(data.attribute(3).value(5)=="") {
//            data.attribute(3).value(5) = "0";
//        }

        System.out.println(data.attribute(2).value(0));


    }
}
