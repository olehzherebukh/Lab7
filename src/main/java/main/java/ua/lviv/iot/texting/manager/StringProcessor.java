package main.java.ua.lviv.iot.texting.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    public static String readInputText() throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("Enter String");
            return br.readLine();
        } finally {
            System.out.println("Reading was successfull");
        }
    }

    public void findingSecondWords() throws IOException {
        String text = readInputText();

        Pattern pattern = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String plateNumber = matcher.group();
            System.out.println(plateNumber);
            Pattern regex = Pattern.compile("^\\S+\\s*(\\S+)\\s*(\\S+)\\s*(\\S+).*$");
            Matcher matcher1 = regex.matcher(plateNumber);
            while (matcher1.find()) {
                String plateNumber1 = matcher1.group(1);
                for (String st : plateNumber1.split(" ")) {
                    if (st.startsWith("t")) {
                        System.out.println(st);
                    }
                }
            }
        }
    }
    
    public void findingWordsInQuestionableSentences () throws IOException {
        String text = readInputText();
        Pattern pattern = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String plateNumber = matcher.group();
            System.out.println(plateNumber);
            Pattern regex = Pattern.compile("\\w{3,4}");
            Matcher matcher1 = regex.matcher(plateNumber);
            while (matcher1.find()) {
                String plateNumber1 = matcher1.group();
                System.out.println(plateNumber1);
            }
            /*String[] sentences = plateNumber.split("\\?"); 
            for (int i = 0; i < sentences.length; i++) {
                System.out.println(sentences[i]); */
            }
                
        }
        
        /*String[] sentences = text.split("\\?"); 

        for (int i = 0; i < sentences.length; i++)
            System.out.println(sentences[i]); */
    }

