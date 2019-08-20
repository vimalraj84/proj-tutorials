package com.bilqu.java8.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

//\b: look for word boundary (match only beginning of word instead of somewhere in the middle);
//(\w+): match one ore more word characters and remember them as a group (the parens) to which later we can refer to using a number; so this matches a complete word and remembers it;
//\s+: match one or more space characters;
//\1: match the word remembered in step 2;
//\b: like in step 1 – make sure it’s not a part of some longer word;
//(\s+\1\b)+: match one or more occurrences of the word captured in step 2.
        String regex = "\\b(\\w+)(\\s+\\1)+\\b";
//        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex,java.util.regex.Pattern.CASE_INSENSITIVE);

//        Scanner in = new Scanner(System.in);
//        int numSentences = Integer.parseInt(in.nextLine());
//
//        while (numSentences-- > 0) {
//            String input = in.nextLine();
        String input =  "Goodbye bye bye world world world";
//        Sam went went to to to his business";
//        Reya is is the the best player in eye eye game";
//        in inthe";
//        Hello hello Ab aB";

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(0), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
//        }

//        in.close();
    }
}

