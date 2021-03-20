package homework_client_server_5_1;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {
    public List<Long> result(int num) {
        List<Long> res = new ArrayList<>();
        long tmp;
        if (num == 1 || num == 0) res.add(0L);
        if (num == 2) {
            res.add(0L);
            res.add(1L);
        }
        if (num > 2) {
            long left = 0;
            long right = 1;
            res.add(0L);
            res.add(1L);
            for (int i = 2; i < num; i++) {
                tmp = left + right;
                res.add(tmp);
                left = right;
                right = tmp;
            }
        }
        return res;
    }
}
