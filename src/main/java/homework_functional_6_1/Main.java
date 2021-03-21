package homework_functional_6_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        HandlerPhraseI handlerPhraseI;
        HandlerPhrase handlerPhrase = new HandlerPhrase();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aborigen = null;

        {
            try {
                aborigen = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String finalAborigen = aborigen;
        handlerPhraseI = (String s) -> {
            Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
            List<String> list = new ArrayList<>(Arrays.asList(pattern.split(finalAborigen)));
            return list;
        };

        Set<String> myDict =handlerPhrase.handleString(handlerPhraseI.actionWithString(finalAborigen));
        for (String el: myDict
             ) {
            System.out.println(el);
        }
    }
}
