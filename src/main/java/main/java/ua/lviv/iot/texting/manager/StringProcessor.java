package main.java.ua.lviv.iot.texting.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    public static final String SPLIT_SENTENCE = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    public static final String FIND_SECOND_WORD = "^\\S+\\s*(\\S+)\\s*(\\S+)\\s*(\\S+).*$";
    public static final String FIND_WORDS_WITH_NUMBER_OF_LETTERS = "^\\w{3,4}";
    
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

        Pattern pattern = Pattern.compile(SPLIT_SENTENCE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String firstText = matcher.group();
            System.out.println(firstText);
            Pattern regex = Pattern.compile(FIND_SECOND_WORD);
            Matcher secondMatcher = regex.matcher(firstText);
            while (secondMatcher.find()) {
                String secondText = secondMatcher.group(1);
                for (String st : secondText.split(" ")) {
                    if (st.startsWith("t")) {
                        System.out.println(st);
                    }
                }
            }
        }
    }

    public void findingWordsInQuestionableSentences() throws IOException {
        String text = readInputText();
        Pattern pattern = Pattern.compile(SPLIT_SENTENCE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String firstText = matcher.group();
            System.out.println(firstText);
            Pattern regex = Pattern.compile(FIND_WORDS_WITH_NUMBER_OF_LETTERS);
            Matcher secondMatcher = regex.matcher(firstText);
            while (secondMatcher.find()) {
                String secondText = secondMatcher.group();
                System.out.println(secondText);
            }
        }
    }
}
