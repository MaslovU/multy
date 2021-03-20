package homework_client_server_5_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandlerString {
    public long returnLastValue(String res) {
        String replace1 = res.replace("[", ",");
        String replace2 = replace1.replace("]", ",");
        List<String> list = new ArrayList<String>(Arrays.asList(replace2.split(",")));
        return Long.parseLong(list.get(list.size() - 1).trim());
    }
}
