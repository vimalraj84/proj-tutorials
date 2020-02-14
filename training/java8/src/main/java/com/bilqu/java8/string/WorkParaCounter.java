package com.bilqu.java8.string;

import java.io.*;
import java.util.stream.Stream;

public class WorkParaCounter {

    public static void main(String[] a) throws IOException {


        try(BufferedReader bf = new BufferedReader(new InputStreamReader(WorkParaCounter.class.getResourceAsStream("/story.txt")))){

            int wordCounter = 0;
            int paraCounter = 1;
            int sentenceCounter = 0;
            int spaceCounter = 0;
            int charCounter = 0;

            String line = null;
            while((line = bf.readLine()) != null){

                if(line.equals("")){
                    ++paraCounter;
                    continue;
                }else{
                    // \\s+ is the space
                    String[] words = line.split("\\s+");
                    wordCounter += words.length;

                    spaceCounter += words.length-1;

                    // [!?.:]+
                    String[] sentences = line.split("[!?.:]++");

                    sentenceCounter += sentences.length;

                    charCounter +=line.length();
                }
            }


            System.out.println("No. of words :"+wordCounter);
            System.out.println("No. of Paragraph :"+paraCounter);
            System.out.println("No. of Sentences :"+sentenceCounter);
            System.out.println("No. of Space :"+spaceCounter);
            System.out.println("No. of Char :"+charCounter);


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
