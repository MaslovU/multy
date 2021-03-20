package homework_client_server_5_1;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 8583);

        try {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(client.getInputStream())
            );
                 PrintWriter out = new PrintWriter(
                         new OutputStreamWriter(client.getOutputStream()), true);
                 Scanner scanner = new Scanner(System.in)) {
                String value;
                while (true) {
                    System.out.println("Enter your number or print word: no if wont continue");
                    value = scanner.nextLine();
                    out.println(value);
                    if (value.equals("no")) break;
                    String res = reader.readLine();

                    System.out.println("Server return resuli is: " + res);
                    String replace1 = res.replace("[", ",");
                    String replace2 = replace1.replace("]", ",");
                    List<String> list = new ArrayList<String>(Arrays.asList(replace2.split(",")));
                    long longRes = Long.parseLong(list.get(list.size() - 1).trim());

                    System.out.println("Last value is: " + longRes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
