package homework_functional_6_1;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandlerPhrase {


    public Set<String> handleString(List<String> myString) {
        return myString.stream()
                .sorted()
                .collect(Collectors.toSet());
    }
}
