package main.java.ua.lviv.iot.texting.manager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        StringProcessor obj = new StringProcessor();
        //obj.findingSecondWords();
        obj.findingWordsInQuestionableSentences();
    }

}
