package homework_functional_6_1;

import java.util.List;

public class HandlerPhrase {


    public void handleString(List<String> myString) {
        myString.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
